package cc.stevenyin.crowd.service.api

import cc.stevenyin.crowd.entity.AdminRecord
import com.github.pagehelper.PageInfo

interface AdminService {
    fun saveAdmin(adminRecord: AdminRecord): Int
    fun findAll(): List<AdminRecord>
    fun doLogin(adminRecord: AdminRecord)
    fun getUser(keyword: String, pageNum: Integer, pageSize: Integer): PageInfo<AdminRecord>
}