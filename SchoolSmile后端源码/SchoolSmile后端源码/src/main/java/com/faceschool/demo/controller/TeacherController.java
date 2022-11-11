package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.*;
import com.faceschool.demo.mapper.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-09
 */
@Api(value = "教师controller", tags = {"教师的系列接口"})
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SigninMapper signinMapper;
    @Autowired
    private SigninstuMapper signinstuMapper;
    @Autowired
    private GradeMapper gradeMapper;

    @ApiOperation(value = "教师创建课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "教师工号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "kc_names", value = "课程名称", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "people_room", value = "签到教室", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "bj_nums", value = "班级编号", required = false, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "miaoshu", value = "课程描述", required = false, dataType = "string", paramType = "query")
    })
    @GetMapping("/createCourse")
    public JSONObject createCourse(@RequestParam("user") String user,@RequestParam("kc_names") String cname,
                                   @RequestParam("people_room") String room,@RequestParam("bj_nums") String gradeid,
                                   @RequestParam("miaoshu") String describe){
        JSONObject jsonObject = new JSONObject();
        boolean result = true;
        Teacher teacher = teacherMapper.selectByName(user);
        Course course = new Course();
        course.setCname(cname);
        course.setClassroom(room);
        course.setGradename(gradeid);
        course.setDescription(describe);
        course.setCreatetime(new Date());
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        course.setStarttime(d.format(new Date()));
        course.setTeacherid(teacher.getTid());
        Integer a = courseMapper.insertcourse(course);
        System.out.println("课程id---------------" + course.getCid() + "-----------------------------------------");
        if(a != 0) {
            result = true;
        }else {
            result = false;
        }
        jsonObject.put("courseid",course.getCid());
        jsonObject.put("result",result);
        return jsonObject;
    }


    @ApiOperation(value = "教师获取课程列表的接口")
    @ApiImplicitParam(name = "user", value = "教师的工号", required = true, dataType = "string", paramType = "query")
    @GetMapping("/getcourse")
    public JSONArray getCourse(@RequestParam("user") String user){
        JSONArray jsonArray = new JSONArray();
        Teacher teacher = teacherMapper.selectByName(user);
        List<Course> list = courseMapper.getCourseByTeacherid(teacher.getTid());
        List<SigninCourse> list1 = new ArrayList<>();
        //倒序列表
        Collections.reverse(list);
        for (Course course : list) {
             Integer a = getVerify(course.getCid());
             if (a == 0){
                 list1.add(new SigninCourse(course,0));
             }else {
                 list1.add(new SigninCourse(course,a));
             }
        }
        jsonArray = JSONArray.parseArray(JSON.toJSONString(list1));
        return jsonArray;
    }

    public Integer getVerify(Integer id){
        List<Signin> list = signinMapper.selectListByCourseId(id);
        if(list.size() == 0){
            return 0;
        }else {
            Signin signin = list.get(list.size()-1);
            return signin.getVerify();
        }
    }


    @ApiOperation("获取签到结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "verify", value = "课程码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "gradename", value = "班级代号", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/getlist")
    public JSONObject getList(@RequestParam("verify") String verify, @RequestParam("gradename") String gradename){
        System.out.println(verify);
        Signin signin = signinMapper.selectByVerify(Integer.parseInt(verify));
        Integer id = signin.getId();
        List<Qstudent> lis = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        //获得签到了的学生List
        List<Signinstu> list = signinstuMapper.selectBySigninId(id);
        for (Signinstu signinstu : list) {
            if (signinstu.getSignin() != 0){
                studentList.add(studentMapper.selectById(signinstu.getStudentid()));
                lis.add(new Qstudent(studentMapper.selectById(signinstu.getStudentid()),true));
            }
        }
        System.out.println("---前---------"+lis.size()+"-----------------");
        Integer a = 0;
        if(lis.size() == 0){
            //没有签到的情况
            a = 0;
        }else {
            //得到签到了的学生的人数
            a = lis.size();
        }
        //获得马上需要签到的班级
        Grade grade = gradeMapper.selectByGradename(gradename);
        System.out.println(grade.getName());
        //通过班级id来查找一个班级中的学生
        List<Student> studentList1 = studentMapper.selectListByGrade(grade.getId());
        System.out.println("------班级中学生总数----"+studentList1.size()+"-----------");
        //取两个List中的差集
        //List<Student> studentList2 = studentList1.stream().filter(item -> !studentList.contains(item)).collect(toList());
        List<Student> studentList2 = studentList1.stream().filter(item -> !studentList.contains(item)).collect(toList());
        System.out.println("------学生与签到学生差集集合----"+studentList2.size()+"-----------");
        for (Student student : studentList2) {
            System.out.println(student.toString());
            System.out.println("马上加入list中");
            lis.add(new Qstudent(student,false));
        }

        for (Qstudent qstudent : lis) {
            System.out.println(qstudent);
        }
        System.out.println("---后---------"+lis.size()+"-----------------");
        //System.out.println(lis.get(0).toString());
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(lis));
        /*jsonArray.add(lis.size(),a);
        jsonArray.add(lis.size()+1,lis.size()-a);*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("jsonarray",jsonArray);
        jsonObject.put("signin",a);
        System.out.println("签到" + a);
        jsonObject.put("unsignin",lis.size()-a);
        return jsonObject;
    }


    /**
     *
     * @param user
     * @return
     */
    @GetMapping("/getone")
    public JSONObject getone(@RequestParam("user") String user){
        JSONObject jsonObject = new JSONObject();
        Teacher teacher = teacherMapper.selectByName(user);
        jsonObject.put("teacher",teacher);
        return jsonObject;
    }


    @GetMapping("/add")
    public JSONObject add(@RequestParam("tnumber") String tnumber, @RequestParam("tname") String tname,
                          @RequestParam("tpassword") String tpassword){
        JSONObject jsonObject = new JSONObject();
        Teacher teacher = new Teacher();
        teacher.setTname(tname);
        teacher.setTpassword(tpassword);
        teacher.setTnumber(tnumber);
        Integer a = teacherMapper.insert(teacher);
        if(a != 0){
            jsonObject.put("result","success");
        }else {
            jsonObject.put("result","failed");
        }
        return jsonObject;
    }
}

