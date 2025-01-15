package org.Presenter.Presenter;


import org.Model.Model.Facade;
import org.Model.Model.IModel;
import org.Model.Model.Order;

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
		model.AddOrder(new Order());
	}

	@Override
	public void UpdateOrder(Order Order) {
		model.UpdateOrder(Order);
	}
}