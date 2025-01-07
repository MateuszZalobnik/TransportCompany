package Presenter.Presenter;

import Model.Model.*;
import Model.Model.Facade;

public class OrderDAO implements IOrderDAO {

	private IModel model;

	public OrderDAO() {
		model = new Facade();
	}

	@Override
	public Order GetOrderById(int OrderId) {
		return model.GetOrderById(OrderId);
	}

	@Override
	public void AddOrder(Order Order) {

	}

	@Override
	public void UpdateOrder(Order Order) {
		model.UpdateOrder(Order);
	}
}