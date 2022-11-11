package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.faceschool.demo.BaiduService.FaceAdd;
import com.faceschool.demo.BaiduService.FaceSearch;
import com.faceschool.demo.BaiduService.FaceVerify;
import com.faceschool.demo.BaiduUtils.GPSUtils;
import com.faceschool.demo.entity.*;
import com.faceschool.demo.mapper.*;
import com.google.gson.Gson;
import io.swagger.annotations.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-09
 */
@Api(value = "学生controller", tags = {"学生登录后获取签到课程的接口"})
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private SigninstuMapper signinstuMapper;
    @Autowired
    private SigninMapper signinMapper;
    @Autowired
    private CourselocationMapper courselocationMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private FaceMapper faceMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;


    @ApiOperation(value = "获取课程的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "学生学号", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/getcourse")
    public JSONArray getcourse(@RequestParam("user") String user){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Student student = studentMapper.selectByName(user);
        Integer gradeid = student.getGradeid();
        Grade grade = gradeMapper.selectById(gradeid);
        List<Course> list = courseMapper.getCourses(grade.getName());
        Collections.reverse(list);
        List<CourseTeacher> list1 = new ArrayList<>();
        for (Course course : list) {
            Teacher teacher = teacherMapper.selectById(course.getTeacherid());
            list1.add(new CourseTeacher(course,teacher.getTname()));
        }
        /*Course course = list.get(list.size()-1);
        jsonObject.put("course",course);*/
        jsonArray = JSONArray.parseArray(JSON.toJSONString(list1));
        return jsonArray;
    }

    @ApiOperation(value = "课程码接口")
    @ApiImplicitParam(name = "vertify", value = "课程码", required = true, dataType = "string", paramType = "query")
    @GetMapping("/courseverify")
    public JSONObject courseverify(@RequestParam("vertify") String verify){
        JSONObject jsonObject = new JSONObject();
        Signin signin = signinMapper.selectByVerify(Integer.parseInt(verify));
        if (signin != null){
            jsonObject.put("result","success");
            jsonObject.put("signinid",signin.getId());
        }else{
            jsonObject.put("result","failed");
            jsonObject.put("signinid",0);
        }
        return jsonObject;
    }


    @ApiOperation(value = "人脸比对接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "人脸验证照片", required = true, dataType = "string", paramType = "query")
    })
    @PostMapping("/faceschool")
    public JSONObject faceschool(@RequestParam("file") MultipartFile file){
        JSONObject jsonObject = new JSONObject();

        //将MultipartFile转换为File类型
        File f = FaceSearch.MultipartFileToFile(file);
        String json = FaceVerify.faceVerify(f);
        double face = FaceVerify.getResult(json);
        if (face == 1.0){
            //活体检验判断是为活体
            //调用百度的接口在人脸库中对比
            String result = (String) FaceSearch.search(f);
            Gson gson = new Gson();
            Map<String,Object> map = gson.fromJson(result,Map.class);
            Map<String,Object> map1 = (Map<String, Object>) map.get("result");
            List<Object> list = (List<Object>) map1.get("user_list");
            Map<String,Object> map2 = (Map<String, Object>) list.get(0);
            Double score = (Double) map2.get("score");
            //Integer score = Integer.parseInt((String) map2.get("score"));
            if(score >= 60.00){
                jsonObject.put("result","success");
                jsonObject.put("message","人脸识别成功");
            }else {
                jsonObject.put("result","filed");
                jsonObject.put("message","人脸识别失败");
            }
        }else {
            jsonObject.put("result","failed");
            jsonObject.put("message","活体检验失败!");
        }

        return jsonObject;
    }

    @ApiOperation(value = "最后人脸识别成功的点击签到")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signinid", value = "签到id", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/signin")
    public JSONObject signin(@RequestParam("signinid") String signinid){
        JSONObject jsonObject = new JSONObject();
        Signinstu signinstu = signinstuMapper.selectById(signinid);
        Signin signin = signinMapper.selectById(signinstu.getSigninid());
        List<Courselocation> list = courselocationMapper.selectByCid(signin.getCid());
        Courselocation courselocation = list.get(list.size()-1);
        Double clat = courselocation.getLatitude().doubleValue();
        Double clon = courselocation.getLongitude().doubleValue();
        Double slat = signinstu.getLatitude().doubleValue();
        Double slon = signinstu.getLongitude().doubleValue();

        double s = GPSUtils.getDistance(clat,clon,slat,slon);

        if (s <=50.00 ){
            signinstu.setSignin(1);
            signinstuMapper.updateById(signinstu);
           jsonObject.put("result", "success");
            System.out.println("----成功---------------------------------------" + s + "---------");
        }else{
            jsonObject.put("result", "falied");
            System.out.println("----失败-----------------------------------------" + s + "---------");
        }
       return jsonObject;
    }


    /**
     * 获取我的信息
     * @param user
     * @return
     */
    @GetMapping("/getone")
    public JSONObject getone(@RequestParam("user") String user){
        JSONObject jsonObject = new JSONObject();
        Student student = studentMapper.selectByName(user);
        Grade grade = gradeMapper.selectById(student.getGradeid());
        //提交作业的次数
        EntityWrapper<Homework> wrapper = new EntityWrapper<>();
        wrapper.eq("userid",student.getId());
        Integer count = homeworkMapper.selectCount(wrapper);
        //获得签到的次数
        EntityWrapper<Signinstu> wrapper1 = new EntityWrapper<>();
        wrapper1.eq("studentid",student.getId());
        Integer count1 = signinstuMapper.selectCount(wrapper1);
        //获得签到总次数
        Grade grade1 = gradeMapper.selectById(student.getGradeid());
        EntityWrapper<Course> wrapper2 = new EntityWrapper<>();
        wrapper2.eq("gradename",grade1.getName());
        Integer count2 = courseMapper.selectCount(wrapper2);
        Integer unsign = count2 - count1;
        jsonObject.put("grade",grade.getName());
        jsonObject.put("student",student);
        jsonObject.put("homeworkcount",count);
        jsonObject.put("signin",count1);
        jsonObject.put("unsignin",count2);
        return jsonObject;
    }

}

