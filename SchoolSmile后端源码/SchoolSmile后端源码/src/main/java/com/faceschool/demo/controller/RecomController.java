package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.*;
import com.faceschool.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/recom")
public class RecomController {

    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private RecomMapper recomMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 教师创建反馈再反馈
     * @param commentid
     * @param user
     * @param teachercontent
     * @return
     */
    @GetMapping("/create")
    public JSONObject create(@RequestParam("commentid") String commentid, @RequestParam("user") String user,
                             @RequestParam("teachercontent") String teachercontent){
        Comments comments = commentsMapper.selectById(Integer.parseInt(commentid));
        Course course = courseMapper.selectById(comments.getCourseid());
        Teacher teacher = teacherMapper.selectByName(user);
        Student student = studentMapper.selectById(comments.getStudentid());
        Recom recom = new Recom();
        Date date = new Date();
        SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        recom.setStarttime(si.format(date));
        recom.setCoursename(course.getCname());
        recom.setStudentcontent(comments.getContent());
        recom.setStudentname(student.getName());
        recom.setTeachername(teacher.getTname());
        recom.setTeachercontent(teachercontent);
        recom.setCommentid(comments.getId());
        Integer a = recomMapper.insert(recom);
        JSONObject jsonObject = new JSONObject();
        if(a != 0){
            jsonObject.put("result","success");
        }else {
            jsonObject.put("result","failed");
        }
        return jsonObject;
    }


    /**
     * 学生获取单个评论
     * @param commentid
     * @return
     */
    @GetMapping("/getrecom")
    public JSONObject getrecom(@RequestParam("commentid") String commentid){
        JSONObject jsonObject = new JSONObject();
        Comments comments = commentsMapper.selectById(Integer.parseInt(commentid));
        CommentsStudent commentsStudent = new CommentsStudent(comments,studentMapper.selectById(comments.getStudentid()),
                courseMapper.selectById(comments.getCourseid()).getCname());
        try {
            Recom recom = recomMapper.selectByCommentid(Integer.parseInt(commentid));
            System.out.println("------------------" + recom.getId() + "==============");
            jsonObject.put("result","success");
            jsonObject.put("comment",commentsStudent);
            jsonObject.put("recom",recom);
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("result","failed");
            jsonObject.put("comment",commentsStudent);
            jsonObject.put("recom",null);
            return jsonObject;
        }
    }

}

