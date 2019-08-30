/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

/**
 *
 * @author vasil
 * @param <K>
 * @param <V>
 */
public class CacheLocalFactory<K, V> implements CacheFactoryInterface<K, V>{

    private Cache<K, V> cache;

    private CacheLocalFactory() {
    }

    public static Cache create(String cachename, String tempDir) {
        EmbeddedCacheManager manager = new DefaultCacheManager();
        Configuration config = new ConfigurationBuilder()
                .persistence().passivation(false)
                .addSingleFileStore().location(tempDir).async().enable()
                .preload(false).shared(false).build();
        manager.defineConfiguration(cachename, config);
        return manager.getCache();
    }

    @Override
    public Cache<K, V> create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
