package com.kiranacademy.onlineexam3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController 
{
	@RequestMapping("showlogin")
	public String showlogin()
	{
		return "login";
	}

	@RequestMapping("showregister")
	public String showregister()
	{
		return "register";
	}
}
