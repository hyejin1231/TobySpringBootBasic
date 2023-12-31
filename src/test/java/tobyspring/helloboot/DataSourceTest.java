package tobyspring.helloboot;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

//@ExtendWith(SpringExtension.class) // 스프링 컨테이너 테스트가 가능하도록 함!
//@ContextConfiguration(classes = HellobootApplication.class)
//@TestPropertySource("classpath:/application.properties")
@HelloBootTest
public class DataSourceTest
{
	@Autowired DataSource dataSource;
	
	@Test
	void connect() throws SQLException
	{
		Connection connection = dataSource.getConnection();
		connection.close();
	}

}
