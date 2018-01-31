package ru.demi;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import ru.demi.logger.ConsoleEventLogger;
import ru.demi.logger.Event;
import ru.demi.logger.EventLogger;
import ru.demi.logger.FileEventLogger;

@Configuration
@PropertySource("app.properties")
public class Config {

	@Value("${fileName}")
	private String fileName;
    
    @Bean
    public Client client() {
        return new Client("1", "Ivan Ivanov");
    }
    
    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateTimeInstance();
    }
    
    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public Event event() {
        return new Event(new Date(), dateFormat());
    }
    
    @Bean
    public EventLogger eventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean
	public EventLogger fileEventLogger() {
    	return new FileEventLogger(fileName);
	}

    @Bean
    public App app() {
        return new App(client(), fileEventLogger());
    }
}
