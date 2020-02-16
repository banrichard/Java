package work1;

public class ThreadA extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i = 0;i < 20; i++) {
			System.out.print("A");
		}
	}
}
class ThreadB extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i = 0;i < 20; i++) {
			System.out.print("B");
		}
	}
}
