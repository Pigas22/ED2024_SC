package simplesmente;

import dados.Item;

public class TestarQuestao09 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(8));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(2));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(10));
		
		int[] pares = lista.valoresPares();
		
		if (pares[0] == 0) {
			System.out.println("Sem números pares.");
			
		} else {
			System.out.print("Números Pares: ");
			for (int i = 0; pares[i]!= 0; i++) {
				System.out.print("" + pares[i] + " ");				
			}
			
		}
	}

}
