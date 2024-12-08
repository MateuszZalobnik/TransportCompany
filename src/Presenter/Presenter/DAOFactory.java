package Presenter.Presenter;

import Model.Model.*;

public class DAOFactory implements IDAOFactory {

	private IModel Model;

	@Override
	public IUserDAO CreateUserDAO() {
		return null;
	}

	@Override
	public IOrderDAO CreateOrderDAO() {
		return null;
	}

	@Override
	public void IDAOFactory() {

	}
}