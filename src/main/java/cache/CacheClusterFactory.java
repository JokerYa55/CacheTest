/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

import org.infinispan.Cache;

/**
 *
 * @author vasil
 * @param <K>
 * @param <V>
 */
public class CacheClusterFactory<K, V> implements CacheFactoryInterface<K, V>{

    private Cache<K, V> cache;

    private CacheClusterFactory() {
    }

    @Override
    public Cache<K, V> create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
