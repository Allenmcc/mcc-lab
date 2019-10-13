package java8;

import java.util.function.Supplier;

public class SupplierTest {
    private int age;

    SupplierTest(){
        System.out.println(age);
    }
    public static void main(String[] args) {
        //创建Supplier容器，声明为TestSupplier类型，此时并不会调用对象的构造方法，即不会创建对象
        Supplier<SupplierTest> sup = SupplierTest::new;
        System.out.println("--------");
        //调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        sup.get();
        System.out.println(sup.get().hashCode());
        System.out.println(sup.get().hashCode());
        //每次get都会调用构造方法，即获取的对象不同
        sup.get();
    }

}
