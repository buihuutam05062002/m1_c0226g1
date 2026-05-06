package topic18;

public class Bai2 {
    public static void main(String[] args) {
        String regex = "^\\(\\d{1,}\\)-\\(+0+\\d{9}\\)";
        System.out.println("(84)-(0978489648)".matches(regex));
    }
}
