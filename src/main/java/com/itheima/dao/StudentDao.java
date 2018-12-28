package com.itheima.dao;

import com.itheima.domin.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAll();

    void addStudent(Student student);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    List<Student> findName(String name);

    List<String> findAllName();
}
