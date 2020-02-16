package work2;
import java.util.Random;
public class Circle implements Comparable{
	int radius;
	Circle(int r){
		this.radius = r;
	}
	Circle(){
		this.radius = 0;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Circle c =(Circle) o;
		return (this.radius-c.radius);
	}
	public void randomGetVal() {
		Random random = new Random();
		int number = random.nextInt(100);
		this.radius = number;
	}
}
