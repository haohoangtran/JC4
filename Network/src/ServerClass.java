import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tranh on 16-Sep-16.
 */
public class ServerClass {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2003);
        System.out.println("Đợi");
        Socket socket = serverSocket.accept();
        System.out.println("Chấp nhận");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriterToClient=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String name = bufferedReader.readLine();
        System.out.println(name);
        if (name.indexOf(' ') == -1 || name.isEmpty()) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\" + name)));
            while (bufferedReader.ready()){
                bufferedWriter.write(bufferedReader.read());
            }
            bufferedWriter.flush();
            System.out.println("Nhận xong!");
            System.out.println("Bắt đầu gửi path!");

            bufferedWriterToClient.write("E:\\"+name);
            bufferedWriterToClient.newLine();
            bufferedWriterToClient.flush();
        } else {
            socket.close();
            System.out.println("Tên méo hợp lệ!");
            return;
        }
    }
}
