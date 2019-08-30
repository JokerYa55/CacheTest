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
 */
public interface CacheFactoryInterface<K, V> {

    public Cache<K, V> create();
}
