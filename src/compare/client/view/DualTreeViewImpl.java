package compare.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

public class DualTreeViewImpl extends Composite implements DualTreeView {

	private static DualTreeViewUiBinder uiBinder = GWT
			.create(DualTreeViewUiBinder.class);

	@UiTemplate("DualTreeView.ui.xml")
	interface DualTreeViewUiBinder extends UiBinder<Widget, DualTreeViewImpl> {
	}
	
	@UiField
	RadioButton radioButtonA;
	
	@UiField
	RadioButton radioButtonB;
	
	@UiField
	TreeViewImpl treeView;

	private Presenter presenter;
	
	public DualTreeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		this.radioButtonA.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				presenter.onValueChangeA(event.getValue());
			}
		});
		this.radioButtonB.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				presenter.onValueChangeB(event.getValue());
			}
		});
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public TreeView getTreeView() {
		return treeView;
	}

}
