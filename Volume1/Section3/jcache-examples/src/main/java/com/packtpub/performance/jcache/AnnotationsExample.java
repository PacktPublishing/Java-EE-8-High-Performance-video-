package com.packtpub.performance.jcache;

import javax.cache.annotation.*;

/**
 * Example Annotations
 */
@CacheDefaults(cacheName = "capitals")
public class AnnotationsExample {

    @CacheResult()
    public String getCapital(String country){
        // Stuff
        return "default";
    }

    @CacheRemove()
    public void removeCapital(String country){
        // Stuff
    }

    @CacheRemoveAll()
    public void removeAllCapitals(){
        // Stuff
    }

    @CachePut()
    public void createCapital(@CacheKey String country, @CacheValue String capital) {
        // Stuff
    }

}
