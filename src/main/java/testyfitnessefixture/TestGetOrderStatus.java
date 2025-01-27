package testyfitnessefixture;

import fit.ColumnFixture;
import org.Model.Model.Order;
import org.Model.Model.OrderStatusEnum;

public class TestGetOrderStatus extends ColumnFixture {
    public int OrderId;
    public String NewStatus;

    public String setOrderStatus() {
        try {
            var orderDAO = SetUp.app.factory.CreateOrderDAO();

            // Zmiana statusu zamówienia
            OrderStatusEnum statusEnum = OrderStatusEnum.valueOf(NewStatus);
            SetUp.app.SetOrderStatus(OrderId, statusEnum);

            var updatedOrder = orderDAO.GetOrderById(OrderId);

            if (updatedOrder.Status == statusEnum) {
                return String.format("Status zamówienia %s zmieniono na %s.", updatedOrder.Id, updatedOrder.Status);
            } else {
                return "Zmiana statusu nie powiodła się.";
            }
        } catch (Exception e) {
            return "Błąd: " + e.getMessage();
        }
    }
}
