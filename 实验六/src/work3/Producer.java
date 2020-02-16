package work3;

public class Producer extends Thread {
	GoodShelf goodshelf = null;
	public Producer(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public void setGoodshelf(GoodShelf goodshelf) {
		this.goodshelf = goodshelf;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			goodshelf.deposit(1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
