package org.Model.Model;

import mockit.Verifications;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("Facade")
class FacadeTest {

    private Facade facade;


    @BeforeEach
    void setUp() {
        facade = new Facade();
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void testAddOrder() {
        Order newOrder = new Order();
        newOrder.Id = 124;

        var initialOrderCount = facade.getOrders().length;

        facade.AddOrder(newOrder);

        assertEquals(initialOrderCount + 1, facade.getOrders().length, "Order count should be increased by 1 after adding a new order.");

        new Verifications() {{
            facade.AddOrder(newOrder);
            times = 1;
        }};
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void testUpdateOrder() {
        int orderId = 123;
        var mockOrder = new Order();
        mockOrder.Id = orderId;
        mockOrder.Status = OrderStatusEnum.New;
        mockOrder.Date = "2025-01-19";
        mockOrder.Weight = 10;
        mockOrder.Price = 100.0;

        facade.AddOrder(mockOrder);

        Order updatedOrder = new Order();
        updatedOrder.Id = orderId;
        updatedOrder.Status = OrderStatusEnum.ReadyToAssign;
        updatedOrder.Date = "2025-01-20";
        updatedOrder.Weight = 15;
        updatedOrder.Price = 120.0;

        facade.UpdateOrder(updatedOrder);

        assertEquals(OrderStatusEnum.ReadyToAssign, mockOrder.Status, "Order status should be updated.");
        assertEquals("2025-01-20", mockOrder.Date, "Date should be updated.");
        assertEquals(15, mockOrder.Weight, "Weight should be updated.");
        assertEquals(120.0, mockOrder.Price, "Price should be updated.");

        new Verifications() {{
            facade.UpdateOrder(updatedOrder);
            times = 1;
        }};
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void deleteOrder() {
        Order orderToDelete = new Order();
        orderToDelete.Id = 1;
        orderToDelete.Status = OrderStatusEnum.New;

        facade.AddOrder(orderToDelete);

        var initialOrderCount = facade.getOrders().length;

        facade.DeleteOrder(orderToDelete);

        assertEquals(initialOrderCount - 1, facade.getOrders().length, "Order count should decrease by 1 after deleting the order.");
    }
}
