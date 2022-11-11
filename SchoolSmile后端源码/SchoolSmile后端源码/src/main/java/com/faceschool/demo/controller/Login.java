package com.faceschool.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.entity.Student;
import com.faceschool.demo.entity.Teacher;
import com.faceschool.demo.mapper.StudentMapper;
import com.faceschool.demo.mapper.TeacherMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Api(value = "登录的controller", tags = {"用户登录操作的接口"})
@Controller
public class Login {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/hello")
    public String index(){
        return "web";
    }


    @ApiOperation(value = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户名/学号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/login")
    @ResponseBody
    public JSONObject login(@RequestParam("user") String user, @RequestParam("password") String password){
        boolean exist = false;
        String identity = null;
        JSONObject jsonObject = new JSONObject();
        System.out.println(user);
        if (user.length() == 10){
            identity = "student";
            Student student = studentMapper.selectByName(user);
            if(student != null){
                if (password.equals(student.getPassword())){
                    exist = true;
                }else {
                    exist = false;
                }
            }
            jsonObject.put("identity",identity);
            jsonObject.put("exist",exist);
        }else {
            identity = "teacher";
            Teacher teacher = teacherMapper.selectByName(user);
            if(teacher != null) {
                if (password.equals(teacher.getTpassword())) {
                    exist = true;
                } else {
                    exist = false;
                }
            }
            jsonObject.put("identity",identity);
            jsonObject.put("exist",exist);
        }
        return jsonObject;
    }
}
