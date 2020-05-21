package pattern.genericInterface;

public class Client {

    public static void main(String[] args) {
        InterfaceEx interfaceEx = new InterfaceIml();
        interfaceEx.show(12);

//        InterfaceEx interfaceEx1 = new InterfaceIml2();  可以
        InterfaceEx<String> interfaceEx1 = new InterfaceIml2();
        interfaceEx1.show("aa");

    }
}
