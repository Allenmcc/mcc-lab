package hashTest;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    @Test
    public void testConcurrentHashMap(){

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1,12);
        concurrentHashMap.put(2,2);
        concurrentHashMap.put(3,13);
        concurrentHashMap.put(4,15);
        concurrentHashMap.put(4,18);

        System.out.println(concurrentHashMap.get(4));
    }
}
