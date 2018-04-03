package com.packtpub.performance.jcache;

import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryEventFilter;
import javax.cache.event.CacheEntryListenerException;

/**
 * Sample Entry Event Filter
 */
public class MyCacheEntryEventFilter implements CacheEntryEventFilter<String, String> {

    public boolean evaluate(CacheEntryEvent<? extends String, ? extends String> event) throws CacheEntryListenerException {
        return "London".equals(event.getValue());
    }
}
