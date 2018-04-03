package com.packtpub.performance.javolution;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import javolution.text.TextBuilder;
import org.junit.Test;
 
/**
 * Benchmark for String concatenation. Compares StringBuilder (JDK) and
 * TextBuilder (Javolution).
 */
public class StringConcatenationBenchmark extends AbstractBenchmark {
    public static final long LOOPS_COUNT = 10000000;
 
    @Test
    @BenchmarkOptions(benchmarkRounds = 3, warmupRounds = 1)
    public void stringBuilderBenchmark()  {
        final StringBuilder builder = new StringBuilder();
        for (long i = 0; i < LOOPS_COUNT; i++) {
            builder.append('i').append(i);
        }
        System.out.println(builder.toString().length());
    }
     
    @Test
    @BenchmarkOptions(benchmarkRounds = 3, warmupRounds = 1)
    public void textBuilderBenchmark()  {   
        final TextBuilder builder = new TextBuilder();
        for (long i = 0; i < LOOPS_COUNT; i++) {
            builder.append('i').append(i);
        }
        System.out.println(builder.toString().length());
    }
}
