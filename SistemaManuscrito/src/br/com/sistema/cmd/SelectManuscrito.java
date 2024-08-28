package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			//create database to export data
			String sql = "select * from manuscrito";
			PreparedStatement cmd = conexao.prepareStatement(sql);
			ResultSet resultado = cmd.executeQuery();
			
			//create variable to receive data
			String manuscritos;
			manuscritos = "<<Manuscritos encontrados!>>\n";
			while(resultado.next())  {
				manuscritos += "ID: " + resultado.getInt("id") + "- Titulo: " + resultado.getString("titulo") + "- Autor: " + resultado.getString("autor") + "\n"; 
			}
			JOptionPane.showMessageDialog(null, manuscritos);
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
