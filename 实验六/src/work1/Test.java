package work1;

public class Test {
	public static void main(String[] args) {
		ThreadA a;
		ThreadB b;
		a = new ThreadA();
		b = new ThreadB();
		a.start();
		b.start();
	}
}
