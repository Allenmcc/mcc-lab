package pattern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunchen.meng on 2018/6/9.
 * 泛型:
 * 泛型，即“参数化类型”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。
 * 那么参数化类型怎么理解呢？顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），
 * 然后在使用/调用时传入具体的类型（类型实参）。
 *
 * 泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。
 * 也就是说在泛型使用过程中，操作的数据类型被指定为一个参数，这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法。
 *
 * https://www.cnblogs.com/coprince/p/8603492.html
 */
public class GenericFruit {

    public <T> void printMsg( T... args){
        for(T t : args){
            System.out.println("泛型测试t is " + t);
        }
    }
    class Fruit{
            int i = 2;
        @Override
        public String toString() {
            return "fruit";
        }
    }

    class Apple extends Fruit{
        @Override
        public String toString() {
            i = 3;
            return "apple";
        }
    }

    class Person{
        @Override
        public String toString() {
            return "listTest.Person";
        }
    }

    class GenerateTest<T>{
        public void show_1(T t){
            System.out.println("show_1:"+ t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
        //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
        public <E> void show_3(E t){
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种!!!!!!!!全新的类型!!!!!!!!!!!!，可以与泛型类中声明的T不是同一种类型。
        public <T> void show_2(T t){
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {

        //内部类初始化，先初始化类
        GenericFruit genericFruit = new GenericFruit();

        //内部类可以随意访问外部类的成员方法
        genericFruit.printMsg("111",222,"aaaa","2323.4",55.55);

        Apple apple = genericFruit.new Apple();
        Person person = genericFruit.new Person();


        GenerateTest<Fruit> generateTest = genericFruit.new GenerateTest<Fruit>();
        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
//        generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);
    }


    @Test
    public void testCompile(){
        List arrayList = new ArrayList();
//        List<String> arrayList = new ArrayList();
//        我们将第一行声明初始化list的代码更改一下，编译器会在编译阶段就能够帮我们发现类似这样的问题。dada


        arrayList.add("aaaa");
        arrayList.add(100);

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            //编译没有问题,运行出错
            System.out.println("泛型测试:item = " + item);
        }
    }


    /**
     * 在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。
     * 在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
     * 也就是说，泛型信息不会进入到运行时阶段
     * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     */
    @Test
    public void typeRemove(){
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试:类型相同");
        }
    }
}
