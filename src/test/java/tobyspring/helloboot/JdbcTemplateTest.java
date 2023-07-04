package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@HelloBootTest
public class JdbcTemplateTest
{
	@Autowired JdbcTemplate jdbcTemplate;
	
	@BeforeEach
	void init()
	{
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS HELLO(NAME VARCHAR(50) PRIMARY KEY, COUNT INT)");
	}
	
	@Test
	void insertAndQuery()
	{
		jdbcTemplate.update("INSERT INTO HELLO VALUES (?,?)", "HYEJIN", 3);
		jdbcTemplate.update("INSERT INTO HELLO VALUES (?,?)", "SPRING", 1);
		
		Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM HELLO", Long.class);
		
		Assertions.assertThat(count).isEqualTo(2);
	}
	
}
