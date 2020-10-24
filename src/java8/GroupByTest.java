package java8;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import threads.semaphore.Log;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.jianshu.com/p/232fc8acedba
 */

public class GroupByTest {

    public static void main(String[] args) {

        List<Fruit> fruitList = Lists.newArrayList(
                new Fruit("apple", 6.0),
                new Fruit("apple", 6.0),
                new Fruit("banana", 7.0),
                new Fruit("banana", 7.0),
                new Fruit("banana", 7.0),
                new Fruit("grape", 8.0));


        Function<Fruit,List<Object>> compositeKey = p-> Arrays.asList(p.getName(),p.getPrice(),null);
       //key是集合Arrays.asList(p.getName(),p.getPrice())

        Map<Object, Long> mapp = fruitList.stream().collect(Collectors.groupingBy(compositeKey,Collectors.counting()));
        //数量大于1输出
        for (Map.Entry<Object,Long> entry:mapp.entrySet()){
            if(entry.getValue()>=2){
                System.out.println("包含重复"+entry.getKey());
            }
        }

        Map<String, Long> map = fruitList.stream().
                collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));


        map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(System.out::println);

        Map<String, Double> sumMap = fruitList.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.summingDouble(Fruit::getPrice)));

        System.out.println(sumMap);
        Map<String, List<Fruit>> groupMap =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName));
        System.out.println(groupMap);


        Map<org.springframework.data.util.Pair<String,Double>, List<Fruit>> groupMapPair =
                fruitList.stream().collect(Collectors.groupingBy( p-> org.springframework.data.util.Pair.of(p.getName(),p.getPrice())));
        System.out.println(groupMapPair);


        Map<String, List<Double>> groupMap2 =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName,
                        Collectors.mapping(Fruit::getPrice, Collectors.toList())));

        System.out.println(groupMap2);

        List<String> stringList = Arrays.asList("Hello", "Java", "JDK", "Android", "Kotlin", "World");

        List<Integer> collect = stringList.stream()
                .collect(Collectors.mapping(String::length, Collectors.toList()));
        /**
         * Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
         *  含义：将一个Collector的类型进行转换，在进行元素聚合之前，使用mapper参数将每一个输入的T类型的元素转换为U类型。mapping函数常用于多级分区和多级分组
         *  泛型含义：
         *   T 输入的元素的类型
         *   U downstream的输入类型，也就是mapper的结果类型
         *   A downstream的中间聚合的类型
         *   R 聚合的结果类型
         *  参数含义：Function接口的作用是接受一个T类型的参数，返回U类型，mapper的含义就是装换流中元素，downstream接受转换后的类型，downstream的聚合结果是R类型，同返回值的结果聚合类型一致。约等于 downstream的结果就是该函数返回的结果
         */
        //将集合的元素转为长度(计算后的对象)，同时聚合至list，
        //Collectors.toList()的结果就是整个链的结果
        System.out.println(collect);

        Multimap<String, Double> multiMap = ArrayListMultimap.create();
        fruitList.forEach(fruit -> multiMap.put(fruit.getName(), fruit.getPrice()));

        System.out.println(multiMap);

        Map<String, Set<Double>> mapSet = fruitList.stream().
                collect(Collectors.groupingBy(Fruit::getName, Collectors.mapping(Fruit::getPrice, Collectors.toSet())));
        System.out.println(mapSet);

    }


}
