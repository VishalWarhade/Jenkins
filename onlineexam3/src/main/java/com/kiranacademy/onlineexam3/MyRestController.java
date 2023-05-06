package com.kiranacademy.onlineexam3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	//REST - object's state
	// state transfer
	
	@RequestMapping("getStudent")
	public Student getStudent()
	{
		Student student=new Student();
		student.rno=1;
		student.marks=100;
		
		return student; // {"rno":1,"marks":100}
	}

}
