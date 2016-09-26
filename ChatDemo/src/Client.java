import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tranh on 23-Sep-16.
 */
public class Client implements Runnable {
    private static Socket socket;
    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static Scanner input = new Scanner(System.in);
    private static String nickname;

    public static void main(String[] args) throws IOException {
        socket = new Socket("127.0.0.1", 1995);
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("Nhập nick name: ");
        nickname = input.nextLine();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String msg = input.nextLine();
                        writer.write(nickname + ":" + msg);
                        writer.newLine();
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Client client = new Client();
        Thread thread = new Thread(client);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = reader.readLine();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
