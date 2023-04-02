package program;

import java.util.Scanner;

import db.db;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o nome ");
		String nome= scan.next();
		scan.next();
		
		System.out.println("Digite a idade ");
		int idade=scan.nextInt();
		System.out.println("Digite a profissão ");
		String profissao= scan.next();
		
		System.out.println("o nome é " + nome + "idade : " +idade + " profissao " + profissao );
		
		
		db.conectar();
		db.adicionar(nome,idade,profissao);
//		db.deletar(1);
//		db.atualizar(2,"Laura Bolsonaro",13,"Filha do Presidente");
	}

}
