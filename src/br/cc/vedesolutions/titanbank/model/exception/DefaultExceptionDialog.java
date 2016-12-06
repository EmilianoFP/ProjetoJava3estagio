package br.cc.vedesolutions.titanbank.model.exception;

import br.cc.vedesolutions.titanbank.model.utils.MessageDialog;
import javafx.scene.control.Alert;

//metodo padrao das caixas de dialogo (para mensagens de erro, por exemplo)

public class DefaultExceptionDialog extends MessageDialog {

	public DefaultExceptionDialog(String dialogMessage) {
		super("Titan Bank", null, dialogMessage, Alert.AlertType.ERROR);
		// TODO Auto-generated constructor stub
	}


}
