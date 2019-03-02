package inner;

/**
 * Created by chunchen.meng on 2018/11/28.
 */
public class Outer {

    interface Inner {    //注释后，编译时提示类Inner找不到
        String getName();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.getInner("Inner", "gz");
        System.out.println(inner.getName());
    }

    public Inner getInner(final String name, String city) {  // 形参 name 被设为 final
        return new Inner() {
            private String nameStr = name;       // OK
            private String cityStr = city;       // Error: 形参 city 未被设为 final

            @Override
            public String getName() {
                return nameStr;
            }
        };
    }
}
