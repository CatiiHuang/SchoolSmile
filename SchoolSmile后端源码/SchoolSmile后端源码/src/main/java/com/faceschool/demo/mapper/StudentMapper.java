package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Student;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fyly
 * @since 2019-04-09
 */
@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Insert({"insert into student(name,snumber,password,gradeid) values(#{name},#{snumber},#{password},#{gradeid})"})
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertStudent(Student student);

    @Select({" select * from student where snumber = #{name}"})
    Student selectByName(String name);

    @Select({"select * from student where gradeid = #{id}"})
    List<Student> selectListByGrade(Integer id);
}
