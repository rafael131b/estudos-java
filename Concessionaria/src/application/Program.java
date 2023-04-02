package application;

import db.DbException;
import entities.model.Carro;
import entities.model.Pessoa;
import model.dao.CarroDao;
import model.dao.DaoFactory;
import model.dao.PessoaDao;

public class Program {

	public static void main(String[] args) throws DbException {
		
		CarroDao  carroDao=DaoFactory.createCarroDao();
		PessoaDao pessoaDao=DaoFactory.createPessoa();
//		Pessoa pessoa2= new Pessoa  ("Evelyn Torres","30009922","rua das ilusões","02020202020");
//		Carro uno=new Carro("gol", "uno milly fire", 2002, 6800.00);
//		carroDao.inserir(uno);
//		carroDao.update(uno,11);
		carroDao.findAll();
		
//		Pessoa pessoa=pessoaDao.findById(5);
//		pessoaDao.inserir(pessoa2);
//		Pessoa pessoa2=pessoaDao.inserir("Paulo souza","400289223","rua do limoeiro","000000000");
//		pessoaDao.delete(5);
//		pessoaDao.update(23, "rua da melancia", "9999-9999");
		
		
	
	}

}
