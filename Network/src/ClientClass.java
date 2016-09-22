import sun.util.calendar.BaseCalendar;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tranh on 16-Sep-16.
 */
public class ClientClass {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 2003);
        File file = new File("aaa.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(file.getPath());
        bufferedWriter.newLine();
        bufferedWriter.flush();
        while (bufferedReader.ready()) {
            bufferedWriter.write(bufferedReader.read());
        }
        bufferedWriter.flush();
        System.out.println("Viết xong!");
        System.out.println("Bắt đầu nhận tên file!");
        BufferedReader bufferedReaderFromServe = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String path = bufferedReaderFromServe.readLine();
        System.out.println("path: " + path);
        bufferedWriter.close();
        System.out.println("đã xong!!!!");

    }
}
