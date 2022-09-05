package ua.com.acomahmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.acomahmanager.domain.Unit;

import ua.com.acomahmanager.service.MenuService;
import ua.com.acomahmanager.service.UnitService;


@Controller
public class UnitController {
	
	@Autowired
	private UnitService unitService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/units", method = RequestMethod.GET)
	public ModelAndView getAllUnits() throws Exception {
		ModelAndView map = new ModelAndView("units");
		map.addObject("units", unitService.getAllUnits());
		menuService.addMenuToPage(map);
		
		return map;
	}
	
	@RequestMapping(value = "/create-unit", method = RequestMethod.GET)
	public ModelAndView createUnit() throws Exception {
		ModelAndView map = new ModelAndView("createUnit", "unit", new Unit());
		menuService.addMenuToPage(map);
		
		return map;
	}

	
	@RequestMapping(value = "/add-unit", method = RequestMethod.POST)
	public ModelAndView createUnit(@Validated @ModelAttribute("unit") Unit unit, BindingResult bindingResult) {
		if (unit.getName().trim().equals("")) {
			unit.setName("");
			bindingResult.rejectValue("name", "error.unitNameIsEmpty", "Field Unit can't be blank or contains only spaces");

			return new ModelAndView("createUnit", "unit", unit);
		} else {
			unit.setIsDeleted(false);
			unitService.save(unit);
			
			return new ModelAndView("redirect:/units");
		}
	}
	
}
