package ru.demi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.demi.logger.Event;
import ru.demi.logger.EventLogger;

public class App {
    private Client client;
    private EventLogger eventLogger;
    
    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        event.setMessage("Event for user 1");
        app.logEvent(event);
    }
    
    public void logEvent(Event event) {
        String message = event.getMessage().replaceAll(client.getId(), client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }
}
