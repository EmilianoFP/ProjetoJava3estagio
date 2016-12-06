package br.cc.vedesolutions.titanbank.model.exception;

import java.io.IOException;

//metodo que verifica se os dados login/senha estão corretos

public class LoginIncorretoException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 6985543942949089134L;

	public LoginIncorretoException() throws RuntimeException, IOException {
		super("Login ou senha incorretos. Não é possível entrar no sistema");
		// TODO Auto-generated constructor stub
	}
}
