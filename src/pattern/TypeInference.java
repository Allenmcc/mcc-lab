package pattern;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chunchen.meng on 2018/11/29.
 *
 * 泛型通配符
 *
 * 当使用泛型类或者接口时，传递的数据中，泛型类型不确定，可以通过通配符<?>表示。但是一旦使用泛型的通配符后，
 * 只能使用Object类中的共性方法，集合中元素自身方法无法使用。
 * 定义：(查看ArrayList的构造方法或者addAll方法)无法在类中使用
 * 使用：调用方法时可以给予任意类型。参照Arraylist的构造方法或者addAll方法
 *
 * ? extends E代表只要是E类型的子类即可
 * ? super E代表只要是E类型的父类即可
 * eg：
 * <? extends Animal>：表示一种泛型，这种泛型必须是Animal或Animal的子类
 * <? super Animal>：表示一种泛型，这种泛型必须是Animal或Animal的父类
 *
 * <?> 任意通配符
 * <? extend Person> 向下限定。有天花板，person及其子类
 * <? super Person> 向上限定，person 及其父类
 *
 *
 * 泛型通配符不是用在定义对象上 ArrayList<?> list= new ArraryList();
 * 用在方法形参上
 *
 * 为啥要有泛型通配符？因为集合没有协变
 * 但数组有协变（子类可以放到父类的数组里面：多态）method(Person[] ps) 调用Person[] 和 Student[] 都可以
 *
 * 但集合没有协变（子类可以放到父类的数组里面：多态）method(ArraryList<Person> list)
 * 调用List<Person>可以 和List<Student> 不可以，必须一一对应
 * 所有出现泛型通配符
 *
 */
public class TypeInference {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<Integer>();
        Set<Double> doubles = new HashSet<Double>();
        Set<Number> numbers = null;

        //编译器的类型推断能力有限
        numbers = TypeInference.union(integers, doubles);    // Error
//        numbers = TypeInference.<Number>union(integers, doubles);   // OK
        System.out.println(numbers.size());
    }

}
