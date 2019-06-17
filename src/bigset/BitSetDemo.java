package bigset;

import java.util.BitSet;

/**
 * Created by chunchen.meng on 2019/4/18.
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        System.out.println("default size="+bitSet.size()+" "+bitSet.length());

        BitSet bitSet2 = new BitSet(1);
        System.out.println("        size="+bitSet2.size()+" "+bitSet.length());

        //这个时候bitSet.size() = 128;   2个long
        BitSet bitSet3 = new BitSet(100);
        System.out.println("allocate size="+bitSet3.size()+" "+bitSet.length());

        //这个时候bitSet.size() = 256；  4个long
        BitSet bitSet4 = new BitSet(200);
        System.out.println("allocate size="+bitSet4.size()+" "+bitSet.length());


        //创建一个具有10000000位的bitset　初始所有位的值为false
        BitSet bitSet5 = new BitSet(10000000);
        //将指定位的值设为true
        bitSet5.set(9999);
        //或者bitSet.set(9999,true);
        //输出指定位的值
        System.out.println("9999:"+bitSet5.get(9999));
        System.out.println("9998:"+bitSet5.get(9998));


    }

}
