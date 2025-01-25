package org.Presenter.Presenter;

import org.Model.Model.IModel;

public interface IValuationStrategy {

	/**
	 * 
	 * @param Request
	 */
	float DoAlgorithm(GetValuationRequest Request, IModel model);

}