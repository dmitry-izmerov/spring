package ru.demi.logger;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import lombok.Data;

@Data
public class Event {
    private final int id;
    private String message;
    private final Date date;
    private DateFormat dateFormat;
    
    public Event(Date date, DateFormat dateFormat) {
        id = new Random(10000).nextInt();
        this.date = date;
        this.dateFormat = dateFormat;
    }
    
    @Override
    public String toString() {
        return "Event{" +
            "id=" + id +
            ", message=" + message +
            ", date=" + dateFormat.format(date) +
            '}';
    }
}
