package org.Presenter.Presenter;

import org.Model.Model.IModel;

public class ValuationContext {

	private IValuationStrategy IStrategy;

	/**
	 * 
	 * @param Strategy
	 */
	public void SetStrategy(IValuationStrategy Strategy) {
		this.IStrategy = Strategy;
	}

	/**
	 * 
	 * @param Request
	 */
	public float DoBusinessLogic(GetValuationRequest Request, IModel model) {
		return IStrategy.DoAlgorithm(Request, model);
	}

	/**
	 * 
	 * @param request
	 */
	public ValuationContext(GetValuationRequest request) {
		if (request.IsManualValuation == false) {
			SetStrategy(new AutoValuationStrategy());
		} else {
			SetStrategy(new ManualValuationStrategy());
		}
	}

}