package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.run;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view.WWMMainView;

public class Run {

	public static void main(String[] args) {
		WWMModel model = new WWMModel("/Users/erikmartens/Dropbox/Projekte/Software Development/EclipseWorkspace/de.hs_mannheim.SS16.IB.oot.gruppeWER/");
		
		new WWMMainView(model, new WWMController(model));
	}
}