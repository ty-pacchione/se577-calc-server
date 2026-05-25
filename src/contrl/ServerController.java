package contrl;

import logger.ComputationLogger;
import server.CalculatorServer;

public class ServerController {
    private CalculatorServer server;
    private ComputationLogger logger;

    public ServerController(CalculatorServer server, ComputationLogger logger) {
        this.server = server;
        this.logger = logger;
    }

    public void run() {
        String calculation = server.getMessage();

        while (calculation != null) {
            logger.logCalculation(calculation);
            calculation = server.getMessage();
        }

        server.close();
        logger.close();
    }
}