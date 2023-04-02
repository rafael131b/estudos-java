
public class Professor extends Pessoas {

	private String materia;
	private double salario;

	public Professor(String nome,String cpf,int idade,String materia, double salario) {
		super(nome,cpf,idade);
		this.materia=materia;
		this.salario=salario;
		

	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " +  this.getNome() + " cpf " + this.getCpf();
	}

}
