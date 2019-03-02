package extendtest;

/**
 * Created by chunchen.meng on 2019/1/31.
 */

// https://blog.csdn.net/qq_40422256/article/details/83041938

class Base {

    private String a;
    public Base() {
        a = getA();
//        a= "base";
    }
    public String getA() {
        return "Base";
    }
    @Override
    public String toString() {
        return a;
    }

}



