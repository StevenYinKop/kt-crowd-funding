package cc.stevenyin.crowd.exception

enum class ExceptionCode(val message: String, val code: Int) {

    LOGIN_INFO_ERROR("账号信息有误", 500),
    ACCOUNT_NOT_EXIST("账号不存在", 500),
    PWD_NOT_CORRECT("密码不正确", 500)

}