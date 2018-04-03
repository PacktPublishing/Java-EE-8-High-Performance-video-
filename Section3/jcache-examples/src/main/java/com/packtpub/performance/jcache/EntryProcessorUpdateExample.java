package com.packtpub.performance.jcache;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.MutableEntry;
import javax.cache.spi.CachingProvider;

import static com.packtpub.performance.jcache.Providers.PROVIDER_MAP;

/**
 * Caching Provider Example
 */
public class EntryProcessorUpdateExample {

    public static void main(String[] args) {
    	
		CachingProvider cachingProvider = null;
		if (args != null && args.length > 0) {
			 // Acquire an explicit cache provider
			cachingProvider = Caching.getCachingProvider(String.valueOf(PROVIDER_MAP.get(args[0])));
		} else {
			// Acquire the default cache provider (fallback)
			cachingProvider = Caching.getCachingProvider();
		}

        // Acquire the default cache manager
        CacheManager manager = cachingProvider.getCacheManager();

        // Define a cache
        MutableConfiguration<String, String> cacheConfig =
                new MutableConfiguration<String, String>()
                        .setStoreByValue(true)
                        .setTypes(String.class, String.class);

        // Create the cache
        Cache<String, String> cache = manager.createCache("capitals", cacheConfig);

        // Enter some Capitals
        cache.put("UK", "London");
        cache.put("France", "Paris");
        cache.put("Spain", "Madrid");
        cache.put("Belgium", "Brussels");
        cache.put("Germany", "Berlin");

        // Check capital
        System.out.println("Capital of Germany is : " + cache.get("Germany"));
       
        // Convert a Capital to Upper Case
        cache.invoke("Germany", new EntryProcessor<String, String, Object>() {
            public Object process(MutableEntry<String, String> entry, Object... arguments) throws EntryProcessorException {
                if (entry.exists()) {
                    entry.setValue(entry.getValue().toUpperCase());
                }
                return null;
            }
        });

        // Now Check capital again
        System.out.println("Capital of Germany is : " + cache.get("Germany"));
        
        System.exit(0);
    }

}
