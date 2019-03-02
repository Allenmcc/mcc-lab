package extendtest;

/**
 * Created by chunchen.meng on 2019/1/31.
 */
public class Sub extends Base{

    String name;
    int age;
    public Sub(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getA() {
        return "Sub [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {

        System.out.println(new Sub("小明", 20));

    }

}