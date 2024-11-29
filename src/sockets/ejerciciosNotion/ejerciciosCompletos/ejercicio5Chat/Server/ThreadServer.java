package sockets.ejerciciosNotion.ejerciciosCompletos.ejercicio5Chat.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadServer implements Runnable {

    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private String message;

    public ThreadServer(Socket socket) {
        this.socket = socket;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getMessage() {
        return message;
    }

    public void sendMessage(String messageFinal) {
        try {
            this.out.writeBoolean(true);
            //Le escribe el mensaje a los clientes
            this.out.writeUTF(messageFinal);
            this.message = null;
        } catch (IOException e) {
            System.out.println("[ERROR] - Error sending text final to client " + this.socket.getRemoteSocketAddress());
        }
    }


    public void sendWaitingMessage() {
        try {
            this.out.writeBoolean(false);
            this.out.writeUTF("Waiting for another users..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        System.out.println("[INFO] - Client connected: " + this.socket.getRemoteSocketAddress());
        this.getClientText();
    }

    public void getClientText() {
        System.out.println("[INFO] - getTextClient: " + this.socket.getRemoteSocketAddress());
        try {
            this.message = in.readUTF();
            System.out.println("[INFO] - Text from client: " + this.message);
            Server.evaluateBroadCast(this);
            this.getClientText();
        } catch (IOException e) {
            Server.SERVERS_CLIENTS.remove(this);
            System.out.println("[INFO] - Client disconnected" + this.socket.getRemoteSocketAddress());
            this.closeAll();
        }
    }

    public void sendStartMessage() {
        try {
            this.out.writeBoolean(true);
        } catch (IOException e) {
            System.out.println("[ERROR] - Error sending start message to client " + socket.getRemoteSocketAddress());
        }
    }

    public void closeAll() {
        try {
            if (this.in != null) {
                this.in.close();
            }
            if (this.out != null) {
                this.out.close();
            }
            if (this.socket != null) {
                this.socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
