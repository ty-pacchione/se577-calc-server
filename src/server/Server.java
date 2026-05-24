package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Server(int port) {
        startServer(port);
        acceptClient();
        String request = getRequest();
        System.out.println("Request: " + request);
        String response = "6";
        sendResponse(response);
        close();
    }

    private void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");
        } catch (IOException ioe) {
            System.out.println("Unable to start server");
        }
    }

    private void acceptClient() {
        try {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Client accepted");
        } catch (IOException ioe) {
            System.out.println("Unable to connect to client");
        }
    }

    private String getRequest() {
        try {
            String request = in.readLine();

            while (request == null) {
                request = in.readLine();
            }

            return request;
        } catch (IOException ioe) {
            return "error";
        }
    }

    private void sendResponse(String response) {
        out.println(response);
    }

    public void close() {
        try {
            serverSocket.close();
            clientSocket.close();
            out.close();
            in.close();
        } catch (IOException ioe) {
            System.out.println("Unable to close connection");
        }
    }
}