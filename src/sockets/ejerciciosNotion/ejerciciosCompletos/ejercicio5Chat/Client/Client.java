package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        new ClientHandler(reader);
        
    }
}
