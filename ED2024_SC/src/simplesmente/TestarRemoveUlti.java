package simplesmente;

import dados.Item;

public class TestarRemoveUlti {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(1));
		lista.inserirUltimo(new Item(6));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(78));
		
		
		System.out.println(lista.removeUlti());
		
		
		System.out.println(lista.toString());
	}

}
