package Chain.ChainBase;


import org.apache.commons.chain.Command;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

/**
 * Created by chunchen.meng on 2017/11/14.
 */
public class CommandChain extends ChainBase {
    //增加命令的顺序也决定了执行命令的顺序
    public CommandChain() {
        addCommand(new Command1());
        addCommand(new Command2());
        addCommand(new Command3());
    }

    public static void main(String[] args) throws Exception {
        CommandChain process = new CommandChain();
        Context ctx = new ContextBase();
        process.execute(ctx);
//        process.execute();
    }

    public class Command1 implements Command {
        public boolean execute(Context arg0) throws Exception {
            System.out.println("Command1is done!");
            return false;
        }
    }

    public class Command2 implements Command {
        public boolean execute(Context arg0) throws Exception {
            System.out.println("Command2is done!");
            return false;
        }
    }

    public class Command3 implements Command {
        public boolean execute(Context arg0) throws Exception {
            System.out.println("Command3is done!");
            return true;
        }
    }
}
