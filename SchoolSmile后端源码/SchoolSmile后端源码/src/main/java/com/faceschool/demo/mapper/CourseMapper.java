package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Course;
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
public interface CourseMapper extends BaseMapper<Course> {


    //, keyColumn = "cid"
    @Insert({"insert into course(cname,description,gradename,teacherid,classroom,createtime,starttime) " +
            "values(#{cname},#{description},#{gradename},#{teacherid},#{classroom},#{createtime, jdbcType=TIMESTAMP},#{starttime})"})
    @Options(useGeneratedKeys = true, keyProperty = "cid")
    int insertcourse(Course course);

    @Select({"select * from course where gradename = #{gradename}"})
    List<Course> getCourses(String gradename);

    @Select({"select * from course where teacherid = #{id}"})
    List<Course> getCourseByTeacherid(Integer id);
}
