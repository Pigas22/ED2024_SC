package simplesmente;

import dados.Item;

public class TestarQuestsao12 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();

		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(6));
		lista.inserirUltimo(new Item(4));
		lista.inserirUltimo(new Item(235));
		lista.inserirUltimo(new Item(15));
		
		int nos = lista.achaNum(5);
		
		if (nos == -1) {
			System.out.println("Número não encontrado, foi adicionado ao final da lista");
		} else {
			System.out.println("Número encontrado no Nó: " + nos);	
		}
		System.out.println(lista.toString());
	}
}
