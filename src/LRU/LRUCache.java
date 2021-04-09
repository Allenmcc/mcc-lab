package LRU;

import java.util.LinkedHashMap;


/**
 * LinkedHashMap 实现LRU (赞)
 */

public class LRUCache extends LinkedHashMap {
    /**
     * 传递进来最多能缓存多少数据
     *
     * @param maxSize 缓存大小
     */
    public LRUCache(int maxSize) {
        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super(maxSize, 0.75F, true);
        maxElements = maxSize;
    }

    /**
     * 钩子方法，通过put新增键值对的时候，若该方法返回true
     * 便移除该map中最老的键和值
     */
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
        // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > maxElements;
    }

//    private static final long serialVersionUID = 1L;
    protected int maxElements;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);
        System.out.println(lruCache);
    }
}