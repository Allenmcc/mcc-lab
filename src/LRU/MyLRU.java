package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by chunchen.meng on 2019/2/26.
 */
public class MyLRU extends LinkedHashMap {

    private  int maxSize;

    public  MyLRU (int maxSize){

        super(maxSize,0.75f,true);
        this.maxSize = maxSize;

    }

    @Override
    public boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxSize;
    }

    public static void main(String[] args) {
        MyLRU myLRU = new MyLRU(3);
        myLRU.put(1,1);
        myLRU.put(2,2);
        myLRU.put(3,3);
        myLRU.put(4,4);
        System.out.println(myLRU);


    }
}
