package tobyspring.helloboot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@UnitTest
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface FastUnitTest
{

}

@Test
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface UnitTest
{

}

public class HelloServiceTest
{
	
//	@FastUnitTest
	@Test
	void simpleHelloService()
	{
		SimpleHelloService helloService = new SimpleHelloService(
				new HelloRepository()
				{
					@Override
					public Hello findHello(String name)
					{
						return null;
					}
					
					@Override
					public void increaseCount(String name)
					{
					
					}
				});
		
		String ret = helloService.sayHello("Test");
		
		Assertions.assertThat(ret).isEqualTo("Hello Test");
		
	}
	
	@Test
	void helloDecorator()
	{
		HelloDecorator helloDecorator = new HelloDecorator(name -> name);
		
		String ret = helloDecorator.sayHello("test");
		
		Assertions.assertThat(ret).isEqualTo("*test*");
		
	}
}
