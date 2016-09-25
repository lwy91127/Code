package NIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by lwy on 2016/9/15.
 */
public class NioServer {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            int recvMsgSize = 0;
            byte[] info = new byte[1024];
            while (true) {
                Socket clntSocket = serverSocket.accept();
                SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
                System.out.println("Handling client at " + clientAddress);
                inputStream = clntSocket.getInputStream();
                while ((recvMsgSize = inputStream.read(info)) != -1) {
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvMsgSize, 0, info, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
