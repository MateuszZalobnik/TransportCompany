package org.Presenter.Presenter;

import org.Model.Model.IModel;

public interface IDAOFactory {

	IUserDAO CreateUserDAO();

	IOrderDAO CreateOrderDAO();
}