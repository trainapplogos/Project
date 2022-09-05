package ua.com.acomahmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.acomahmanager.dao.UtilityRepository;
import ua.com.acomahmanager.domain.Utility;

@Service
public class UtilityService {
	
	@Autowired
	private UtilityRepository utilityRepository;
	
	public Utility save(Utility utility) {
		return utilityRepository.save(utility);
	}
	
	public List<Utility> getAllUtilities() {
		return utilityRepository.findAll();
	}
}
