# Eclipse MicroProfile 1.2 samples #

[![Build Status](https://travis-ci.org/javaee-samples/microprofile1.2-samples.svg?branch=master)](https://travis-ci.org/javaee-samples/microprofile1.2-samples)

This workspace consists of MicroProfile 1.2 Samples and unit tests for Metrics. MicroProfile is a code first, open API initiative about optimizing Enterprise Java for a microservices architecture.  See [microprofile.io](https://microprofile.io) for additional info.

Samples are categorized in different directories, one for each technology/spec. 


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


**To run them in the console do**:

1. In the terminal, ``mvn test -fae`` at the top-level directory to start the tests for the default profile.

When developing and runing them from IDE, remember to activate the profile before running the test.

To learn more about Arquillian please refer to the [Arquillian Guides](http://arquillian.org/guides/)

**To run only a subset of the tests do at the top-level directory**:

1. Install top level dependencies: ``mvn clean install -pl "test-utils" -am``
1. cd into desired module, e.g.: ``cd cdi``
1. Run tests against desired server, e.g.: ``mvn clean test -P payara-remote``


## How to contribute ##

With your help we can improve this set of samples, learn from each other and grow the community full of passionate people who care about the technology, innovation and code quality. Every contribution matters!

There is just a bunch of things you should keep in mind before sending a pull request, so we can easily get all the new things incorporated into the master branch.

Standard tests are jUnit based. Test classes naming must comply with surefire naming standards `**/*Test.java`, `**/*Test*.java` or `**/*TestCase.java`.

For the sake of clarity and consistency, and to minimize the upfront complexity, we prefer standard jUnit tests using Java, with as additional helpers HtmlUnit, Hamcrest and of course Arquillian. Please don't use alternatives for these technologies. If any new dependency has to be introduced into this project it should provide something that's not covered by these existing dependencies.