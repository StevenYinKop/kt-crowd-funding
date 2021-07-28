package cc.stevenyin.crowd.service.api

import cc.stevenyin.crowd.entity.AdminRecord

interface AdminService {
    fun saveAdmin(adminRecord: AdminRecord): Int
    fun findAll(): List<AdminRecord>
    fun doLogin(adminRecord: AdminRecord)
}