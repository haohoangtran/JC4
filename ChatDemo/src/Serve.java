import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tranh on 20-Sep-16.
 */
public class Serve {
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        ServerSocket serverSocket=new ServerSocket(1003);
        System.out.println("Đơi!");
        Socket socket=serverSocket.accept();
        System.out.println("Kết nối thành công!");
        while (true) {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String msg=input.nextLine();
            System.out.println("CLient: "+bufferedReader.readLine());
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Server: "+msg);
            bufferedWriter.close();
        }
    }

}
