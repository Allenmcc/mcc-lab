package java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 看方法的返回值,可以看到中间操作的返回类型都是Stream，而终结操作的返回类型是其他的结果，也就不能在进行流的链式操作了。
 *
 * https://blog.csdn.net/weixin_42596738/article/details/109387353
 * Stream的中间操作：中间操作在一个流上进行操作，返回结果是一个新的流。这些操作是延迟执行
 *
 *   过滤 filter
 *   去重 distinct
 *   排序 sorted
 *   截取 limit、skip
 *   转换 map/flatMap
 *   其他 peek
 *
 * Stream的终止操作:终结操作遍历流来产生一个结果或是副作用。在一个流上执行终结操作之后，该流被消费， 无法再次被消费
 *  1.匹配与查找
 * * allMatch(Predicate p)  是否匹配所有
 * * anyMatch(Predicate p) - 是否匹配一个
 * * noneMatch(Predicate p)  是否没有匹配一个
 * * findFirst 返回第一个
 * * count 返回总数
 * * max(Comparator c)  返回最大
 * * min(Comparator c)  返回最小
 * * forEach(Consumer c) -内部迭代
 *
 *  2.归约
 * * reduce(T iden,BinaryOperator b) :可以将流中元素反复结合起来，得到一个值，返回T
 * * reduce(BinaryOperator b) :可以将流中元素反复结合起来，得到一个值，返回一个Optional< T >
 *
 * * 3.收集
 *    collect(Collector c)
 *   1 将流转换成其他的形式(其他集合)
 *   2 接收Collector接口 用于Stream中元素各种汇总      特例 Collectors.joining()拼接字符串
 */
public class StreamTest {

    List<Employee> employeeList = Arrays.asList(
            new Employee(1, "a", 15, 1333.0, Status.BUSY),
            new Employee(2, "b", 25, 13334.0, Status.FREE),
            new Employee(3, "d", 35, 13332.0, Status.BUSY),
            new Employee(4, "c", 17, 1523.0, Status.FREE),
            new Employee(5, "f", 18, 1237.0, Status.FREE),
            new Employee(6, "a", 19, 1239.0, Status.FREE)

    );

    //创建stream
    @Test
    public void test() {
        //1.可以通过Collection系列集合提供stream()或paralleStream()
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();


        //2.通过Arrays的静态方法stream()获得数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream = Arrays.stream(employees);

        //3.通过Stream 的静态方法of()
        Stream<String> stringStream1 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        Stream<Integer> stream1 = Stream.iterate(0, x -> x + 2);
        //forEach(Consumer<? super T> action); 消费函数,没有返回值
        stream1.limit(10).forEach(System.out::println);


        //生成

        //limit 短路
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
        //skip 与limit 互补 跳过前101个
        Stream.generate(() -> Math.random()).skip(10).forEach(System.out::println);
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "dd");


        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //Map   {{a,a,a},{b,b,b},{c,c,c},{d,d}}  相当于add
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest::filterCharacter);
        streamStream.forEach(s ->
                s.forEach(System.out::println)
        );

//        streamStream.forEach(System.out::println);


        //flatMap  打平   {a,a,a,b,b,b,c,c,c,d,d} 相当于addAll
        Stream<Character> streamflatMap = list.stream().flatMap(StreamTest::filterCharacter);
        streamflatMap.forEach(System.out::println);

    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> charlist = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            charlist.add(character);

        }
        return charlist.stream();
    }

    @Test
    public void testFlatMap(){
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();

        for(List<String> team : playersInWorldCup2016){
            for(String name : team){
                listOfAllPlayers.add(name);
            }
        }

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);


        // Now let's do this in Java 8 using FlatMap
        //把几个小的list转换到一个大的list  addAll()
        List<String> flatMapList = playersInWorldCup2016.stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

        System.out.println("List of all Players using Java 8");
        System.out.println(flatMapList);
    }

    /**
     * 中间排序
     * sorted() 自然排序（Comparable）
     * sorted(Comparator com) 定制排序（Comparator）
     */
    @Test
    public void testSort() {
        List<String> list = Arrays.asList("aaa", "bbb", "ddd", "cc");
        list.stream().sorted().forEach(System.out::println);


        employeeList.stream().sorted((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
//                return -e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);

    }

    /**
     * 查找与匹配
     */
    @Test
    public void testFind() {

        //是否匹配所有
        boolean re = employeeList.stream().allMatch(e -> e.getAge().equals(11));
        System.out.println(re);

        //检查至少匹配一个
        boolean re1 = employeeList.stream().anyMatch(e -> e.getAge().equals(11));
        System.out.println(re1);

        //检查是否没有匹配所有元素
        boolean re2 = employeeList.stream().noneMatch(e -> e.getAge().equals(11));
        System.out.println(re2);

        Optional<Employee> optional = employeeList.stream().sorted((e1, e2) ->
                Double.compare(e1.getSalary(), e2.getSalary())
        ).findFirst();

        System.out.println(optional.get());


        //parallelStream()并行流  stream() 串行流 由上到下第一个
        Optional<Employee> optional2 = employeeList.parallelStream().
                filter(e -> e.getStatus().equals(Status.FREE)
                ).findAny();

        System.out.println(optional2.get());


    }

    @Test
    public void testCountMaxMin() {
        Long count = employeeList.stream().count();
        System.out.println(count);

        //金额最大的员工
        Optional<Employee> optional = employeeList.stream().max((e1, e2) ->
                e1.getSalary().compareTo(e2.getSalary())
        );

        System.out.println(optional.get());

        //金额最小的金额
        Optional<Double> optional2 = employeeList.stream()
                .map(Employee::getSalary)
                .min(Double::compareTo);
        System.out.println(optional2.get());
    }


    /**
     * 归约
     * reduce(T identity,BinaryOperator) /reduce(BinaryOperator)
     * 可以将流中元素反复结合起来，得到一个值
     */
    @Test
    public void testMapReduct() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> op = employeeList.stream().map(Employee::getSalary).reduce(Double::sum);

        System.out.println(op.get());

    }

    /**
     * 收集
     * collect----将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void testCollect() {

        List<String> stringLists = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        Set<String> stringSet = employeeList.stream().map(Employee::getName).collect(Collectors.toSet());

        HashSet<String> hs = employeeList.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    @Test
    public void testCount() {
        //总数
        Long count = employeeList.stream().collect(Collectors.counting());
        System.out.println(count);

        //平均值
        Double avg = employeeList.stream().collect(Collectors.averagingDouble(Employee::getAge));

        //总和
        Double total = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));

        //最大值
        Optional<Employee> max = employeeList.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = employeeList.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compareTo));
        System.out.println(min.get());
    }


    /**
     * 分组
     * 多级分组
     */
    @Test
    public void testGroupBy() {

        Map<Status, List<Employee>> map =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        Map<Status, Map<String, List<Employee>>> mapMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() < 10) {
                return "少年";
            } else if (e.getAge() <= 30) {
                return "青年";

            } else if (e.getAge() <= 60) {
                return "中年";
            }
            return "老年";
        })));

        System.out.println(mapMap);

//        Map<Status, List<Employee>> map2 =
        List<Employee> employees = Lists.newArrayList();
                employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus)).forEach((o1,o2)->{
                    System.out.println(o1);  //Employee::getStatus
                    o2.stream().reduce((p1,p2)->{
                        System.out.println(p1);
                        System.out.println(p2);
                        Employee employee = new Employee();
                        employee.setAge(p1.getAge()+p2.getAge());
                        return employee;
//                    }).ifPresent(System.out::println);
                    }).ifPresent(employees::add);
                });

        System.out.println(employees);

    }

    /**
     * 分区
     */
    @Test
    public void testPartition() {

        Map<Boolean, List<Employee>> map = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 10000));

        System.out.println(map);
    }

    @Test
    public void testStatics() {
        DoubleSummaryStatistics dss = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getMax());
        System.out.println(dss.getCount());
        System.out.println(dss.getAverage());
        System.out.println(dss.getSum());
    }

    /**
     *
     */
    @Test
    public void testJoin() {
        String str = employeeList.stream().map(Employee::getName)
                .collect(Collectors.joining(",", "pre", "post"));
        System.out.println(str);

    }

    /**
     *
     * 并行流  底层fork/join
     */
    @Test
    public void parallelTest(){

        Instant start = Instant.now();

        LongStream.rangeClosed(0,100000000000L).parallel().reduce(0,Long::sum);

        Instant end = Instant.now();

        //耗时：19310 远快于for 单线程
        System.out.println("耗时："+ Duration.between(start,end).toMillis());

    }

//    @Test
//    public void testBolean(){
//        Boolean a = new Boolean();
//        System.out.println(a);
//    }



    public class Employee {

        private Integer id;
        private String name;
        private Integer age;
        private Double salary;
        private Status status;

        public Employee(Integer id, String name, Integer age, Double salary, Status status) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.status = status;
        }

        public Employee(Integer id, String name, Integer age, Double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public Employee() {
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }


        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", status=" + status +
                    '}';
        }
    }

    public enum Status {
        FREE, BUSY, VOCATION;
    }
}
