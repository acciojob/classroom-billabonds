package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb = new HashMap<>();

    HashMap<String,Teacher> teacherDb = new HashMap<>();

    HashMap<String,List<String>> studentTeacherPair = new HashMap<>();

    public void addStudent(Student student){

        String key = student.getName();
        studentDb.put(key,student);
        return ;
    }

    public void addTeacher(Teacher teacher){

        String key = teacher.getName();
        teacherDb.put(key,teacher);
        return ;
    }

    public void addStudentTeacherPair(String student,String teacher){

        List<String> list = studentTeacherPair.get(teacher);

        if(list == null){
                list = new ArrayList<>();
        }

        list.add(student);
        studentTeacherPair.put(teacher,list);

    }

    public void removeTeacher(String teacher){

        for(String st : studentTeacherPair.get(teacher)){
            studentDb.remove(st);
        }

        studentTeacherPair.remove(teacher);
        teacherDb.remove(teacher);
    }

    public void removeAllTeacher(){

        for(String teacher : teacherDb.keySet())
        {
            for(String st : studentTeacherPair.get(teacher)){
                studentDb.remove(st);
            }

            studentTeacherPair.remove(teacher);
            teacherDb.remove(teacher);
        }
    }

    public Student getStudentByName(String name){

        return studentDb.get(name);
    }

    public Teacher getTeacherByName(String name){

        return teacherDb.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){

        return studentTeacherPair.get(teacher);
    }

    public List<String> getAllStudents(){

        List<String> list = new ArrayList<>();

        for(String st : studentDb.keySet()){
            list.add(st);
        }

        return list;
    }

}
