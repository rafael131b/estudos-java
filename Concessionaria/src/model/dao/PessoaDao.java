package model.dao;


import java.sql.Date;
import java.util.List;

import entities.model.Carro;
import entities.model.Pessoa;



public interface PessoaDao {
	
	 public Pessoa inserir (Pessoa  obj);
	 public Pessoa inserir (String nome,String endereco,String telefone,String cpf);
	 public void delete(int id);
	 public void update(int id,String nome,String endereco,String telefone,String cpf);
	 public void update(int id,String endereco,String telefone);
	 public Pessoa findById(int id);
	 public List<Pessoa> findAll ();
	 

}
