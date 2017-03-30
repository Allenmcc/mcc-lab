/**
 * Created by danny on 16/7/23.
 */
public class Xyz implements InterfaceA,InterfaceB {
    public void output() {
        System.out.println("output in class Xyz.");
    }

    public void outputLen(int type) {
        switch (type) {
            case InterfaceA.len:
                System.out.println("len of InterfaceA=." + type);
                break;
            case InterfaceB.len:
                System.out.println("len of InterfaceB=." + type);
                break;
        }
    }
    public   static   void  main(String[] args) {
        Xyz xyz=  new  Xyz ();
//        InterfaceA a = new InterfaceA() {
//            @Override
//            public void output() {
////                InterfaceA.len
//            }
//        };
        xyz.output();
        xyz.outputLen(1);
    }
}
