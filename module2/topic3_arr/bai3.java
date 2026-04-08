package topic3_arr;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int columns = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[rows][];

        for (int i = 0; i < rows; i++) {
            arr[i] = new int[columns];
            for (int j = 0; j < columns; j++) {
                System.out.println("Nhap phan tu thu " + i + " " + j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        int sumcolumns = 0;
        System.out.println("Nhap cot cu the ");
        int detailColumn;
        do {
            detailColumn = Integer.parseInt(sc.nextLine());
            if (detailColumn >= arr[0].length){
                System.out.println("vui lòng nhập số cột nhỏ hơn cột của ma trận");
            }
        }while (detailColumn >= arr[0].length);




        for (int i = 0; i < arr.length; i++) {
            sumcolumns += arr[i][detailColumn];
        }


        System.out.println(sumcolumns);

    }
}
