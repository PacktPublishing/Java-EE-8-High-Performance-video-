# Section 5

- [REST Async CompletionStage](async-pipeline) example for Video 5.2
- [REST Stability](stability) examples for Video 5.2
- Examples of JSON-P 1.1 features like JSON Patch or JSON Merge Patch can be found in [Section 3](https://github.com/PacktPublishing/JSON-with-Java-EE-8-Hands-on-Training/tree/master/Section3) of https://github.com/PacktPublishing/JSON-with-Java-EE-8-Hands-on-Training

## Video 5.3
- [CDI Performance benchmark](https://github.com/struberg/cdi-performance) for Video 5.3

### Weld-3.0.3
<pre>$> mvn clean install -PWeld3 -Dweld.version=3.0.3.Final</pre>

Test invocation on @ApplicationScoped bean TOOK: 3324 ms
Test invocation on @ApplicationScoped bean which got injected into another @ApplicationScoped bean TOOK: 3515 ms
Test invocation on @RequestScoped bean TOOK: 1880 ms
Test invocation on ClassIntercepted bean TOOK: 9286 ms
Test invocation on intercepted method of MethodInterceptedBean TOOK: 10368 ms
Test invocation on NON-intercepted method of MethodInterceptedBean TOOK: 7040 ms
Test event observer TOOK: 6167 ms

### OWB-2.0.1
<pre>$> mvn clean install -POWB2</pre>

Test invocation on @ApplicationScoped bean TOOK: 56 ms
Test invocation on @ApplicationScoped bean which got injected into another @ApplicationScoped bean TOOK: 257 ms
Test invocation on @RequestScoped bean TOOK: 796 ms
Test invocation on ClassIntercepted bean TOOK: 2762 ms
Test invocation on intercepted method of MethodInterceptedBean TOOK: 2884 ms
Test invocation on NON-intercepted method of MethodInterceptedBean TOOK: 253 ms
Test event observer TOOK: 4509 ms