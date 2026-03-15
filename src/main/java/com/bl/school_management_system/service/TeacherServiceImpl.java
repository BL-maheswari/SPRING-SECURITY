package com.bl.school_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.school_management_system.entity.Teacher;
import com.bl.school_management_system.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository repository;

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return repository.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return repository.findAll();
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void deleteTeacher(Long id) {
		repository.deleteById(id);
	}

}
