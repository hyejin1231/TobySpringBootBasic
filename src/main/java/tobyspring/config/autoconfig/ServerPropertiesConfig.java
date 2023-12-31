package tobyspring.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import tobyspring.config.MyAutoConfiguration;

//@MyAutoConfiguration
public class ServerPropertiesConfig
{
//	@Bean
//	public ServerProperties serverProperties(Environment environment)
//	{
//		ServerProperties properties = new ServerProperties();
//		properties.setContextPath(environment.getProperty("contextPath"));
//		properties.setPort(Integer.parseInt(environment.getProperty("port")));
//
//		return properties;
//	}
	
//	@Bean
	public ServerProperties serverProperties(Environment environment)
	{
		return Binder.get(environment).bind("", ServerProperties.class).get();
	}
}
