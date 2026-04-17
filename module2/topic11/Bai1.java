package topic11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bai1 {

    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();

        numbers.push(6);
        numbers.push(19);
        numbers.push(15);

        List temp = new ArrayList<Integer>();


        while (!numbers.isEmpty()){
            int a = (int) numbers.pop();
            System.out.println(a);
            temp.add(a);
        }
        System.out.println(temp);

    }
}
