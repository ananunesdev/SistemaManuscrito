package br.com.sistema.cmd;

import java.sql.Connection;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;

public class CreateManuscrito {

	public static void main(String[] args) {
		try {
			//Import connection class with database
			Connection conexao = ConnectionFactory.createConnection();
			//Import transition data class database
			Manuscrito manuscrito = new Manuscrito();
			
			//send data to class Manuscrito
			
			manuscrito.setTitulo (JOptionPane.showInputDialog("Insira o título do manuscrito: "));
			manuscrito.setAutor(JOptionPane.showInputDialog("Insira o nome do autor do manuscrito: "));
			
			//create database to insert data 
			String sql = "insert into manuscrito (titulo, autor) values (?,?)";
			
			java.sql.PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, manuscrito.getTitulo());
			cmd.setString(2, manuscrito.getAutor());
			
			//execution
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Manuscrito inserido com sucesso!");
			
			cmd.close();
			
			
			
		} catch (Exception e) {
			
		}

	}

}
