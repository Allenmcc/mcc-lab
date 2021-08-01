package leetCode;

public class SingletonTest4 {

    public static void main(String[] args) {

    }
}

class Singleton4{

    private  static volatile   Singleton3 instance;

    private Singleton4(){

    }



    private static class SingletonInstance{
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private static Singleton4 getInstance(){
        return SingletonInstance.INSTANCE;
    }

}
