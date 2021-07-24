package cc.stevenyin.crowd

import cc.stevenyin.crowd.entity.TestRecord
import cc.stevenyin.crowd.mapper.TestMapper
import cc.stevenyin.crowd.mapper.insert
import cc.stevenyin.crowd.service.api.TestService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*
import javax.sql.DataSource

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = ["classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"])
class CrowdTest {

    @Autowired
    private lateinit var dataSource: DataSource

    @Autowired
    private lateinit var testMapper: TestMapper

    @Autowired
    private lateinit var testService: TestService

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

    @Test
    fun testTx() {
        val test = TestRecord()
        test.id = UUID.randomUUID().toString()
        test.age = 1
        test.description = "test"
        test.name = "carina"
        testService.saveTest(test)
    }
}