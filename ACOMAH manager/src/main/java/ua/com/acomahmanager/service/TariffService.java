package ua.com.acomahmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.acomahmanager.dao.TariffRepository;
import ua.com.acomahmanager.domain.Tariff;

@Service
public class TariffService {

	@Autowired
	private TariffRepository TariffRepository;
	
	public Tariff save(Tariff tariff) {
		return TariffRepository.save(tariff);
	}
	
	public List<Tariff> getAllTariffs() {
		return TariffRepository.findAll();
	}
	
}
