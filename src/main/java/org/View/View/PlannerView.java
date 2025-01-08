package org.View.View;


import org.Presenter.Presenter.Facade;
import org.Presenter.Presenter.IPresenter;

public class PlannerView implements IDisplay {

	public void DisplayOrdersAndDrivers() {
		// TODO - implement PlannerView.DisplayOrdersAndDrivers
		throw new UnsupportedOperationException();
	}

	public void AssignDriverToOrder() {
		IPresenter presenter = new Facade();
		presenter.AssignDriverToOrder(1,1);
	}

	@Override
	public void Display() {

	}
}