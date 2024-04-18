package simplesmente;

import dados.Item;

public class TestarQuestao08 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(8));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(2));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(10));
		
		double media = lista.calcularMedia();
		
		System.out.println("A média é: " + media);
	}

}
