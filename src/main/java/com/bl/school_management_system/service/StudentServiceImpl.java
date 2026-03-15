package com.bl.school_management_system.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.school_management_system.entity.Student;
import com.bl.school_management_system.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	    @Autowired
	    private StudentRepository repository;

	    @Override
	    public Student saveStudent(Student student) {
	        return repository.save(student);
	    }

	    @Override
	    public List<Student> getAllStudents() {
	        return repository.findAll();
	    }

	    @Override
	    public Student getStudentById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    @Override
	    public void deleteStudent(Long id) {
	        repository.deleteById(id);
	    }
	}


