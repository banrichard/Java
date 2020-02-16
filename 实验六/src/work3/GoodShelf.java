package work3;

public class GoodShelf {

	int size = 0;
	Product[] P = new Product[100];

	public int getsize() {
		return size;
	}

	public GoodShelf(int size) {
		this.size = size;
	}

	public synchronized void deposit(int num) {
		while (size > 100) {
			try {
				System.out.println("货架已满，等会再来");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		size = size + num;
		if (size > 100)
			return;
		P[size] = new Product(size);
		System.out.println("生产者"+Thread.currentThread().getName() + "送来" + P[size] + "件商品");
		System.out.println(this);
		this.notifyAll();
	}

	public synchronized void withDraw(int n) {
		while (size <= 0) {
			try {
				System.out.println("货架已空，等会再来");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (size - n < 0)
			return;
		size = size - n;
		System.out.println("消费者"+Thread.currentThread().getName() + "买了" + n + "件商品 ");
		System.out.println(this);
		this.notifyAll();
		if (size < 100)
			this.notifyAll();
	}

	public String toString() {
		return "剩余数量" + size;
	}

}
