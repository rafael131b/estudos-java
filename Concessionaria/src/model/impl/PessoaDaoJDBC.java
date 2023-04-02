package model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import entities.model.Carro;
import entities.model.Pessoa;
import model.dao.PessoaDao;

public class PessoaDaoJDBC implements PessoaDao {
	Connection conn = null;

	public PessoaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	public Pessoa inserir(String nome, String endereco, String telefone, String cpf) {

		ResultSet rs = null;
		PreparedStatement st = null;
		String sql = "INSERT INTO pessoas (nome, endereco, telefone, cpf) VALUES (?, ?, ?, ?)";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, endereco);
			st.setString(3, telefone);
			st.setString(4, cpf);

			int rowsAffected = st.executeUpdate();
			System.out.println("linhas afetadas" + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Nao foi possível salvar essa pessoa");
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM pessoas WHERE id = ?";
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();

			System.out.println("linhas afetadas" + rowsAffected);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void update(int id, String nome, String endereco, String telefone, String cpf) {
		ResultSet rs = null;
		PreparedStatement st = null;
		String sql = "UPDATE pessoas set nome=?,endereco=?,telefone=?,cpf=? WHERE id=?";

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, endereco);
			st.setString(3, telefone);
			st.setString(4, cpf);
			st.setInt(5, id);

			int rowsAffected = st.executeUpdate();

			System.out.println("linhas afetadas" + rowsAffected);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(int id, String endereco, String telefone) {
		ResultSet rs = null;
		PreparedStatement st = null;
		String sql = "UPDATE pessoas set endereco=?,telefone=? WHERE id=?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, endereco);
			st.setString(2, telefone);
			st.setInt(3, id);

			int rowsAffected = st.executeUpdate();

			System.out.println("linhas afetadas" + rowsAffected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pessoa findById(int id) {
		ResultSet rs = null;
		PreparedStatement st = null;
		String sql = "SELECT * FROM pessoas WHERE id = ?";

		return null;

	}

	@Override
	public List<Pessoa> findAll() {

		return null;
	}

	@Override
	public Pessoa inserir(Pessoa obj) {
		ResultSet rs = null;
		PreparedStatement st = null;

		try {
			String sql = "INSERT INTO pessoas (nome, endereco, telefone, cpf) VALUES (?, ?, ?, ?)";
			st = conn.prepareStatement(sql);
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEndereco());
			st.setString(3, obj.getTelefone());
			st.setString(4, obj.getCpf());

			int rowsAffected = st.executeUpdate();
			System.out.println("linhas afetadas" + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Nao foi possível salvar essa pessoa");
			e.printStackTrace();
		}
		return obj;

	}

}
