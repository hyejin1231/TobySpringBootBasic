package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) // springBoot를 이용하는데 웹 환경을 세팅할 필요는 없다..!
public class HelloRepositoryTest
{
	@Autowired HelloRepository helloRepository;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	void findHelloFailed()
	{
		Assertions.assertThat(helloRepository.findHello("HYEJIN")).isNull();
	}
	
	@Test
	void increaseCount()
	{
		Assertions.assertThat(helloRepository.countOf("HYEJIN")).isEqualTo(0);
		
		helloRepository.increaseCount("HYEJIN");
		Assertions.assertThat(helloRepository.countOf("HYEJIN")).isEqualTo(1);
		
		helloRepository.increaseCount("HYEJIN");
		Assertions.assertThat(helloRepository.countOf("HYEJIN")).isEqualTo(2);
	}
}
