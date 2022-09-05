package ua.com.acomahmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.acomahmanager.domain.User;
import ua.com.acomahmanager.domain.UserRole;
import ua.com.acomahmanager.service.MenuService;
import ua.com.acomahmanager.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		
		User user = new User();

		model.addAttribute("userForm", user);
		
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.save(userForm);
		
		return "redirect:/home";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		
		if (error != null)
			model.addAttribute("error", "There is no user with such email or password.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() throws Exception { 
		
		ModelAndView map;
		
		UserRole role = userService.getUserRole();
		if (role == UserRole.ROLE_SUPERVISOR) {
			map = new ModelAndView("home-supervisor");
		} else if (role == UserRole.ROLE_ADMIN) {
			map = new ModelAndView("home-admin");
		} else if (role == UserRole.ROLE_USER) {
			map = new ModelAndView("home");
		} else {
			map = new ModelAndView("403");
			System.out.println(">>>> ADD MENU HANDLER FOR CURRENT ROLE");
		}
		menuService.addMenuToPage(map);
		return map;
	}
}
