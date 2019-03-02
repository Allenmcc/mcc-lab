package threads.eater;

/**
 * Created by chunchen.meng on 2019/2/15.
 */
public class Tool {
    private final String name;
    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ " + name + " ]";
    }
}
