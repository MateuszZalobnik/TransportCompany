package testyfitnessefixture;

import fit.Fixture;
import org.Model.Model.*;
import org.Presenter.Presenter.Facade;

public class SetUp extends Fixture {
    static Facade app;
    public SetUp() {
        app = new Facade();
        initializeMockData();
    }

    private void initializeMockData() {
        var orderDAO = app.factory.CreateOrderDAO();
        orderDAO.AddOrder(new Order(101, "2021-01-01", new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12"),  new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12"), 100, 100.0, OrderStatusEnum.ReadyToAssign, null));
        orderDAO.AddOrder(new Order(102, "2021-01-01", new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12"),  new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12"), 100, 100.0, OrderStatusEnum.ReadyToAssign, null));

        var userDAO = app.factory.CreateUserDAO();
        userDAO.AddUser(new Driver(1, "Jan Kowalski", "password", DriverStatusEnum.Available, new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12")));
        userDAO.AddUser(new Driver(2, "Anna Nowak", "password", DriverStatusEnum.Available, new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12")));
    }
}
