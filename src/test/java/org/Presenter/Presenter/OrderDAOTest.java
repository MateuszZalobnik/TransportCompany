package org.Presenter.Presenter;

import org.Model.Model.Facade;
import org.Model.Model.IModel;
import org.Model.Model.Order;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

// Apply Mockito extension
@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Order tests
class OrderDAOTest {

    @Mock
    private IModel model; // Mock the model

    @InjectMocks
    private OrderDAO orderDAO; // the mock into OrderDAO

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this); // Initi mocks
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close(); // Closing mocks
    }

    @Test
    //@Order(1)
    void addOrder() {
        Order newOrder = new Order();
        newOrder.Id = 1;

        orderDAO.AddOrder(newOrder);

        verify(model, times(1)).AddOrder(any(Order.class)); // Verify AddOrder was called
    }

    @Test
    //@Order(2)
    void updateOrder() {
        Order updatedOrder = new Order();
        updatedOrder.Id = 1;

        orderDAO.UpdateOrder(updatedOrder);

        verify(model, times(1)).UpdateOrder(any(Order.class)); // Verify UpdateOrder was called
    }
}
