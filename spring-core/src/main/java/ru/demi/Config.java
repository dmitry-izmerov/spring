package ru.demi;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import ru.demi.logger.Event;

@Configuration
@ComponentScan("ru.demi")
@ImportResource("loggers.xml")
@PropertySource("client.properties")
@EnableAspectJAutoProxy
public class Config {

	@Value("${id}")
	private String id;

	@Value("${fullName}")
	private String fullName;

	@Value("#{ systemEnvironment['ENV'] }")
	private String env;

	@Value("${devEnvName}")
	private String devEnvName;

    @Bean
    public Client client() {
        return new Client(id, fullName);
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

	public boolean isDevEnv() {
		return devEnvName.equals(env);
	}
}
