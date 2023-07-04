package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloRepositoryTest
{
	@Autowired HelloRepository helloRepository;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@BeforeEach
//	void init()
//	{
//		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS HELLO(NAME VARCHAR(50) PRIMARY KEY, COUNT INT)");
//	}
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
