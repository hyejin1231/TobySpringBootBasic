package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest
{
	@Test
	void helloController()
	{
		HelloController helloController = new HelloController(name -> name); // 테스트에서 사용하는 수동적인 DI
		
		String ret = helloController.hello("Test");
		
		Assertions.assertThat(ret).isEqualTo("Test");
	}
	
	@Test
	void failsHelloController()
	{
		HelloController helloController = new HelloController(name -> name);
		
		Assertions.assertThatThrownBy(() -> {
			helloController.hello(null);
		}).isInstanceOf(IllegalArgumentException.class);
		
		Assertions.assertThatThrownBy(() -> {
			helloController.hello("");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
