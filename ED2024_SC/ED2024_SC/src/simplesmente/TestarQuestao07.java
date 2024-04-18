package simplesmente;

import dados.Item;

public class TestarQuestao07 {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(8));
		lista.inserirUltimo(new Item(2));
		lista.inserirUltimo(new Item(7));
		
		int soma = lista.calcularSoma();
		
		System.out.println("a soma é "+soma);
	}

}
