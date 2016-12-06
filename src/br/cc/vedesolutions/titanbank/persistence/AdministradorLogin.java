package br.cc.vedesolutions.titanbank.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cc.vedesolutions.titanbank.model.Administrador;
import br.cc.vedesolutions.titanbank.model.exception.LoginIncorretoException;
import br.cc.vedesolutions.titanbank.model.utils.BuilderPassword;
import br.cc.vedesolutions.titanbank.model.utils.Hash;

// metodo que faz chamada dos dados do adm

public class AdministradorLogin {

	private String userName;
	private List<String> senha;
	private Administrador adm;

	public boolean login() throws RuntimeException, IOException, LoginIncorretoException, SQLException{
		AdministradorDAO admDao = new AdministradorDAO();
		this.adm = admDao.login(this.userName);
		if (this.adm == null || BuilderPassword.decryptPassword(senha, Hash.decode(adm.getPassword()))==false){
			throw new LoginIncorretoException();
		}
		return true;
	}


	public AdministradorLogin(String login, List<String> senha) {
		this.userName = login;
		this.senha = senha;
	}

}
