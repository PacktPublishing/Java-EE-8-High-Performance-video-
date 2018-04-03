package com.packtpub.performance.stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("dashboard")
public class Dashboard {

    private final List<Contract> contracts;

    public Dashboard() {
        contracts = TestDataGenerator.makeTestData();
    }

    // Called by the benchmark to set the number of contracts in the test data.
    public Dashboard(List<Contract> contracts) {
        this.contracts = contracts;
    }

    private Predicate<Contract> last12months = contract -> contract.getDate().isAfter(now().minusYears(1));

    @GET
    @Path("total-sales")
    @Produces(APPLICATION_JSON)
    public int totalSales() {
        return contracts
                .stream()
                .filter(contract -> contract.getDate().isAfter(now().minusYears(1)))
                .mapToInt(Contract::getPriceInCent)
                .sum();
    }

    // Called by the benchmark to compare the throughput with the totalSales() method.
    public int parallelTotalSales() {
        return contracts
                .parallelStream()
                .filter(contract -> contract.getDate().isAfter(now().minusYears(1)))
                .mapToInt(Contract::getPriceInCent)
                .sum();
    }

    @GET
    @Path("sales-by-state")
    @Produces(APPLICATION_JSON)
    public Map<State, Integer> salesByState() {
        return contracts
                .stream()
                .filter(last12months)
                .collect(Collectors.groupingBy(
                        Contract::getState,
                        Collectors.summingInt(Contract::getPriceInCent)));
    }

    @GET
    @Path("sales-per-month")
    @Produces(APPLICATION_JSON)
    public Map<String, Integer> salesByMonth() {
        return contracts
                .stream()
                .filter(last12months)
                .collect(Collectors.groupingBy(
                        c -> c.getDate().getYear() + "-" + c.getDate().getMonthValue(),
                        Collectors.summingInt(Contract::getPriceInCent)));
    }
}
