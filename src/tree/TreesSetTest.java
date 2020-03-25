package tree;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * https://www.jianshu.com/p/12f4dbdbc652
 * https://www.cnblogs.com/jason0529/p/6604726.html
 */
public class TreesSetTest {
    public static void main(String[] args) {

        stringTest();
        personTest();
    }

    public static void stringTest() {
        TreeSet ts = new TreeSet();

        ts.add("abc");
        ts.add("zaa");
        ts.add("aa");
        ts.add("nba");
        ts.add("cba");

        Iterator it = ts.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void personTest() {
        TreeSet<Person> ts = new TreeSet<>();


        ts.add(new Person("张三", 11));
        ts.add(new Person("李四", 12));
        ts.add(new Person("四李", 12));
        ts.add(new Person("赵六", 21));
        ts.add(new Person("王五", 15));


        Iterator it = ts.iterator();

        while(it.hasNext()){
            Person p = (Person)it.next();

            System.out.println(p.getName()+":"+p.getAge());
        }


    }



    static class Person implements Comparable<Person>{

        String name;
        int age;


        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * TreeSet判断元素是否重复 、以及确定元素的顺序 靠的都是这个方法；不是equals。内置默认的Comparator比较器，一旦设定，后续所有的比较必须依据此比较器进行。
         * 如果将compareTo()返回值写死为0，元素值每次比较，都认为是相同的元素，这时就不再向TreeSet中插入除第一个外的新元素。所以TreeSet中就只存在插入的第一个元素。
         * 如果将compareTo()返回值写死为1，元素值每次比较，都认为新插入的元素（this）比上一个元素大，于是二叉树存储时，会存在根的右侧，读取时就是正序排列的。
         * 如果将compareTo()返回值写死为-1，元素值每次比较，都认为新插入的元素比上一个元素小，于是二叉树存储时，会存在根的左侧，读取时就是倒序序排列的。
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Person o) {
//            return 0;              //0都是同一个对象，只存一个
//            return 1;                //当compareTo方法返回正数的时候集合会怎么存就怎么取，无年龄相同去重
//            return -1;                //当compareTo方法返回负数的时候集合会倒序存储，无年龄相同去重

            Person p = (Person) o;

            if (this.age > p.age)   //年龄从小到大  this.page 新的 p.age 之前的
                return 1;
            if (this.age < p.age)
                return -1;
            return 0;                //相同，取前一个

        }

        @Override
        public int hashCode() {
            return name.hashCode()+age*27;       //将age和name设置成为hashCode。
        }

        /**
         * 无效
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Person))
                throw new ClassCastException("类型错误");

            System.out.println(this + "....equals....." + obj);
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;   //通过对比当前对象与下个将要比较的对象的姓名和age 是否相同来确定是否为同一个对象。

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
