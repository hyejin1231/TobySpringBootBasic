package tobyspring.helloboot;

import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloServiceCountTest
{
	@Autowired HelloService helloService;
	@Autowired HelloRepository helloRepository;
	
	@Test
	void sayHelloIncreaseCount()
	{
		IntStream.rangeClosed(1, 10).forEach(count -> {
			helloService.sayHello("HYEJIN");
			Assertions.assertThat(helloRepository.countOf("HYEJIN")).isEqualTo(count);
		});
		
	}
	
}
