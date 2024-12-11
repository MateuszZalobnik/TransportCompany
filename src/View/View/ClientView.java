package View.View;

import Presenter.Presenter.Facade;
import Presenter.Presenter.GetValuationRequest;

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
		Presenter.Presenter.IPresenter presenter = new Facade();
		GetValuationRequest request = new GetValuationRequest(); //No attributes inside
		float valuation = presenter.GetValuation(request);
	}

	@Override
	public void Display() {

	}
}