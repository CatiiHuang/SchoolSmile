package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Signin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
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
public interface SigninMapper extends BaseMapper<Signin> {

    @Select({"select * from signin where verify = #{verify}"})
    Signin selectByVerify(Integer verify);

    @Select({"select * from signin where cid = #{id}"})
    List<Signin> selectListByCourseId(Integer id);
}
