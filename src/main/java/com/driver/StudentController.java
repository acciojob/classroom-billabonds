package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")                                                    // 1st API - done
    public ResponseEntity<String> addStudent(@RequestBody Student student){

        studentService.addStudent(student);
        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-teacher")                                                    // 2nd API - done
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){

        studentService.addTeacher(teacher);
        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair")                                         // 3rd API - done
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){

        studentService.addStudentTeacherPair(student,teacher);
        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by-name/{name}")                                       // 4th API - Done
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
//        Student student = null; // Assign student by calling service layer method

        Student student = studentService.getStudentByName(name);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-by-name/{name}")                                        // 5th API - Done
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
//        Teacher teacher = null; // Assign student by calling service layer method

         Teacher teacher = studentService.getTeacherByName(name);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")                              // 6th API - Done
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
//        List<String> students = null; // Assign list of student by calling service layer method

        List<String> list = studentService.getStudentsByTeacherName(teacher);

        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students")                                                    // 7th API - Done
    public ResponseEntity<List<String>> getAllStudents(){
//        List<String> students = null; // Assign list of student by calling service layer method

        List<String> list = studentService.getAllStudents();
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-teacher-by-name")                                           // 8th API - done
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){

        studentService.removeTeacher(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-teachers")                                             // 9th API - done
    public ResponseEntity<String> deleteAllTeachers(){

        studentService.removeAllTeacher();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }
}
