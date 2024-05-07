package pilha;

import java.util.Scanner;

public class TestarAlunosExpulsos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Digite o tamanho da Pilha: ");
		int tamPilha = teclado.nextInt();
		
		PilhaContig pilha = new PilhaContig(tamPilha);
		
		pilha.removeAlunosEvento(null);
	}
}
