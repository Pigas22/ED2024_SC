package pilha;

import dados.Item;

public class TestandoToStringPilha {

	public static void main(String[] args) {
		PilhaContig pilha = new PilhaContig(4);
		PilhaContig pilha2 = new PilhaContig(4);
		
		pilha.empilhar(new Item(2));
		pilha.empilhar(new Item(4));
		pilha.empilhar(new Item(1));
		pilha.empilhar(new Item(6));
		
		pilha2.empilhar(new Item(2));
		pilha2.empilhar(new Item(7));
		pilha2.empilhar(new Item(9));
		pilha2.empilhar(new Item(1));

		System.out.println(pilha.toString());
		System.out.println(pilha2.toString());
		System.out.println(pilha.verificarIdenticas(pilha2));
	}

}
