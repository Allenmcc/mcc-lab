package odering;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunchen.meng on 2018/9/30.
 */
public class testNatural {

    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<People>() {{
            add(new People("A", 33));
            add(new People("B", 11));
            add(new People("C", 18));
        }};
        Ordering<People> ordering = Ordering.natural().onResultOf(new Function<People, Comparable>() {
            @Override
            public Comparable apply(People people) {
                return people.getAge();
            }
        }).reverse();

        for (People people : peopleList) {

            System.out.println(people.getName() + " " + people.getAge());
        }


        for (People p : ordering.sortedCopy(peopleList)) {
            System.out.println(p.getName() + " " + p.getAge());
        }

        for (People people : peopleList) {

            System.out.println(people.getName() + " " + people.getAge());
        }


//        List<? extends Number> foo1 = new ArrayList<? extends Number>();
//
//
//        List<? extends Number> foo2 = new ArrayList<? extends Integer>();
//
//        List<? super Integer> foo3 = new ArrayList<Number>();

        ArrayList<String> arrayList1=new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass()==arrayList2.getClass());
    }


}

