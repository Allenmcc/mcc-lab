package hashTest;

/**
 * Created by chunchen.meng on 2019/2/24.
 * 在一个应用程序执行期间，如果一个对象的equals方法做比较所用到的信息没有被修改的话，
 * 那么，对该对象调用hashCode方法多次，它必须始终如一地返回同一个整数。
 * 在同一个应用程序的多次执行过程中，这个整数可以不同，
 * 即这个应用程序这次执行返回的整数与下一次执行返回的整数可以不一致。
 如果两个对象根据equals(Object)方法是相等的，那么调用这两个对象中任一个对象的hashCode方法必须产生同样的整数结果。
 如果两个对象根据equals(Object)方法是不相等的，那么调
 */
public class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private String name;
    private int age;


    @Override
    public int hashCode() {
        return name.hashCode() + age * 10;
    }

    @Override
    public  boolean equals(Object obj)  {
        if  (!(obj  instanceof  Person))
            throw  new  ClassCastException("类型不匹配");
        Person  p   =   (Person)    obj;
        return  this.name.equals(p.getName()) && this.age == p.getAge();
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

    @Override
    public String toString() {
        return "{" + name + ", " + age + "}";
    }
}
