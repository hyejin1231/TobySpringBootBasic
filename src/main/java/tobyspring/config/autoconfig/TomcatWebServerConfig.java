package tobyspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import tobyspring.config.ConditionalMyOnClass;
import tobyspring.config.MyAutoConfiguration;

//@Configuration
//@Conditional(TomcatWebServerConfig.TomcatCondition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat") // 우선 Tomcat 라이브러리가 있는지 1차로 확인해보고..
@MyAutoConfiguration
public class TomcatWebServerConfig
{
	@Value("${contextPath}")
	String contextPath;
	
	@Bean("tomcatWebServerFactory")
	@ConditionalOnMissingBean // 그 다음 사용자가 관련 빈을 만든게 있는지 확인해보고 만약 없다면 Bean으로 생성해달라... !
	public ServletWebServerFactory servletWebServerFactory()
	{
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.setContextPath(this.contextPath);
		return factory;
	}
	
//	static class TomcatCondition implements Condition
//	{
//		@Override
//		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
//		{
//			return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", context.getClassLoader());
//		}
//	}
}
