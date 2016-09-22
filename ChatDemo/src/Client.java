import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tranh on 20-Sep-16.
 */
public class Client{
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        Socket socket=new Socket("localhost",1003);
        while (true) {
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg=input.nextLine();
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Client: "+msg);
            System.out.println("Server: "+bufferedReader.readLine());
            bufferedWriter.close();
        }

    }
}
