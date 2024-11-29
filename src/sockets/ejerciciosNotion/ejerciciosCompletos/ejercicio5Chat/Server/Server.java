package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Server;

import sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Client.ThreadClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final List<ThreadServer> SERVERS_CLIENTS = new LinkedList<>();

    public static void main(String[] args) {
        final int port = 8080;
        try (ServerSocket server = new ServerSocket(port)) {
            //Creacion de 3 hilos para los 3 clientes
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            System.out.println("[INFO] - Listening in port: " + port);

            while (server.isBound()) {
                Socket client = server.accept();
                ThreadServer threadServer = new ThreadServer(client);
                SERVERS_CLIENTS.add(threadServer);
                ThreadClient threadClient = new ThreadClient();
                threadClient.setSERVERS_CLIENTS(SERVERS_CLIENTS);
                evaluateTransmission();
                executorService.execute(threadServer);
                //Creo el hilo del cliente y le envio la lista con las instancias
            }
            executorService.shutdownNow();
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void evaluateTransmission() {
        System.out.println("[INFO] - Clients connected: " + SERVERS_CLIENTS.size());
        if (SERVERS_CLIENTS.size() == 2 || SERVERS_CLIENTS.size() == 3) {
            SERVERS_CLIENTS.forEach(ThreadServer::sendStartMessage);
        }
    }

    public synchronized static void evaluateBroadCast(ThreadServer sender) {
        long validValue = SERVERS_CLIENTS.stream().map(ThreadServer::getMessage).filter(Objects::nonNull).count();

        if (validValue == 2 || validValue == 3 && SERVERS_CLIENTS.size() == 2 || SERVERS_CLIENTS.size() == 3) {
            //Se envia el mensaje del cliente a los demas clientes
            String message = SERVERS_CLIENTS.stream().map(ThreadServer::getMessage).toString();

            SERVERS_CLIENTS.forEach(client -> client.sendMessage(message));
        } else {
            SERVERS_CLIENTS.forEach(ThreadServer::sendWaitingMessage);
        }
    }
}
