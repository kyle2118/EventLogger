package loggers;

import beans.Event;
import loggers.interfaces.EventLogger;

public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
