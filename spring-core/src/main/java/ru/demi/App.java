package ru.demi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Component;
import ru.demi.logger.Event;
import ru.demi.logger.EventLogger;
import ru.demi.logger.EventType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.Map;

@Component
public class App {
    private Client client;
	private Map<EventType, EventLogger> loggers;
	private EventLogger cacheFileEventLogger;

	@Autowired
    public App(Client client, EventLogger cacheFileEventLogger) {
        this.client = client;
		this.cacheFileEventLogger = cacheFileEventLogger;
	}

	public void setLoggers(Map<EventType, EventLogger> loggers) {
		this.loggers = loggers;
	}

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        App app = context.getBean(App.class);
        app.setLoggers((Map<EventType, EventLogger>) context.getBean("loggers"));
		Event event1 = context.getBean(Event.class);
		Event event2 = context.getBean(Event.class);
		Event event3 = context.getBean(Event.class);
		event1.setMessage("Event for user 1");
		app.logEvent(event1, null);
		event2.setMessage("Event for user 2");
		app.logEvent(event2, EventType.INFO);
		event3.setMessage("Event for user 3");
		app.logEvent(event3, EventType.ERROR);

		TimeUnit.SECONDS.sleep(3);

		context.close();
	}
    
    public void logEvent(Event event, EventType eventType) {
		EventLogger eventLogger = loggers.get(eventType);
    	if (Objects.isNull(eventLogger)) {
			eventLogger = cacheFileEventLogger;
		}
        String message = event.getMessage().replaceAll(client.getId(), client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }
}
