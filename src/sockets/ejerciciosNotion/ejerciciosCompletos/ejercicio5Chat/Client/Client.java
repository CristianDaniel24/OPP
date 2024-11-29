package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Enter your name:");
            String nameUser = reader.readLine();
            System.out.println("Enter 'exit' for exit");

            boolean exit = false;
            while (!exit) {
                System.out.println("---------------------------------");
                System.out.println("👾 Enter your message:");
                String message = reader.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Exit..");
                    exit = true;
                }
                //Enviar el nombre del usuario al servidor
                out.writeUTF(nameUser);
                //Enviar el mensaje al servidor
                out.writeUTF(message);
                //Se lee el mensaje del servidor
                ThreadClient threadClient = new ThreadClient(socket);
                threadClient.readSendMessage();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
