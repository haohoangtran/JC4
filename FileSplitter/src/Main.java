import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by tranh on 25-Aug-16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        FileSplitter fileSplitter = new FileSplitter();
        System.out.println("Nhập dường dẫn file cần cắt: ");
        String path= input.nextLine();
        try {
            FileSplitter.fileSplitter(path,5);
        } catch (IOException e) {
            System.out.println("Lỗi nhập xuất file");
            e.printStackTrace();
        }
    }
}
