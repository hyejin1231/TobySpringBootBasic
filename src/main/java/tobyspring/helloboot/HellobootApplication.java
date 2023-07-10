package tobyspring.helloboot;

import jakarta.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import tobyspring.config.MySpringBootApplication;

@MySpringBootApplication
public class HellobootApplication {
	
	private final JdbcTemplate jdbcTemplate;
	
	public HellobootApplication(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@PostConstruct
	void init()
	{
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS HELLO(NAME VARCHAR(50) PRIMARY KEY, COUNT INT)");
	}
	
	//	@Bean
//	ApplicationRunner applicationRunner(Environment environment)
//	{
//		return args -> {
//			String name = environment.getProperty("my.name");
//			System.out.println("name = " + name);
//		};
//	}
	
	public static void main(String[] args) {
//		MySpringApplication.run(HellobootApplication.class, args);
		SpringApplication.run(HellobootApplication.class, args);
	}
	
	
}
