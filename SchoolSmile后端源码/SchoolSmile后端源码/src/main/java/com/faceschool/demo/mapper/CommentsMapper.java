package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Comments;
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
 * @since 2019-04-19
 */
@Repository
@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {

    @Select({"select * from comments where studentid = #{id}"})
    List<Comments> selectStudent(Integer id);

    @Select({"select * from comments where courseid = #{id}"})
    List<Comments> selectListByCourse(Integer id);

    @Select({"select * from comments"})
    List<Comments> selectAll();
}
