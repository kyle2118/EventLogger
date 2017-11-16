package loggers;

import events.Event;
import loggers.interfaces.EventLogger;

import java.util.Collection;
import java.util.Iterator;

public class CombinedEventLogger implements EventLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (Iterator it = loggers.iterator(); it.hasNext(); ) {
            EventLogger logger = (EventLogger)it.next();
            logger.logEvent(event);
        }
    }
}
