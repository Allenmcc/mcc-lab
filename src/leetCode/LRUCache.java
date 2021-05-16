package leetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现LRU
 */
public class LRUCache {

    int size;
    Map<Integer, Integer> map;

    public LRUCache(int size) {
        this.size = size;
        map = new LinkedHashMap<>();
    }

    public Integer get(Integer key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(Integer key, Integer value) {

        if (!map.containsKey(key)) {
            map.put(key, value);
        }

        map.remove(key);
        map.put(key, value);
        //超过大小，删除第一个
        if (map.size() > size) {
            map.remove(map.entrySet().iterator().next().getKey());

        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 6);
        lruCache.put(4, 5);
        lruCache.get(3);
        System.out.println(lruCache);


    }

}
