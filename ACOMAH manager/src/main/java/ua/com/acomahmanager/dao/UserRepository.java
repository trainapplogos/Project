package ua.com.acomahmanager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.acomahmanager.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
}
