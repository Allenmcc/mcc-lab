package leetCode;

public class SingletonTest3 {

    public static void main(String[] args) {

    }
}

class Singleton3{

    private  static volatile   Singleton3 instance;

    private Singleton3(){

    }

//    public static synchronized   Singleton3 getInstance(){
//
//        if(instance == null){
//            instance = new Singleton3();
//        }
//
//        return  instance;
//    }


//    public static Singleton3 getInstance() {
//
//        if (instance == null) {
//            synchronized (Singleton3.class) {
//                instance = new Singleton3();
//            }
//        }
//
//        return instance;
//    }


    public static Singleton3 getInstance() {

        if (instance == null) {
            synchronized (Singleton3.class) {
                if(instance == null){
                    instance = new Singleton3();
                }
            }
        }

        return instance;
    }

}
