package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.*;
import com.faceschool.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/homeworkcomment")
public class HomeworkcommentController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private HomeworkcommentMapper homeworkcommentMapper;

    /**
     * 老师创建回复
     * @param homworkid
     * @param user
     * @param content
     * @return
     */
    @GetMapping("/creat")
    public JSONObject create(@RequestParam("homeworkid") String homworkid, @RequestParam("user") String user,
                             @RequestParam("content") String content,@RequestParam("studentname") String studentname){
        System.out.println(homworkid);
        Homework homework = homeworkMapper.selectById(Integer.parseInt(homworkid));
        Teacher teacher = teacherMapper.selectByName(user);
        Course course = courseMapper.selectById(homework.getCourseid());
        Homeworkcomment homeworkcomment = new Homeworkcomment();
        homeworkcomment.setContent(content);
        homeworkcomment.setCoursename(course.getCname());
        homeworkcomment.setTeachername(teacher.getTname());
        homeworkcomment.setStudentname(studentname);
        homeworkcomment.setUrl(homework.getUrl());
        homeworkcomment.setUser(user);
        homeworkcomment.setName(homework.getName());
        homeworkcomment.setHomeworkid(Integer.parseInt(homworkid));
        Integer a = homeworkcommentMapper.insert(homeworkcomment);
        JSONObject jsonObject = new JSONObject();
        if(a != 0){
            jsonObject.put("result","success");
        }else{
            jsonObject.put("result","failed");
        }
        return jsonObject;
    }

    /**
     * 学生获取单个查看详细评论
     * @param homworkid
     * @return
     */
    @GetMapping("/getcomment")
    public JSONObject gethomeworkcomment(@RequestParam("homeworkid") String homworkid){
        JSONObject jsonObject = new JSONObject();
        Homework homework = homeworkMapper.selectById(Integer.parseInt(homworkid));
        try {
            Homeworkcomment homeworkcomment = homeworkcommentMapper.selectByHomeworkId(Integer.parseInt(homworkid));
            System.out.println(homeworkcomment.toString());
            jsonObject.put("result","success");
            jsonObject.put("homework",homework);
            jsonObject.put("homeworkcomment",homeworkcomment);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("result","failed");
            jsonObject.put("homework",homework);
            jsonObject.put("homeworkcomment",null);
        }
        return jsonObject;
    }
}

