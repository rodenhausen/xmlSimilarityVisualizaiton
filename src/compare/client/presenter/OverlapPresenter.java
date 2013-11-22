package compare.client.presenter;

import compare.client.view.OverlapView;
import compare.shared.algo.Result;

public class OverlapPresenter implements OverlapView.Presenter {

	private OverlapView view;

	public OverlapPresenter(OverlapView view) {
		this.view = view;
		view.setPresenter(this);
	}
	
	public void setData(Result result) {
		view.setData(result);
	}
	
}
