package cc.stevenyin.crowd.mapper

import org.mybatis.dynamic.sql.SqlTable
import java.sql.JDBCType

object AdminDynamicSqlSupport {
    object Admin : SqlTable("t_admin") {
        val id = column<Int>("id", JDBCType.INTEGER)

        val loginAcct = column<String>("login_acct", JDBCType.VARCHAR)

        val userPswd = column<String>("user_pswd", JDBCType.CHAR)

        val userName = column<String>("user_name", JDBCType.VARCHAR)

        val email = column<String>("email", JDBCType.VARCHAR)

        val createTime = column<String>("create_time", JDBCType.CHAR)
    }
}