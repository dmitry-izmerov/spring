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

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.demi.logger.Event;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.demi")
@ImportResource("loggers.xml")
@PropertySource({"client.properties", "classpath:jdbc.properties"})
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

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String userName;
	@Value("${jdbc.password}")
	private String password;

	@PostConstruct
	private void postConstruct() {
		JdbcTemplate jdbcTemplate = jdbcTemplate();
		jdbcTemplate.execute("DROP TABLE events IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE events(id INT PRIMARY KEY, message VARCHAR)");
	}

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

    @Bean
    public JdbcTemplate jdbcTemplate() {
    	return new JdbcTemplate(dataSource());
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}

	public boolean isDevEnv() {
		return devEnvName.equals(env);
	}
}
