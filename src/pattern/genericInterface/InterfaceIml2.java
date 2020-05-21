package pattern.genericInterface;

/**
 * 2、实现接口,不指定泛型的类型，直到创建对象时，确定泛型的类型
 * 泛型类 格式：修饰符 class 类名<代表泛型的变量> {  }
 * @param <TT>
 */
public class InterfaceIml2<TT> implements InterfaceEx<TT> {

    @Override
    public int compareTo(TT o) {
        return 0;
    }

    @Override
    public void show(TT t) {
        System.out.println(t);
    }
}
