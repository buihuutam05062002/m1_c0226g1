package topic15;

public class IllegalTriangleException extends Exception{

    private int sideA;
    private int sideB;
    private int sideC;

    public IllegalTriangleException(int sideA, int sideB, int sideC) {
        super("1 trong số các cạnh không thể tạo được tam giác: " + sideA +" "+ sideB +" "+ sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return "IllegalTriangleException{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                "} " + super.toString();
    }
}
