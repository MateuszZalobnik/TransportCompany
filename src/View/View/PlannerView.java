package View.View;

import Presenter.Presenter.Facade;

public class PlannerView implements IDisplay {

	public void DisplayOrdersAndDrivers() {
		// TODO - implement PlannerView.DisplayOrdersAndDrivers
		throw new UnsupportedOperationException();
	}

	public void AssignDriverToOrder() {
		Presenter.Presenter.IPresenter presenter = new Facade();
		presenter.AssignDriverToOrder(1,1);
	}

	@Override
	public void Display() {

	}
}