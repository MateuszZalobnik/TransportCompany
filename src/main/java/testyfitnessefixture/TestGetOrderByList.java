package testyfitnessefixture;

import fit.ColumnFixture;
import org.Model.Model.Order;
import org.Model.Model.OrderStatusEnum;
import org.Model.Model.UserRoleEnum;

import java.util.Arrays;

public class TestGetOrderByList extends ColumnFixture {
    public String UserRole;

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }

    public int[] getOrderIdsByRole() {
        try {
            UserRoleEnum role = UserRoleEnum.valueOf(UserRole);

            Order[] filteredOrders = SetUp.app.GetOrderListByRole(role);

            return Arrays.stream(filteredOrders)
                    .mapToInt(order -> order.Id)
                    .toArray();
        } catch (Exception e) {

            return new int[]{};
        }
    }
}
