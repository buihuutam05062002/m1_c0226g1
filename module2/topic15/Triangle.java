package topic15;

public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) throws IllegalTriangleException {
        if(isTriangle(sideA,sideB,sideC)){
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }else throw new IllegalTriangleException(sideA, sideB, sideC);

    }

    private boolean isTriangle(int sideA,int sideB,int sideC){
        return (sideA + sideB > sideC) && (sideB + sideC > sideA) && (sideC + sideA > sideB);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }

    public static void main(String[] args) {
        Triangle triangle = null;
        try {
            triangle = new Triangle(7,11,5);

            System.out.println(triangle);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());;
        }

    }
}
