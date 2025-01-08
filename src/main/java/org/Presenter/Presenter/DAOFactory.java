package org.Presenter.Presenter;

public class DAOFactory implements IDAOFactory {

	@Override
	public IUserDAO CreateUserDAO() {
		return new UserDAO();
	}

	@Override
	public IOrderDAO CreateOrderDAO() {
		return new OrderDAO();
	}
}