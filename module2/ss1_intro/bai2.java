package week1;

import java.util.Scanner;

public class bai2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float rate = 23000;

        String tta = sc.nextLine();
        float usd = Float.parseFloat(tta);

        System.out.println(usd *rate);
    }


}
