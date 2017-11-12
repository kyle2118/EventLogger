package enter;

import beans.Client;
import loggers.ConsoleEventLogger;
import loggers.interfaces.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public Client client;
    public EventLogger logger;

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId() + "", client.getName());
        logger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)context.getBean("app");


        app.logEvent("Event for user 1");
    }
}
