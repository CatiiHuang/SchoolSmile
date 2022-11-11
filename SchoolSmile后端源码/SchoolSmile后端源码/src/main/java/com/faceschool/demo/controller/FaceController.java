package com.faceschool.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.faceschool.demo.BaiduService.FaceAdd;
import com.faceschool.demo.entity.Face;
import com.faceschool.demo.entity.Student;
import com.faceschool.demo.mapper.FaceMapper;
import com.faceschool.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fyly
 * @since 2019-04-26
 */
@RestController
@RequestMapping("/face")
public class FaceController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private FaceMapper faceMapper;

    /**
     * 学生注册
     * @param name
     * @param snumber
     * @param password
     * @param gradeid
     * @param
     * @return
     */
    @PostMapping("/add")
    public JSONObject addstudent(@RequestParam("name") String name, @RequestParam("snumber") String snumber,
                                 @RequestParam("password") String password, @RequestParam("gradeid") String gradeid,
                                 @RequestParam("file") MultipartFile file1){
        JSONObject jsonObject = new JSONObject();
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        student.setSnumber(snumber);
        student.setGradeid(Integer.parseInt(gradeid));
        studentMapper.insertStudent(student);
        File file = FaceAdd.MultipartFileToFile(file1);
        Face face = new Face();
        face.setName(name);
        faceMapper.inserFace(face);
        FaceAdd.add(file,face.getId(),face.getName());
        jsonObject.put("result","success");
        return jsonObject;
    }

}

