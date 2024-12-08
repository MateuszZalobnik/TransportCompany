package Model.Model;

public interface IModel {

	/**
	 * 
	 * @param Order
	 */
	void UpdateOrder(Order Order);

	/**
	 * 
	 * @param Order
	 */
	void AddOrder(Order Order);

	/**
	 * 
	 * @param Order
	 */
	void DeleteOrder(Order Order);

	User AddUser();

	/**
	 * 
	 * @param Id
	 */
	Order GetOrderById(int Id);

	/**
	 * 
	 * @param Id
	 */
	User GetUserById(int Id);

	User[] GetUsers();

	Order[] GetOrders();

	/**
	 * 
	 * @param User
	 */
	void UpdateUser(User User);

}