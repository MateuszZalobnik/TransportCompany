package org.Presenter.Presenter;

import org.Model.Model.IModel;

public class AutoValuationStrategy implements IValuationStrategy {
    @Override
    public float DoAlgorithm(GetValuationRequest Request, IModel model) {
        return Request.Weight * 15f;
    }
}