package cc.stevenyin.crowd.mapper

import cc.stevenyin.crowd.entity.TestRecord
import cc.stevenyin.crowd.mapper.TestDynamicSqlSupport.Test
import cc.stevenyin.crowd.mapper.TestDynamicSqlSupport.Test.age
import cc.stevenyin.crowd.mapper.TestDynamicSqlSupport.Test.description
import cc.stevenyin.crowd.mapper.TestDynamicSqlSupport.Test.id
import cc.stevenyin.crowd.mapper.TestDynamicSqlSupport.Test.name
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun TestMapper.count(completer: CountCompleter) =
    countFrom(this::count, Test, completer)

fun TestMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Test, completer)

fun TestMapper.deleteByPrimaryKey(id_: String) =
    delete {
        where(id, isEqualTo(id_))
    }

fun TestMapper.insert(record: TestRecord) =
    insert(this::insert, record, Test) {
        map(id).toProperty("id")
        map(name).toProperty("name")
        map(age).toProperty("age")
        map(description).toProperty("description")
    }

fun TestMapper.insertMultiple(records: Collection<TestRecord>) =
    insertMultiple(this::insertMultiple, records, Test) {
        map(id).toProperty("id")
        map(name).toProperty("name")
        map(age).toProperty("age")
        map(description).toProperty("description")
    }

fun TestMapper.insertMultiple(vararg records: TestRecord) =
    insertMultiple(records.toList())

fun TestMapper.insertSelective(record: TestRecord) =
    insert(this::insert, record, Test) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(name).toPropertyWhenPresent("name", record::name)
        map(age).toPropertyWhenPresent("age", record::age)
        map(description).toPropertyWhenPresent("description", record::description)
    }

private val columnList = listOf(id, name, age, description)

fun TestMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Test, completer)

fun TestMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Test, completer)

fun TestMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Test, completer)

fun TestMapper.selectByPrimaryKey(id_: String) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun TestMapper.update(completer: UpdateCompleter) =
    update(this::update, Test, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: TestRecord) =
    apply {
        set(id).equalTo(record::id)
        set(name).equalTo(record::name)
        set(age).equalTo(record::age)
        set(description).equalTo(record::description)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: TestRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(name).equalToWhenPresent(record::name)
        set(age).equalToWhenPresent(record::age)
        set(description).equalToWhenPresent(record::description)
    }

fun TestMapper.updateByPrimaryKey(record: TestRecord) =
    update {
        set(name).equalTo(record::name)
        set(age).equalTo(record::age)
        set(description).equalTo(record::description)
        where(id, isEqualTo(record::id))
    }

fun TestMapper.updateByPrimaryKeySelective(record: TestRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(age).equalToWhenPresent(record::age)
        set(description).equalToWhenPresent(record::description)
        where(id, isEqualTo(record::id))
    }