package org.Presenter.Presenter;

import org.Model.Model.IModel;
import org.Model.Model.User;

public class UserDAO implements IUserDAO {

	private IModel model;

	public UserDAO(IModel model) {
		this.model = model;
	}

	@Override
	public User GetUserById(int UserId) {
		return model.GetUserById(UserId);
	}

	@Override
	public void AddUser(User User) {

	}

	@Override
	public void UpdateUser(User User) {
		model.UpdateUser(User);
	}
}