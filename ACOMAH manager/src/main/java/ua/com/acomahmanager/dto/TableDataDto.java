package ua.com.acomahmanager.dto;

import java.util.List;

public class TableDataDto {
	public Long total;
	public Long totalNotFiltered;
	public List<UserDataDto> rows;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getTotalNotFiltered() {
		return totalNotFiltered;
	}
	public void setTotalNotFiltered(Long totalNotFiltered) {
		this.totalNotFiltered = totalNotFiltered;
	}
	public List<UserDataDto> getRows() {
		return rows;
	}
	public void setRows(List<UserDataDto> rows) {
		this.rows = rows;
	}
	
	

}
