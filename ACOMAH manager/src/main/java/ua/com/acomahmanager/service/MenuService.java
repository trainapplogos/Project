package ua.com.acomahmanager.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import ua.com.acomahmanager.dao.MenuRepository;
import ua.com.acomahmanager.domain.UserRole;
import ua.com.acomahmanager.dto.MenuItem;

@Service
public class MenuService implements MenuRepository {
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<MenuItem> getMenuByRole() throws Exception {
		List<MenuItem> menu = new ArrayList<>();
		UserRole role = userService.getUserRole();
		
		if (role == UserRole.ROLE_ADMIN) {
			menu.add(new MenuItem("Home", "/home", ""));
			
			menu.add(new MenuItem("", "", "Bills")); //add group accordion title 
			menu.add(new MenuItem("Bills List", "/bills", "Bills"));
			menu.add(new MenuItem("Create Bill", "/create-bill", "Bills"));
//			menu.add(new MenuItem("Bills Management", "/users-management", "Bills"));
			
			menu.add(new MenuItem("Send message", "/create-message", ""));
			
			menu.add(new MenuItem("", "", "Tariffs"));
			menu.add(new MenuItem("All Tariffs", "/tariffs", "Tariffs"));
			menu.add(new MenuItem("Create tariff", "/create-tariff", "Tariffs"));
			
			menu.add(new MenuItem("", "", "Utilities"));
			menu.add(new MenuItem("All Utilities", "/utilities", "Utilities"));
			menu.add(new MenuItem("Create utility", "/create-utility", "Utilities")); 
			
			menu.add(new MenuItem("", "", "Units"));
			menu.add(new MenuItem("All Units", "/units", "Units"));
			menu.add(new MenuItem("Create Unit", "/create-unit", "Units"));
			
			menu.add(new MenuItem("Logout", "/login?logout", ""));
			
		} else if (role == UserRole.ROLE_USER) {
			menu.add(new MenuItem("Home", "/home", ""));
			menu.add(new MenuItem("Bills", "/bill-form", ""));
			menu.add(new MenuItem("Inbox Messages", "/messages-form", ""));
		} else {
			menu.add(new MenuItem("Home", "/home", ""));
			System.out.println(">>>> ADD MENU HANDLER FOR CURRENT ROLE '" + role + "'"); //Log it
		}
		
		return menu;
	}
	
	public void addMenuToPage(ModelAndView map) throws Exception {
			map.addObject("menuItems", getMenuByRole());
	}
	
}
