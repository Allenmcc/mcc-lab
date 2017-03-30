package PatternDemo;

/**
 * Created by danny on 2017/2/14.
 */
public class Demo {
    public static void main(String arsg[]) {
        Info<String> obj = new InfoImp<String>("www.weixueyuan.net");
      //实现接口
        Info<String> obj2 = new Info<String>() {
            @Override
            public String getVar() {
                return "123";
            }
        };


        //不好的初始化方法，没有利用接口的多态
        InfoImp<String> obj3 = new InfoImp<>("hh");

        System.out.println("Length Of String: " + obj.getVar().length());
        System.out.println(obj2.getVar());
        System.out.println(obj3.getVar());

        //实现接口
       Info<String> test =  new Info<String>() {
            @Override
            public String getVar() {
                return "helloword";
            }
        };

        System.out.println(test.getVar());
        System.out.println(getInfo().getVar());
        System.out.println(getInfoByImp().getVar());
    }


    //实现接口
    public static Info<String> getInfo(){
        return new Info<String>() {
            @Override
            public String getVar() {
                return "getInfoByInterface";
            }
        };

    }

    //返回实现方法
    public static Info<String> getInfoByImp(){
        return new InfoImp<>("getInfoByImp");
    }
}
