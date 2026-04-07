package topic3_arr;

public class bai5 {
    public static void main(String[] args) {

        String str = "sdfjalfjawefjvnaenbawrio";

        char c = 'b';
        int count = 0;

        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println(count);
    }
}
