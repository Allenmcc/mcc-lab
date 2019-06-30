package pattern.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunchen.meng on 2019/6/28.
 * 泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
  和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。
 */
public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("啊哦"));

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());


        /**
         * 通过下面的例子可以证明，在编译之后程序会采取去泛型化的措施。
         * 也就是说Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，
         * 会将泛型的相关信息擦除，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
         * 也就是说，泛型信息不会进入到运行时阶段。
         */
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试,类型相同");
        }
    }

}
