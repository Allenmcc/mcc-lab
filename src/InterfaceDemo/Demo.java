package InterfaceDemo;

/**
 * Created by danny on 2017/2/14.
 */
public class Demo {
    public static void main(String arsg[]) {
//        UserService userService = new UserServiceImpl();
//        userService.regist();

         UserServiceImpl userService = new UserServiceImpl();
        userService.regist();

        UserServiceImpl2 userServiceImpl2 = new UserServiceImpl2();
        userServiceImpl2.regist();
        UserService userService3 =   new UserService() {
            @Override
            public void regist() {
                // you impl

            }
        };
    }
}


