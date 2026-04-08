package topic4;

import java.util.Scanner;

public class QuadraticEquation {
    private double numA;
    private double numB;
    private double numC;

    public QuadraticEquation(double numA, double numB, double numC) {
        this.numA = numA;
        this.numB = numB;
        this.numC = numC;
    }

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    public double getNumC() {
        return numC;
    }

    public void setNumC(double numC) {
        this.numC = numC;
    }

    public double getDiscriminant() {
        return Math.pow(this.numB, 2) - (4 * this.numA * this.numC);
    }

    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            return (-this.numB + Math.sqrt(Math.pow(this.numB, 2) - (4 * this.numA * this.numC))) / 2 * this.numA;
        } else {
            return 0;
        }
    }

    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            return (-this.numB - Math.sqrt(Math.pow(this.numB, 2) - (4 * this.numA * this.numC))) / 2 * this.numA;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double numA = Double.parseDouble(sc.nextLine());
        double numB = Double.parseDouble(sc.nextLine());
        double numC = Double.parseDouble(sc.nextLine());

        QuadraticEquation quadraticEquation = new QuadraticEquation(numA, numB, numC);

        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("Nghiem 1: " + quadraticEquation.getRoot1());
            System.out.println("Nghiem 2: " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("nghiem kep: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
