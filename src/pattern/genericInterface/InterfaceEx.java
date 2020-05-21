package pattern.genericInterface;

/**
 * 泛型接口
 * 格式：修饰符 interface接口名<代表泛型的变量> {  }
 *
 * 接口继承Comparable
 */
public interface InterfaceEx<T> extends Comparable<T> {
//public interface InterfaceEx<T> extends Comparable<T> {

    public abstract void show(T t);

}
