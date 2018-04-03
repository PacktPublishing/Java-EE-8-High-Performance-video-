# JCache (JSR107) Examples

Examples on JCache for Video 3.4 of [Java EE 8 High Performance](https://github.com/PacktPublishing/Java-EE-8-High-Performance-video-)

* Simple Cache and Configuration
* CacheLoader for read-through to a back-end, maybe an RDBMS
* CacheWriter for write-through to a back-end
* CacheListeners with Filters, to get callbacks on Cache events.
* EntryProcessors to show data processing in-situ, good for distributed caches.

## Getting Started.

In the pom.xml I have included 3 different JCache providers

1. Hazelcast
2. EHCache
3. Oracle Coherence

WARNING : To use Oracle Coherence you'll have to download the jars manually from their [download site](http://www.oracle.com/technetwork/middleware/coherence/downloads/index.html)
and install them to you local maven repo.

You should be able to switch the providers by changing the String passed to the CachingProvider...
```
// Acquire the default cache provider
CachingProvider cachingProvider = Caching.getCachingProvider(CACHING_PROVIDER_HAZELCAST);
```
