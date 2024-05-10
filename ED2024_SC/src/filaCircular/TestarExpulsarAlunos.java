package filaCircular;

import java.util.Scanner;

import dados.Item;
import duplamente.ListaDupla;

public class TestarExpulsarAlunos {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ListaDupla listaSaida;
		Item pessoaItem; 

		System.out.print("| Digite o tamanho da Fila: ");
		int tamanho = teclado.nextInt();


		System.out.println("\n========================================");
		FilaCircular fila = new FilaCircular(tamanho);
		
		for (int i = 0; i < tamanho; i++) {

			System.out.print("Digite o nome " + (i+1) + "° da Pessoa: ");
			pessoaItem = new Item(teclado.next().toLowerCase());

			fila.enfileirar(pessoaItem);
		}


		System.out.println("\n========================================");
		System.out.print("| Digite o nome das Pessoas separadas por Vígulas, Ponto e Vírgula, Dois Pontos ou Ponto:"
				+ "\nR: ");
		String nomeAlunos = teclado.next();


		System.out.println("\n========================================");
		listaSaida = fila.removeAlunos(nomeAlunos);
		
		
		System.out.println("========================================");
		System.out.println("| Lista Atual de Alunos na Fila: ");
		System.out.println(fila.toStringQuestao07());
		System.out.println("========================================");
		
		
		if (listaSaida.eVazia()) {
			System.out.println("| Nenhum aluno foi removido.\n");

		} else {
			System.out.println("| Lista de Alunos removidos: ");
			System.out.println(listaSaida.toString());

		}

		teclado.close();
	}
}
