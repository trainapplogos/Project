package ua.com.acomahmanager.dto;

public class MenuItem {

	private String name;
	private String url;
	private String group;

	public MenuItem() {}
	
	public MenuItem(String name, String url, String group) {
		this.name = name;
		this.url = url;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
}
