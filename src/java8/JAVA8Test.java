package java8;

import com.google.common.collect.Lists;
import listTest.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.io.FileDescriptor.out;

/**
 * Created by chunchen.meng on 2017/11/1.
 */
public class JAVA8Test {

    public static void main(String args[]) {

//        List<String> output = wordList.stream().
//                map(String::toUpperCase).
//                collect(Collectors.toList());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
//        List<Integer> nums = new ArrayList<>();
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).filter(p -> p.equals(2)).
                collect(Collectors.toList());

//        Stream.of(nums).map(n -> n * n).collect(Collectors.toList());


        System.out.println(squareNums.size());

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());

//       System.out.println(outputStream.mapToInt(n->n).sum());

        System.out.println(outputStream.collect(Collectors.toList()));

//       System.out.println(outputStream.collect(Collectors.toSet()));

//       System.out.println(outputStream.collect(Collectors.joining()).toString());

//       System.out.println(outputStream.collect(Collectors.toCollection(ArrayList::new)));

//        outputStream.forEach(System.out::println);

        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens =
                Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);

        System.out.println(evens.length);


        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .peek(e -> System.out.println("test value: " + e))
                .collect(Collectors.toList());


        List<Integer> test = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

        System.out.println("sum is:" + test.stream().filter(num -> num != null).

                distinct().mapToInt(num -> num * 2).

                peek(System.out::println).skip(2).limit(4).sum());


        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        //自然排序
        List<String> sorted = strings.stream().sorted().collect(Collectors.toList());


        List<Person> list = new ArrayList<Person>();
        Person a = new Person();
        a.id = 1;
        a.age = 10;
        Person b = new Person();
        b.id = 2;
        b.age = 20;

        Person c = new Person();
        c.id = 2;
        c.age = 30;
        list.add(a);
        list.add(b);
        list.add(c);


        //过滤
        List<Person> l2 = list.stream().filter(p -> p.id == 1).collect(Collectors.toList());


        //取某些字段,对某些元素操作
        List<Integer> l3 = list.stream().map(p -> p.age).collect(Collectors.toList());
        List<Integer> l4 = list.stream().map(Person::getAge).collect(Collectors.toList());

        list.stream().forEach(p -> System.out.println(p.getAge() + " " + p.getId()));

        System.out.println(list.size());

        //sorted
       List<Person> sortedPersons =  list.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
       //reversed() 只能Person::getAge() 形式
       List<Person> sortedPersons2 =  list.stream().sorted(Comparator.comparing(p->p.getAge())).collect(Collectors.toList());



       //Collectors.toMap  (aa,bb)->bb  重复key 保存后面
        Map<Integer,Integer> listToMap = list.stream().collect(Collectors.toMap(Person::getId,Person::getAge,(aa,bb)->aa));
        Map<String,Integer> listToMapStr = list.stream().collect(Collectors.toMap(p->p.getId()+p.getAge()+"",Person::getAge));

        //value是对象 Function.identity()
        Map<Integer,Person> listToMap2 = list.stream().collect(Collectors.toMap(Person::getId,Function.identity(),(aa,bb)->bb));
        //map 转对应类型 ConcurrentHashMap::new
        Map<Integer,Person> listToTreeMap = list.stream().collect(Collectors.toMap(Person::getId,Function.identity(),(aa,bb)->bb, TreeMap::new));




        List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple", 6.0),
                new Fruit("apple", 6.0),
                new Fruit("banana", 7.0), new Fruit("banana", 7.0),
                new Fruit("banana", 7.0), new Fruit("grape",8.0));

        Map<String, Long> map = fruitList.stream().
                collect(Collectors.groupingBy(Fruit::getName,Collectors.counting()));
        System.out.println(map);

        Map<String, Long> map2 = fruitList.stream().map(Fruit::getName).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map2);

//
//        Map<String, Set<Long>> mapSet = fruitList.stream().
//                collect(Collectors.groupingBy(Fruit::getName,Collectors.mapping(Fruit::getPrice,Collectors.toSet())));
//        System.out.println(mapSet);



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEach(p->System.out.println(p));

        List<String> ss = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
    // 获取空字符串的数量
        long count = ss.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);




    }

}

