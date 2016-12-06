package br.cc.vedesolutions.titanbank.model;

//metodo que cria acoes da Conta

public interface IContaActions {
	public void creditar (double valor);
	public double debitar (double valor);
	public boolean transferir (Cliente c, double valor);
}
