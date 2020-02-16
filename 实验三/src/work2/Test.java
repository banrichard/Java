package work2;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		
		
		LinkedList<Circle> linklist = new LinkedList<Circle>();
		for(int i=0;i<10;i++) {//生成链表
			Circle circle = new Circle();
			circle.randomGetVal();
			linklist.add(circle);
		}
		Iterator<Circle> iter = linklist.iterator();
		while(iter.hasNext()) {
			Circle temp = iter.next();
			System.out.println("半径等于:"+temp.radius);
		}
		System.out.println("--------我是分割线--------");
		linklist.add(1, new Circle(7));//插入
		iter = linklist.iterator();
		while(iter.hasNext()) {
			Circle temp = iter.next();
			System.out.println("半径等于:"+temp.radius);
		}
		System.out.println("--------我是分割线--------");
		linklist.remove(1);//删除
		iter = linklist.iterator();
		while(iter.hasNext()) {
			Circle temp = iter.next();
			System.out.println("半径等于:"+temp.radius);
		}
		System.out.println("--------我是分割线--------");
		System.out.println("排序前：");
		iter = linklist.iterator();
		while(iter.hasNext()) {
			Circle temp = iter.next();
			System.out.println("半径等于:"+temp.radius);
		}
		System.out.println("--------我是分割线--------");
		Collections.sort(linklist);
		iter = linklist.iterator();
		System.out.println("排序后：");
		while(iter.hasNext()) {
			Circle temp = iter.next();
			System.out.println("半径等于:"+temp.radius);
		}
	}
	
}
