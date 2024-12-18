package Presenter.Presenter;

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
	public float DoBussinessLogic(GetValuationRequest Request) {
		return IStrategy.DoAlgorithm(Request);
	}

	/**
	 * 
	 * @param request
	 */
	public ValuationContext(GetValuationRequest request) {
		if (request.IsManualValuation == false){
			SetStrategy(new AutoValuationStrategy());
		}else {
			SetStrategy(new ManualValuationStrategy());
		}
	}

}