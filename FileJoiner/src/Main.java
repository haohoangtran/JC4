import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tranh on 27-Aug-16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.println("Nhập dường dẫn file đầu tiên (đuôi .001): ");
        String path= input.nextLine();
        try {
            FileJoiner.joinFile(new File(path));
        } catch (IOException e) {
            System.out.println("Lỗi nhập xuất file");
            e.printStackTrace();
        }
    }
}
