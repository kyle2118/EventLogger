package enter;

import beans.Client;
import events.Event;
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

    public void logEvent(Event event) {

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)context.getBean("app");
        Event event1 = (Event)context.getBean("event");

        app.logEvent(new Event("Hard connection via type1", LocalDateTime.now()));
        app.logEvent(new Event("Hard connection via type2", LocalDateTime.now()));
        app.logEvent(event1);
        app.logEvent(new Event("Hard connection via type3", LocalDateTime.of(1957, 11, 21, 10, 14, 15)));
        app.logEvent(new Event("Hard connection via type4", LocalDateTime.now()));
        app.logEvent(new Event("Hard connection via type5", LocalDateTime.now()));

        context.close();
    }
}
