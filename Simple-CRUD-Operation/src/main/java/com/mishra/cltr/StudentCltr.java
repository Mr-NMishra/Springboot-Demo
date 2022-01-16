package com.mishra.cltr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entities.Student;
import com.mishra.service.StudentServiceImpl;

@Controller
public class StudentCltr {
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	private Student student;

	@RequestMapping("addStudent")
	public Object studentForm(@ModelAttribute("student") Student student) {
		Student studentSaved= studentServiceImpl.addStudent(student);
		System.out.println("Done---"+studentSaved);
		ModelAndView modelAndView= new ModelAndView("StudentDetails");
		modelAndView.addObject(student);
		return modelAndView;
	}
	
	@RequestMapping("CheckStudent")
	public Object checkStudent(@RequestParam("rno")String rno) {
		Student student=studentServiceImpl.findStudent(rno);
		if(student!=null) {
			ModelAndView view= new ModelAndView("StudentDetails");
			view.addObject(student);
			return view;
		}else {
			return "StudentNotFound";
		}
	}
	
	@RequestMapping("StudentList")
	public Object studentList() {
		List<Student> studentList= studentServiceImpl.studentList();
		//System.out.println(studentList);
			ModelAndView view= new ModelAndView("SavedStudents-Old");
			view.addObject("savedStudentList", studentList);
			//return view;
			return view;
	}
	
	@RequestMapping("deleteStudent")
	public Object deleteStudent(@RequestParam("id") String id) {
		Student student=studentServiceImpl.findStudent(id);
		if(student!=null) {
			studentServiceImpl.deleteStudent(id);
		}
		return "forward:StudentList";
	}
	
//	@RequestMapping("Student")
//	public Object showStudent() {
//		
//	}
}
