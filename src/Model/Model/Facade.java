package Model.Model;


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