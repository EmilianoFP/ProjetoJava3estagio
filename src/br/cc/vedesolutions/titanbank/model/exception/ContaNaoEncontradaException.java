package br.cc.vedesolutions.titanbank.model.exception;

import java.io.IOException;

//metodo que verifica se a conta existe

public class ContaNaoEncontradaException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 303964344011775471L;

	public ContaNaoEncontradaException() throws IOException {
		super("Nao foram encontradas informacoes com as entradas colocadas.");
		// TODO Auto-generated constructor stub
	}

}
