package com.sprinboot.web.springdemo.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validate(String name,String password )
	{
		if(name.equals("sharif") && password.equals("sharifteli"))
		{
			return true;
		}
		return false;
	}
}
