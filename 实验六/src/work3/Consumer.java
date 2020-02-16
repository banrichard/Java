package work3;

public class Consumer extends Thread {
	GoodShelf goodshelf = null;
	public Consumer(String name) {
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
		while (true) {
			goodshelf.withDraw(1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
