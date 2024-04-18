package simplesmente;

import dados.Item;
import java.util.Scanner;

public class TestarQuestao11 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		Scanner teclado = new Scanner(System.in);
		
		lista.inserirUltimo(new Item(4));
		lista.inserirUltimo(new Item(9));
		lista.inserirUltimo(new Item(8));
		lista.inserirUltimo(new Item(56));
		lista.inserirUltimo(new Item(2));
		
		System.out.print("Digite o número que deseja procurar: ");
		int num = teclado.nextInt();
		boolean achou = lista.procuraNum(num);
		
		if (achou) {
			System.out.println("O número " + num + " foi encontrado.");
		} else {
			System.out.println("Não foi possível encontrar o número " + num + ".");
		}
		System.out.println(lista.toString());
		
		teclado.close();
	}
}
