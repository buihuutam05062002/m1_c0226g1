package topic3_arr;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[rows][];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            arr[i] = new int[columns];
            for (int j = 0; j < columns; j++) {
                System.out.println("Nhap phan tu thu " + i + " " + j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
