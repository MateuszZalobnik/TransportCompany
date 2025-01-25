package org.Presenter.Presenter;

import org.Model.Model.Address;
import org.Model.Model.IModel;
import org.Model.Model.Order;
import org.Model.Model.OrderStatusEnum;

public class ManualValuationStrategy implements IValuationStrategy {
    @Override
    public float DoAlgorithm(GetValuationRequest Request, IModel model) {
        var order = new Order();
        order.Weight = Request.Weight;
        order.Date = Request.Date;

        var endPoint = new Address();
        endPoint.Country = Request.EndCountry;
        endPoint.City = Request.StartCity;
        endPoint.Street = Request.EndStreet;
        endPoint.BlockNumber = Request.EndBlockNumber;
        endPoint.ZipCode = Request.EndZipCode;
        var startPoint = new Address();
        startPoint.Country = Request.StartCountry;
        startPoint.City = Request.EndCity;
        startPoint.Street = Request.StartStreet;
        startPoint.BlockNumber = Request.StartBlockNumber;
        startPoint.ZipCode = Request.StartZipCode;

        order.EndPoint = endPoint;
        order.StartPoint = startPoint;
        order.Status = OrderStatusEnum.InValuation;

        model.AddOrder(order);
        return -1;
    }
}