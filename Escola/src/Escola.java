import java.util.ArrayList;
import java.util.List;

public class Escola {

	private String nome;
	private int capacidade;
	public List<Professor> listaProfessor= new ArrayList<>();

	public Escola(String nome, int capacidade) {
		super();
		this.nome = nome;
		this.capacidade = capacidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public void AdicionarProfessor(Professor professor) {
		listaProfessor.add(professor);
		System.out.println(listaProfessor);
	}

	public List<Professor> verProfessor() {
		return listaProfessor;
	}

}
