package com.itheima;

import com.itheima.dao.StudentDao;
import com.itheima.domin.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

    private StudentDao mapper;
    private InputStream is;
    SqlSession sqlSession;

    @Before
    public void init()throws IOException{
        is = Resources.getResourceAsStream("SqlConfigMap.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(StudentDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @org.junit.Test
    public void test() throws IOException {
        List<Student> all = mapper.findAll();
        for (Student student : all) {
            System.out.println(student);
        }
    }
    @org.junit.Test
    public void test2() throws IOException {
        Student student = new Student();
        student.setName("田七");
        student.setAddress("天津");
        mapper.addStudent(student);
        System.out.println(student);
        System.out.println("helloWorld");
    }
    @org.junit.Test
    public void test3() throws IOException {
        mapper.deleteStudent(15);
    }

    @org.junit.Test
    public void test4() throws IOException {
        Student student = new Student();
        student.setId(12);
        student.setName("九");
        student.setAddress("郑州");
        mapper.updateStudent(student);
    }
    @org.junit.Test
    public void test5() throws IOException {
        List<Student> name = mapper.findName("%李%");
        System.out.println(name);
    }
    @org.junit.Test
    public void test6() throws IOException {
        List<String> allName = mapper.findAllName();
        System.out.println(allName);
    }
}
