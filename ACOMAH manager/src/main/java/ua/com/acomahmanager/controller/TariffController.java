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

import ua.com.acomahmanager.domain.Tariff;
import ua.com.acomahmanager.service.MenuService;
import ua.com.acomahmanager.service.TariffService;
import ua.com.acomahmanager.service.UtilityService;

@Controller
public class TariffController {
	
	@Autowired
	private TariffService tariffService;
	
	@Autowired
	private UtilityService utilityService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/tariffs", method = RequestMethod.GET)
	public ModelAndView getAllMonthlyTariffs() throws Exception {
		ModelAndView map = new ModelAndView("tariffs");
		map.addObject("tariffs", tariffService.getAllTariffs());
		menuService.addMenuToPage(map);
		
		return map;
	}
	
	@RequestMapping(value = "/create-tariff", method = RequestMethod.GET)
	public ModelAndView createTariff() throws Exception {
		ModelAndView map = new ModelAndView("createTariff", "tariff", new Tariff()); //monthlyTariff
		map.addObject("utilities", utilityService.getAllUtilities());
		menuService.addMenuToPage(map);
		
		return map;
	}
	
	@RequestMapping(value = "/add-tariff", method = RequestMethod.POST)
	public ModelAndView createUtility(@Validated @ModelAttribute("tariff") Tariff tariff, BindingResult bindResult) {
		if (tariff.getUtility() == null ) {
			bindResult.rejectValue("utility", "error.utilityNotSelected", "Utility can't be blank or contain spaces only");
			
			return new ModelAndView("createTariff", "tariff", tariff);
		} else {		
			tariff.setIsDeleted(false);
			tariffService.save(tariff);
			return new ModelAndView("redirect:/tariffs");
		}
	}
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	    
	}
}
