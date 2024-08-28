package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class UpdateManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			//save variables with data to insert in the database
			Manuscrito manuscrito = new Manuscrito();
			
			manuscrito.setId (JOptionPane.showInputDialog
					("Insira o ID do manuscrito: "));
			
			manuscrito.setTitulo (JOptionPane.showInputDialog
					("Insira o título do manuscrito: "));
			
			manuscrito.setAutor(JOptionPane.showInputDialog
					("Insira o nome do autor do manuscrito: "));
			
			String sql = "update manuscrito set titulo = ? , autor = ? where id = ?;";
			
			System.out.println(sql);
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, manuscrito.getTitulo());
			cmd.setString(2, manuscrito.getAutor());
			cmd.setString(3, manuscrito.getId());
			
			cmd.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Dado atualizado com sucesso!");
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
