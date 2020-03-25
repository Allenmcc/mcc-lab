package intTest;

/**
 * Created by chunchen.meng on 2019/6/19.
 * https://www.cnblogs.com/guodongdidi/p/6953217.html
 */
public class IntTest {

    public static void main(String[] args) {

        Integer i = new Integer(100);
        Integer j = new Integer(100);
        //由于Integer变量实际上是对一个Integer对象的引用，
        // 所以两个通过new生成的Integer变量永远是不相等的（因为new生成的是两个对象，其内存地址不同）。
        //== 比较地址
        System.out.println(i == j); //false

        //equals 比较值
        System.out.println(i.equals(j)); //true


        //Integer变量和int变量比较时，只要两个变量的值是向等的，则结果为true
        //（因为包装类Integer和基本数据类型int比较时，java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较）
        Integer i1 = new Integer(100);
        int j1 = 100;
        System.out.println(i1 == j1); //true


        Integer i2 = new Integer(100);
        Integer j2 = 100;
        System.out.println(i2 == j2); //false
        System.out.println(i2.equals(j2)); //true


        //对于两个非new生成的Integer对象，进行比较时，如果两个变量的值在区间-128到127之间，则比较结果为true
        // 如果两个变量的值不在此区间，则比较结果为false
        Integer i3 = 100;
        Integer j3 = 100;
        System.out.println(i3 == j3); //true

        Integer i4 = 128;
        Integer j4 = 128;
        System.out.println(i4 == j4); //false

        /**
         * 对于第4条的原因：
         java在编译Integer i = 100 ;时，会翻译成为Integer i = Integer.valueOf(100)；，而java API中对Integer类型的valueOf的定义如下：

         public static Integer valueOf(int i){
             assert IntegerCache.high >= 127;
              if (i >= IntegerCache.low && i <= IntegerCache.high){
               return IntegerCache.cache[i + (-IntegerCache.low)];
         }
         return new Integer(i);
         }
         java对于-128到127之间的数，会进行缓存，Integer i = 127时，会将127进行缓存，下次再写Integer j = 127时，就会直接从缓存中取，就不会new了
         */

        Integer integer;
        int ii;
        System.out.println(getInteger());
    }

    private static int getInteger(){
//        Integer integer = new Integer();
        int i = 2;
        return i;
    }
}
