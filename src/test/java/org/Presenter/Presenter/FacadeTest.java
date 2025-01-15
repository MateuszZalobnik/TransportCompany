package org.Presenter.Presenter;

import org.Model.Model.Driver;
import org.Model.Model.DriverStatusEnum;
import org.Model.Model.OrderStatusEnum;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FacadeTest {

    private IOrderDAO mockOrderDAO;
    private IUserDAO mockUserDAO;
    private IDAOFactory mockFactory;
    private Facade facade;

    @BeforeEach
    void setUp() {
        mockOrderDAO = mock(IOrderDAO.class);
        mockUserDAO = mock(IUserDAO.class);
        mockFactory = mock(IDAOFactory.class);

        when(mockFactory.CreateOrderDAO()).thenReturn(mockOrderDAO);
        when(mockFactory.CreateUserDAO()).thenReturn(mockUserDAO);

        facade = new Facade(mockFactory);
    }

    @Test
    @Order(1)
    void testPayForOrderChangesOrderStatus() {
        int orderId = 123;
        org.Model.Model.Order mockOrder = new org.Model.Model.Order();
        mockOrder.Id = orderId;
        mockOrder.Status = OrderStatusEnum.New;

        when(mockOrderDAO.GetOrderById(orderId)).thenReturn(mockOrder);

        facade.PayForOrder(orderId);

        assertEquals(OrderStatusEnum.ReadyToAssign, mockOrder.Status, "Order status should be changed to ReadyToAssign");
        verify(mockOrderDAO, times(1)).UpdateOrder(mockOrder);
    }

    @Test
    @Order(2)
    void assignDriverToOrder() {
        int orderId = 123;
        int driverId = 456;

        org.Model.Model.Order mockOrder = new org.Model.Model.Order();
        mockOrder.Id = orderId;
        mockOrder.Status = OrderStatusEnum.ReadyToAssign;

        Driver mockDriver = mock(Driver.class);
        mockDriver.Id = driverId;
        mockDriver.Status = DriverStatusEnum.Available;

        when(mockOrderDAO.GetOrderById(orderId)).thenReturn(mockOrder);
        when(mockUserDAO.GetUserById(driverId)).thenReturn(mockDriver);

        facade.AssignDriverToOrder(driverId, orderId);

        assertEquals(OrderStatusEnum.InProgress, mockOrder.Status, "Order status should be changed to InProgress");
        assertEquals(driverId, mockOrder.Driver.Id, "DriverId should be set to the driverId");
        assertEquals(DriverStatusEnum.Driving, mockDriver.Status, "Driver status should be changed to Driving");

        verify(mockOrderDAO, times(1)).UpdateOrder(mockOrder);
        verify(mockUserDAO, times(1)).UpdateUser(mockDriver);
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

        Driver mockDriver = mock(Driver.class);
        mockDriver.Id = driverId;

        when(mockOrderDAO.GetOrderById(orderId)).thenReturn(mockOrder);
        when(mockUserDAO.GetUserById(driverId)).thenReturn(mockDriver);

        facade.AssignDriverToOrder(driverId, orderId);

        assertEquals(expectedStatus, mockOrder.Status, "Order status should be updated correctly");
        verify(mockOrderDAO, times(1)).UpdateOrder(mockOrder);
    }
}