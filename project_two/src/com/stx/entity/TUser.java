package com.stx.entity;

public class TUser {
	private Integer usernumber;
	private String username;
	private String pwd;
	private String ctime;
	private String customertype;
	private String certificatenumber;
	private String email;
	private int discount;
	private String sex;
	
	public TUser() {}
	
	public TUser(Integer usernumber, String username, String pwd, String ctime, String customertype,
			String certificatenumber, String email, int discount, String sex) {
		super();
		this.usernumber = usernumber;
		this.username = username;
		this.pwd = pwd;
		this.ctime = ctime;
		this.customertype = customertype;
		this.certificatenumber = certificatenumber;
		this.email = email;
		this.discount = discount;
		this.sex = sex;
	}

	public TUser(String username){
		super();
		this.username = username;
	}
	public TUser(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	public Integer getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCustomertype() {
		return customertype;
	}

	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}

	public String getCertificatenumber() {
		return certificatenumber;
	}

	public void setCertificatenumber(String certificatenumber) {
		this.certificatenumber = certificatenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	

}
