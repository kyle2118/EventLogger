package enter;

import beans.Client;
import loggers.ConsoleEventLogger;

public class App {
    public Client client;
    public ConsoleEventLogger consoleEventLogger;


    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId() + "", client.getName());
        consoleEventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client(1, "Kirk Osborn");
        app.consoleEventLogger = new ConsoleEventLogger();
        app.logEvent("Event for user 1");
    }
}
