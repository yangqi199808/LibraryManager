package com.yangqi.test;

import com.yangqi.dao.StudentDAO;
import com.yangqi.model.StudentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestStudent {
    private StudentDAO studentDAO;

    @Resource
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    /**
     * 添加一条学生记录
     *
     * @throws Exception
     */
    @Test
    public void addStudent() throws Exception {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStuId("1618014058");
        studentEntity.setStuName("杨旗");
        studentEntity.setStuSex("男");
        studentEntity.setStuAge(21);
        studentEntity.setStuPro("计算机科学与技术");
        studentEntity.setStuGrade("2016");
        studentEntity.setStuIntegrity(1);

        studentDAO.save(studentEntity);
    }

    /**
     * 删除一条学生记录
     */
    @Test
    public void deleteStudent() {
        StudentEntity studentEntity = studentDAO.findByID("1618014058");
        studentDAO.delete(studentEntity);
    }

    /**
     * 查询所有的学生记录
     */
    @Test
    public void findAllStudent() {
        List<StudentEntity> studentEntityList = studentDAO.findAll();
        for (StudentEntity studentEntity : studentEntityList) {
            System.out.println(studentEntity);
        }
    }
}
