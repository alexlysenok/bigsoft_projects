package by.lesson11.web;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.lesson11.entity.User;

@Service
public class LoginValidator implements Validator {

	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {

		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "required.login", "Field login is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field password is required.");

		User user = (User) target;
		
		
		
	}
}
