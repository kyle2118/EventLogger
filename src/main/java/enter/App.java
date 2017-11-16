package enter;

import beans.Client;
import beans.Event;
import beans.EventType;
import loggers.interfaces.EventLogger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class App {
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)context.getBean(App.class);

        Event event = (Event)context.getBean(Event.class);
        Client client1 = (Client)context.getBean("client1");
        Client client2 = (Client)context.getBean("client2");
        Client client3 = (Client)context.getBean("client3");

        app.logEvent(client1, EventType.ERROR, event, "Event for " + client1.getId() + " with ERROR");
        app.logEvent(client2, EventType.INFO, event, "Event for " + client2.getId() + " with INFO");
        app.logEvent(client3, null, event, "Event for " + client3.getId() + " with null");

        context.close();
    }

    public App(EventLogger logger, Map<EventType, EventLogger> loggers) {
        this.defaultLogger = logger;
        this.loggers = loggers;
    }

    public void logEvent(Client client, EventType type, Event event, String msg) {
        msg = msg.replaceAll(client.getId() + "", client.getName());
        event.setMsg(msg);
        EventLogger logger = loggers.get(type);

        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
