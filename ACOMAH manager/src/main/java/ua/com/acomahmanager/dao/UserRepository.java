package ua.com.acomahmanager.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import ua.com.acomahmanager.domain.User;
import ua.com.acomahmanager.domain.UserRole;

public interface UserRepository
		extends JpaRepository<User, Long>, CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {

	Optional<User> findByEmail(String email); 

	@Query(value = "SELECT u FROM User u WHERE u.role = 'ROLE_USER' AND u.isDeleted = false AND u.isDeleted = false AND u.isActive = true")
	Page<User> findAllByRole(Pageable page); // by role

	Page<User> findAll(Specification<User> spec, Pageable pageable);

	@Query("SELECT COUNT(u) FROM User u WHERE u.role = ?1 AND u.isDeleted = false") // add condition "AND u.isActive = true"
	Integer getUsersCountByRole(UserRole role);
	
}
