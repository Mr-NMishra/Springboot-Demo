package com.mishra.cltr;

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
	
//	@RequestMapping("Student")
//	public Object showStudent() {
//		
//	}
}
