package pilha;

import dados.Item;
import duplamente.ListaDupla;

public class PilhaContig {
	private Item [] info;
	private int topo;
	public PilhaContig(int qte){
		this.topo = 0;
		this.info = new Item [qte];						
	}
	public Item getInfo(){
		return this.info[this.topo-1];
	}
	public int getTopo(){
		return this.topo;
	}
	public boolean eVazia(){
		return (this.topo == 0);
	}
	public boolean eCheia(){
		return (this.topo == this.info.length);
	}
	//inserir um novo dado no topo da pilha.
	public boolean empilhar (Item elem){
		if (this.eCheia())
			return false;
		else {
			this.info[this.topo]= elem;
			this.topo++;
			return true;
		}
	}
	//remove o dado que está no topo da pilha (somente um dado).
	public Item desempilhar(){
		if (this.eVazia())
			return null;
		else{
			this.topo--;
			return this.info[this.topo];
		}
	}


	// Lista 05 - Questão 02
	public void retirarMaiores10 () {
		PilhaContig aux = new PilhaContig(this.topo);
		Item item;

		while (!this.eVazia()) {
			item = this.desempilhar();
			if (item.getChave() <= 10) {
				aux.empilhar(item);

			}
		}

		while (!aux.eVazia()) {
			this.empilhar(aux.desempilhar());
		}

	}


	// Lista 05 - Questão 03
	public int verificarIdenticas(PilhaContig pilha2) {
		if (this.eVazia() && pilha2.eVazia()) {
			return 1;
		} else {
			if (this.topo != pilha2.getTopo()) {
				return 0;

			} else {
				PilhaContig aux = new PilhaContig(this.topo);
				PilhaContig aux2 = new PilhaContig(this.topo);
				Item item, item2;
				boolean igual = true;				

				while (!this.eVazia() && igual) {
					item = this.desempilhar();
					item2 = pilha2.desempilhar();

					if (item.getChave() != item2.getChave()) {
						igual = false;
					} else {
						aux.empilhar(item);
						aux2.empilhar(item2);
					}
				}

				while (!aux.eVazia()) {
					this.empilhar(aux.desempilhar());
					pilha2.empilhar(aux2.desempilhar());
				}
				if (igual) {
					return 1;

				} else {
					return 0;

				}
			}
		}
	}

	/*
	 * Lista 06 - Questão 7
	 * 7) Foram realizadas inscrições para a maratona de programação. Estas inscrições foram armazenadas em uma Fila Circular.
	 * O problema é que um conjunto de alunos não podem mais participar do evento. Implemente um método que retire da Fila 
	 * todas as ocorrências destes alunos e insira em uma Lista Duplamente encadeada.
	 * Considerações:
	 *		- A Fila não está vazia e a Lista será retornada pelo método;
	 *		- As duas estruturas têm o mesmo tipo de dados;
	 *		- Se o valor do campo chave for “true”, o aluno será removido da fila e inserido no final da 
	 *	          Lista Duplamente Encadeada. A Fila pode ter um, vários ou nenhum aluno com chave igual à “true”;
	 *		- Os alunos com campos chaves iguais à “false” deverão permanecer na fila na mesma ordem em que entraram
	*/
	public ListaDupla removeAlunosEvento (String stringAlunosExpulsos) {
		ListaDupla listaAlunosRemovidos = new ListaDupla();
		final String[] SEPARATORS = {",", ".", ":"};		

		for (int i = 0; i < 3; i++) {
			if (stringAlunosExpulsos.contains(SEPARATORS[i])) {
				stringAlunosExpulsos = stringAlunosExpulsos.replace(SEPARATORS[i], ";");
			}			
		}
		String[] listAlunosExpulsos = stringAlunosExpulsos.split(";");

		if (this.eVazia()) {
			System.out.println("A pilha está vazia.");
		} else {
			PilhaContig aux = new PilhaContig(this.topo);
			for (int indexAlunos = 0; indexAlunos < listAlunosExpulsos.length; indexAlunos++) {
				for (int tamanhoPilha = 0; tamanhoPilha < this.getTopo(); tamanhoPilha++) {

					Item alunoDados = this.desempilhar();
					aux.empilhar(alunoDados);

					if (listAlunosExpulsos[indexAlunos]
							.equals(alunoDados.getNome())) {

						listaAlunosRemovidos.inserirUltimo(alunoDados);
						System.out.println("Aluno Expulso encontrado na Fila");

						break;
					}
				}
			}

			for (int tamanhoPilha2 = 0; tamanhoPilha2 <= aux.getTopo(); tamanhoPilha2++) {
				this.empilhar(aux.desempilhar());
			}
		}

		return listaAlunosRemovidos;
	}
}