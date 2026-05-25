package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
    public static final int PORT = 3000;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader inputReader;

    public CalculatorServer() {
        startServer();
        acceptClient();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started");
        } catch (IOException ioe) {
            System.out.println("Unable to start server");
        }
    }

    private void acceptClient() {
        try {
            clientSocket = serverSocket.accept();
            inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Client accepted");
        } catch (IOException ioe) {
            System.out.println("Unable to accept client");
        }
    }

    public String getMessage() {
        try {
            return inputReader.readLine();
        } catch (IOException ioe) {
            System.out.println("Unable to read input");
            return null;
        }
    }

    public void close() {
        try {
            serverSocket.close();
            clientSocket.close();
            inputReader.close();
        } catch (IOException ioe) {
            System.out.println("Unable to close server");
        }
    }
}