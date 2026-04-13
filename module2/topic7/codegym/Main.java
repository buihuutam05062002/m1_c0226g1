package topic7.codegym;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes =  new Shape[3];

        Shape circle = new Circle(4);
        Shape RecShape = new Rectangle(3, 5);
        Shape square = new Square(6);

        shapes[0] = circle;
        shapes[1] = RecShape;
        shapes[2] = square;


        for (Shape s : shapes){
            double rand = Math.random() + 100;
            double before = s.getArea();

            ((Resizeable) s).resize(rand);

            if(s instanceof Colorable){
                ((Colorable) s).howToColor();
            }

            double after = s.getArea();

            System.out.println(before);
            System.out.println(after);
        }
    }
}
