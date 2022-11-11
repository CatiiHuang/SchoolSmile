package com.faceschool.demo.service.impl;

import com.faceschool.demo.entity.Face;
import com.faceschool.demo.mapper.FaceMapper;
import com.faceschool.demo.service.IFaceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fyly
 * @since 2019-04-26
 */
@Service
public class FaceServiceImpl extends ServiceImpl<FaceMapper, Face> implements IFaceService {

}
