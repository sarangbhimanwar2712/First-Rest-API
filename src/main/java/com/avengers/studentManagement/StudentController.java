package com.avengers.studentManagement;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    //adding the information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student) ;
        return new ResponseEntity<>(response, HttpStatus.FOUND) ;
    }

    //get information by admn no as primary key
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo){
        Student student = studentService.getStudent(admnNo) ;
        return new ResponseEntity<>(student,HttpStatus.FOUND) ;
    }

    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response = studentService.deleteStudent(id) ;
        if(response.equals("Invalid id")){
            return new ResponseEntity(response,HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(response,HttpStatus.FOUND) ;
    }

    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id , @RequestParam("age") int age){
        String reponse = studentService.updateStudent(id,age) ;
        if(reponse.equals("Invalid id")){
            return new ResponseEntity(reponse,HttpStatus.NOT_FOUND) ;
        }
        return new ResponseEntity(reponse,HttpStatus.ACCEPTED) ;
     }
}
