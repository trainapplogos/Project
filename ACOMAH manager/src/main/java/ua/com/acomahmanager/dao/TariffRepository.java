package ua.com.acomahmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.acomahmanager.domain.Tariff;

public interface TariffRepository extends JpaRepository<Tariff, Integer> {

}
