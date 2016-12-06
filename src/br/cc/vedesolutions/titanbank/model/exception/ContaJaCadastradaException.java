package br.cc.vedesolutions.titanbank.model.exception;

import java.io.IOException;

//metodo que verifica se a conta já estiver cadastrada

public class ContaJaCadastradaException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 6981751099275877256L;

	public ContaJaCadastradaException() throws IOException {
		super("Ja existe uma conta cadastrada.");
		// TODO Auto-generated constructor stub

	}
}
