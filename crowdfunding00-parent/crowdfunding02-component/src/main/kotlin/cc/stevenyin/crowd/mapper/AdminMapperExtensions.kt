package cc.stevenyin.crowd.mapper

import cc.stevenyin.crowd.entity.AdminRecord
import cc.stevenyin.crowd.mapper.AdminDynamicSqlSupport.Admin
import cc.stevenyin.crowd.mapper.AdminDynamicSqlSupport.Admin.createTime
import cc.stevenyin.crowd.mapper.AdminDynamicSqlSupport.Admin.email
import cc.stevenyin.crowd.mapper.AdminDynamicSqlSupport.Admin.id
import cc.stevenyin.crowd.mapper.AdminDynamicSqlSupport.Admin.loginAcct
import cc.stevenyin.crowd.mapper.AdminDynamicSqlSupport.Admin.userName
import cc.stevenyin.crowd.mapper.AdminDynamicSqlSupport.Admin.userPswd
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun AdminMapper.count(completer: CountCompleter) =
    countFrom(this::count, Admin, completer)

fun AdminMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Admin, completer)

fun AdminMapper.deleteByPrimaryKey(id_: Int) =
    delete {
        where(id, isEqualTo(id_))
    }

fun AdminMapper.insert(record: AdminRecord) =
    insert(this::insert, record, Admin) {
        map(id).toProperty("id")
        map(loginAcct).toProperty("loginAcct")
        map(userPswd).toProperty("userPswd")
        map(userName).toProperty("userName")
        map(email).toProperty("email")
        map(createTime).toProperty("createTime")
    }

fun AdminMapper.insertMultiple(records: Collection<AdminRecord>) =
    insertMultiple(this::insertMultiple, records, Admin) {
        map(id).toProperty("id")
        map(loginAcct).toProperty("loginAcct")
        map(userPswd).toProperty("userPswd")
        map(userName).toProperty("userName")
        map(email).toProperty("email")
        map(createTime).toProperty("createTime")
    }

fun AdminMapper.insertMultiple(vararg records: AdminRecord) =
    insertMultiple(records.toList())

fun AdminMapper.insertSelective(record: AdminRecord) =
    insert(this::insert, record, Admin) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(loginAcct).toPropertyWhenPresent("loginAcct", record::loginAcct)
        map(userPswd).toPropertyWhenPresent("userPswd", record::userPswd)
        map(userName).toPropertyWhenPresent("userName", record::userName)
        map(email).toPropertyWhenPresent("email", record::email)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
    }

private val columnList = listOf(id, loginAcct, userPswd, userName, email, createTime)

fun AdminMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Admin, completer)

fun AdminMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Admin, completer)

fun AdminMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Admin, completer)

fun AdminMapper.selectByPrimaryKey(id_: Int) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun AdminMapper.update(completer: UpdateCompleter) =
    update(this::update, Admin, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: AdminRecord) =
    apply {
        set(id).equalTo(record::id)
        set(loginAcct).equalTo(record::loginAcct)
        set(userPswd).equalTo(record::userPswd)
        set(userName).equalTo(record::userName)
        set(email).equalTo(record::email)
        set(createTime).equalTo(record::createTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: AdminRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(loginAcct).equalToWhenPresent(record::loginAcct)
        set(userPswd).equalToWhenPresent(record::userPswd)
        set(userName).equalToWhenPresent(record::userName)
        set(email).equalToWhenPresent(record::email)
        set(createTime).equalToWhenPresent(record::createTime)
    }

fun AdminMapper.updateByPrimaryKey(record: AdminRecord) =
    update {
        set(loginAcct).equalTo(record::loginAcct)
        set(userPswd).equalTo(record::userPswd)
        set(userName).equalTo(record::userName)
        set(email).equalTo(record::email)
        set(createTime).equalTo(record::createTime)
        where(id, isEqualTo(record::id))
    }

fun AdminMapper.updateByPrimaryKeySelective(record: AdminRecord) =
    update {
        set(loginAcct).equalToWhenPresent(record::loginAcct)
        set(userPswd).equalToWhenPresent(record::userPswd)
        set(userName).equalToWhenPresent(record::userName)
        set(email).equalToWhenPresent(record::email)
        set(createTime).equalToWhenPresent(record::createTime)
        where(id, isEqualTo(record::id))
    }