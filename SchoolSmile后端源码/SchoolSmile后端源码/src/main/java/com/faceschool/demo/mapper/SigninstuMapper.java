package com.faceschool.demo.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.faceschool.demo.entity.Signinstu;
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
public interface SigninstuMapper extends BaseMapper<Signinstu> {

    @Select({"select * from signinstu where signinid = #{id}"})
    List<Signinstu> selectBySigninId(Integer id);

    @Select({"select * from signinstu where studentid = #{id}"})
    List<Signinstu> selectByStudentId(Integer id);

    @Insert({"insert into signinstu(signinid,studentid,latitude,longitude,signin) values(#{signinid},#{studentid}," +
            "#{latitude},#{longitude},#{signin})"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSigninStu(Signinstu signinstu);
}
