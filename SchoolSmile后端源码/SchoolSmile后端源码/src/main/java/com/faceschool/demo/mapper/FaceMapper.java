package com.faceschool.demo.mapper;

import com.faceschool.demo.entity.Face;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fyly
 * @since 2019-04-26
 */
@Repository
@Mapper
public interface FaceMapper extends BaseMapper<Face> {

    @Insert({"insert into face(name) values(#{name})"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int inserFace(Face face);
}
