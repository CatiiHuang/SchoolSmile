package com.faceschool.demo.service.impl;

import com.faceschool.demo.entity.Course;
import com.faceschool.demo.mapper.CourseMapper;
import com.faceschool.demo.service.ICourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fyly
 * @since 2019-04-09
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
