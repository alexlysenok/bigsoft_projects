package by.lesson11.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import by.lesson11.dal.BookDao;
import by.lesson11.dal.CrudDao;
import by.lesson11.entity.User;
import by.lesson11.exception.DalException;

@Controller
public class LoginController {
	
	private Logger LOGGER = Logger.getLogger(LoginController.class
			.getSimpleName());
	
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	private BookDao bookDao; 
	public static String currentUser=null;
	

    private List<User> users = new ArrayList<User>();
	
	@RequestMapping("/login/check")
	public String login(@CookieValue("JSESSIONID") String sessionId, @ModelAttribute User user, BindingResult result, Model model, Errors errors, HttpServletRequest request) {

		model.addAttribute("sessionId", sessionId);
		System.out.println(sessionId+"------------");
		
		String error="wrong login or password";
		String success="login success";
		
        users=getUsers();
		
		boolean doesMatchlog = checkLogin(user);
		boolean doesMatchpass = checkPassword(user);
		
		
		
		
		if(doesMatchlog && doesMatchpass){
			
			
			request.getSession().setAttribute("currentuser", user);
			System.out.println(request.getSession().getCreationTime());
			//model.addAttribute("currentuser", user);
		
			return "forward:/main";
			}
		else if(!doesMatchlog && doesMatchpass){
			//errors.rejectValue("login", "login.notexist", "Such login dosn't exist ");	
			model.addAttribute("success", success);
			return "login";
		}
		else if(doesMatchlog || !doesMatchpass){
			// errors.rejectValue("password", "password.notexist", "Such password dosn't exist ");
			 model.addAttribute("error", error);
			 return "login";
		}
		
		else{
			return "login";
		}
		
		
		
		//return doesMatch ? "forward:/list" : "login";
	}
	
	@RequestMapping("/list")
	public String list(@CookieValue("JSESSIONID") String sessionId, Model model) {
		model.addAttribute("sessionId", sessionId);
		
		return "list";
	}
	
	
	
	@ModelAttribute("users")
	public List<User> allUsers() {
		
	
		users=getUsers();
		return users;
	}
	
	
	public List<User> getUsers(){
		
		
		
		try {
			users = bookDao.list(User.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}
	

	@RequestMapping("/login")
	public String loginJsp(Model model) {
		return "login";
	}

	@ModelAttribute("user")
	public User populateUser() {
		return new User();
	}
	
	/*
	@ModelAttribute("currentuser")
	public String currentUser() {
		return currentUser;
	}
	*/

	
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
	
	public boolean checkPassword(User user){
		
        
		
		boolean match = false;
		
		for(int i=0;i<users.size();i++){
			if(user.getPassword().equals(users.get(i).getPassword())){
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