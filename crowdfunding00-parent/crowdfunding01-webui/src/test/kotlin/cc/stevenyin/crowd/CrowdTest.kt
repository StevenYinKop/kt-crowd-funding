package cc.stevenyin.crowd

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import javax.sql.DataSource
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import cc.stevenyin.crowd.mapper.TestMapper

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = arrayOf("classpath:spring-persist-mybatis.xml"))
class CrowdTest {
	
	@Autowired
	private lateinit var dataSource: DataSource
    @Autowired
    private lateinit var testMapper: TestMapper
	
	@Test
	fun testConnection() {
		println(dataSource);
		val test = cc.stevenyin.crowd.entity.TestRecord();
		test.id = "123"
		test.age = 1
		test.description = "test"
		test.name = "steven"
	}
}