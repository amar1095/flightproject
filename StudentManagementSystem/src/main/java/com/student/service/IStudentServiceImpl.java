package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.Exception.ResourceNotFoundException;
import com.student.entity.StudentEntity;

@Service
public class IStudentServiceImpl implements IStudentService {
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Integer saveStudent(StudentEntity student) {
		StudentEntity saveStudent=studentRepository.save(student);
        return saveStudent.getId();
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	} 
	@Override
    public Optional<StudentEntity> getStudent( Integer id){
		return studentRepository.findById(id);

    }
    @Override
    public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);

    }
    
    public  Integer  updateStudent(StudentEntity student, Integer id) {
    	StudentEntity  exitstudent=studentRepository.findById(id).orElseThrow(()->
    	new ResourceNotFoundException("Employee","id",id));
    	exitstudent.setFirstName(student.getFirstName());
    	exitstudent.setLastName(student.getLastName());
    	studentRepository.save(exitstudent);
    	return exitstudent.getId();
    	
    			
    }


}
