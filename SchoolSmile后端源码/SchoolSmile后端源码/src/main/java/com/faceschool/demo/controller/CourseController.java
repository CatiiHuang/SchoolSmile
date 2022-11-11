package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.faceschool.demo.entity.*;
import com.faceschool.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-09
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SigninstuMapper signinstuMapper;
    @Autowired
    private SigninMapper signinMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 学生查看自己的签到结果
     * @param user
     * @return
     */
    @GetMapping("/getsignin")
    public JSONArray getsignin(@RequestParam("user") String user){
        Student student = studentMapper.selectByName(user);
        List<Signinstu> list = signinstuMapper.selectByStudentId(student.getId());
        List<Signin> list1 = new ArrayList<>();
        for (Signinstu signinstu : list) {
            Signin signin = signinMapper.selectById(signinstu.getSigninid());
            list1.add(signin);
        }
        //为学生签到课程的List
        List<Course> list2 = new ArrayList<>();
        for (Signin signin : list1) {
            Course course = courseMapper.selectById(signin.getCid());
            list2.add(course);
        }

        System.out.println("学生签到的课程++++++" + list2.size());
        System.out.println(list2.get(0).toString());
        Grade grade = gradeMapper.selectById(student.getGradeid());
        //得到学生拥有的课程
        List<Course> courseList = courseMapper.getCourses(grade.getName());
        System.out.println("学生拥有的课程++++++" + courseList.size());

        //取差集得到未签到课程
        List<Course> signinlist = courseList.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("两个List的差集+++++++" + signinlist.size());
       // System.out.println(signinlist.get(0).toString());
        List<Courseis> list3 = new ArrayList<>();
        for (Course course : list2) {
            list3.add(new Courseis(course,true, teacherMapper.selectById(course.getTeacherid()).getTname()));
        }
        for (Course course : signinlist) {
            list3.add(new Courseis(course,false,teacherMapper.selectById(course.getTeacherid()).getTname()));
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray = JSONArray.parseArray(JSON.toJSONString(list3));
        return jsonArray;
    }
}

