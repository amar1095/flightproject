package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.StudentEntity;

public interface IStudentService {
	
	Integer saveStudent(StudentEntity student);
	
	public List<StudentEntity> getAllStudents();
	
	Optional<StudentEntity> getStudent(Integer id);
	
	public void deleteStudent(Integer id);

	Integer updateStudent(StudentEntity student, Integer id);

}
