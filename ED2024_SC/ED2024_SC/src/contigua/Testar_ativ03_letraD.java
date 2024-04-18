package contigua;

import dados.Item;

public class Testar_ativ03_letraD {
	public static void main(String [] args) {
		ListaContig lista = new ListaContig(100);
		
		lista.inserirUltimo(new Item(1));
		lista.inserirUltimo(new Item(4));
		lista.inserirUltimo(new Item(3));
		
		System.out.println("Lista antes de remover\n" + lista.toString());
		
		if (lista.removerValor()) {
			System.out.println("Removeu com sucesso!");
			System.out.println("Lista depois da remoção\n" + lista.toString());
		} else {
			System.out.println("Não existe na Lista.");
		}	
	}
}
