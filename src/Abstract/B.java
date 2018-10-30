package Abstract;

/**
 * Created by chunchen.meng on 2018/5/29.
 */
abstract class B {
    private String str;

    public B(String a) {
        System.out.println("父类已经实例化");
        this.str=a;
        System.out.println(str);
    }

    public abstract void play();
}
