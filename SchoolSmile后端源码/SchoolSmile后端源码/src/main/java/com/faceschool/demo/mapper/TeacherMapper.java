package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Teacher;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select({"select * from teacher where tnumber = #{name}"})
    Teacher selectByName(String name);

}
