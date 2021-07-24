package cc.stevenyin.crowd.service.impl

import cc.stevenyin.crowd.entity.TestRecord
import cc.stevenyin.crowd.mapper.TestMapper
import cc.stevenyin.crowd.mapper.insert
import cc.stevenyin.crowd.mapper.select
import cc.stevenyin.crowd.service.api.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestServiceImpl : TestService {
    @Autowired
    private lateinit var testMapper: TestMapper

    override fun saveTest(testRecord: TestRecord) = testMapper.insert(testRecord)

    override fun findAll() = testMapper.select { allRows() }
}