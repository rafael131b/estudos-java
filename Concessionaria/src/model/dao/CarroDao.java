package model.dao;

import java.util.List;

import entities.model.Carro;

public interface CarroDao {
	
	
	 public void inserir (Carro car);
	
	 public void delete(int id);
	 public void update(Carro car,int id);
	 public Carro findById(int id);
	 public List<Carro> findAll ();
	 

}
