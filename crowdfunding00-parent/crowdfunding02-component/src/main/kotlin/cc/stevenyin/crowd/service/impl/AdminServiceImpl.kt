package cc.stevenyin.crowd.service.impl

import cc.stevenyin.crowd.Constants.Companion.ADMIN_SESSION_KEY
import cc.stevenyin.crowd.entity.AdminRecord
import cc.stevenyin.crowd.exception.BusinessException
import cc.stevenyin.crowd.exception.ExceptionCode
import cc.stevenyin.crowd.mapper.*
import cc.stevenyin.crowd.service.api.AdminService
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.apache.commons.lang3.StringUtils
import org.mybatis.dynamic.sql.where.condition.IsEqualTo
import org.mybatis.dynamic.sql.where.condition.IsLike
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest

@Service
class AdminServiceImpl : AdminService {
    @Autowired
    private lateinit var adminMapper: AdminMapper

    @Autowired
    private lateinit var context: HttpServletRequest;

    override fun saveAdmin(adminRecord: AdminRecord) = adminMapper.insert(adminRecord)

    override fun findAll() = adminMapper.select { allRows() }
    override fun doLogin(adminRecord: AdminRecord) {
        val adminRecordInDB = checkPwd(adminRecord)
        storeSession(adminRecordInDB)
    }

    override fun getUser(keyword: String, pageNum: Integer, pageSize: Integer): PageInfo<AdminRecord> {
        PageHelper.startPage<AdminRecord>(pageNum.toInt(), pageSize.toInt())
        val adminList = if (StringUtils.isBlank(keyword)) findAll() else adminMapper.select {
                    where(AdminDynamicSqlSupport.Admin.email, IsLike.of { "%$keyword%" })
                    or(AdminDynamicSqlSupport.Admin.userName, IsLike.of { "%$keyword%" })
                    or(AdminDynamicSqlSupport.Admin.loginAcct, IsLike.of { "%$keyword%" })
                }
        val pageInfo = PageInfo(adminList)
        return pageInfo
    }

    private fun storeSession(adminRecord: AdminRecord) {
        val httpSession = context.session
        httpSession.setAttribute(ADMIN_SESSION_KEY, adminRecord)
    }

    private fun checkPwd(adminRecord: AdminRecord): AdminRecord {
        val loginAcct = adminRecord.loginAcct
        val userPswd = adminRecord.userPswd
        if (StringUtils.isAnyEmpty(loginAcct, userPswd))
            throw BusinessException(ExceptionCode.LOGIN_INFO_ERROR)
        val adminRecordInDB = adminMapper.selectOne {
            where(AdminDynamicSqlSupport.Admin.loginAcct, IsEqualTo.of { loginAcct })
        } ?: throw BusinessException(ExceptionCode.ACCOUNT_NOT_EXIST)
        if (!StringUtils.equals(adminRecordInDB.userPswd, userPswd)) {
            throw BusinessException(ExceptionCode.PWD_NOT_CORRECT)
        }
        return adminRecordInDB
    }
}