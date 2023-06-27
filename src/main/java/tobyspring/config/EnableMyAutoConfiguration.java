package tobyspring.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import tobyspring.config.autoconfig.DispatcherServletConfig;
import tobyspring.config.autoconfig.TomcatWebServerConfig;

@Import({ DispatcherServletConfig.class, TomcatWebServerConfig.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableMyAutoConfiguration
{

}
