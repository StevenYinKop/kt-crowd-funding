package cc.stevenyin.crowd.service.api

import cc.stevenyin.crowd.entity.TestRecord

interface TestService {
    fun saveTest(testRecord: TestRecord): Int
    fun findAll(): List<TestRecord>
}