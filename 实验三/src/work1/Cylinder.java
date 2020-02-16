package work1;

 abstract class Shape {
	 
	abstract double getArea();
}

class Circle extends Shape {
	double radius;
	double area;

	Circle(double r) {
		this.radius = r;
	}

	public double getArea() {
		area = Math.PI * radius * radius;
		return area;
	}

}

class Rect extends Shape {
	double sideA, sideB, area;

	Rect(double a, double b) {
		sideA = a;
		sideB = b;
	}

	public double getArea() {
		area = sideA * sideB;
		return area;
	}

}

class Cylinder<T extends Shape> {
	double height;
	T bottom;

	public Cylinder(T b) {
		this.bottom = b;
	}

	public void setHeight(double h) {
		this.height = h;
	}

	public double computerVolume() {
		
		double area = bottom.getArea();
		return area * height;
	}
}
