package com.packtpub.performance.stream;

import java.time.LocalDate;

public class Contract {

    private final State state;
    private final int priceInCent;
    private final LocalDate date;

    public Contract(State state, int priceInCent, LocalDate date) {
        this.state = state;
        this.priceInCent = priceInCent;
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public int getPriceInCent() {
        return priceInCent;
    }

    public LocalDate getDate() {
        return date;
    }
}
