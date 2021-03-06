package br.cc.vedesolutions.titanbank.ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.cc.vedesolutions.titanbank.model.Cliente;
import br.cc.vedesolutions.titanbank.model.exception.LoginIncorretoException;
import br.cc.vedesolutions.titanbank.model.utils.GlobalInfor;
import br.cc.vedesolutions.titanbank.model.utils.MessageDialog;
import br.cc.vedesolutions.titanbank.persistence.ClienteDAO;
import br.cc.vedesolutions.titanbank.screenframework.IControlledScreen;
import br.cc.vedesolutions.titanbank.screenframework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserLoginScreenController implements Initializable, IControlledScreen {

	@FXML
	private ResourceBundle resources;

	@FXML
	private ImageView btnAdmScreen;

	@FXML
	private VBox vBoxMain;

	@FXML
	private URL location;

	@FXML
	private Button btnLogin;

	@FXML
	private TextField editAgencia;

	@FXML
	private TextField editConta;

	@FXML
	private Button btnAbout;

	private ScreensController myController;

	@FXML
	void btnLoginOnAction(ActionEvent event) throws NumberFormatException, RuntimeException, IOException {
		MessageDialog md = new MessageDialog();
		if (this.editAgencia.getText().length() > 0 && this.editConta.getText().length() > 0
				&& this.editAgencia.getText().matches("\\d+") && this.editConta.getText().matches("\\d+")) {
			try {
			    ClienteDAO clDAO = new ClienteDAO();
				Cliente cl = clDAO.login(Long.parseLong(this.editConta.getText().trim()),
						Long.parseLong(this.editAgencia.getText().trim()));
				GlobalInfor.cliente_logged = cl;
				this.myController.unloadScreen("user_logged");
				this.myController.loadScreen("user_logged",
						"./br/cc/vedesolutions/titanbank/ui/controllers/UserPrincipalScreen.fxml");
				this.myController.setScreen("user_logged");
				limparCampos();


			} catch (LoginIncorretoException e) {
				md.setBallonType(AlertType.ERROR);
				md.setDialogMessage(e.getMessage());
				md.showDialog();
			} catch (NumberFormatException e) {
				md.setBallonType(AlertType.ERROR);
				md.setDialogMessage("Par�metro incorreto");
				md.showDialog();
			}
		} else {
			md.setBallonType(AlertType.WARNING);
			md.setDialogMessage("Ag�nia e/ou conta inv�lida(as)");
			md.showDialog();
		}
	}

	private void limparCampos() {
		this.editAgencia.clear();
		this.editConta.clear();
	}

	@FXML
	void BtnAdminScreenOnClick(MouseEvent event) {
		this.editAgencia.clear();
		this.editConta.clear();
		((Stage) vBoxMain.getScene().getWindow()).setTitle("Titan Bank: Administra��o");
		this.myController.setScreen("adm_login_screen");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.resources = resources;
		this.location = location;
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		// TODO Auto-generated method stub
		this.myController = screenPage;
	}
}
