package ua.com.acomahmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.acomahmanager.dao.UnitRepository;
import ua.com.acomahmanager.domain.Unit;


@Service
public class UnitService {
	
	@Autowired
	private UnitRepository unitRepository;
	
	public Unit save(Unit unit) {
		return unitRepository.save(unit);
	}
	
	public List<Unit> getAllUnits() {
		return unitRepository.findAll();
	}
}
