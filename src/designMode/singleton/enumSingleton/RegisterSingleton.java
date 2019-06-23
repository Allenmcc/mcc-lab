package designMode.singleton.enumSingleton;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public enum  RegisterSingleton {
    INSTANCE;

    public RegisterSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        RegisterSingleton registerSingleton = RegisterSingleton.INSTANCE;
    }
}
