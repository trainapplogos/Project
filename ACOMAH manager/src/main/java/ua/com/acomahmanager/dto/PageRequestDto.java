package ua.com.acomahmanager.dto;

import java.util.List;

public class PageRequestDto {
	
	private List<UserDataDto> list;
	private Long size;
	
	public PageRequestDto(List<UserDataDto> list, Long size) {
		this.list = list;
		this.size = size;
	}

	public List<UserDataDto> getList() {
		return list;
	}

	public void setList(List<UserDataDto> list) {
		this.list = list;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}
