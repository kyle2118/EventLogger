package beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Event {
    private static final int RANDOM_BOUND = 1000;
    private int id;
    private String msg;
    private LocalDateTime dateTime;

    public static Random random = new Random();

    public Event(String msg, LocalDateTime date) {
        id = random.nextInt(RANDOM_BOUND);
        this.msg = msg;
        dateTime = date;
    }

    public Event(LocalDateTime date) {
        this("Default message", date);
    }

    public int getId() { return id; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public LocalDateTime getDateTime() { return dateTime; }

    @Override
    public String toString() {
        String date = dateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")); // 20 symbols
        return String.format("[%04d, %-20s, %s]\n", id, date, msg);
    }
}
