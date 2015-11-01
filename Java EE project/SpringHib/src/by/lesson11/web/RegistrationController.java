package by.lesson11.web;

import java.util.ArrayList;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.lesson11.dal.BookDao;
import by.lesson11.dal.CrudDao;
import by.lesson11.entity.User;
import by.lesson11.exception.DalException;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationValidator registrationValidator;

	private List<User> users = new ArrayList<User>();
	@Autowired
	private BookDao bookDao;

	@RequestMapping("/registration/check")
	public String login(@ModelAttribute User user, BindingResult result, Model model,Errors errors) {
		String error="Such login already exists";
		String success="Registration success. Log in now.";
		
		
		registrationValidator.validate(user, result);

		if (result.hasErrors()) {
			return "registration";
		}
		
		try {
			users = bookDao.list(User.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    boolean match=checkLogin(user);
	    if(!match){
	    	model.addAttribute("success", success);
	    	
	    	try {
		    	 
	    		bookDao.merge(user);
			} catch (DalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	return "login";
	    	}		
	    else if(match){
	    	model.addAttribute("error", error);
	    	return "registration";
		
	    }
	    else return "registration";
	}

	@RequestMapping("/registration")
	public String registrationJsp(Model model) {
		
		return "registration";
	}

	

	@ModelAttribute("users")
	public List<User> allUsers() {
		
		return users;
	}
	
	
	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
	
	public boolean checkLogin(User user){

		boolean match = false;
		
		for(int i=0;i<users.size();i++){
			if(user.getLogin().equals(users.get(i).getLogin())){
				match=true;
				break;
				}
			else{
			match=false;
			}
		}
	
		return match;	
	}

}
