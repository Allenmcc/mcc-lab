package bytecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chunchen.meng on 2019/1/24.
 */
public class UserAdmin {

    private Map userMap = new HashMap<String,User>();

//    public void addUser(String userName) {
//             User user = new User(userName);
//             userMap.put(userName, user);
//         }
    public User addUser(String userName) {
        User user = new User(userName);
        userMap.put(userName, user);
        return user;
    }
}
