package topic16;

import java.io.BufferedReader;
import java.io.FileReader;

public class Bai2 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/topic16/Data.csv"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");

                String id = p[0];
                String code = p[1];
                String name = p[2];

                System.out.println(id + code + name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
