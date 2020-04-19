package designMode.atguigu.command;

/**
 *没有任何命令，即空执行，当调用空命令时，对象什么都不做
 * 其实，这样是一种设计模式，可以省掉对空的判断
 * @author Administrator
 *
 */
public class NoCommand implements Command {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
