package Domain.Common.Dto;

import java.util.List;

public class UserDto {
	
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String phone;
	private String role;
	
	public UserDto() {	}
		
	public UserDto(String id, String pw, String name, String addr, String phone, String role) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.role = role;
	}

	//toString
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + ", phone=" + phone + ", role=" + role + "]";
	}

	//getter-setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
