package Presenter.Presenter;

import Model.Model.*;

public class Facade implements IPresenter {

	/**
	 * 
	 * @param UserId
	 */
	public int GetUserRole(int UserId) {
		// TODO - implement Facade.GetUserRole
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param UserLogin
	 * @param UserPassword
	 * @param UserRole
	 */
	public User SignUpNewUser(String UserLogin, String UserPassword, int UserRole) {
		// TODO - implement Facade.SignUpNewUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param UserLogin
	 * @param UserPassword
	 */
	public int LogInUser(String UserLogin, String UserPassword) {
		// TODO - implement Facade.LogInUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Request
	 */
	public float GetValuation(GetValuationRequest Request) {
		// TODO - implement Facade.GetValuation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param OrderId
	 * @param Status
	 */
	public void SetOrderStatus(int OrderId, int Status) {
		// TODO - implement Facade.SetOrderStatus
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param UserRole
	 */
	public Model.Model.Order[] GetOrderListByRole(int UserRole) {
		// TODO - implement Facade.GetOrderListByRole
		throw new UnsupportedOperationException();
	}

	public Model.Model.Driver[] GetDriversList() {
		// TODO - implement Facade.GetDriversList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param UserId
	 * @param OrderId
	 */
	public void AssignDriverToOrder(int UserId, int OrderId) {
		IDAOFactory factory = new DAOFactory();
		IOrderDAO orderDAO = factory.CreateOrderDAO();
		IUserDAO driverDAO = factory.CreateUserDAO();

		Order order = orderDAO.GetOrderById(OrderId);
		Driver driver = (Driver) driverDAO.GetUserById(UserId);

		order.Status = OrderStatusEnum.InProgress;
		order.Driver = driver;

		driver.Status = DriverStatusEnum.Driving;

		orderDAO.UpdateOrder(order);
		driverDAO.UpdateUser(driver);
	}

	/**
	 * 
	 * @param UserId
	 * @param Status
	 */
	public void SetDriverStatus(int UserId, int Status) {
		// TODO - implement Facade.SetDriverStatus
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param UserId
	 * @param Value
	 */
	public void MakeTransfer(int UserId, float Value) {
		// TODO - implement Facade.MakeTransfer
		throw new UnsupportedOperationException();
	}

	public void GetFinancialBalance() {
		// TODO - implement Facade.GetFinancialBalance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param OrderId
	 */
	public void PayForOrder(int OrderId) {
		// TODO - implement Facade.PayForOrder
		throw new UnsupportedOperationException();
	}

}