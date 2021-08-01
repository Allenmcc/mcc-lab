package leetCode;

public class SingletonTest1 {

    public static void main(String[] args) {

    }
}

class Singleton{

    private Singleton(){

    }

    private final static Singleton instance = new Singleton();

    public static  Singleton getInstance(){
        return  instance;
    }

    public long useSingle(){
        return 1;
    }
}
