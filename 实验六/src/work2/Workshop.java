package work2;

public class Workshop implements Runnable {
	private int count = 800;
	private String name;
	Thread []t = new Thread[4];
	public Workshop() {
		super();
		t[0] = new Thread(this, "一号车间");
		t[1] = new Thread(this, "二号车间");
		t[2] = new Thread(this, "三号车间");
		t[3] = new Thread(this, "四号车间");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		while(this.count>0) {
			this.count--;
			sum++;
			produce();
		}
		System.out.println(Thread.currentThread().getName()+"造了"+sum+"个零件");
	}
	private synchronized void produce(){
		try {
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
