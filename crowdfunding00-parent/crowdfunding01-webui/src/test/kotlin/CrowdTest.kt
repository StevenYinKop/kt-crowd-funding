
import cc.stevenyin.crowd.entity.AdminRecord
import cc.stevenyin.crowd.mapper.AdminMapper
import cc.stevenyin.crowd.mapper.insertMultiple
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = arrayOf("classpath:spring-persist-mybatis.xml"))
class CrowdTest {
	@Autowired
	private lateinit var adminMapper: AdminMapper

	@Test
	fun insertBatch() {
		val currentTimeMillis = System.currentTimeMillis()
		val arrayList = ArrayList<AdminRecord>()
		for (i in 0..100) {
			arrayList.add(AdminRecord(null, "loginAcct$i", "pass$i", "userName$i", "steven.yin$i@kpmg.com", currentTimeMillis.toString() ))
		}
		adminMapper.insertMultiple(arrayList)
	}

}