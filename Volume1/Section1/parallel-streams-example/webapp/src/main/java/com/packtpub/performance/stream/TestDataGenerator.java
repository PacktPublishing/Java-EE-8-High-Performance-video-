package com.packtpub.performance.stream;

import java.util.Arrays;
import java.util.List;

import static com.packtpub.performance.stream.State.*;
import static java.time.LocalDate.now;

public class TestDataGenerator {

    public static List<Contract> makeTestData() {
        return Arrays.asList(
            new Contract(BY, 2000, now()),
            new Contract(BY, 3500, now().minusDays(1)),
            new Contract(NW, 7000, now().minusMonths(1)),
            new Contract(HE, 400, now().minusMonths(1).minusDays(2))
        );
    }
}
