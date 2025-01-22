package org.Presenter.Presenter;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.Model.Model.Driver;
import org.Model.Model.DriverStatusEnum;
import org.Model.Model.OrderStatusEnum;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("Facade")
class FacadeTest {

    @Mocked
    private IOrderDAO mockOrderDAO;

    @Mocked
    private IUserDAO mockUserDAO;

    @Mocked
    private IDAOFactory mockFactory;

    private Facade facade;

    @BeforeEach
    void setUp() {
        // Zainicjalizowanie fabryki, która zwróci zamockowany obiekt mockOrderDAO
        facade = new Facade(mockFactory);
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

}