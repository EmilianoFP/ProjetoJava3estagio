package br.cc.vedesolutions.titanbank.persistence;

import java.sql.ResultSet;

//metodo que inicializa/finaliza a conexao com o banco

public interface IDBConnection {
	public boolean open();
	public void close();
	public ResultSet execute(String Query);
}
