package org.Model.Model;


import java.util.Arrays;

public class Facade implements IModel {

	private Order[] Orders;
	private User[] Users;
	private Address[] Addresses;

	public Order[] getOrders() {
		return this.Orders;
	}

	public void setOrders(Order[] Orders) {
		this.Orders = Orders;
	}

	public Facade() {
		this.Orders = new Order[0];
		this.Users = new User[0];
		this.Addresses = new Address[0];
	}

	@Override
	public void UpdateOrder(Order Order) {
		var order = this.GetOrderById(Order.Id);
		order.Status = Order.Status;
		order.Driver = Order.Driver;
		order.Date = Order.Date;
		order.EndPoint = Order.EndPoint;
		order.StartPoint = Order.StartPoint;
		order.Price = Order.Price;
		order.Weight = Order.Weight;
	}

	@Override
	public void AddOrder(Order Order) {
		this.Orders = Arrays.copyOf(this.Orders, this.Orders.length + 1);
		this.Orders[this.Orders.length - 1] = Order;
	}

	@Override
	public void DeleteOrder(Order Order) {
		if (this.Orders != null) {
			this.Orders = Arrays.stream(this.Orders)
					.filter(o -> o != null && o.Id != Order.Id)
					.toArray(Order[]::new);
		}
	}

	@Override
	public User AddUser() {
		return null;
	}

	@Override
	public Order GetOrderById(int Id) {
		var order = Arrays.stream(Orders)
				.filter(o -> o != null && o.Id == Id)
				.findFirst();
		return order.orElse(null);
	}


	@Override
	public User GetUserById(int Id) {
		var user = Arrays.stream(Users).filter(u -> u.Id == Id).findFirst();
		return user.orElse(null);
	}

	@Override
	public User[] GetUsers() {
		return new User[0];
	}

	@Override
	public Order[] GetOrders() {
		return new Order[0];
	}

	@Override
	public void UpdateUser(User User) {
		var user = this.GetUserById(User.Id);
		user = User;
	}
}