package testyfitnessefixture;

import fit.ColumnFixture;
import org.Model.Model.Driver;
import org.Model.Model.DriverStatusEnum;
import org.Model.Model.OrderStatusEnum;

public class TestAssignDriverToOrder extends ColumnFixture {
    public int UserId;
    public int OrderId;

    public String assignDriverToOrder() {
        try {
            var orderDAO = SetUp.app.factory.CreateOrderDAO();
            var driverDAO = SetUp.app.factory.CreateUserDAO();

            SetUp.app.AssignDriverToOrder(UserId, OrderId);

            var orderAfter = orderDAO.GetOrderById(OrderId);
            var driverAfter = (Driver) driverDAO.GetUserById(UserId);

            if (orderAfter.Status == OrderStatusEnum.InProgress
                    && orderAfter.Driver != null
                    && orderAfter.Driver.Id == UserId
                    && driverAfter.Status == DriverStatusEnum.Driving) {
                return String.format("Przypisano kierowcę %s do zamówienia %s. Status zamówienia: %s, Status kierowcy: %s",
                        driverAfter.Login, orderAfter.Id, orderAfter.Status, driverAfter.Status);
            } else {
                return "Przypisanie nie powiodło się.";
            }
        } catch (Exception e) {
            return "Błąd: " + e.getMessage();
        }
    }
}
