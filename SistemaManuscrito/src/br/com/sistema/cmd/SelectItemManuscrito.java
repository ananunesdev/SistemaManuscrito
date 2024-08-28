package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectItemManuscrito {

	public static void main(String[] args) {
		try {
			//open connection with database
			Connection conexao = ConnectionFactory.createConnection();
			
			//create variable to search for record in the database
			String id;
			
			//ID receives the value typed by user
			
			id = JOptionPane.showInputDialog("Digite o ID do manuscrito: ");
			
			//create sql to extract data
			
			String sql;
			sql = "select * manuscrito where id = " + id + ";";
			
			//text in database
			//System.out.println(sql);
			
			//prepare to receive data
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//execute
			ResultSet resultado = cmd.executeQuery();
			
			String manuscritos;
			manuscritos = "<<Manuscritos encontrados!>>\n";
			while(resultado.next())  {
				manuscritos += "ID: " + resultado.getInt("id") + "- Titulo: " + resultado.getString("titulo") + "- Autor: " + resultado.getString("autor") + "\n"; 
			}
			JOptionPane.showMessageDialog(null, manuscritos);
			conexao.close();
			
		} catch (Exception e) {
			
		}

	}

}
