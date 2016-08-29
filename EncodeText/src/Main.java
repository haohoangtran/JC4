import java.io.IOException;

/**
 * Created by tranh on 28-Aug-16.
 */
public class Main {
    public static void main(String[] args) {
        try {
            EncodeText.encodeText("example.txt","exampleEncode.txt");
            EncodeText.restoreText("exampleEncode.txt","ex.txt");
        } catch (IOException e) {
            System.out.println("Lỗi , xin thử lại!");
        }
    }
}
