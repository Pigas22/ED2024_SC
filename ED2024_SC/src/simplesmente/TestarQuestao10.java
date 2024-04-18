package simplesmente;

import dados.Item;

public class TestarQuestao10 {
	public static void main(String [] args) {
		ListaSimples lista1 = new ListaSimples();
		ListaSimples lista2 = new ListaSimples();

		lista1.inserirUltimo(new Item(10));
		lista1.inserirUltimo(new Item(8));
		lista1.inserirUltimo(new Item(3));

		lista2.inserirUltimo(new Item(10));
		lista2.inserirUltimo(new Item(5));
		lista2.inserirUltimo(new Item(3));

		if (lista1.verificarIdentica(lista2)) {
			System.out.println("As listas são idênticas.");
		} else {
			System.out.println("As listas não são idênticas.");
		}
	}
}
