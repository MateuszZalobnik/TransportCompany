package Presenter.Presenter;

public interface IDAOFactory {

	IUserDAO CreateUserDAO();

	IOrderDAO CreateOrderDAO();
}