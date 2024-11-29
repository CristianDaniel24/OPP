package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final BufferedReader reader;
    private final ThreadClient threadClient;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(BufferedReader reader) {
        this.reader = reader;
        this.threadClient = new ThreadClient();
        this.connect();
    }

    public void connect() {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            while (socket.isConnected()) {
                handleAccess(false);
            }
        } catch (IOException e) {
            System.out.println("[INFO] - Server disconnected");
        }
    }

    public void handleAccess(boolean skip) {
        try {
            if (skip || in.readBoolean()) {
                //Se pide y se envia el nombre del usuario
                //Como puedo pedir el nombre una unica vez sin que vuelva a pedirlo
                System.out.println("Enter your name:");
                String nameUser = reader.readLine();
                threadClient.setName(nameUser);

                System.out.println("---------------------------------");
                System.out.println("👾 Enter your message:");
                out.writeUTF(reader.readLine());
                evaluate();
            } else {
                handleAccess(false);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void evaluate() throws IOException {
        boolean hasResult = in.readBoolean();
        if (hasResult) {
            //Se le muestra el mensaje a los demas clientes
            System.out.println(in.readUTF());
            handleAccess(true);
        } else {
            System.out.println();
            evaluate();
        }
    }
}
