# Section 8

## Video 8.1
- [Simple Spring Batch Demo](simple-spring-batch) based on [Spring Batch Performance Monitoring](https://github.com/viadee/springBatchPerformanceMonitoring) (SBPM).

To run [DBeaver](https://dbeaver.io/) directly in your Eclipse IDE please install the Eclipse Plugin from the **Update Site** or **Eclipse Marketplace** as described on the [Download](https://dbeaver.io/download/) page for DBeaver. 

Note, a [dbeaver-data-sources](https://github.com/PacktPublishing/Java-EE-8-High-Performance-video-/blob/master/.dbeaver-data-sources.xml) file for the sample monitoring DB is located in the repository root because DBeaver expects it there. Other installations of DBeaver may use a different location. Depending on the OS you may need to adjust the URL slightly e.g. `/data/h2/monitoringDB` instead of `C:/data/h2/monitoringDB`. 
Where you do, please also update `db.url` in [SpringBatchMonitoring.properties](simple-spring-batch/src/main/java/resources/SpringBatchMonitoring.properties)

If you prefer a stand-alone installation or other comparable tools like [Squirrel SQL Client](http://squirrel-sql.sourceforge.net/), you may also view the **H2 monitoring DB** with one of these.