package org.Model.Model;

public class Order {

	public int Id;
	public String Date;
	public Address StartPoint;
	public Address EndPoint;
	public String Weight;
	public int Price;
	public OrderStatusEnum Status;
	public User Driver;

}