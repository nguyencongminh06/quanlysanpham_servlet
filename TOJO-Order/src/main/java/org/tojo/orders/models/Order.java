package org.tojo.orders.models;

import java.util.List;

public class Order {
	private String customerName;
	private String customerPhong;
	private String customerEamil;
	private String createDate;
	private List<OrderDetail> orderDatail;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhong() {
		return customerPhong;
	}
	public void setCustomerPhong(String customerPhong) {
		this.customerPhong = customerPhong;
	}
	public String getCustomerEamil() {
		return customerEamil;
	}
	public void setCustomerEamil(String customerEamil) {
		this.customerEamil = customerEamil;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public List<OrderDetail> getOrderDatail() {
		return orderDatail;
	}
	public void setOrderDatail(List<OrderDetail> orderDatail) {
		this.orderDatail = orderDatail;
	}
	
	
	
	
	
	
}
