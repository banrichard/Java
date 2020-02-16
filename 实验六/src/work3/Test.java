package work3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodShelf gShelf = new GoodShelf(0);
		Producer p1 = new Producer("张三");
		p1.setGoodshelf(gShelf);
		Producer p2 = new Producer("李四");
		p2.setGoodshelf(gShelf);
		Consumer c1 = new Consumer("王五");
		c1.setGoodshelf(gShelf);
		Consumer c2 = new Consumer("赵四");
		c2.setGoodshelf(gShelf);
		Consumer c3 = new Consumer("刘能");
		c3.setGoodshelf(gShelf);
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
