package duplamente;

import dados.Item;

public class TestarEhPolindroma {

	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();
		
		
		lista.inserirUltimo(new Item(100));
		lista.inserirUltimo(new Item(99));
		lista.inserirUltimo(new Item(98));
		lista.inserirUltimo(new Item(100));
		
		
		System.out.println(lista.ehPolindroma());

	}

}
