package bytecode;

/**
 * Created by chunchen.meng on 2019/1/24.
 */
public class UserService {


    UserAdmin admin = new UserAdmin();

    public void add(String userName) {
            admin.addUser(userName);
         }
}
