package topic3_arr;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[rows][];


        int sum = 0;
        for (int i = 0; i < rows; i++) {
            arr[i] = new int[columns];
            for (int j = 0; j < columns; j++) {
                System.out.println("Nhap phan tu thu " + i + " " + j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
            sum += arr[i][n - 1 - i];
            ;
        }
        if (n % 2 == 1) {
            sum -= arr[n / 2][n / 2];
        }

        System.out.println(sum);



    }
}
