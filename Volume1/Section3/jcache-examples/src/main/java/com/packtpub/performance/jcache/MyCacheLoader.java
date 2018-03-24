package com.packtpub.performance.jcache;

import javax.cache.integration.CacheLoader;
import javax.cache.integration.CacheLoaderException;
import java.util.Map;

/**
 * Sample of a Read Through CacheLoader
 */
public class MyCacheLoader implements CacheLoader<String, String> {

    public String load(String key) throws CacheLoaderException {
        if ("Portugal".equals(key)) {
            return "Lisbon";
        }
        return null;
    }

    /**
     * Async Load Up of a Cache.
     */
    public Map<String, String> loadAll(Iterable<? extends String> keys) throws CacheLoaderException {

        // Iterate the keys and maybe batch load from a DB, a Filesystem or some other System completely.
        return null;

    }
}
