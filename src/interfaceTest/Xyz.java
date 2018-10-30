package interfaceTest;

/**
 * Created by danny on 16/7/23.
 */
public class Xyz implements Interface1, Interface2 {
    public void output() {
        System.out.println("output in class interfaceTest.Xyz.");
    }

    public void outputLen(int type) {
        switch (type) {
            case Interface1.len:
                System.out.println("len of interfaceTest.Interface1=." + type);
                break;
            case Interface2.len:
                System.out.println("len of interfaceTest.Interface2=." + type);
                break;
        }
    }
    public   static   void  main(String[] args) {
        Xyz xyz=  new  Xyz ();
//        interfaceTest.Interface1 a = new interfaceTest.Interface1() {
//            @Override
//            public void output() {
////                interfaceTest.Interface1.len
//            }
//        };
        xyz.output();
        xyz.outputLen(1);
    }
}
