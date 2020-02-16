package work2;

public class TestOfProduce {
	public static void main(String[] args) {
		Workshop w = new Workshop();
		for(int i=0;i<4;i++) {
			w.t[i].start();
		}
	}
}
