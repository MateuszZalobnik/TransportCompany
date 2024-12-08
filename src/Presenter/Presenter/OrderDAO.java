package Presenter.Presenter;

import Model.Model.*;
import Model.Model.Facade;

public class OrderDAO implements IOrderDAO {

	private IModel Model;

	public OrderDAO() {
		Model = new Facade();
	}

	@Override
	public Order GetOrderById(int OrderId) {
		return Model.GetOrderById(OrderId);
	}

	@Override
	public void AddOrder(Order Order) {

	}

	@Override
	public void UpdateOrder(Order Order) {
		Model.UpdateOrder(Order);
	}
}