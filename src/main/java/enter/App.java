package enter;

import beans.Client;
import events.Event;
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

    public void logEvent(Event event) {

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)context.getBean("app");
        Event event1 = (Event)context.getBean("event");


        app.logEvent(event1);
    }
}
