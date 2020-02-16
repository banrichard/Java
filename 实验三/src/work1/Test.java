package work1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle(10);
		Cylinder<Circle> cylinder1 = new Cylinder<Circle>(circle);
		cylinder1.setHeight(10);
		System.out.print("圆柱的体积:");
		System.out.println(cylinder1.computerVolume());
		Rect rect = new Rect(10,9);
		Cylinder<Rect> cylinder2 = new Cylinder<Rect>(rect);
		cylinder2.setHeight(10);
		System.out.print("长方体体积：");
		System.out.println(cylinder2.computerVolume());
	}

}
