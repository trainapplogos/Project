package ua.com.acomahmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.acomahmanager.domain.MonthlyTariff;

public interface MonthlyTariffRepository extends JpaRepository<MonthlyTariff, Integer> {

}
