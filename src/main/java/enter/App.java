package enter;

import beans.Client;
import events.Event;
import events.EventType;
import loggers.ConsoleEventLogger;
import loggers.interfaces.EventLogger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class App {
    public Client client;
    public EventLogger logger;

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public void logEvent(Event event, EventType type) {
        if (type == EventType.ERROR) {

        } else if (type == EventType.INFO) {

        } else if (type == null) {

        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)context.getBean("app");
        Event event1 = (Event)context.getBean("event");
        event1.setMsg("New Message set");

        app.logEvent(event1, EventType.ERROR);

        context.close();
    }
}
