package topic2;

public class bai1 {

    static String rectangle(int row, int column) {
        String temp = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                temp += "*";
            }
            temp += "\n";
        }
        return temp;
    }

    static String right_angled(int row, int column) {
        String temp = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == j || i > j) {
                    temp += "*";
                }

            }
            temp += "\n";
        }
        return temp;
    }

    static String top_left_angled(int row, int column) {
        String temp = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j >= i) {
                    temp += "*";
                }

            }
            temp += "\n";
        }
        return temp;
    }

    public static void main(String[] args) {

        System.out.println(top_left_angled(5, 5));

    }

}
