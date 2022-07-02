package com.student.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.StudentEntity;
import com.student.service.IStudentService;

@RestController
public class StudentController {
	@Autowired
    IStudentService  studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello world";
	}

     @PostMapping("/student")
	Integer createStudent(@RequestBody StudentEntity student) {
 	Integer id = studentService.saveStudent(student);
 	System.out.println("Id..."+id);
 	return id;
		
	}
     
     @GetMapping("/allstudent")
 	public List<StudentEntity> getStudents(){
    	 return studentService.getAllStudents();
     }
     
     @GetMapping("/student/{id}")
     public Optional<StudentEntity> getStudent(@PathVariable Integer id){
    	 Optional<StudentEntity> student=  studentService.getStudent(id);
    	 return student;
     }
     
     @DeleteMapping("/deletestudent/{id}")
     public ResponseEntity<StudentEntity> deleteStudent(@PathVariable Integer id){
    	 ResponseEntity<StudentEntity> responseentity=new  ResponseEntity<>(HttpStatus.OK);
    	 
    	 try{
    		 studentService.deleteStudent(id);
    	 }catch(Exception e) {
    		 e.printStackTrace();
        	 responseentity=new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }
    	 return responseentity;
     }
     
     @PutMapping("/updatestudent/{id}")
     public ResponseEntity<StudentEntity> updateStudent(@PathVariable Integer id,@RequestBody StudentEntity student){
    	 ResponseEntity<StudentEntity> responseentity=new  ResponseEntity<>(HttpStatus.OK);
    	 
    	 try{
    		 studentService.updateStudent(student, id);
    	 }catch(Exception e) {
    		 e.printStackTrace();
        	 responseentity=new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    	 }
    	 return responseentity;
     }
}
