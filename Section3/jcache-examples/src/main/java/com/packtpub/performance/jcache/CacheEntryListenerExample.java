package com.packtpub.performance.jcache;

import static com.packtpub.performance.jcache.Providers.*;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.*;
import javax.cache.event.CacheEntryEventFilter;
import javax.cache.spi.CachingProvider;

/**
 * Cache Data Example
 */
public class CacheEntryListenerExample {
    private static final Factory<? extends CacheEntryEventFilter> NO_FILTER = null;

    public static void main(String[] args) {
    	final boolean IS_SYNCHRONOUS = (args != null && args.length > 1) ? Boolean.getBoolean(args[1]) : false;
        final boolean IS_OLD_VALUE_REQUIRED = (args != null && args.length > 2) ? Boolean.getBoolean(args[2]) : false;

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
                        .setTypes(String.class, String.class);

        // Create the cache
        Cache<String, String> cache = manager.createCache("capitals", cacheConfig);

        // Create the Listener

        //You can put CacheEntryEventFilter in here as well...
        CacheEntryListenerConfiguration listenerConfigurationWithFilter =
                new MutableCacheEntryListenerConfiguration(FactoryBuilder.factoryOf(MyCacheEntryListener.class),
                        FactoryBuilder.factoryOf(MyCacheEntryEventFilter.class),
                        IS_OLD_VALUE_REQUIRED,
                        IS_SYNCHRONOUS);

        CacheEntryListenerConfiguration listenerConfiguration =
                new MutableCacheEntryListenerConfiguration(FactoryBuilder.factoryOf(MyCacheEntryListener.class),
                        NO_FILTER,
                        IS_OLD_VALUE_REQUIRED,
                        IS_SYNCHRONOUS);

        cache.registerCacheEntryListener(listenerConfiguration);

        // Enter some Capitals
        cache.put("UK", "London");
        cache.put("France", "Paris");
        cache.put("Spain", "Madrid");
        cache.put("Belgium", "Brussels");
        cache.put("Germany", "Berlin");

        System.exit(0);
    }
}
