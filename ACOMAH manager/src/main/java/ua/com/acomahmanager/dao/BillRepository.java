package ua.com.acomahmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.acomahmanager.domain.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
