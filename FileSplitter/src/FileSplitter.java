import java.io.*;
import java.nio.Buffer;

/**
 * Created by tranh on 25-Aug-16.
 */
public class FileSplitter {
    public static void fileSplitter(String sourceFile,int numberOfPieces) throws IOException {
        File file=new File(sourceFile);
        int piece=1;
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
        long size=file.length();
        byte[] buffer=new byte[(int) (size)/(numberOfPieces) + 100];
        int tmp;
        while (( tmp = bufferedInputStream.read(buffer)) > 0) {
            File newFile = new File(file.getParent(), file.getName() + "."
                    + String.format("%03d", piece++));
            System.out.println(tmp);
            try (FileOutputStream out = new FileOutputStream(newFile)){
                out.write(buffer, 0, tmp);
            }
        }
    }
}