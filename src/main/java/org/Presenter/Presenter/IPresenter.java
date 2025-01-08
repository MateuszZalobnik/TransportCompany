package org.Presenter.Presenter;

import org.Model.Model.Driver;
import org.Model.Model.Order;
import org.Model.Model.User;

public interface IPresenter {

	/**
	 * 
	 * @param UserId
	 */
	int GetUserRole(int UserId);

	/**
	 * 
	 * @param UserLogin
	 * @param UserPassword
	 * @param UserRole
	 */
	User SignUpNewUser(String UserLogin, String UserPassword, int UserRole);

	/**
	 * 
	 * @param UserLogin
	 * @param UserPassword
	 */
	int LogInUser(String UserLogin, String UserPassword);

	/**
	 * 
	 * @param Request
	 */
	float GetValuation(GetValuationRequest Request);

	/**
	 * 
	 * @param OrderId
	 * @param Status
	 */
	void SetOrderStatus(int OrderId, int Status);

	/**
	 * 
	 * @param UserRole
	 */
	Order[] GetOrderListByRole(int UserRole);

	Driver[] GetDriversList();

	/**
	 * 
	 * @param UserId
	 * @param OrderId
	 */
	void AssignDriverToOrder(int UserId, int OrderId);

	/**
	 * 
	 * @param UserId
	 * @param Status
	 */
	void SetDriverStatus(int UserId, int Status);

	/**
	 * 
	 * @param UserId
	 * @param Value
	 */
	void MakeTransfer(int UserId, float Value);

	void GetFinancialBalance();

	/**
	 * 
	 * @param OrderId
	 */
	void PayForOrder(int OrderId);

}