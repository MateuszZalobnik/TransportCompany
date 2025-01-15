package org.Presenter.Presenter;

import org.Model.Model.IModel;

public class DAOFactory implements IDAOFactory {

	private final IModel model;
	public DAOFactory(IModel model) {
		this.model = model;
	}
	@Override
	public IUserDAO CreateUserDAO() {
		return new UserDAO(model);
	}

	@Override
	public IOrderDAO CreateOrderDAO() {
		return new OrderDAO(model);
	}
}