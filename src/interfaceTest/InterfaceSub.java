package interfaceTest;

/**
 * Created by danny on 16/7/23.
 */
public class InterfaceSub implements Interface1, Interface2 {
    public void output() {
        System.out.println("output in class interfaceTest.InterfaceSub.");
    }

    public void outputLen(int type) {
        switch (type) {
            case Interface1.len:
                System.out.println("len of interfaceTest.Interface1=." + type);
                break;
            case Interface2.len:
                System.out.println("len of interfaceTest.Interface2=." + type);
                break;
            case Interface3.len:
                System.out.println("len of interfaceTest.Interface2=." + type);
                break;
        }
    }
    public   static   void  main(String[] args) {
        InterfaceSub interfaceSub=  new InterfaceSub();
//        interfaceTest.Interface1 a = new interfaceTest.Interface1() {
//            @Override
//            public void output() {
////                interfaceTest.Interface1.len
//            }
//        };
        interfaceSub.output();
        interfaceSub.outputLen(1);
        interfaceSub.outputLen(2);
        interfaceSub.outputLen(3);
    }
}
