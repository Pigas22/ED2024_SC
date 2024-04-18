package duplamente;

import dados.Item;

public class TestarCopiaLista {
	
	public static void main(String [] args) {
		ListaDupla lista1 = new ListaDupla();
		ListaDupla lista2 = new ListaDupla();
		
		lista1.inserirUltimo(new Item(1));
		lista1.inserirUltimo(new Item(2));
		lista1.inserirUltimo(new Item(3));
		
		lista1.inserirUltimo(new Item(7));
		lista1.inserirUltimo(new Item(8));
		
		
		lista1.copiaLista(lista2);

		System.out.println(lista1.toString());
		
		System.out.println(lista2.toString());
	}
}
