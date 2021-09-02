package ua.com.acomahmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.com.acomahmanager.dao.UserRepository;
import ua.com.acomahmanager.domain.User;
import ua.com.acomahmanager.domain.UserRole;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder; //should we use BCryptPasswordEncoder instead of PasswordEncoder


    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }

}