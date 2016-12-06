package br.cc.vedesolutions.titanbank.screenframework;

import br.cc.vedesolutions.titanbank.screenframework.ScreensController;

public interface IControlledScreen {
	//Este metodo permite a introdução de telas no ScreenPane
	public void setScreenParent(ScreensController screenPage);
}
