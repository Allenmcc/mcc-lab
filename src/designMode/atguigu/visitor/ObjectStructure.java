package designMode.atguigu.visitor;

import java.util.LinkedList;
import java.util.List;

//数据结构，管理很多人（Man，Woman）
public class ObjectStructure {

	//维护了一个集合,组合关系  访问者
	private List<Person> persons = new LinkedList<>();
	
	//添加到list
	public void attach(Person p) {
		persons.add(p);
	}
	//移除
	public void detach(Person p) {
		persons.remove(p);
	}
	
	//显示测评情况  访问者展示访问结果
	public void display(Action action) {
		for(Person p: persons) {
			p.accept(action);
		}
	}
}
