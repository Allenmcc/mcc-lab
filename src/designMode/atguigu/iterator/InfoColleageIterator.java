package designMode.atguigu.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoColleageIterator implements Iterator {

	
	List<Department> departmentList; // 信息工程需要是以List方式存放
	int index = -1;//索引
	

	public InfoColleageIterator(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	//判断lsit中还有没有下一个元素
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(index >= departmentList.size() - 1) {
			return false;
		} else {
			index += 1;
			return true;
		}
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return departmentList.get(index);
	}
	
	//空实现 remove
	public void remove() {
		
	}

}
