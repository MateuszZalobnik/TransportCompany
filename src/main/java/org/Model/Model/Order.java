package org.Model.Model;

public class Order {

	public int Id;
	public String Date;
	public Address StartPoint;
	public Address EndPoint;
	public Integer Weight;
	public double Price;
	public OrderStatusEnum Status;
	public User Driver;

}