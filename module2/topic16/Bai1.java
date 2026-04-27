package topic16;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Bai1 {
    public static void main(String[] args) {
        int charCount = 0;
        try (FileReader reader = new FileReader("src/topic16/dulieu.txt"); FileOutputStream output = new FileOutputStream("src/topic16/output.txt")) {

            {
                int ch;
                while ((ch = reader.read()) != -1) {
                    output.write(ch);
                    charCount++;
                }

                System.out.println("Characters: " + charCount);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
