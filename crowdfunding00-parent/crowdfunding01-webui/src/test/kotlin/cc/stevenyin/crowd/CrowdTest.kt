package cc.stevenyin.crowd

import cc.stevenyin.crowd.entity.TestRecord
import cc.stevenyin.crowd.mapper.TestMapper
import cc.stevenyin.crowd.mapper.insert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.sql.DataSource

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = ["classpath:spring-persist-mybatis.xml"])
class CrowdTest {

    @Autowired
    private lateinit var dataSource: DataSource

    @Autowired
    private lateinit var testMapper: TestMapper

    @Test
    fun testConnection() {
        println(dataSource)
        val test = TestRecord()
        test.id = "123"
        test.age = 1
        test.description = "test"
        test.name = "steven"
        testMapper.insert(test)
    }
}