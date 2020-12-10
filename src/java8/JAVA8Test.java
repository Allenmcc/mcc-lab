package java8;

import com.google.common.collect.Lists;
import listTest.*;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
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

       System.out.println(outputStream.mapToInt(n->n).sum());

        System.out.println(outputStream.collect(Collectors.toList()));

//        System.out.println(outputStream.collect(Collectors.toSet()));
        List<Integer> result = null ;
//        System.out.println(result.stream().collect(Collectors.toList()));
//        System.out.println(result.stream().collect(Collectors.toSet()));

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
        c.id = 0;
        c.age = 30;
        list.add(a);
        list.add(b);
        list.add(c);


        //过滤
        List<Person> l2 = list.stream().filter(p -> p.id == 1).collect(Collectors.toList());
        List<Integer> ll2 = list.stream().filter(p -> p.id == 2).map(p->p.age).collect(Collectors.toList());


        //取某些字段,对某些元素操作
        List<Integer> l3 = list.stream().map(p -> p.age).collect(Collectors.toList());
        List<Integer> l4 = list.stream().map(Person::getAge).collect(Collectors.toList());

        Optional<Integer> optional = list.stream().map(p->p.getAge()).findFirst();
        optional.ifPresent(e->System.out.println("optional.ifPresent:"+e));

        list.stream().forEach(p -> System.out.println(p.getAge() + " " + p.getId()));

        System.out.println(list.size());

        //sorted
//       List<Person> sortedPersons =  list.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
       List<Person> sortedPersons =  list.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
       //reversed() 只能Person::getAge() 形式
       List<Person> sortedPersons2 =  list.stream().sorted(Comparator.comparing(p->p.getAge())).collect(Collectors.toList());


       //没有去重处理
//        Map<Integer,Person> listToMap0 = list.stream().collect(Collectors.toMap(Person::getId,cc -> cc));
//        Map<Integer,Person> listToMap00 = list.stream().collect(Collectors.toMap(Person::getId,Function.identity()));


        //Collectors.toMap(key,value,rule)  rule (aa,bb)->bb  重复key 保存后面
        Map<Integer,Integer> listToMap = list.stream().collect(Collectors.toMap(Person::getId,Person::getAge,(aa,bb)->aa));
        Map<String,Integer> listToMapStr = list.stream().collect(Collectors.toMap(p->p.getId()+p.getAge()+"",Person::getAge));
        Map<String,Person> listToMapStr2 = list.stream().collect(Collectors.toMap(p->p.getId()+p.getAge()+"",p->p,(aa,bb)->aa));


        Integer abc = listToMapStr.get("1212");

        //value是对象 Function.identity()
        Map<Integer,Person> listToMap2 = list.stream().collect(Collectors.toMap(Person::getId,Function.identity(),(aa,bb)->bb));
        //map 转对应类型 ConcurrentHashMap::new
        Map<Integer,Person> listToTreeMap = list.stream().collect(Collectors.toMap(Person::getId,Function.identity(),(aa,bb)->bb, TreeMap::new));



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEach(p->System.out.println(p));

        numbers.parallelStream()
                .map(p->p+1).map(p-> p*2).forEach(p-> System.out.println(p));

        //和之前Intergr类型不一样
        List<String> nStrs = numbers.stream().map(p -> p + "tt").collect(Collectors.toList());
        nStrs.forEach(p-> System.out.println(p));


        List<String> ss = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
    // 获取空字符串的数量
        long count = ss.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);





    }

    @Test
    public void testParalleStream(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

//
//        numbers.parallelStream().forEach(p->{
//            System.out.println("aa"+Thread.currentThread()+p);
//        });


//        中间操作(结果是Stream map,filter)之间也是没有顺序
        numbers.parallelStream()
                .map(p -> {
                    System.out.println("a:" + Thread.currentThread()+ p);
                    return p + 1;
                })
                .map(p -> {
                    System.out.println("b:" + Thread.currentThread()+ p);
                    return p * 10;
                })
                .forEach(p -> System.out.println("c:" + Thread.currentThread() + p));


        System.out.println("---------------------------->");

        //numbers 没有变,如果numbers是对象会变
        numbers.parallelStream().map(p -> {
            p=p*10;
            return p ;
        }).collect(Collectors.toList());

        //numbers 变成新的list (numbers 接受新的值)
       numbers = numbers.parallelStream().map(p -> {
            p=p*10;
            return p ;
        }).collect(Collectors.toList());


        List<String> strings =  numbers.parallelStream().map(p->p.toString()).collect(Collectors.toList());
        System.out.println(strings);
    }


    @Test
    public void testParalleStream2() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        numbers.parallelStream().forEach(p -> {
                    System.out.println(count());
                }
        );

    }

    private int count(){
        int cnt = 0;
        for (int i=0;i<10000000;i++){
            cnt++;
        }
        return cnt;
    }

    /**
     * https://www.cnblogs.com/sueyyyy/p/13079525.html
     */
    @Test
    public void testStream() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        List<Integer> streamList = new ArrayList<>();  //线程不安全 <1000
//        List<Integer> streamList = new CopyOnWriteArrayList<>();  //线程安全
//        List<Integer> streamList =  Collections.synchronizedList(Arrays.asList());
        list.parallelStream().forEach(streamList::add);
//        List<Integer> res= list.parallelStream().filter(p->p>=0).collect(Collectors.toList());
        System.out.println(streamList.size());
    }

}

