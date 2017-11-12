package loggers;

import events.Event;
import loggers.interfaces.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String filename;
    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(filename), event.toString(), true);
        } catch (IOException e) {
            System.err.println("IOException has been caught: " + e);
        }
    }
}
