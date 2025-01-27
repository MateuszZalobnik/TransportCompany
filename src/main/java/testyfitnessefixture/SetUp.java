package testyfitnessefixture;

import fit.Fixture;
import org.Model.Model.*;
import org.Presenter.Presenter.Facade;

import java.util.ArrayList;
import java.util.List;

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
        orderDAO.AddOrder(new Order(103, "2021-01-01", new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12"),  new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12"), 100, 100.0, OrderStatusEnum.ReadyToAssign, null));

        // Zamowienia dla testow getOrderByList
        // Dodanie przykładowych zamówień do modelu
        orderDAO.AddOrder(new Order(1, "2023-01-01", null, null, 10, 100.0, OrderStatusEnum.New, null));
        orderDAO.AddOrder(new Order(2, "2023-01-02", null, null, 20, 200.0, OrderStatusEnum.InValuation, null));
        orderDAO.AddOrder(new Order(3, "2023-01-03", null, null, 30, 300.0, OrderStatusEnum.ReadyToAssign, null));
        orderDAO.AddOrder(new Order(4, "2023-01-04", null, null, 40, 400.0, OrderStatusEnum.InProgress, null));
        orderDAO.AddOrder(new Order(5, "2023-01-05", null, null, 50, 500.0, OrderStatusEnum.Done, null));
        orderDAO.AddOrder(new Order(6, "2023-01-06", null, null, 60, 600.0, OrderStatusEnum.Done, null));


        var userDAO = app.factory.CreateUserDAO();
        userDAO.AddUser(new Driver(1, "Jan Kowalski", "password", DriverStatusEnum.Available, new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12")));
        userDAO.AddUser(new Driver(2, "Anna Nowak", "password", DriverStatusEnum.Available, new Address("PL", "Wrocław", "50-001", "ul. Grunwaldzka 1", "12")));
    }
}
