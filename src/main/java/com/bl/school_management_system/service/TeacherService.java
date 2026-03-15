package com.bl.school_management_system.service;

import java.util.List;

import com.bl.school_management_system.entity.Teacher;

public interface TeacherService {
	Teacher saveTeacher(Teacher teacher);

	List<Teacher> getAllTeachers();

	Teacher getTeacherById(Long id);

	void deleteTeacher(Long id);

}
