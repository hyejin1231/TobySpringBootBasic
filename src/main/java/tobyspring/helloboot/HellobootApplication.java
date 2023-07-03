package tobyspring.helloboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import tobyspring.config.MySpringBootApplication;

@MySpringBootApplication
public class HellobootApplication {
	
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
