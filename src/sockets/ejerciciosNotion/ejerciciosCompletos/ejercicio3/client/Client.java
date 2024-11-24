package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio3.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            //DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //ObjectInputStream inObjec = new ObjectInputStream(socket.getInputStream());
            //ObjectOutputStream outObjec = new ObjectOutputStream(socket.getOutputStream());
            boolean exit = false;
            while (!exit) {
                System.out.println("\nWelcome!!");
                System.out.println("1. Start");
                System.out.println("2. Exit");
                System.out.println("Enter the option:");
                int option = Integer.parseInt(reader.readLine());
                if (option == 1) {
                    System.out.println("Enter the number:");
                    int number = Integer.parseInt(reader.readLine());
                    out.writeInt(number);
                    boolean sentNumber = true;
                    out.writeBoolean(sentNumber);
                } else if (option == 2) {
                    System.out.println("Exit..");
                    exit = true;
                } else {
                    System.out.println("The option is invalid");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
