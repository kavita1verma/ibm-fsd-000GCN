package com.assesmentQ4;

public class Contact implements Comparable<Contact> {
	private String name;
	private String email;
	private Long mobile;
	private String address;
	
	public Contact(String name, String email, Long mobile, String address) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "-" + mobile;
	}

	@Override
	public int compareTo(Contact e) {
		if(this.getMobile() == e.getMobile()) {
			return 0;
		}
		else if(this.getMobile() > e.getMobile()) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	

}
