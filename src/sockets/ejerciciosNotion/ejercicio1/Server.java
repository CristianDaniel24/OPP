package sockets.ejerciciosNotion.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            Socket client = serverSocket.accept();

            DataInputStream in = new DataInputStream(client.getInputStream());
            String inputClient = in.readUTF();

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(inputClient);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
