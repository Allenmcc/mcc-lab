package leetCode;

public class SingletonTest2 {

    public static void main(String[] args) {

    }
}

class Singleton2{

    private Singleton2(){

    }

    private final static Singleton2 instance ;

    static {
        instance = new Singleton2();
    }

    public static  Singleton2 getInstance(){
        return  instance;
    }

}
