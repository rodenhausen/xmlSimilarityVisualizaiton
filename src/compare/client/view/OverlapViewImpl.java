package compare.client.view;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import compare.shared.algo.Result;
import edu.arizona.sirls.etc.site.client.view.annotationReview.ResultViewImpl;
import edu.arizona.sirls.etc.site.shared.rpc.file.search.SearchResult;

public class OverlapViewImpl extends Composite implements OverlapView {

	private static OverlapViewUiBinder uiBinder = GWT
			.create(OverlapViewUiBinder.class);

	@UiTemplate("OverlapView.ui.xml")
	interface OverlapViewUiBinder extends UiBinder<Widget, OverlapViewImpl> {
	}

	private Presenter presenter;

	@UiField
	StackLayoutPanel stackLayoutPanel;
	
	public OverlapViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setData(Result result) {
		stackLayoutPanel.clear();
		int headerSize = 20;
		int contentViewSize = 200;
		stackLayoutPanel.setHeight((headerSize*results.size() + contentViewSize)+"px");
		this.results = results;
		int matches = 0;
		Set<String> files = new HashSet<String>();
		for(SearchResult result : results) {
			matches += result.getFilePaths().size();
			files.addAll(result.getFilePaths());
			
			ScrollPanel scrollPanel = new ScrollPanel();
			VerticalPanel filesPanel = new VerticalPanel();
			for(final String target : result.getFilePaths()) {
				Anchor anchor = new Anchor(target);
				filesPanel.add(anchor);
				anchor.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						ResultViewImpl.this.presenter.onTargetClicked(target);
					}
				});
			}
			scrollPanel.add(filesPanel);
			Anchor headerAnchor = new Anchor(result.getCapturedMatch());
			headerAnchor.setTitle(result.getCapturedMatch());
			stackLayoutPanel.add(scrollPanel, headerAnchor, headerSize);
		}
	}

}
