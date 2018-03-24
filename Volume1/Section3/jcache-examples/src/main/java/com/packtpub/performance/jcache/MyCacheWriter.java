package com.packtpub.performance.jcache;

import javax.cache.Cache;
import javax.cache.integration.CacheWriter;
import javax.cache.integration.CacheWriterException;
import java.util.Collection;

/**
 * Example of a JCache CacheWriter, use this to write to a RDBMS or somefink.
 */
public class MyCacheWriter implements CacheWriter<String, String> {

    public void write(Cache.Entry<? extends String, ? extends String> entry) throws CacheWriterException {
        System.out.println("Write Entry : " + entry.getKey());
    }

    public void writeAll(Collection<Cache.Entry<? extends String, ? extends String>> entries) throws CacheWriterException {
        for (Cache.Entry entry : entries) {
            System.out.println("Write Entry : " + entry.getKey());
        }
    }

    public void delete(Object key) throws CacheWriterException {

    }

    public void deleteAll(Collection<?> keys) throws CacheWriterException {

    }
}
