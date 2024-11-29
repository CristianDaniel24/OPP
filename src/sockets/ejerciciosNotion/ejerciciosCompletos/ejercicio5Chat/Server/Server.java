package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final List<ThreadServer> SERVERS_CLIENTS = new LinkedList<>();

    public static void main(String[] args) {
        final int port = 8080;
        try (ServerSocket server = new ServerSocket(port)) {
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            System.out.println("[INFO] - Listening in port: " + port);
            while (server.isBound()) {
                Socket client = server.accept();
                ThreadServer threadServer = new ThreadServer(client);
                SERVERS_CLIENTS.add(threadServer);
                boolean continuar = evaluateClients();
                if (continuar) {
                    //Si hay 2 o mas clientes
                    System.out.println("[INFO] - There are 2 or more clients connected");
                } else {
                    System.out.println("[INFO] - There is only one user logged in");
                }
                executorService.execute(threadServer);
                sendMessage();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static boolean evaluateClients() {
        boolean continuar = false;
        if (SERVERS_CLIENTS.size() == 2 || SERVERS_CLIENTS.size() == 3) {
            continuar = true;
        }
        return continuar;
    }

    public synchronized static void sendMessage() {
        //Se envia el mensaje para cada cliente
        SERVERS_CLIENTS.forEach(ThreadServer::messageForClients);
    }
}
