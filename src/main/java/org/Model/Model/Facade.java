package org.Model.Model;


import java.util.Arrays;
import java.util.List;
import java.util.*;

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
		// TODO - for test - it will be removed
		var userForTest = new Driver() {};
		userForTest.Id = 1;
		userForTest.Login = "";
		userForTest.Password = "";
		var orderForTest = new Order();
		orderForTest.Id = 1;

		Orders = new Order[] { orderForTest };
		Users = new User[] { userForTest };
	}

	@Override
	public void UpdateOrder(Order Order) {
		var order = this.GetOrderById(Order.Id);
		order = Order;
	}

	@Override
	public void AddOrder(Order Order) {
		if (Orders == null) {
			// If the array is null init it with the new order
			Orders = new Order[] { Order };
		} else {
			// Create a new array with one extra place
			Order[] newOrders = Arrays.copyOf(Orders, Orders.length + 1);
			// Add the new order to the end of the list
			newOrders[newOrders.length - 1] = Order;
			Orders = newOrders;
		}
	}

	@Override
	public void DeleteOrder(Order Order) {

	}

	@Override
	public User AddUser() {
		return null;
	}

	@Override
	public Order GetOrderById(int Id) {
		var order = Arrays.stream(Orders).filter(o -> o.Id == Id).findFirst();
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