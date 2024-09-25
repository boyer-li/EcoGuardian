package com.boyer.utils;

import java.util.HashMap;

public class CacheUtils {
    private static final HashMap<String,Object> cache = new HashMap<String, Object>();

    public static Object get(String key,Object defaultValue){
        System.out.println("访问了CacheUtils，objectget:"+key);
        Object obj = cache.get(key);
        System.out.println("CacheUtils"+obj);
        return obj == null ? defaultValue : obj;
    }

    public static void put(String key,Object obj){
       System.out.println("访问了CacheUtils"+key+obj);
        cache.put(key,obj);
    }

    public static void remove(String key){
        cache.remove(key);
    }
}
