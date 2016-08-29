import java.io.*;

/**
 * Created by tranh on 28-Aug-16.
 */
public class EncodeText {
    public static void encodeText(String path,String newPath) throws IOException {
        File fileEncode=new File(path);

        byte[] bytesOfFileInput=new byte[(int)fileEncode.length()];
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(path));
        bufferedInputStream.read(bytesOfFileInput);
        bufferedInputStream.close();
        for (int i=0;i<bytesOfFileInput.length;i++) {
            bytesOfFileInput[i]+=5;
        }
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(newPath));
        bufferedOutputStream.write(bytesOfFileInput);
        bufferedOutputStream.close();
    }
    public static void restoreText(String path,String newPath) throws IOException {
        File fileEncoded=new File(path);
        byte[] bytesOfFileInput=new byte[(int)fileEncoded.length()];
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(path));
        bufferedInputStream.read(bytesOfFileInput);
        bufferedInputStream.close();
        for (int i=0;i<bytesOfFileInput.length;i++) {
            bytesOfFileInput[i]-=5;
        }
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(newPath));
        bufferedOutputStream.write(bytesOfFileInput);
        bufferedOutputStream.close();
    }
}
