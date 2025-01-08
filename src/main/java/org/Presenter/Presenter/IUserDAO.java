package org.Presenter.Presenter;

import Model.Model.*;

public interface IUserDAO {

	/**
	 * 
	 * @param UserId
	 */
	User GetUserById(int UserId);

	/**
	 * 
	 * @param User
	 */
	void AddUser(User User);

	/**
	 * 
	 * @param User
	 */
	void UpdateUser(User User);

}