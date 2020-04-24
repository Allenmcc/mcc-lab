package java8;

import lombok.Data;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * https://www.toutiao.com/i6770858450273436164/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1578316045&app=news_article&utm_source=weixin&utm_medium=toutiao_android&req_id=202001062107250100140470770B4C6D28&group_id=6770858450273436164
 * 左侧lambda 表达式的参数列表
 * 右侧lambda 表达式中所需要执行的功能，即lambda体
 * 函数式接口:任何接口，如果只包含唯一一个抽象方法，那么它就是一个函数式接口
 * 对于函数式接口，我们可以通过lambda表达式来创建该接口的对象（接口里面的方法，都是抽象的abstract，隐式申明，可以不用写）
 */
public class lambdaTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通，线程启动");
            }
        };
        runnable.run();

        //无参数
        test2();
        //一个参数,并且无返回值
        test3();
        test4();
        test5();

        //consumer消费型接口 无返回值  右边实现
        consumerTest("传入参数", e -> System.out.println("consumer 消费型接口:" + e));

        //Supplier供给型接口：T get(); 无入参 ，右边产生方法实现
        ArrayList<Integer> res = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(res);


        //函数式接口：R apply(T t); 有入参 ->对入参函数操作 有返回值
        String newStr = strHandler("abc", (str) -> str.toUpperCase());
        System.out.println(newStr);
        newStr = strHandler(" abc ", (str) -> str.trim());
        System.out.println(newStr);

        consumerTest(" abc ", (str) -> System.out.println("cc"));
        System.out.println(newStr);

        //Predicate 断言式接口：boolean test(T t);  有入参 返回 true false
        List<String> list = Arrays.asList("hello", "jiangshuying", "lambda", "www", "ok", "q");
        List<String> ret = filterStr(list, (str) -> str.length() > 2);
        System.out.println(ret);
    }

    //无参数，无返回值
    public static void test2() {
        //“->”左边只有一个小括号，表示无参数(run（）无参数)，右边是Lambda体(就相当于实现了匿名内部类里面的方法了，
        // (即就是一个可用的接口实现类了。))
        Runnable runnable = () -> System.out.println("Lambda 表达式方式，线程启动");
        runnable.run();
    }

    //有一个参数，小括号可以不写，并且无返回值
    public static void test3() {
        //这个e就代表所实现的接口的方法的参数，
        //Consumer 消费性接口：void accept(T t)；
        Consumer<String> consumer = e -> System.out.println("Lambda 表达式方式，" + e);
        consumer.accept("传入参数");
    }

    //有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
    public static void test4() {
        //Lambda 体中有多条语句，记得要用大括号括起来
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        int compare = com.compare(100, 244);
        System.out.println("有两个以上的参数，有返回值," + compare);
    }

    //若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
    public static void test5() {
        Comparator com = (x, y) -> Integer.compare(100, 244);
        System.out.println("若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写," + Integer.compare(100, 244));
    }

    //如果使用lambda还要自己写一个接口的话太麻烦，所以Java自己提供了一些接口

    /**
     * Consumer 消费性接口：void accept(T t)；无返回值 void
     *
     * @param consumer
     */
    public static void consumerTest(String str, Consumer<String> consumer) {
        //这个str就代表所实现的接口的方法的参数，
//      e->System.out.println("Lambda 表达式方式，"+e);
        consumer.accept(str);
    }

    /**
     * Supplier供给型接口：T get();无参数
     *
     * @param num
     * @param sup
     * @return
     */
    public static ArrayList<Integer> getNumList(int num, Supplier<Integer> sup) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer e = sup.get();
            list.add(e);
        }
        return list;
    }


    /**
     * Function 函数式接口：R apply(T t);
     *
     * @param str
     * @param fun
     * @return
     */
    public static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * Predicate 断言式接口：boolean test(T t); 返回boolean
     * 判断一些字符串数组判断长度>2的字符串:
     *
     * @param list
     * @param pre
     * @return
     */
    public static List<String> filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }


    /**
     * 方法引用：若lambda体中的内容已经实现了，我们可以使用"方法引用"
     * （可以理解为方法引用是lambda表达式的另外一种表达方式）
     * <p>
     * <p>
     * 主要有3种表达方式
     * 对象：：实例方法
     * 类：：静态方法
     * 类：：实例方法
     * <p>
     * 注意:
     * 1.lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型报错一致！
     * 2.若lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用
     * ClassName：：method
     */


    //对象：：实例方法
    @Test
    public void test11() {
        PrintStream ps = System.out;
        Consumer<String> con = x -> ps.println(x);

        PrintStream ps1 = System.out;
        Consumer<String> con1 = ps1::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("mcc");

    }


    @Test
    public void test22() {
        Employee employee = new Employee();
        Supplier<String> sup = () -> employee.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = employee::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }

    //类：：静态方法名
    //lambda体中调用方法的参数列表与返回值类型，
    //要与函数式接口中抽象方法的函数列表和返回值类型报错一致！
    @Test
    public void test33() {

        Comparator<Integer> con = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> con1 = Integer::compare;

    }

    //类：：实例方法
    //若lambda参数列表中的第一个参数是实例方法的调用者，
    //而第二个参数是实例方法的参数时，可以使用
    @Test
    public void test44() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;
        BiPredicate<String, String> bp3 = (x,y) ->y.contains(x);


        System.out.println(bp3.test("10","20,10"));

    }


    /**
     * 构造器引用
     * <p>
     * 注意:需要调用1构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
     */
    @Test
    public void test55() {

        Supplier<Employee> supplier = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> supplier1 = Employee::new;
        Employee employee = supplier1.get();
        System.out.println(employee);


    }

    @Test
    public void test66() {

        Function<Integer, Employee> function = x -> new Employee(x);

        //构造器引用apply() 一个入参 ，选择一个参数的构造器。
        Function<Integer, Employee> function1 = Employee::new;
        Employee employee = function1.apply(12);
        System.out.println(employee.getId());

        ///构造器引用apply() 2个入参 ，选择2个参数的构造器。
        BiFunction<Integer, Integer, Employee> bf = Employee::new;
        Employee employee1 = bf.apply(15, 20);
        System.out.println(employee1.getId());


    }


    /**
     *
     * 数组引用
     * type[]::new
     */
    @Test
    public void test77(){
        Function<Integer,String[]> function = x->new String[x];
        String[] strings = function.apply(10);
        System.out.println(strings.length);

        Function<Integer,String[]> function1 = String[]::new;
        String[] strings1 = function1.apply(20);
        System.out.println(strings1.length);
    }



    public class Employee {

        private int id;
        private String name;
        private int age;
        private Double salary;

        public Employee() {
        }

        public Employee(int id) {
            this.id = id;
        }

        public Employee(int id, int age) {
            this.id = id;
            this.age = age;
        }

        public Employee(int id, String name, int age, Double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
    }

}
