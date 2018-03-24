package com.packtpub.performance.jcache;

import static com.packtpub.performance.jcache.Providers.*;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

/**
 * Cache Data Example
 */
public class CacheLoaderExample {

   public static void main(String[] args) {
		CachingProvider cachingProvider = null;
		if (args != null && args.length > 0) {
			cachingProvider = Caching.getCachingProvider(String.valueOf(PROVIDER_MAP.get(args[0])));
		} else {
			// Acquire the default cache provider (fallback)
			cachingProvider = Caching.getCachingProvider();
		}
		
        // Acquire the default cache manager
        CacheManager manager = cachingProvider.getCacheManager();

        // Define a cache
        MutableConfiguration<String, String> cacheConfig =
                new MutableConfiguration<String, String>().setStoreByValue(true)
                        .setTypes(String.class, String.class)
                        .setCacheLoaderFactory(FactoryBuilder.factoryOf(MyCacheLoader.class))
                        .setReadThrough(true);


        // Create the cache
        Cache<String, String> cache = manager.createCache("capitals", cacheConfig);

        // Enter some Capitals
        cache.put("UK", "London");
        cache.put("France", "Paris");
        cache.put("Spain", "Madrid");
        cache.put("Belgium", "Brussels");
        cache.put("Germany", "Berlin");

        // I forgot, what's the Capital of Portugal?
        System.out.println("Capital of Portugal is : " + cache.get("Portugal"));
    }

}
