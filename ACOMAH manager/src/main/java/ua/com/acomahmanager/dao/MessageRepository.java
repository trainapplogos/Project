package ua.com.acomahmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.acomahmanager.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
