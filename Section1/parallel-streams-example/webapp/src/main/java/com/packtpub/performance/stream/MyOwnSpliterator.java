package com.packtpub.performance.stream;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

// Example implementation of a custom spliterator.
// In order to get a parallel stream of this spliterator, call
// StreamSupport.stream(new MyOwnSpliterator(contracts), true)
public class MyOwnSpliterator implements Spliterator<Contract> {

    private final List<Contract> contracts;
    private int from;
    private int to;

    public MyOwnSpliterator(List<Contract> contracts) {
        this(contracts, 0, contracts.size());
    }

    private MyOwnSpliterator(List<Contract> contracts, int from, int to) {
        this.contracts = contracts;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Contract> action) {
        if (size() > 0) {
            action.accept(contracts.get(from));
            from++;
            return true;
        }
        return false;
    }   

    private int size() {
        return to - from;
    }

    @Override
    public Spliterator<Contract> trySplit() {
        if (size() == 1) {
            System.out.printf("split -> [%d-%d] not splitting because size is 1\n", from, to);
            return null;
        }
        System.out.printf("split -> [%d-%d] -> [%d-%d], [%d-%d]\n", from, to, from, to-size()/2, from + size()/2, to);
        Spliterator<Contract> other = new MyOwnSpliterator(contracts, from + size()/2, to);
        this.to -= size()/2;
        return other;
    }

    @Override
    public long estimateSize() {
        return Long.MAX_VALUE;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
