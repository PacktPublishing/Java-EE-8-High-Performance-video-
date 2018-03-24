package com.packtpub.performance.jcache;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public abstract class Providers {
    private static final String CACHING_PROVIDER_EHCACHE = "org.ehcache.jcache.JCacheCachingProvider";
    private static final String CACHING_PROVIDER_HAZELCAST = "com.hazelcast.cache.HazelcastCachingProvider";
    private static final String CACHING_PROVIDER_COHERENCE = "com.tangosol.coherence.jcache.CoherenceBasedCachingProvider";
	private static final String[][] PROVIDERS = { { "ehcache", CACHING_PROVIDER_EHCACHE },
			{ "hazelcast", CACHING_PROVIDER_HAZELCAST }, { "coherence", CACHING_PROVIDER_COHERENCE } };
	@SuppressWarnings("rawtypes")
	static final Map PROVIDER_MAP = ArrayUtils.toMap(PROVIDERS);
}
