package inherit;

/**
 * Created by chunchen.meng on 2018/7/20.
 */
public class B extends A{
    float a=3.0f;

    String d="Java program.";

    String c= "B property";

    @Override
    void show(){

        super.show( );

        System.out.println("Class B: a="+a +"\td="+d+"\tc="+c);

    }

    void show1(){

        super.show( );

        System.out.println("Class B: a="+a +"\td="+d);

    }


    public static void main(String[] args) {
//        A a=new A();
//        a.show();

        A b = new B();

        b.show();
//        b.show2(); error

    }
}
