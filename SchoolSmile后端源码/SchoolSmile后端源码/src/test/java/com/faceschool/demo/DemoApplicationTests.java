package com.faceschool.demo;


import com.faceschool.demo.BaiduService.FaceSearch;
import com.faceschool.demo.BaiduService.FaceVerify;
import com.faceschool.demo.entity.Course;
import com.faceschool.demo.entity.Face;
import com.faceschool.demo.entity.Student;
import com.faceschool.demo.entity.Teacher;
import com.faceschool.demo.mapper.CourseMapper;
import com.faceschool.demo.mapper.FaceMapper;
import com.faceschool.demo.mapper.StudentMapper;
import com.faceschool.demo.mapper.TeacherMapper;
import com.faceschool.demo.service.impl.StudentServiceImpl;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;
import java.io.File;
import java.util.*;

import static java.util.stream.Collectors.toList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private FaceMapper faceMapper;

    /*@Test
    public void contextLoads() {
         Student s = new Student();
         s.setId(1);
         s.setName("刘君");
         s.setSnumber("2017211435");
         s.setPassword("123456");
         //boolean a = studentService.insert(s);
        Integer a = studentMapper.insert(s);
        System.out.println(a);
    }*/

    /*@Test
    public void testaddT(){
        Teacher teacher = new Teacher();
        teacher.setTid(1);
        teacher.setTname("向珂熠");
        teacher.setTnumber("2017211");
        teacher.setTpassword("123456");
        Integer a = teacherMapper.insert(teacher);
        System.out.println(a);
    }*/

   // @Test
    public void testSelect(){
        Student student = studentMapper.selectByName("2017211435");
        System.out.println(student.toString());
    }

    //@Test
    public void testgetcourselist(){
        String name = "1";
        List<Course> list = courseMapper.getCourses(name);
        Integer a = list.size()-1;
        System.out.println(list.get(a).toString());
    }


    //@Test
    public void testfacesearch(){
        FaceSearch faceSearch = new FaceSearch();
        //String result = faceSearch.search();
        String result = null;
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();
        map = gson.fromJson(result,Map.class);
        Map<String,Object> map1 = (Map<String, Object>) map.get("result");
        List<Object> list = (List<Object>) map1.get("user_list");
        Map<String,Object> map2 = (Map<String, Object>) list.get(0);
        //Map<String,Object> map2 = (Map<String, Object>) map1.get("user_list");

        System.out.println(map2.get("score"));
        /*List<Object> list = (List<Object>) map.get("result");
        Map<String,Object> map1 = (Map<String, Object>) list.get(1);
        System.out.println(map1.get("score"));*/
    }

    //@Test
   /* public void test(){
        List list = new ArrayList(Arrays.asList(1,2,3));
        Collections.reverse(list);
        System.out.println(list.get(0));
    }*/

    //@Test
  /*  public void testtime(){
        Date date = new Date();
        System.out.println(date);
    }*/

   /* @Test
    public void teainserid(){
        Course course = new Course();
        course.setCname("疾风剑豪");
        Integer a = courseMapper.insertcourse(course);
        System.out.println(course.getCid());
    }*/

   /*@Test
   public void testaddFace(){
       Face face = new Face();
       face.setName("刘君");
       faceMapper.inserFace(face);
       System.out.println(face.getId());
   }*/

   /*@Test
   public void teatadd(){
       Student stu = new Student();
       stu.setName("何箐桢");
       Integer a = studentMapper.insert(stu);
       System.out.println(a);
   }*/

   @Test
   public void testFace(){
       File file = new File("F:/facephoto/yxh.jpg");
       String result = FaceVerify.faceVerify(file);
       System.out.println(FaceVerify.getResult(result));
   }
}
