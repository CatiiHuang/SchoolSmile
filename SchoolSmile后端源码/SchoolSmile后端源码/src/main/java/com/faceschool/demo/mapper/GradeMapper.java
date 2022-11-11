package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Grade;
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
public interface GradeMapper extends BaseMapper<Grade> {

    @Select({"select * from grade where name = #{name}"})
    Grade selectByGradename(String name);
}
