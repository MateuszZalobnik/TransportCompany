package org.View.View;


import org.Presenter.Presenter.Facade;
import org.Presenter.Presenter.GetValuationRequest;
import org.Presenter.Presenter.IPresenter;

public class ClientView implements IDisplay {

	public void DisplayOrders() {
		// TODO - implement ClientView.DisplayOrders
		throw new UnsupportedOperationException();
	}

	public void PayForOrder() {
		// TODO - implement ClientView.PayForOrder
		throw new UnsupportedOperationException();
	}

	public void ValuateOrder() {
		IPresenter presenter = new Facade();
		GetValuationRequest request = new GetValuationRequest(); //No attributes inside
		float valuation = presenter.GetValuation(request);
	}

	@Override
	public void Display() {

	}
}