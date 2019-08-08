package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by chunchen.meng on 2019/7/10.
 */
public class OptionalTest {

    /**
     * Optional容器类（JDK1.8）
     * 用处：在开发中想把上一个对象的返回值最为下一个对象的参数，但不确定上一个对象的返回值是否为空的情况下，可以把
     * 上一个对象的返回值创建一个Optional对象
     * <p>
     * 这是一个可以为Null的容器对象。如果值存在则isPresent()方法会返回true,调用get()方法会返回该对象。
     * <p>
     * 方法介绍：
     * of:
     * 为非null的值创建一个Optional
     * <p>
     * ofNullable：
     * 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional
     * <p>
     * isPresent:
     * 如果值存在返回true,否则返回false
     * <p>
     * get:
     * 如果Optional有值则将其返回，否则抛出NoSuchElementException
     * <p>
     * ifPresent:
     * 如果Optional实例有值则为其调用consumer，否则不做处理
     * <p>
     * orElse：
     * 如果有值则将其返回，否则返回指定的其它值
     * <p>
     * orElseGet:
     * orElseGet与orElse方法类似，去别在于得到的默认值。orElse方法将传入的字符串作为默认值，orElseGet方法可以接受
     * Supplier接口的实现用来生成默认值
     * <p>
     * orElseThrow:
     * 如果有值则将其返回，否则抛出Supplier接口创建的异常
     * <p>
     * map:
     * 如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map
     * 方法返回值，否则返回空Optional
     * <p>
     * flatmap:
     * 如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。flatMap与map(Function)方法类似，区别
     * 在于flatMap中的mapper返回值必须是Optional。调用结束时，faltMap不会对结果用Optional封装。
     * <p>
     * filter：
     * 如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
     */


    public static void main(String[] args) {

        //创建Optional对象的方式：
        Optional<String> optional = Optional.of("bin");
        Optional<String> optional2 = Optional.ofNullable("bin");
        Optional<String> optional3 = Optional.empty();

        //isPresent
        System.out.println(optional.isPresent());

        //get
        System.out.println(optional2.get());

        //ifPresent
        optional.ifPresent((value) -> System.out.println(value));

        //orElse
        System.out.println(optional3.orElse("无值"));

        //orElseGet
        System.out.println(optional3.orElseGet(() -> "default"));

        //orElseThrow
        try {
//            optional3.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //map方法会自动创建一个Optional对象
        Optional<String> optional4 = optional3.map((value) -> value.toUpperCase());
        System.out.println(optional4.orElse("no such value"));

        //flatMap不会自己创建，所以需要手动创建封装
        Optional<String> optional5 = optional.flatMap((value) -> Optional.of(value.toUpperCase() + "-flatMap"));
        System.out.println(optional5.orElse("no found"));

        //filter
        Optional<String> optional6 = optional.filter((value) -> value.length() > 4);
        System.out.println(optional6.orElse("该值长度小于4"));

        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001L, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002L, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003L, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004L, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001L, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002L, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003L, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001L, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002L, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001L, "丁奉", 24, 5, "土木工程", "南京大学"));
            }

        };
        List<Student> whuStudents = students.stream().filter(student -> "武汉大学".equals(student.getSchool())).collect(Collectors.toList());

        whuStudents.stream().forEach(p-> System.out.println(p.getName()));
        Optional<Student> optional1 = whuStudents.stream().filter(p-> p.getAge() == 20).findFirst();
        if(optional.isPresent()){
            System.out.println(optional1.get().getName());
        }
    }

}
