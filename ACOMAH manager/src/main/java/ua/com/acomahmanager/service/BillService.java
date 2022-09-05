package ua.com.acomahmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.acomahmanager.dao.BillRepository;
import ua.com.acomahmanager.domain.Bill;

@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	public Bill save(Bill bill) {
		return billRepository.save(bill);
	}
	
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}
	
	
}
