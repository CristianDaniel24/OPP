package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadServer implements Runnable {
    private final Socket client;
    private String nameUser;
    private String messageClient;
    private DataInputStream in;
    private DataOutputStream out;

    public ThreadServer(Socket client) {
        this.client = client;
        try {
            this.in = new DataInputStream(client.getInputStream());
            this.out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            boolean exit = false;
            while (!exit) {
                //Se recibe el nombre del cliente
                this.nameUser = in.readUTF();
                System.out.println("\n[INFO] - Name user to send message: " + this.nameUser);
                //Se recibe el mensaje del cliente
                this.messageClient = in.readUTF();
                System.out.println("[INFO] - Message to client: " + this.messageClient);
                //out.writeUTF(this.nameUser);
                //out.writeUTF(this.messageClient);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void messageForClients() {
        try {
            //Se le envia el mensaje con el formato al cliente
            String messageForClients = String.format(String.format("Message of %s%n👽: %s", this.nameUser, this.messageClient));
            out.writeUTF(messageForClients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
