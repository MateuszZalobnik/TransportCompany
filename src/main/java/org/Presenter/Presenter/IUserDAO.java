package org.Presenter.Presenter;

import org.Model.Model.User;

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