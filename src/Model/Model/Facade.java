package Model.Model;

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

	@Override
	public void UpdateOrder(Order Order) {

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
		return null;
	}

	@Override
	public User GetUserById(int Id) {
		return null;
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

	}
}