package topic11;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Bai3 {


    public static void main(String[] args) {

        int numb = Integer.parseInt(new Scanner(System.in).nextLine());

        Stack<Integer> decimal = new Stack<>();
        while (numb != 0) {
            decimal.push(numb % 2);
            numb = numb / 2;
        }
        String str = "";
        while (!decimal.isEmpty()) {
            str += decimal.pop();
        }
        System.out.println(str);
    }


}
