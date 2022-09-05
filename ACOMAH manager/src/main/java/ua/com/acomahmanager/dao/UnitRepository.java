package ua.com.acomahmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.acomahmanager.domain.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
