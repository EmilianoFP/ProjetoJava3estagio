package br.cc.vedesolutions.titanbank.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.cc.vedesolutions.titanbank.screenframework.IControlledScreen;
import br.cc.vedesolutions.titanbank.screenframework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AboutScreenController  implements Initializable, IControlledScreen {

	@FXML
	private Label lblText;

	@FXML
	private Label lblTitle;

	@FXML
	private Button btnOk;

	private ScreensController myController;

	@FXML
	void btnOkOnAction (ActionEvent event) {
		this.myController.setScreen("adm_main");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.lblText.setText(String.format("Versao: 1.0.0.0%n%n" +
		                     "Software desenvolvido para o projeto da disciplina de%n" +
				             "Metodologia e Linguagem de Programacao III do%n" +
		                     "Centro Universitario de Joao Pessoa - UNIPE.%n%n" +
				             "Integrantes:%n" +
		                     "Emiliano de Freitas%n" +
				             "Victor Nascimento%n" +
		                     "Diogo Dornelas%n" +
				             "Edyara Araújo%n%n"));
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		// TODO Auto-generated method stub
		this.myController = screenPage;
	}

}
