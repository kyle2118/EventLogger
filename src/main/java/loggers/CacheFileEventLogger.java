package loggers;

import events.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    /*
     *  While events are created, they are stored in the list.
     *  if list's size reaches cache size, it flushes all events into file
     */
    private List<Event> listOfEvents;
    private int cacheSize;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        listOfEvents = new ArrayList<>();
    }


    /*
     *  Adding Event objects into the list unless cache size isn't reached.
     */
    @Override
    public void logEvent(Event event) {
        listOfEvents.add(event);
        if (listOfEvents.size() == cacheSize) {
            writeEventsFromCache();
        }
    }
    protected void writeEventsFromCache() {
        StringBuilder output = new StringBuilder("");
        for (Event temp : listOfEvents) {
            output.append(temp.toString());
        }
        try {
            FileUtils.writeStringToFile(file, output.toString(), true);
        } catch (IOException e) {
            System.err.println("IOException has been caught: " + e);
        }
        listOfEvents.clear();
    }
}
