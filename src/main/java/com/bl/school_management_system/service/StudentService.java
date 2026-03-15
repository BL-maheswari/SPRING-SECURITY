package com.bl.school_management_system.service;

import java.util.List;

import com.bl.school_management_system.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	void deleteStudent(Long id);
}
