package topic6;

import topic6.Circle;

public class Cylinder extends Circle {
    private int height;


    public Cylinder(double radius, int height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume() {
        return Math.pow(this.getRadius(), 2) * Math.PI * this.height;
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(4, 13, "Vangf");
        System.out.println(cylinder.getArea());
    }
}
