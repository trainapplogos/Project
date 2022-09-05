package ua.com.acomahmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ua.com.acomahmanager.domain.UserRole;
import ua.com.acomahmanager.dto.PageRequestDto;
import ua.com.acomahmanager.dto.TableDataDto;
import ua.com.acomahmanager.dto.UserDataDto;
import ua.com.acomahmanager.service.UserService;

@RestController
@RequestMapping("/api/get-data")
public class SearchController {
	
	private Long totalCount;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<String> filterUsersByAllFields(
				@RequestParam(name = "search", required = false) String search,
				@RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset, 
				@RequestParam(name = "limit", required = false) Integer limit,
				@RequestParam(name = "sort", required = false, defaultValue = "id") String sort,
				@RequestParam(name = "order", required = false, defaultValue = "asc") String order
			) throws Exception {
		
		PageRequestDto list = userService.getUsersList(offset, limit, sort, order, search); 
		
		List<UserDataDto> users = list.getList();
	
		Long count = list.getSize();
		if (search.equals("")) totalCount = count; //save size of total non-filtered items for possible filtration in feature
			
		Gson gson = new Gson();
		
		final HttpHeaders httpHeaders= new HttpHeaders();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		TableDataDto table = new TableDataDto();
		 
		table.total = count;
		table.totalNotFiltered = totalCount;
		table.rows = users;
		
		return new ResponseEntity<String>(gson.toJson(table), httpHeaders, HttpStatus.OK);
		
	}
			

}
