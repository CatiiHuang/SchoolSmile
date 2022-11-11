package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.Comments;
import com.faceschool.demo.entity.CommentsStudent;
import com.faceschool.demo.entity.Course;
import com.faceschool.demo.entity.Student;
import com.faceschool.demo.mapper.CommentsMapper;
import com.faceschool.demo.mapper.CourseMapper;
import com.faceschool.demo.mapper.StudentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-19
 */

/**
 * 学生创建评论类
 */
@Api(value = "评论类的controller", tags = {"评论类相关的接口"})
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private StudentMapper studentMapper;

    @ApiOperation(value = "学生创建课程评论的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "学生学号", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "courseid", value = "评论课程的id", required = false, dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "content", value = "课程评论", required = false, dataType = "string", paramType = "query")
    })
    @GetMapping("/create")
    public JSONObject createcomments(@RequestParam("user") String user, @RequestParam("courseid") String courseid,
                                     @RequestParam("contenet") String content){
        JSONObject jsonObject = new JSONObject();
        Comments comments = new Comments();
        Student student = studentMapper.selectByName(user);
        //Course course = courseMapper.selectById(courseid);
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comments.setStarttime(d.format(new Date()));
        comments.setContent(content);
        comments.setCourseid(Integer.parseInt(courseid));
        comments.setStudentid(student.getId());
        Integer a = commentsMapper.insert(comments);
        if (a != 0){
            jsonObject.put("result", "success");
        }else {
            jsonObject.put("result", "failed");
        }
        return jsonObject;
    }

    /**
     * 学生查看自己评论的接口
     * @param user
     * @return
     */
    @GetMapping("/getstudentcom")
    public JSONArray getstudentcom(@RequestParam("user") String user){
        Student student = studentMapper.selectByName(user);
        List<Comments> list = commentsMapper.selectStudent(student.getId());
        List<CommentsStudent> list1 = new ArrayList<>();
        for (Comments comments : list) {
           Student student1 = studentMapper.selectById(comments.getStudentid());
            Course course = courseMapper.selectById(comments.getCourseid());
            list1.add(new CommentsStudent(comments,student1,course.getCname()));
        }
        Collections.reverse(list1);
        JSONArray jsonArray = new JSONArray();
        jsonArray = JSONArray.parseArray(JSON.toJSONString(list1));
        return jsonArray;
    }

    @ApiOperation(value = "老师获取评论的接口")
    @ApiImplicitParam(name = "courseid", value = "课程id", required = true, dataType = "string", paramType = "query")
    @GetMapping("/getcomments")
    public JSONArray getcommens(@RequestParam("courseid") String courseid){
        //Course course = courseMapper.selectById(Integer.parseInt(courseid));
        JSONArray jsonArray = new JSONArray();
        List<Comments> list = commentsMapper.selectListByCourse(Integer.parseInt(courseid));
        List<CommentsStudent> list1 = new ArrayList<>();
        for (Comments comments : list) {
            Student student = studentMapper.selectById(comments.getStudentid());
            Course course = courseMapper.selectById(comments.getCourseid());
            list1.add(new CommentsStudent(comments,student,course.getCname()));
        }
        Collections.reverse(list1);
        jsonArray = JSONArray.parseArray(JSON.toJSONString(list1));

        return jsonArray;
    }

    public JSONArray getit(@RequestParam("courseid") String courseid){
        //List<Comments> list =
        return null;
    }


    /**
     * 获取单个评论后查看详情
     * @param id
     * @return
     */
    @GetMapping("/getcom")
    public JSONObject getcomment(@RequestParam("commentid") String id){
        JSONObject jsonObject = new JSONObject();
        Comments comments = commentsMapper.selectById(Integer.parseInt(id));
        Student student = studentMapper.selectById(comments.getStudentid());
        Course course = courseMapper.selectById(comments.getCourseid());
        jsonObject.put("studentname",student.getName());
        jsonObject.put("starttime",comments.getStarttime());
        jsonObject.put("coursename",course.getCname());
        jsonObject.put("comment",comments.getContent());
        return jsonObject;
    }
}

