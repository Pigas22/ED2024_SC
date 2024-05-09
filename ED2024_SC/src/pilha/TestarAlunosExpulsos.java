package pilha;

import java.util.Scanner;

import dados.Item;
import duplamente.ListaDupla;

public class TestarAlunosExpulsos {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite o tamanho da Pilha: ");
		int tamPilha = teclado.nextInt();

		PilhaContig pilha = new PilhaContig(tamPilha);


		for (int i = 0; i < tamPilha; i ++) {
			System.out.print("Digite o nome do Competidor:");
			String competidor = teclado.next();		

			pilha.empilhar(new Item(competidor));
		}

		System.out.println("Digite o nome dos Alunos separados por Vírgulas (,), Ponto (.), Dois Pontos (:) ou Ponto e Vírgula (;): ");
		String nomeAlunosExpulsos = teclado.next();


		ListaDupla listaTeste = pilha.removeAlunosEvento(nomeAlunosExpulsos);


		System.out.println(listaTeste.toString());


		for (int i = 0; i <= pilha.getTopo(); i++) {
			System.out.print(pilha.desempilhar().getNome() + "; ");
		}

		teclado.close();
	}
}