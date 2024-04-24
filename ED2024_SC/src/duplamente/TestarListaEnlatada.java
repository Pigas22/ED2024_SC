package duplamente;

import dados.Item;

public class TestarListaEnlatada {

	public static void main(String[] args) {
		ListaDupla L1 = new ListaDupla();
		ListaDupla L2 = new ListaDupla();
		
		L1.inserirUltimo(new Item(100));
		L1.inserirUltimo(new Item(200));
		L1.inserirUltimo(new Item(99));
		L1.inserirUltimo(new Item(77));
		L1.inserirUltimo(new Item(300));
		
		L1.listaEnlatados(L2);
		
		System.out.println(L2.toString());
	}

}
