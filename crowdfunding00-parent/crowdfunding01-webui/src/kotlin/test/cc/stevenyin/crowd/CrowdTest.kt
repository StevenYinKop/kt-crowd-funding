package cc.stevenyin.crowd

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import javax.sql.DataSource
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = arrayOf("classpath:spring-persist-mybatis.xml"))
class CrowdTest {
	
	@Autowired
	private lateinit var dataSource: DataSource
	
	@Test
	fun testConnection() {
		println(dataSource);
	}
}