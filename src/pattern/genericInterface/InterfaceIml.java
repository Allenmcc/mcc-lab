package pattern.genericInterface;

/**
 * 1、实现接口时,确定泛型的类型
 */
public class InterfaceIml implements InterfaceEx<Integer> {

    @Override
    public int compareTo(Integer o) {
        return 0;
    }

    @Override
    public void show(Integer integer) {
        System.out.println(integer);
    }
}
