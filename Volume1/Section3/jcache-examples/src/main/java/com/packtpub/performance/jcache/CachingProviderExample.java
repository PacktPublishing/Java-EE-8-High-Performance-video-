package com.packtpub.performance.jcache;

import static com.packtpub.performance.jcache.Providers.PROVIDER_MAP;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

/**
 * Caching Provider Example
 */
public class CachingProviderExample {

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

    }

}
