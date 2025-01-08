package org.Presenter.Presenter;

import org.Model.Model.Order;

public interface IOrderDAO {

	/**
	 * 
	 * @param OrderId
	 */
	Order GetOrderById(int OrderId);

	/**
	 * 
	 * @param Order
	 */
	void AddOrder(Order Order);

	/**
	 * 
	 * @param Order
	 */
	void UpdateOrder(Order Order);

}