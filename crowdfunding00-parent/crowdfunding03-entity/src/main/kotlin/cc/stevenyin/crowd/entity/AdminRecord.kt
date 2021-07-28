package cc.stevenyin.crowd.entity

data class AdminRecord(
    var id: Int? = null,
    var loginAcct: String? = null,
    var userPswd: String? = null,
    var userName: String? = null,
    var email: String? = null,
    var createTime: String? = null
)