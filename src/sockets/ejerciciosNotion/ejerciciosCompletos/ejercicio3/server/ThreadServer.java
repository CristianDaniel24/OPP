package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio3.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ThreadServer extends Thread {
    //Variable contante

    private final Socket client;

    public ThreadServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try (DataInputStream in = new DataInputStream(client.getInputStream())
             //DataOutputStream out = new DataOutputStream(client.getOutputStream());
             //ObjectInputStream inObjec = new ObjectInputStream(client.getInputStream());
             //ObjectOutputStream outObjec = new ObjectOutputStream(client.getOutputStream());
        ) {
            System.out.println("[INFO] - Client connected");
            while (client.isConnected()) {
                int numberRecibed = in.readInt();
                System.out.printf("Number %d%n", numberRecibed);

                boolean sentNumber = in.readBoolean();


            }
        } catch (SocketException e) {
            //Se elimina un usuario de la lista constante que esta en el Server
            System.out.println("[INFO] - Client disconnected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
