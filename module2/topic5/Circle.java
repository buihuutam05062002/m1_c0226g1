package topic5;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }
    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return Math.pow(this.radius ,2) * Math.PI;
    }


    public Circle(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getArea());
    }
}
