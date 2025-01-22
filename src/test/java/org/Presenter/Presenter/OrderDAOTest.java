package org.Presenter.Presenter;

import org.Model.Model.Facade;
import org.Model.Model.IModel;
import org.Model.Model.Order;
import mockit.*;
import mockit.integration.junit5.JMockitExtension;
import org.Model.Model.OrderStatusEnum;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(JMockitExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Order tests
class OrderDAOTest {

    @Mocked
    private IModel model;

    @Tested
    private OrderDAO orderDAO;

    @BeforeEach
    void setUp() {
        model = new Facade();
        orderDAO = new OrderDAO(model);
    }

    @Test
    //@Order(1)
    void addOrder() {
        Order newOrder = new Order();
        newOrder.Id = 1;


        new Expectations() {{
            model.AddOrder(newOrder);
        }};

        orderDAO.AddOrder(newOrder);


        new Verifications() {{
            model.AddOrder((Order) any);
            times = 1;
        }};
    }
}
