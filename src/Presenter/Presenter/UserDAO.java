package Presenter.Presenter;

import Model.Model.*;
import Model.Model.Facade;

public class UserDAO implements IUserDAO {

	private IModel Model;

	public UserDAO() {
		Model = new Facade();
	}

	@Override
	public User GetUserById(int UserId) {
		return Model.GetUserById(UserId);
	}

	@Override
	public void AddUser(User User) {

	}

	@Override
	public void UpdateUser(User User) {
		Model.UpdateUser(User);
	}
}