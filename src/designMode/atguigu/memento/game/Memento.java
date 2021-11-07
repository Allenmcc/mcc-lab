package designMode.atguigu.memento.game;

/**
 * 快照
 * 备忘录（Memento）角色：负责存储发起人的内部状态，
 * 在需要的时候提供这些内部状态给发起人。
 */
public class Memento {

	//攻击力
	private int vit;
	//防御力
	private int def;
	public Memento(int vit, int def) {
		super();
		this.vit = vit;
		this.def = def;
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
