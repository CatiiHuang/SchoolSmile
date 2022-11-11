package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Courselocation;
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
 * @since 2019-04-14
 */
@Repository
@Mapper
public interface CourselocationMapper extends BaseMapper<Courselocation> {

    @Select({"select * from courselocation where courseid = #{id}"})
    List<Courselocation> selectByCid(Integer id);
}
