package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ComputationLogger {
    public static final String FILEPATH = "log.txt";

    private BufferedWriter writer;
    private int index;

    public ComputationLogger() {
        try {
            writer = new BufferedWriter(new FileWriter(FILEPATH));
        } catch (IOException ioe) {
            System.out.println("Unable to open file");
        }
    }

    public void logCalculation(String calculation) {
        try {
            index++;
            String output = String.valueOf(index) + ". " + calculation;
            writer.append(output + "\n");
            System.out.println(output);
        } catch (IOException ioe) {
            System.out.println("Unable to write to file");
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Unable to close file");
        }
    }
}