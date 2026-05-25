package main;

import contrl.ServerController;
import logger.ComputationLogger;
import server.CalculatorServer;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        CalculatorServer server = new CalculatorServer();
        ComputationLogger logger = new ComputationLogger();
        ServerController controller = new ServerController(server, logger);

        controller.start();
    }
}