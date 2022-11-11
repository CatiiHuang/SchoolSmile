package com.faceschool.demo.service.impl;

import com.faceschool.demo.entity.Student;
import com.faceschool.demo.mapper.StudentMapper;
import com.faceschool.demo.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fyly
 * @since 2019-04-09
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    StudentMapper mapper;



}
