# Eclipse MicroProfile 1.2 samples #

This workspace consists of MicroProfile 1.2 Samples and unit tests for Metrics. MicroProfile is a code first, open API initiative about optimizing Enterprise Java for a microservices architecture.  See [microprofile.io](https://microprofile.io) for additional info.

## How to run? ##

Samples are tested on Payara using Arquillian. Arquillian uses container profiles to start up and deploy tests to individual containers (servers). 

Only one container profile can be active at a given time, otherwise there will be dependency conflicts.

These are the available container profiles:

* Payara
  * ``payara-ci-managed``
    
      This profile will install a Payara server and start up the server per sample.
      Useful for CI servers. The Payara version that's used can be set via the ``payara.version`` property.
      This is the default profile and does not have to be specified explicitly.
      
  * ``payara-micro-managed``
    
      This profile will install Payara Micro and start up the jar per sample.
      Useful for CI servers. The Payara Micro version that's used can be set via the ``payara.micro.version`` property.

  * ``payara-remote``
    
      This profile requires you to start up a Payara server outside of the build. Each sample will then
      reuse this instance to run the tests.
      Useful for development to avoid the server start up cost per sample.
 * Liberty      
   * ``liberty-ci-managed``
  
      This profile uses the special "wlp-microProfile1" distribution of Liberty, which contains the MicroProfile APIs out of the box
      and start up the server per sample. 
      Useful for CI servers. The Liberty version that's used can be set via the ``liberty.version`` property.
 * WildFly      
   * ``wildfly-ci-managed``

      This profile is based on WildFly Swarm, and includes the MicroProfile 1.2 fragment. The actual WildFly Swarm code and thus
      the WildFly code is handled internally by the Arquillian connector. 
      Useful for CI servers. The WildFly Swarm version that's used can be set via the ``wildfly.version`` property.
    
The containers that download and install a server (the \*-ci-managed profiles) allow you to override the version used, e.g.:

* `-Dpayara.version=5.0.0.174`

    This will change the version from the current one (e.g 5.0.0.172) to 5.0.0.174 for Payara testing purposes.


**To run a subset do at the top-level directory**:

1. Install top level dependencies: ``mvn clean install -pl "metrics" -am``
1. cd into desired module, e.g.: ``cd metrics/application-metrics``
1. Run against desired server, e.g.: ``mvn clean package -P payara-micro-managed``
1. Run the server e.g. Payara Micro: ``java -jar payara-micro-N.MMM*.jar --deploy application-metrics.war``
