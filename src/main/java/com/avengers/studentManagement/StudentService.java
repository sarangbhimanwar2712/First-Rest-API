package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository ;
    public Student getStudent(int id){
        return studentRepository.getStudent(id) ;
    }

    public String addStudent(Student student){
        return studentRepository.addStudent(student) ;
    }

    public String updateStudent(int id,int age){
        return studentRepository.updateStudent(id,age) ;
    }

    public String deleteStudent(int id) {
        return studentRepository.deleteStudent(id) ;
    }
}
