package ua.com.acomahmanager.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.com.acomahmanager.dao.UserRepository;
import ua.com.acomahmanager.domain.User;
import ua.com.acomahmanager.domain.UserRole;
import ua.com.acomahmanager.dto.PageRequestDto;
import ua.com.acomahmanager.dto.UserDataDto;
import ua.com.acomahmanager.specification.UserSpecification;

@Service
public class UserService {
    
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(UserRole.ROLE_USER);
        user.setIsActive(false);
        user.setIsDeleted(false);
        userRepository.save(user);
    }
    
    public User getUserById(Long id) {
    	return userRepository.getById(id);
    }
    
    public UserRole getUserRole() throws Exception {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_SUPERVISOR"))) {
			return UserRole.ROLE_SUPERVISOR;
    	} else if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
    		return UserRole.ROLE_ADMIN;
    	} else if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
			return UserRole.ROLE_USER;
		} else {
			throw new Exception("UNKNOWN ROLE");
		}
    }
    
    public Integer getUsersCountByRole(UserRole role) {
    	return userRepository.getUsersCountByRole(role);
    }
    
    public PageRequestDto getUsersList(Integer offset, Integer limit, String sort, String order, String search) throws Exception {
    	Pageable page;
    	AtomicInteger ind = new AtomicInteger(1); 
    	List<User> list;
    	
    	if (!(limit == null)) {
    		Integer pageNum = offset / limit;
        	page = PageRequest.of(pageNum, limit, order.equals("asc") ? Sort.by(sort).ascending() : Sort.by(sort).descending());
    	} else {
        	Integer noLimit = userRepository.getUsersCountByRole(UserRole.ROLE_USER);
    		page = PageRequest.of(0, noLimit, order.equals("asc") ? Sort.by(sort).ascending() : Sort.by(sort).descending());
    	}
    	
		Page<User> findAll = userRepository.findAll(UserSpecification.textInAllColumns(search), page); //containsTextInName(search)
		list =  findAll.getContent();
    	Long count = findAll.getTotalElements();
    	    	
    	List<UserDataDto> resultList = list.stream().map(UserService::mapToUserDataDto).collect(Collectors.toList());
    	resultList.forEach(a -> a.setNumberInList(offset + ind.getAndIncrement()));
  
    	return new PageRequestDto(resultList, count);
    }
    
    private static UserDataDto mapToUserDataDto(User user) {
    	UserDataDto userDto = new UserDataDto();
    	userDto.setId(user.getId());
    	userDto.setEmail(user.getEmail());
    	userDto.setFirstName(user.getFirstName());
    	userDto.setLastName(user.getLastName());
    	userDto.setPatronymic(user.getPatronymic());
    	userDto.setStreet(user.getStreet());
    	userDto.setBuilding(user.getBuilding());
    	userDto.setApartment(user.getApartment());
    	userDto.setPhoneNumber(user.getPhoneNumber());
    	userDto.setZipCode(user.getZipCode());
    	
    	return userDto;
	}

}