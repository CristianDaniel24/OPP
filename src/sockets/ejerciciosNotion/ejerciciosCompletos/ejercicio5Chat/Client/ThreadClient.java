package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Client;

import sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Server.ThreadServer;

import java.util.LinkedList;
import java.util.List;

public class ThreadClient implements Runnable {

    private String name;
    private List<ThreadServer> SERVERS_CLIENTS;

    public ThreadClient() {
    }

    public ThreadClient(String name) {
        this.name = name;
        this.SERVERS_CLIENTS = new LinkedList<>();
    }

    public void setSERVERS_CLIENTS(List<ThreadServer> SERVERS_CLIENTS) {
        this.SERVERS_CLIENTS = SERVERS_CLIENTS;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        printUser();
    }

    public void printUser() {
        //Se imprimen los nombres del los clientes
        System.out.println("Client name: " + this.name);
        //this.SERVERS_CLIENTS.stream().forEach(client -> client.sendMessage());
    }
}
