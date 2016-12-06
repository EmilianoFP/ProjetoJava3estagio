package br.cc.vedesolutions.titanbank.persistence;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.cc.vedesolutions.titanbank.model.exception.DefaultExceptionDialog;

public class DBConnectionManager implements IDBConnection {

	// metodo que faz o gerenciamento da conex�o com o DB

	private static DBConnectionManager uniqueInstance = new DBConnectionManager();
	private Connection con;
	private Statement st;
	private DatabaseConfigLoader dbLoader;

	private DBConnectionManager() {
		try {
			con = null;
			st = null;
			this.dbLoader = DatabaseConfigLoader.getInstance("./resources/config/database.properties");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		} catch (InstantiationException e) {
			DefaultExceptionDialog ed = new DefaultExceptionDialog("Houve um erro na instânciação do objeto\n"
					+ e.getMessage() +"\nClasse: "+this.getClass().toString());
			ed.showDialog();
		} catch (IllegalAccessException e){
			DefaultExceptionDialog ed = new DefaultExceptionDialog("Houve uma violação de acesso na parte de instância\n"+
					"a conexão com o banco de dados\n"+ e.getMessage() +"\nClasse: "+this.getClass().getName());
			ed.showDialog();
		} catch (ClassNotFoundException e){
			DefaultExceptionDialog ed = new DefaultExceptionDialog("Classe não existe: "+e.getClass().getName());
			ed.showDialog();
		} catch (FileNotFoundException e){
			DefaultExceptionDialog ed = new DefaultExceptionDialog("Arquivo database.properties não existe");
			ed.showDialog();
		}
	}

	public static DBConnectionManager getInstance() {
		return uniqueInstance;
	}

	@Override
	public boolean open() {
		try {
			this.con = DriverManager.getConnection(this.dbLoader.getHost(), this.dbLoader.getName(),
					this.dbLoader.getPass());
			st = con.createStatement();
			if (con != null) {
				System.out.println("Debug: Conexão Ativa");
				return true;
			} else
				System.out.println("Debug: Conexão Inativa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			if (this.con.isClosed() == false)
				this.con.close();
			if (this.st.isClosed() == false)
				this.st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet execute(String Query) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			rs = this.st.executeQuery(Query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
}
