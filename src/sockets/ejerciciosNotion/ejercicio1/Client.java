package sockets.ejerciciosNotion.ejercicio1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (Socket socket = new Socket("localhost", 9090)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Enter the text for the server: ");
            String input = reader.readLine();
            out.writeUTF(input);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Message from the server: " + in.readUTF());
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}