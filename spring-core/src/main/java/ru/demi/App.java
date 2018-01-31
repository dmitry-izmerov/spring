package ru.demi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Component;
import ru.demi.logger.Event;
import ru.demi.logger.EventLogger;

import java.util.concurrent.TimeUnit;

@Component
public class App {
    private Client client;
    private EventLogger eventLogger;

    @Autowired
    public App(Client client, EventLogger cacheFileEventLogger) {
        this.client = client;
        this.eventLogger = cacheFileEventLogger;
    }
    
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        App app = context.getBean(App.class);
		Event event1 = context.getBean(Event.class);
		Event event2 = context.getBean(Event.class);
		Event event3 = context.getBean(Event.class);
		event1.setMessage("Event for user 1");
		app.logEvent(event1);
		event2.setMessage("Event for user 2");
		app.logEvent(event2);
		event3.setMessage("Event for user 3");
		app.logEvent(event3);

		TimeUnit.SECONDS.sleep(3);

		context.close();
	}
    
    public void logEvent(Event event) {
        String message = event.getMessage().replaceAll(client.getId(), client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }
}
