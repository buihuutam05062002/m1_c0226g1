package topic7.codegym;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);



        circle = new Circle(3.5, "indigo", false);
        circle.resize(50);
        System.out.println(circle);
    }
}