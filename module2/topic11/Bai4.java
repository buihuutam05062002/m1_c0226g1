package topic11;

import java.util.*;

public class Bai4 {

    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";

        str = str.toLowerCase();
        str = str.replaceAll("\s+", "");
        System.out.println(str);

        Stack<Character> palindrome1 = new Stack<Character>();
        Queue<Character> palindrome2 = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            palindrome2.add(str.charAt(i));
            palindrome1.push(str.charAt(i));
        }
        System.out.println(palindrome1);
        System.out.println(palindrome2);

        for (int i = 0; i < palindrome2.size(); i++) {
            if (!(palindrome1.pop() == palindrome2.poll())) {
                System.out.println("không phải là chuỗi palindrome");
                return;
            }
        }
        System.out.println("là chuỗi palindrome");
    }
}
