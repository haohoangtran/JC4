import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by tranh on 27-Aug-16.
 */
public class FileJoiner {
    public static void joinFile(File nameOfFirstPath) throws IOException {
        ArrayList<File> arrayListPath = new ArrayList<>();
        int piece = 1;
        while (true) {
            File newFile = new File(nameOfFirstPath.getName().substring(0, nameOfFirstPath.getName().lastIndexOf(".")) + "." +
                    String.format("%03d", piece));
            if (newFile.exists()) {

                arrayListPath.add(newFile);
                piece++;
            } else {
                break;
            }
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(
                nameOfFirstPath.getName().substring(0, nameOfFirstPath.getName().lastIndexOf("."))));
        for (int i = 0; i < arrayListPath.size(); i++) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(arrayListPath.get(i)));
            byte[] bytes = new byte[(int) arrayListPath.get(i).length()];
            bufferedInputStream.read(bytes);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedInputStream.close();
        }
        bufferedOutputStream.close();
        return;

    }
}
