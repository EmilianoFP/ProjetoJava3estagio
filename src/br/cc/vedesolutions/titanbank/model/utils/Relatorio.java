package br.cc.vedesolutions.titanbank.model.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import br.cc.vedesolutions.titanbank.model.Cliente;

public class Relatorio {



	final String header =
	"TITAN BANK - VEDE SOLUTUIONS. Inc\n"+
	"Vers�o: 1.0" +
	"\nAno: "+Calendar.getInstance().get(Calendar.YEAR)
	+ "\nRelat�rio: vers�o 1.0" +
	"\nData: " + Calendar.getInstance().getTime().toString() +
	"\n\n"
	+ "============================================================";
	final String footer = "suporte@titanbank.com\n" + "\nEmiliano de Freitas\n" + "Victor Nascimento\n" + "Diogo Dornelas\n"
			+ "Edyara Ara�jo\n\n"
			+ "============================================================";

	Set<Cliente> hashSet = new HashSet<Cliente>();
	private String filepath;

	public String getFilePath(){
		return this.filepath;
	}

	public void salvarRelatorio() {
		if (hashSet.size() > 0) {
			File testDir = new File("./relatorios");
			if (testDir.exists() == false)
				testDir.mkdir();
			File file = new File("./relatorios/relatorio" + Calendar.getInstance().getTime().toString().replaceAll(" ", "_").replaceAll(":","_") + ".txt");
			try {
				this.filepath = file.getAbsolutePath();
				PrintWriter pw = new PrintWriter(file);
				pw.println(header);
				for (Cliente cliente : hashSet) {
					pw.println(cliente.toString());
				}
				pw.println(footer);
				pw.close();
			} catch ( FileNotFoundException e){
				System.out.println(e.getMessage());
			}

		}

	}

	public void addClients(Cliente cl) {
		hashSet.add(cl);
	}

	public void cleanList() {
		this.hashSet.clear();
	}

}
