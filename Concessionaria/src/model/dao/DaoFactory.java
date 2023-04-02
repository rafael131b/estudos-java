package model.dao;

import db.DB;
import db.DbException;
import model.impl.CarroDaoJDBC;
import model.impl.PessoaDaoJDBC;

public class DaoFactory {

	public static CarroDao createCarroDao() throws DbException {
		return new CarroDaoJDBC(DB.getConexao());
	}
	
	
	public static PessoaDao createPessoa() throws DbException {
		return new PessoaDaoJDBC(DB.getConexao());
	}
	
}
