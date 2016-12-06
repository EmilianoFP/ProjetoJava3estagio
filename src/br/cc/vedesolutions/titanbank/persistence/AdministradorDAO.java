package br.cc.vedesolutions.titanbank.persistence;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cc.vedesolutions.titanbank.model.Administrador;
import br.cc.vedesolutions.titanbank.model.exception.LoginIncorretoException;

//Metodo para conexao com a DB do administrador

public class AdministradorDAO {

	private IDBConnection DbConnector = DBConnectionManager.getInstance();
	private final String TB_ADMINISTRADOR = "`tb_administrador`";

	public Administrador login(String admUserName)
			throws LoginIncorretoException, RuntimeException, IOException {
		final String sql = "SELECT * FROM " + TB_ADMINISTRADOR + " WHERE `LOGIN` = \"%s\"";
		String Query = String.format(sql, admUserName);
		Administrador adm = null;
		if (DbConnector.open()) {
			try {
				ResultSet rs = DbConnector.execute(Query);
				if (rs.next()) {
					adm = new Administrador(rs.getLong("ID"), rs.getString("LOGIN"),
							rs.getString("SENHA"));
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println(
						"public Administrador login@Exception: " + e.getMessage() + "com codigo: " + e.getErrorCode());
			} finally {
				DbConnector.close();
			}
		}
		return adm;
	}
}
