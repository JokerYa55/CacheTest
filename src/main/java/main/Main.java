/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import beans.KeyBean;
import beans.KeyData;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import static org.infinispan.eviction.EvictionStrategy.LIRS;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.persistence.jdbc.configuration.JdbcStringBasedStoreConfigurationBuilder;
import org.jgroups.util.UUID;

/**
 *
 * @author vasil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
//        EmbeddedCacheManager manager = new DefaultCacheManager();
//        manager.defineConfiguration("custom-cache", new ConfigurationBuilder()
//                .eviction().strategy(LIRS).maxEntries(10)
//                .build());
//        Cache<Object, Object> c = manager.getCache("custom-cache");
//        Cache<Object, Object> c = new DefaultCacheManager("infinispan.xml").getCache("xml-configured-cache");
//        EmbeddedCacheManager manager = new DefaultCacheManager();
//        Configuration config = new ConfigurationBuilder()
//                .persistence().passivation(false)
//                .addSingleFileStore().location("/temp/cache").async().enable()
//                .preload(false).shared(false).build();
//        manager.defineConfiguration("test", config);
//        Cache<Object, Object> cache = manager.getCache("test");
//        for (int i = 1; i < 10000; i++) {
//            cache.put("test_" + i, "1_" + i);
//        }

        //EmbeddedCacheManager manager = new DefaultCacheManager();
        GlobalConfigurationBuilder global = GlobalConfigurationBuilder.defaultClusteredBuilder();
        global.transport().clusterName("cluster");
        DefaultCacheManager manager = new DefaultCacheManager(global.build());
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.persistence().addStore(JdbcStringBasedStoreConfigurationBuilder.class)
                .fetchPersistentState(false)
                .ignoreModifications(false)
                .purgeOnStartup(false)
                .shared(false)
                .table()
                .dropOnExit(true)
                .createOnStart(true)
                .tableNamePrefix("cache")
                .idColumnName("ID_COLUMN").idColumnType("TEXT")
                .dataColumnName("DATA_COLUMN").dataColumnType("bytea")
                .timestampColumnName("TIMESTAMP_COLUMN").timestampColumnType("bigint")
                .connectionPool()
                .connectionUrl("jdbc:postgresql://localhost:5432/orders")
                .username("postgres")
                .password("123")
                .driverClass("org.postgresql.Driver");

        manager.defineConfiguration("test", builder.build());
        Cache<Object, Object> cache = manager.getCache("test");
        for (int i = 1; i < 10000; i++) {
            cache.put("test_" + i, "1_" + i);
        }
        KeyBean key = new KeyBean();
        key.setId(UUID.randomUUID().toString());

        KeyData data = new KeyData();
        data.setData("test");
        cache.put("test_500", data, 10, TimeUnit.SECONDS);
        System.out.println(cache.get("test_500"));
        //cache.clear();
        //manager.stop();
        TimeUnit.SECONDS.sleep(30);
        System.out.println("End sleep");
        System.out.println(cache.get("test_500"));

    }

}
