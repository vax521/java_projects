package com.jack.mybatisplus_study1.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.jack.mybatisplus_study1.entity.Student;
import com.jack.mybatisplus_study1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jack
 * @since 2018-08-04
 */
@RestController
@RequestMapping("/student")
public class StudentController extends ApiController{

    @Autowired
    private IStudentService studentService;

    /**
     * 添加学生
     * @param student
     * @return
     */
    @PostMapping
    public boolean addStudent(@RequestBody Student student){
        /*JSONObject rs = new JSONObject();
        rs.put("result",studentService.insert(student));*/
        return studentService.insert(student);
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable("id") Integer id){
        boolean rs = studentService.deleteById(id);
        return rs;
    }

    /**
     * 修改学生
     * @param student
     * @return
     */
    @PutMapping
    public boolean updateStudent(@RequestBody Student student){
        boolean rs = studentService.updateById(student);
        return rs;
    }

    /**
     * 查找所有学生
     * @return
     */
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.selectList(null);
    }


    /**
     * 通过指定id查找学生
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Integer id){
        return studentService.selectById(id);
    }

    /**
     * 通过指定条件查询学生
     * @param name
     * @return
     */
    @GetMapping("/name/{name}")
    public List<Student> getSudentByName(@PathVariable("name") String name){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.eq("name",name);
        List<Student> rs = studentService.selectList(queryWrapper);
        return rs;
    }

}

