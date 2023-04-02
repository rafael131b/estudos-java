

import DAO.ProfessorDao;
import db.DB;
import db.DbException;

public class Program {
	public static void main(String[] args) throws DbException {
		
		Escola escola=new Escola("Albino Fiore",280);
		
		Professor Aline=new Professor("Aline Castro", "44400022211", 19, "Química", 2900);
		Professor Paulo=new Professor ("Paulo Rocha","20099922201",32,"Historia",3000);
		
		escola.AdicionarProfessor(Paulo);
		escola.AdicionarProfessor(Aline);
		
	
	
		try { 
			
			DB.conectar(); 
			
//			for (Professor prof:escola.verProfessor()) {
//				ProfessorDao.adicionarBanco(prof.getNome(),prof.getCpf(),prof.getIdade(),prof.getMateria(),prof.getIdade());
//			}
			
			ProfessorDao.consulta("44400022211");
			ProfessorDao.update("20099922201",4000.00);
			
//			
//			ProfessorDao.deletarBanco();
			
		} catch (DbException e) {
			throw new DbException(e.getMessage());
			
		}
		
		
		
	}
}
