package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Client;

import sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Server.ThreadServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ThreadClient implements Runnable {

    private final DataInputStream in;
    private List<ThreadServer> SERVERS_CLIENTS;
    private Socket client;

    public ThreadClient(Socket client) {
        this.client = client;
        this.SERVERS_CLIENTS = new LinkedList<>();
        try {
            this.in = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSERVERS_CLIENTS(List<ThreadServer> SERVERS_CLIENTS) {
        this.SERVERS_CLIENTS = SERVERS_CLIENTS;
    }

    @Override
    public void run() {
        //Se puede llegar a imprimir los mensajes del server
        System.out.println("Connected to server");
    }

    public void readSendMessage() {
        try {
            //Lee el mensaje del servidor
            System.out.println(in.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
