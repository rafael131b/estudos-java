package model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import entities.model.Carro;
import model.dao.CarroDao;

public class CarroDaoJDBC implements CarroDao {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement st = null;
	List<Carro> listaCarros = new ArrayList<>();

	public CarroDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Carro car) {

		String sql = "INSERT INTO carro (marca,modelo,ano,preco) VALUES (?,?,?,?)";

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, car.getMarca());
			st.setString(2, car.getModelo());
			st.setInt(3, car.getAno());
			st.setDouble(4, car.getPreco());

			int linhasAfetadas = st.executeUpdate();

			System.out.println("linhas afetadas");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM carro WHERE id=?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);

			int linhasAfetadas = st.executeUpdate();
			System.out.println("Linhas apagadas" + linhasAfetadas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Carro car, int id) {
		PreparedStatement st = null;
		String sql = "UPDATE carro SET modelo = ?, marca = ?, ano = ?, preco = ? WHERE id = ?";

		try {
			st = conn.prepareStatement(sql);

			st.setString(1, car.getModelo());
			st.setString(2, car.getMarca());
			st.setInt(3, car.getAno());
			st.setDouble(4, car.getPreco());

			st.setInt(5, id);
			int linhasAfetadas = st.executeUpdate();
			System.out.println("Linhas atualizadas" + linhasAfetadas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Carro findById(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM carro WHERE id = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");
				double preco = rs.getDouble("preco");
				System.out.println("Marca: " + marca);
				System.out.println("Modelo: " + modelo);
				System.out.println("Ano: " + ano);
				System.out.println("Preço: " + preco);
			} else {
				System.out.println("Carro não encontrado.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

//	private List<Carro> carroInstantiante(ResultSet rs) {
//		Carro car = null;
//		try {
//			while (rs.next()) {
//				car = new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getDouble("ano"));
//				listaCarros.add(car);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listaCarros;
//	}

	private Carro carroInstantiante(ResultSet rs) {
		Carro car = null;
		try {
			car = new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getDouble("ano"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public List<Carro> findAll() {

		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT  * FROM carro";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Carro carroTemp = carroInstantiante(rs);

				System.out.println(carroTemp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
	
