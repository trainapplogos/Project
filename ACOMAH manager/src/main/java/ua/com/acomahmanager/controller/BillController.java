package ua.com.acomahmanager.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.acomahmanager.domain.Bill;
import ua.com.acomahmanager.domain.User;
import ua.com.acomahmanager.service.BillService;
import ua.com.acomahmanager.service.MenuService;
import ua.com.acomahmanager.service.TariffService;
import ua.com.acomahmanager.service.UserService;

@Controller
public class BillController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private TariffService tariffService;

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/bills", method = RequestMethod.GET)
	public ModelAndView getAllMonthlyTariffs() throws Exception {
		
		ModelAndView map = new ModelAndView("bills");
		map.addObject("bills", billService.getAllBills());
		menuService.addMenuToPage(map);
		
		return map;
	}
	
	@RequestMapping(value = "/create-bill", method = RequestMethod.GET)
	public ModelAndView getUsersList() throws Exception {
		
		ModelAndView map = new ModelAndView("users-list");
		menuService.addMenuToPage(map);
		
		return map;
	}
	
	@RequestMapping(value = "/create-bill", method = RequestMethod.POST)
	public ModelAndView proceedBill(@ModelAttribute("selectedId") String selectedId) throws Exception {
		
		Bill bill = new Bill();
		ModelAndView map = new ModelAndView("createBill", "bill", bill);
		
		Long userId = Long.parseLong(selectedId);
		User fullUser = userService.getUserById(userId);
		
		map.addObject("userId",  userId);
		map.addObject("userFirstName", fullUser.getFirstName());
		map.addObject("userLastName", fullUser.getLastName());
		
		map.addObject("tariffs", tariffService.getAllTariffs());
		
		menuService.addMenuToPage(map);
		
		return map;
		
	}
	
	@RequestMapping(value = "/add-bill", method = RequestMethod.POST)
	public ModelAndView addBill(@Validated @ModelAttribute("bill") Bill bill, BindingResult bindResult) {
		
		bill.setIsDeleted(false);
		billService.save(bill);
		return new ModelAndView("redirect:/bills");
		
	}
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	    
	}
	

	
}

