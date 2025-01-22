package org.Presenter.Presenter;

import org.Model.Model.*;

import java.util.Arrays;

public class Facade implements IPresenter {
	private IModel model;
	private final IDAOFactory factory;

	public Facade() {
		model = new org.Model.Model.Facade();
		factory = new DAOFactory(model);
	}

	public Facade(IDAOFactory factory, IModel model) {
		this.factory = factory;
		this.model = model;
	}
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
		ValuationContext valuationContext = new ValuationContext(Request);
		float valuation = valuationContext.DoBusinessLogic(Request);
		return valuation;
	}

	/**
	 * 
	 * @param OrderId
	 * @param Status
	 */
	public void SetOrderStatus(int OrderId, OrderStatusEnum Status) {
		var orderDAO = factory.CreateOrderDAO();
		var order = orderDAO.GetOrderById(OrderId);
		order.Status = Status;
		orderDAO.UpdateOrder(order);
	}

	/**
	 * 
	 * @param UserRole
	 */
	public Order[] GetOrderListByRole(UserRoleEnum UserRole) {

		Order[] orders = model.GetOrders();
		var filteredOrders = Arrays.stream(orders)
				.filter(order -> {
					switch (UserRole) {
						case Client:
							return order.Status == OrderStatusEnum.InValuation ||
									order.Status == OrderStatusEnum.InProgress ||
									order.Status == OrderStatusEnum.ReadyToAssign ||
									order.Status == OrderStatusEnum.New ||
									order.Status == OrderStatusEnum.Done;
						case Planner:
							return order.Status == OrderStatusEnum.ReadyToAssign;
						case FinanceDepartment:
							return order.Status == OrderStatusEnum.ReadyToAssign ||
									order.Status == OrderStatusEnum.InProgress ||
									order.Status == OrderStatusEnum.Done;
						default:
							return false;
					}
				})
				.toArray(Order[]::new);
		return filteredOrders;
	}

	public Driver[] GetDriversList() {
		// TODO - implement Facade.GetDriversList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param UserId
	 * @param OrderId
	 */
	public void AssignDriverToOrder(int UserId, int OrderId) {
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
		var orderDAO = factory.CreateOrderDAO();
		var order = orderDAO.GetOrderById(OrderId);
		order.Status = OrderStatusEnum.ReadyToAssign;
		orderDAO.UpdateOrder(order);
	}

}