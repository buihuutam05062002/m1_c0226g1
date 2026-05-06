package topic18;

public class Bai1 {

    public static void main(String[] args) {
        String regex = "^(C|A|P)+\\d{4}(G|K|I|K)";

        System.out.println("C0223G".matches(regex));
    }
}
