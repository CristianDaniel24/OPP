package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    //Se crean ambas variables estaticas para almacenar la de cada cliente
    //Lista estatica de ThreadServer con clientes conectados
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            while (serverSocket.isBound()) {
                Socket client = serverSocket.accept();
                //Condicional par o impar si entro se le asigna a una variable para cada usuario
                //Cuando esten los dos clientes conectados en la lista envia la señal al ThreadClient para que inicie el programa
                ThreadServer threadService = new ThreadServer(client);
                executorService.execute(threadService);
            }
            executorService.shutdownNow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
