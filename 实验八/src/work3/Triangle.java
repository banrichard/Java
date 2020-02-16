package work3;

import java.io.Serializable;

public class Triangle implements Serializable {
    double sideA;
    double sideB;
    double sideC;
    String area;

    public Triangle(double a, double b, double c) { /* TODO Auto-generated constructor stub*/
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public Triangle() { /* TODO Auto-generated constructor stub*/}

    public String calculateArea() {
        double p = (sideA + sideB + sideC) / 2.0f;
        area = "" + Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        return area;
    }

    public boolean isLegal() {
        if (((sideA + sideB) > sideC) || ((sideA + sideC) > sideB) || ((sideB + sideC) > sideA)) return true;
        else return false;
    }
}
