package java8;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * 匿名函数
 * 函数接口
 */
public class BIConsumerTest {
    public static void main(String[] args) {
        BiConsumer<Integer,Integer> consumer = (a, b) -> {
            System.out.println(a + b);
        };
        consumer.accept(5, 2);


        BiConsumer<Integer,Integer> consumer2 = (a, b) -> {
            System.out.println(a - b);
        };

        consumer.andThen(consumer2).accept(10,2);

        Boolean t = null;

        System.out.println(t);



    }




}
