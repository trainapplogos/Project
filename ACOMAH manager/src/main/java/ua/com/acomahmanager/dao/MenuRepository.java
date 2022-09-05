package ua.com.acomahmanager.dao;

import java.util.List;

import ua.com.acomahmanager.dto.MenuItem;

public interface MenuRepository {
	List<MenuItem> getMenuByRole() throws Exception;
}
