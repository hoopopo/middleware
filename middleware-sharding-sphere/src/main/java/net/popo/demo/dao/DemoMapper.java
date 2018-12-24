package net.popo.demo.dao;

import net.popo.demo.po.Demo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DemoMapper {
    @Delete({
        "delete from demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into demo (id, name, ",
        "mobile)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=BIGINT})"
    })
    int insert(Demo record);

    @InsertProvider(type=DemoSqlProvider.class, method="insertSelective")
    int insertSelective(Demo record);

    @Select({
        "select",
        "id, name, mobile",
        "from demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.BIGINT)
    })
    Demo selectByPrimaryKey(Long id);

    @UpdateProvider(type=DemoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Demo record);

    @Update({
        "update demo",
        "set name = #{name,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Demo record);
}