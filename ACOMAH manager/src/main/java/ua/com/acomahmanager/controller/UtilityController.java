package ua.com.acomahmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.acomahmanager.domain.Utility;
import ua.com.acomahmanager.service.MenuService;
import ua.com.acomahmanager.service.UnitService;
import ua.com.acomahmanager.service.UtilityService;

@Controller
public class UtilityController {
	
	@Autowired
	private UtilityService utilityService;
	
	@Autowired
	private UnitService unitService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/utilities", method = RequestMethod.GET)
	public ModelAndView getAllUtilities() throws Exception {
		
		ModelAndView map = new ModelAndView("utilities");
		map.addObject("utilities", utilityService.getAllUtilities());
		menuService.addMenuToPage(map);
		
		return map;
	}
	
	@RequestMapping(value = "/create-utility", method = RequestMethod.GET)
	public ModelAndView createUtility() throws Exception {
		
		ModelAndView map = new ModelAndView("createUtility", "utility", new Utility());
		map.addObject("units", unitService.getAllUnits());
		menuService.addMenuToPage(map);
		
		return map;
	}

	
	@RequestMapping(value = "/add-utility", method = RequestMethod.POST)
	public ModelAndView createUtility(@Validated @ModelAttribute("utility") Utility utility , BindingResult bindingResult) {
		
		if (utility.getName().trim().equals("")) {
			utility.setName("");
			
			bindingResult.rejectValue("name", "error.utilityNameIsEmpty", "Field Utility can't be blank or contains only spaces");
			return new ModelAndView("createUtility", "utility", utility);
		} else if(utility.getUnit() == null) {
			bindingResult.rejectValue("unit", "error.utilityUnitIsEmpty", "Field Unit can't be blank");
			
			return new ModelAndView("createUtility", "utility", utility);
		} else {
			utility.setIsDeleted(false);
			utilityService.save(utility);
			
			return new ModelAndView("redirect:/utilities");
		}
	}
	
}
