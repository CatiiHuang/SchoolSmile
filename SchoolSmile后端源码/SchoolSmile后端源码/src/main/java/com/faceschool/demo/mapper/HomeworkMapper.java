package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Homework;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fyly
 * @since 2019-04-20
 */
@Repository
@Mapper
public interface HomeworkMapper extends BaseMapper<Homework> {

    @Select({"select * from homework where courseid = #{id}"})
    List<Homework> selectListByCourseId(Integer id);

    @Select({"select * from homework where userid = #{id}"})
    List<Homework> selectListByuserId(Integer id);
}
