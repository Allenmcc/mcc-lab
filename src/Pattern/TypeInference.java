package Pattern;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chunchen.meng on 2018/11/29.
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
