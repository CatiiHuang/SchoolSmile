package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Homeworkcomment;
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
 * @since 2019-04-25
 */
@Repository
@Mapper
public interface HomeworkcommentMapper extends BaseMapper<Homeworkcomment> {

    @Select({"select * from homeworkcomment where homeworkid = #{id}"})
    Homeworkcomment selectByHomeworkId(Integer id);
}
