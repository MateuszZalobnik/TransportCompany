package org.Model.Model;

public class Order {
	public Order() {
	}

	public Order(int id, String date, Address startPoint, Address endPoint, Integer weight, double price, OrderStatusEnum status, User driver) {
		Id = id;
		Date = date;
		StartPoint = startPoint;
		EndPoint = endPoint;
		Weight = weight;
		Price = price;
		Status = status;
		Driver = driver;
	}
	public int Id;
	public String Date;
	public Address StartPoint;
	public Address EndPoint;
	public Integer Weight;
	public double Price;
	public OrderStatusEnum Status;
	public User Driver;

}