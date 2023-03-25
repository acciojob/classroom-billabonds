package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){

        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){

        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student,String  teacher){

        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public void removeTeacher(String teacher){

        studentRepository.removeTeacher(teacher);
    }

    public void removeAllTeacher(){

        studentRepository.removeAllTeacher();
    }

    public Student getStudentByName(String name){

        Student student = studentRepository.getStudentByName(name);
        return student;
    }

    public Teacher getTeacherByName(String name){

        Teacher teacher = studentRepository.getTeacherByName(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String teacher){

        List<String> list = studentRepository.getStudentsByTeacherName(teacher);
        return list;
    }

    public List<String> getAllStudents(){

        List<String> list = studentRepository.getAllStudents();
        return list;
    }
}
