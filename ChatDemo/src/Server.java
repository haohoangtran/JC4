import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tranh on 23-Sep-16.
 */

public class Server {
    public static void main(String[] args) throws IOException {

        ArrayList<Socket> socketArrayList = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(1995);
        while (true) {
            final Socket socket = serverSocket.accept();
            socketArrayList.add(socket);
            String date=(new Date()).toString();
            for (Socket socket1 : socketArrayList) {
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                bufferedWriter.write("chào mừng bạn "+socket.getLocalAddress().getHostName()+" gia nhập lúc "+date);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            BufferedReader bufferedReader;
                            BufferedWriter bufferedWriter;
                            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String msg = bufferedReader.readLine();
                            System.out.println("server nhận: " + msg);
                            for (Socket socket1 : socketArrayList) {
                                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                                bufferedWriter.write(msg);
                                bufferedWriter.newLine();
                                bufferedWriter.flush();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException("Lỗi rồi");
                        }
                    }
                }
            }).start();
        }

    }
}






