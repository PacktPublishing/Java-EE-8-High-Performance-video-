parallel-streams-example
========================

Example code for [Video 1.3](../Video_1.3) of [Java EE 8 High Performance](https://github.com/PacktPublishing/Java-EE-8-High-Performance-video-)

A deployable WAR file can be built with

    mvn clean package

The WAR is created in `webapp/target/parallel-streams-example.war`. It was tested with the [Wildfly](http://wildfly.org) application server.

Benchmarks based on [JMH](http://openjdk.java.net/projects/code-tools/jmh/) can be run with

    mvn clean package
    java -jar benchmarks/target/benchmarks.jar .*MyBenchmark.* -f 1
    
---
**NOTE**

If you don't select a particular method instead of the wildcard `MyBenchmark.*` tests may run quite **long**.

---
