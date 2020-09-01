package playground;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author panjx
 */

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
    }

    Main() {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("/3.txt")) {
            if (input != null) {
                int n = 0;
                while ((n = input.read()) != -1) {
                    System.out.println((char) n);
                }
            } else {
                System.out.println("null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


