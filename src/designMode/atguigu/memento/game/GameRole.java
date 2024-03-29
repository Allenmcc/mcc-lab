package designMode.atguigu.memento.game;


/**
 * 发起人（Originator）角色：记录当前时刻的内部状态信息，
 * 提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，
 */
public class GameRole {

	private int vit;
	private int def;
	
	//构造器Memento，即根据当前的状态得到Memento
	public Memento createMemento() {
		return new Memento(vit, def);
	}
	
	//从备忘录对象，恢复GameRole的状态
	public void recoverGameRoleFromMemento(Memento memento) {
		this.vit = memento.getVit();
		this.def = memento.getDef();
	}
	
	//显示当前游戏角色的状态
	public void display() {
		System.out.println("游戏角色当前的攻击力：" + this.vit + " 防御力： " + this.def);
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	
}
