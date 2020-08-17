package cache;

public class CacheLineTest {


    //Cache Line 是 CPU 和主存之间数据传输的最小单位。
    //Cache Line 常见大小为(X86)64字节,64字节,64字节会在传输数据的时候,从内存中连续取64字节的数据.

    public static void main(String[] args) {
        long[][] arr = new long[1024 * 1024][8];
        int sum = 0;
        long marked = System.currentTimeMillis();
        //第一种遍历方式，即按照内存顺序遍历。
        //所以，在从内存中读取数据的时候，会读取连续的数据到cpu的缓存中。所以会非常快
        for (int i = 0; i < 1024 * 1024; i += 1) {
            for (int j = 0; j < 8; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Loop time:" + (System.currentTimeMillis() - marked) + "ms");

        //这样访问顺序对于cpu的高速缓存并不友好。 每次加载到 CacheLine的数据只用到了其中一个，导致总是去内存读取数据。
        sum = 0;
        marked = System.currentTimeMillis();
        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 1024 * 1024; j++) {
                sum += arr[j][i];
            }
        }
        System.out.println("Loop time:" + (System.currentTimeMillis() - marked) + "ms");

    }

}
