package com.packtpub.performance.jcache;

import static com.packtpub.performance.jcache.Providers.*;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 * Cache Data Example
 */
public class CacheExample {
	
    public static void main(String[] args) {
		CachingProvider cachingProvider = null;
		if (args != null && args.length > 0) {
			cachingProvider = Caching.getCachingProvider(String.valueOf(PROVIDER_MAP.get(args[0])));
		} else {
			// Acquire the default cache provider (fallback)
			cachingProvider = Caching.getCachingProvider();
		}
		
        // Acquire the default cache manager
        final CacheManager manager = cachingProvider.getCacheManager();

        // Define a cache
        final MutableConfiguration<String, String> cacheConfig =
                new MutableConfiguration<String, String>()
                        .setStoreByValue(true)
                        .setTypes(String.class, String.class);

        // Create the cache
        Cache<String,String> cache = manager.createCache("capitals", cacheConfig);

        // Get the cache
        cache = manager.getCache("capitals", String.class, String.class);

        // Enter some Capitals
        cache.put("UK", "London");
        cache.put("France", "Paris");
        cache.put("Spain", "Madrid");
        cache.put("Belgium", "Brussels");
        cache.put("Germany", "Berlin");

        // I forgot, what's the Capital of Belgium?
        System.out.println("JCache Capital of UK is : " + cache.get("UK"));
        System.out.println();
        
        // Unwrap to the Vendor API if you need to...(Hazelcast in this instance)
//         ICache<String,String> iCache = cache.unwrap(ICache.class);
//         System.out.println("ICache Capital of Belgium is : " + iCache.get("Belgium"));
        
        System.exit(0);
    }
}
