package cc.stevenyin.crowd.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object TestDynamicSqlSupport {
    object Test : SqlTable("test") {
        val id = column<String>("id", JDBCType.VARCHAR)

        val name = column<String>("name", JDBCType.VARCHAR)

        val age = column<Int>("age", JDBCType.INTEGER)

        val description = column<String>("description", JDBCType.VARCHAR)
    }
}