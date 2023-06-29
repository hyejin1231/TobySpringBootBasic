package tobyspring.study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionalTest
{
	@Test
	void conditional()
	{
		// true
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//		applicationContext.register(Config1.class);
//		applicationContext.refresh();
//
//		MyBean bean = applicationContext.getBean(MyBean.class);
		ApplicationContextRunner contextRunner = new ApplicationContextRunner();
		contextRunner.withUserConfiguration(Config1.class)
				.run(context -> {
					Assertions.assertThat(context).hasSingleBean(MyBean.class);
					Assertions.assertThat(context).hasSingleBean(Config1.class);
				});
		
		
		// false
//		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext();
//		applicationContext2.register(Config2.class);
//		applicationContext2.refresh();
//
//		MyBean bean2 = applicationContext2.getBean(MyBean.class);
		
		ApplicationContextRunner contextRunner1 = new ApplicationContextRunner();
		contextRunner1.withUserConfiguration(Config2.class)
				.run(context -> {
					Assertions.assertThat(context).doesNotHaveBean(MyBean.class);
					Assertions.assertThat(context).doesNotHaveBean(Config2.class);
				});
	}
	
	@Conditional(TrueCondition.class)
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface TrueConditional
	{
	
	}
	
	@Conditional(FalseCondition.class)
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface FalseConditional
	{
	
	}
	
	@Conditional(BooleanCondition.class)
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface BooleanConditional
	{
		boolean value();
	}
	
	@Configuration
	@BooleanConditional(true)
//	@TrueConditional
//	@Conditional(TrueCondition.class)
	static class Config1
	{
		@Bean
		MyBean myBean()
		{
			return new MyBean();
		}
		
	}
	
	@Configuration
	@BooleanConditional(false)
//	@FalseConditional
//	@Conditional(FalseCondition.class)
	static class Config2
	{
		@Bean
		MyBean myBean()
		{
			return new MyBean();
		}
	}
	
	 static class MyBean
	{
	}
	
	 static class TrueCondition implements Condition
	{
		@Override
		public boolean matches(ConditionContext context,
				AnnotatedTypeMetadata metadata)
		{
			return true;
		}
	}
	
	static class FalseCondition implements Condition
	{
		@Override
		public boolean matches(ConditionContext context,
				AnnotatedTypeMetadata metadata)
		{
			return false;
		}
	}
	
	static class BooleanCondition implements Condition
	{
		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
		{
			Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional.class.getName());
			Boolean value = (Boolean) annotationAttributes.get("value");
			
			return value;
		}
	}
}
