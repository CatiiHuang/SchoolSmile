package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.*;
import com.faceschool.demo.mapper.CourseMapper;
import com.faceschool.demo.mapper.HomeworkMapper;
import com.faceschool.demo.mapper.StudentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-20
 */
@Api(value = "上传作业controller", tags = {"作业相关的接口"})
@RestController
@RequestMapping("/homework")
public class HomeworkController {


    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private CourseMapper courseMapper;


    @ApiOperation(value = "学生上传作业的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "作业照片", required = true, dataType = "MultipartFile", paramType = "query"),
            @ApiImplicitParam(name = "user", value = "学生学号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "上传作业的名字", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "courseid", value = "要上传到的课程id", required = true, dataType = "string", paramType = "query")
    })
    @PostMapping("/cteate")
    public JSONObject createhomework(@RequestParam("file") MultipartFile file, @RequestParam("user") String user,
                                     @RequestParam("name") String name, @RequestParam("courseid") String courseid){
        JSONObject jsonObject = new JSONObject();
        String fileName = file.getOriginalFilename();
        System.out.println(user);
        //获得文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String replaceAll = UUID.randomUUID().toString().replaceAll("-","")+suffixName;
        //设置保存路径
        String paths = "E:/schoolface/homework/" + replaceAll;
        System.out.println("保存路径:" + paths);
        File dest = new File(paths);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
       Homework homework = new Homework();
        homework.setName(name);
        homework.setCourseid(Integer.parseInt(courseid));
        homework.setUserid(studentMapper.selectByName(user).getId());
        homework.setUrl("/images/"+replaceAll);
        Date date = new Date();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        homework.setStarttime(d.format(date));
       Integer a = homeworkMapper.insert(homework);
       if (a!=0){
           jsonObject.put("result", "success");
       }else{
           jsonObject.put("result", "failed");
       }
        return jsonObject;
    }


    /**
     * 学生查看自己作业的列表
     * @param user
     * @return
     */
    @GetMapping("/getstudentwork")
    public JSONArray getstudentwork(@RequestParam("user") String user){
        Student student = studentMapper.selectByName(user);
        List<Homework> list = homeworkMapper.selectListByuserId(student.getId());
        Collections.reverse(list);
        List<HomeworkCourse> list1 = new ArrayList<>();
        for (Homework homework:list) {
            Course course = courseMapper.selectById(homework.getCourseid());
            list1.add(new HomeworkCourse(homework,course.getCname()));
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray = JSONArray.parseArray(JSON.toJSONString(list1));
        return jsonArray;
    }


    @ApiOperation(value = "教师得到作业的集合")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseid", value = "课程的id", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/gethomework")
    public JSONArray gethomework(@RequestParam("courseid") String courseid){
        JSONArray jsonArray = new JSONArray();
        List<Homework> list = homeworkMapper.selectListByCourseId(Integer.parseInt(courseid));
        List<HomeworkStudent> list1 = new ArrayList<>();
        for (Homework homework : list) {
            Student student = studentMapper.selectById(homework.getUserid());
            list1.add(new HomeworkStudent(homework,student));
        }
        jsonArray = JSONArray.parseArray(JSON.toJSONString(list1));
        return jsonArray;
    }


    /**
     *得到自己作业
     * @param homeworkid
     * @param studentid
     * @return
     */
    @GetMapping("/getwork")
    public JSONObject getwork(@RequestParam("homeworkid") String homeworkid, @RequestParam("studentid") String studentid){
        JSONObject jsonObject = new JSONObject();
        Homework homework = homeworkMapper.selectById(Integer.parseInt(homeworkid));
        Student student = studentMapper.selectById(Integer.parseInt(studentid));
        HomeworkStudent homeworkStudent = new HomeworkStudent(homework,student);
        jsonObject.put("result",homeworkStudent);
        return jsonObject;
    }


}

