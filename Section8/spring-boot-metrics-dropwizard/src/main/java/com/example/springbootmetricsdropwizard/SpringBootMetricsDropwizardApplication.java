package com.example.springbootmetricsdropwizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

@SpringBootApplication
@EnableMetrics(proxyTargetClass = true)
public class SpringBootMetricsDropwizardApplication extends MetricsConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMetricsDropwizardApplication.class, args);
    }
}