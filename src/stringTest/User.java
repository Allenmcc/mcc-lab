package stringTest;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User implements Diffable<User>{
    private int age;
    private String username;

    public User(int age, String username) {
        this.age = age;
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public DiffResult diff(User user) {
        // TODO Auto-generated method stub
        return new DiffBuilder(this, user, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("age", this.getAge(), user.getAge())
                .append("username", this.getUsername(), user.getUsername())
                .build();
    }

}
