package com.tyning.springboot.manager;

import com.tyning.springboot.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author haining
 */
@Mapper
public interface PersonMapper {

    /**
     * 添加操作，返回新增元素的 ID
     *
     * @param personDO
     */
    @Insert("insert into person(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Person personDO);

    /**
     * 更新操作
     *
     * @param personDO
     * @return 受影响的行数
     */
    @Update("update person set name1=#{name},age=#{age} where id=#{id}")
    Long update(Person personDO);

    /**
     * 删除操作
     *
     * @param id
     * @return 受影响的行数
     */
    @Delete("delete from person where id=#{id}")
    Long delete(@Param("id") Long id);

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select id,name,age from person")
    List<Person> selectAll();

    /**
     * 根据主键查询单个
     *
     * @param id
     * @return
     */
    @Select("select * from person where id=#{id}")
    Person selectById(@Param("id") Long id);
}