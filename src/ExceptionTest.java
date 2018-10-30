/**
 * Created by chunchen.meng on 2018/2/24.
 */
public class ExceptionTest {


    /**
     * try、catch、finally 这个过程也就是这样，如果try catch finally 都有return：
     1、在没有异常的情况下，try 中的返回值先保存到临时区域里在去执行finally ，这个finally 有返回值，这个返回值将之前try中的保存到临时区域的值用返回的这个值替换，再将这个临时区域中的值返回给上一级方法。
     2、如果有异常，则执行catch中的代码，这里的return 将返回一个返回值放到临时区域，再去执行finally ，这个finally如果有返回值，这样就将catch中存在临时区域中的值用这个finally 返回的值替换掉，在将这个临时区域的值返回给上一级方法。 
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(test());


    }

    public static String test() {
        try {
            System.out.println("try block");
            if (1 == 2) {
                throw new Exception();
            }

            //异常后不执行
            System.out.println("try block 1");
//            return test1();
//            return "test";
        }catch (Exception e){
            System.out.println("Exception happen");
            return test2();
        }
        finally {
            System.out.println("finally block");
//             return test3();
        }

        //异常之后不执行
        System.out.println("haha");
        return "last";


    }

    public static String test1() {
        System.out.println("return test1");
        return "after return";
    }

    public static String test2() {
        System.out.println("return test2");
        return "after return test2";
    }

    public static String test3() {
        System.out.println("return test3");
        return "after test3";
    }


}
