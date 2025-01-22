package org.Presenter.Presenter;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.Model.Model.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("Facade")
class FacadeTest {

    @Mocked
    private IOrderDAO mockOrderDAO;

    @Mocked
    private IUserDAO mockUserDAO;

    @Mocked
    private IDAOFactory mockFactory;

    @Mocked
    private IModel mockModel;

    private Facade facade;

    @BeforeEach
    void setUp() {
        // Zainicjalizowanie fabryki, która zwróci zamockowany obiekt mockOrderDAO
        facade = new Facade(mockFactory, mockModel);
    }

    @Test
    @Order(1)
    void testPayForOrderChangesOrderStatus() {
        int orderId = 123;

        // Mock zamówienia
        org.Model.Model.Order mockOrder = new org.Model.Model.Order();
        mockOrder.Id = orderId;
        mockOrder.Status = OrderStatusEnum.New;

        // Konfiguracja mocków
        new Expectations() {{
            mockFactory.CreateOrderDAO();
            result = mockOrderDAO;

            mockOrderDAO.GetOrderById(orderId);
            result = mockOrder;
        }};

        facade.PayForOrder(orderId);

        assertEquals(OrderStatusEnum.ReadyToAssign, mockOrder.Status, "Order status should be changed to ReadyToAssign");

        new Verifications() {{
            mockOrderDAO.UpdateOrder(mockOrder);
            times = 1;
        }};
    }


    @Test
    @Order(2)
    void assignDriverToOrder() {
        int orderId = 123;
        int driverId = 456;

        org.Model.Model.Order mockOrder = new org.Model.Model.Order();
        mockOrder.Id = orderId;
        mockOrder.Status = OrderStatusEnum.ReadyToAssign;

        Driver mockDriver = new Driver();
        mockDriver.Id = driverId;
        mockDriver.Status = DriverStatusEnum.Available;

        new Expectations() {{
            mockOrderDAO.GetOrderById(orderId);
            result = mockOrder;

            mockUserDAO.GetUserById(driverId);
            result = mockDriver;
        }};

        facade.AssignDriverToOrder(driverId, orderId);

        assertEquals(OrderStatusEnum.InProgress, mockOrder.Status, "Order status should be changed to InProgress");
        assertEquals(driverId, mockOrder.Driver.Id, "DriverId should be set to the driverId");
        assertEquals(DriverStatusEnum.Driving, mockDriver.Status, "Driver status should be changed to Driving");

        new mockit.Verifications() {{
            mockOrderDAO.UpdateOrder(mockOrder);
            times = 1;

            mockUserDAO.UpdateUser(mockDriver);
            times = 1;
        }};
    }

    @ParameterizedTest
    @CsvSource({
            "123, 456, ReadyToAssign, InProgress",
            "789, 101, New, InProgress"
    })
    @Order(3)
    void testOrderStatusTransition(int orderId, int driverId, OrderStatusEnum initialStatus, OrderStatusEnum expectedStatus) {
        org.Model.Model.Order mockOrder = new org.Model.Model.Order();
        mockOrder.Id = orderId;
        mockOrder.Status = initialStatus;

        Driver mockDriver = new Driver();
        mockDriver.Id = driverId;

        new Expectations() {{
            mockOrderDAO.GetOrderById(orderId);
            result = mockOrder;

            mockUserDAO.GetUserById(driverId);
            result = mockDriver;
        }};

        facade.AssignDriverToOrder(driverId, orderId);

        assertEquals(expectedStatus, mockOrder.Status, "Order status should be updated correctly");

        new mockit.Verifications() {{
            mockOrderDAO.UpdateOrder(mockOrder);
            times = 1;
        }};
    }

    @ParameterizedTest
    @CsvSource({
            "1, New",
            "2, InValuation",
            "3, ReadyToAssign"
    })
    void testSetOrderStatus(int orderId, OrderStatusEnum inputStatus) {
        org.Model.Model.Order mockOrder = new org.Model.Model.Order();

        new Expectations() {{
            mockFactory.CreateOrderDAO();
            result = mockOrderDAO;

            mockOrderDAO.GetOrderById(orderId);
            result = mockOrder;
        }};

        facade.SetOrderStatus(orderId, inputStatus);

        new Verifications() {{
            assertEquals(inputStatus, mockOrder.Status, "Order status should be updated to the expected status");

            mockOrderDAO.UpdateOrder(mockOrder);
            times = 1;
        }};
    }

    @Test
    @Order(5)
    void testGetOrderListByRole() {
        UserRoleEnum userRole = UserRoleEnum.Planner;

        org.Model.Model.Order mockOrder1 = new org.Model.Model.Order();
        mockOrder1.Id = 1;
        mockOrder1.Status = OrderStatusEnum.ReadyToAssign;

        org.Model.Model.Order mockOrder2 = new org.Model.Model.Order();
        mockOrder2.Id = 2;
        mockOrder2.Status = OrderStatusEnum.InProgress;

        org.Model.Model.Order mockOrder3 = new org.Model.Model.Order();
        mockOrder3.Id = 3;
        mockOrder3.Status = OrderStatusEnum.Done;

        new Expectations() {{
            mockModel.GetOrders();
            result = new org.Model.Model.Order[]{mockOrder1, mockOrder2, mockOrder3};
        }};

        // Call GetOrderListByRole for FinanceDepartment
        org.Model.Model.Order[] orders = facade.GetOrderListByRole(userRole);

        // Assertions to check the results
        assertEquals(1, orders.length, "There should be 3 orders for FinanceDepartment role");
    }

    @ParameterizedTest
    @CsvSource({
            "Client, 5", // Client powinien widzieć InValuation, InProgress, Done
            "Planner, 1", // Planner widzi tylko ReadyToAssign
            "FinanceDepartment, 3", // FinanceDepartment widzi ReadyToAssign, InProgress, Done
            "Driver, 0" // Driver nie widzi żadnych zamówień
    })
    void testGetOrderListByRole(UserRoleEnum userRole, int expectedCount) {
        org.Model.Model.Order mockOrder1 = new org.Model.Model.Order();
        mockOrder1.Id = 1;
        mockOrder1.Status = OrderStatusEnum.New;

        org.Model.Model.Order mockOrder2 = new org.Model.Model.Order();
        mockOrder2.Id = 2;
        mockOrder2.Status = OrderStatusEnum.InValuation;

        org.Model.Model.Order mockOrder3 = new org.Model.Model.Order();
        mockOrder3.Id = 3;
        mockOrder3.Status = OrderStatusEnum.ReadyToAssign;

        org.Model.Model.Order mockOrder4 = new org.Model.Model.Order();
        mockOrder4.Id = 4;
        mockOrder4.Status = OrderStatusEnum.InProgress;

        org.Model.Model.Order mockOrder5 = new org.Model.Model.Order();
        mockOrder5.Id = 5;
        mockOrder5.Status = OrderStatusEnum.Done;

        new Expectations() {{
            mockModel.GetOrders();
            result = new org.Model.Model.Order[]{
                    mockOrder1, mockOrder2, mockOrder3, mockOrder4, mockOrder5
            };
        }};

        org.Model.Model.Order[] filteredOrders = facade.GetOrderListByRole(userRole);

        assertEquals(expectedCount, filteredOrders.length,
                "Filtered orders count does not match expected for role: " + userRole);
    }
}
