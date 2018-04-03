package com.packtpub.performance.jcache;

import static com.packtpub.performance.jcache.Providers.*;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Factory;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.event.CacheEntryEventFilter;
import javax.cache.spi.CachingProvider;
import java.util.Iterator;

/**
 * Caching Provider Example
 */
public class MultiUpdateExample {
	private static final Factory<? extends CacheEntryEventFilter> NO_FILTER = null;

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

         final CacheEntryListenerConfiguration listenerConfiguration =
                new MutableCacheEntryListenerConfiguration(FactoryBuilder.factoryOf(MyCacheEntryListener.class),
                        NO_FILTER, false, true);
      
        // Create the cache
        final Cache<String, String> cache = manager.createCache("capitals", cacheConfig);
        cache.registerCacheEntryListener(listenerConfiguration);

        // Enter some Capitals
        cache.put("UK", "London");
        cache.put("France", "Paris");
        cache.put("Spain", "Madrid");
        cache.put("Belgium", "Brussels");
        cache.put("Germany", "Berlin");

        // Check capital
        System.out.println("Capital of France is : " + cache.get("France"));
        
        // Convert Capitals to Upper Case

        // Iterate and Update (Also look! No locks available in JCache, using CAS update with replace).
        Iterator<Cache.Entry<String, String>> iterator = cache.iterator();
        while (iterator.hasNext()) {
            Cache.Entry<String, String> cacheEntry = iterator.next();
            String value = cacheEntry.getValue();
            String key = cacheEntry.getKey();
            String upperCase = value.toUpperCase();
            cache.replace(key, value, upperCase);
        }

        // Now Check capital again
        System.out.println("Capital of France is : " + cache.get("France"));
    
        System.exit(0);
    }
}
