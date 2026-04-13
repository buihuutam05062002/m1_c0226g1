package topic7.codegym;

public class Square extends Shape implements Colorable,Resizeable {
   private double side;

    public Square(double side) {
        this.side = side;
    }

    public Square() {
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    @Override
    public void resize(double percent) {
        side = side * (1 + percent / 100);
    }

    @Override
    public double getArea() {
        return Math.pow(side,2);
    }


    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                "} " + super.toString();
    }
}
