package topic2;

import java.util.Scanner;

public class bai3 {

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int count = 0;
//        System.out.println("nhập số lượng phần tử in");
//        Scanner sc = new Scanner(System.in);

//        int numb = Integer.parseInt(sc.nextLine());
        for (int i = 0; i <=100; i++) {
            if(isPrime(i)){
                System.out.println(i);
            }
        }


//        System.out.println(isPrime(6));
    }
}
