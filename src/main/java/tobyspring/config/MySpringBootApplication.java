package tobyspring.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableMyAutoConfiguration
@ComponentScan
@Configuration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MySpringBootApplication
{

}
