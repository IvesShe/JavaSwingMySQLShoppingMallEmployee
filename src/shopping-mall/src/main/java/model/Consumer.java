package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Consumer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String consumerNo;
	private String username;
	private String password;
	private String name;
	private String phone;
	private String address;
	private Timestamp createdAt;  // 使用 Timestamp 類型
	private Timestamp updatedAt;  // 使用 Timestamp 類型
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Consumer(String consumerNo, String username, String password, String name, String phone, String address) {
		super();
		this.consumerNo = consumerNo;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	
	
	
	
	
}
