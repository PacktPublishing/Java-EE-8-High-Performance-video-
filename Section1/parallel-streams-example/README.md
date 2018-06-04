parallel-streams-example
========================

Example code for [Video 1.3](../Video_1.3) of [Java EE 8 High Performance](https://github.com/PacktPublishing/Java-EE-8-High-Performance-video-)

A deployable WAR file can be built with

    mvn clean package

The WAR is created in `webapp/target/parallel-streams-example.war`. It was tested with the [Wildfly](http://wildfly.org) application server.

Benchmarks can be run with

    mvn clean package
    java -jar benchmarks/target/benchmarks.jar .*MyBenchmark.* -f 1
