package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Recom;
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
public interface RecomMapper extends BaseMapper<Recom> {

    @Select({"select * from recom where commentid = #{id}"})
    Recom selectByCommentid(Integer id);
}
