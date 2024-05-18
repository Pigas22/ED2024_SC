package filaCircular;

import dados.Item;
import duplamente.ListaDupla;

public class FilaCircular {
	private Item [] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int qte){
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new Item [qte];
	}

	public Item getInfo(){
		return this.info[this.frente];
	}

	public int getFrente(){
		return this.frente;
	}

	public int getTras(){
		return this.tras;
	}
	public int getTamanho(){
		return this.tamanho;
	}

	public boolean eVazia(){
		return (this.tamanho == 0);
	}

	public boolean eCheia(){
		return (this.tamanho == this.info.length);
	}

	public boolean enfileirar (Item elem){
		if (this.eCheia())
			return false;
		else {
			this.info[this.tras]= elem;
			this.tras = (++this.tras % this.info.length);
			this.tamanho++;
			return true;
		}
	}

	public Item desenfileirar(){
		Item no;
		if (this.eVazia())
			return null;
		else{
			no = this.info[this.frente];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return no;
		}
	}

	public String toString(){ //imprimir o conteúdo da fila
		String msg="";
		int aux= this.frente;
		for (int i=1; i <= this.tamanho; i++){
			msg+= this.info[aux].getChave()+" ";
			aux= (++aux % this.info.length);
		}
		return msg;
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
	public ListaDupla removeAlunos(String stringEntrada) {
		ListaDupla listAlunosExpulsos  = new ListaDupla();
		
		if (this.eVazia()) {
			System.out.println("A fila está vazia");
			
		} else {
			String[] listNomes = this.transformaEmListaString(stringEntrada);
			int aux = this.frente;
			Item pessoa;
			
			/* Percorre todos os nomes da Fila. Se o valor do campo chave for “true”, 
			* o aluno será removido da fila e inserido no final da Lista Duplamente Encadeada
			* Obs: com o length pois a intenção é readicionar os Alunos que não serão removidos
			*/ 
			for (int f = 0; f < listNomes.length; f++) {

				// Percorre a lista de nomes
				
				for (int i = 1; i <= this.info.length; i++){
					pessoa = this.desenfileirar();
					if (listNomes[f].equals(pessoa.getNome())) {
						
						// Para teste no terminal:
						// System.out.println("Aluno removido da Fila: " + pessoa.getNome());
						// System.out.println("\n========================================");
						listAlunosExpulsos.inserirUltimo(pessoa);
						
						break;
					} 
					
					this.enfileirar(pessoa);
					aux = (++aux % this.info.length);
				}
			}
		}
		
		return listAlunosExpulsos;
	}
	
	
	public String[] transformaEmListaString (String stringEntrada) {
		final String[] SEPARATORS = {",", ".", ":"};
		
		for (int i = 0; i < 3; i++) {
			if (stringEntrada.contains(SEPARATORS[i])) {
				stringEntrada = stringEntrada.replace(SEPARATORS[i], ";").toLowerCase();
			}			
		}
		
		return stringEntrada.split(";");
	}

	
	//imprimir o nome de cada Item da fila
	public String toStringQuestao07(){ 
		String msg="";
		int aux= this.frente;
		for (int i=1; i <= this.tamanho; i++){
			msg+= (" - " + this.info[aux].getNome()+";\n");
			aux= (++aux % this.info.length);
		}
		return msg;
	}


	public double calculaMedia () {
		FilaCircular aux = new FilaCircular(this.tamanho);
		int soma = 0;
		double media;
		Item item;

		while (this.tamanho != 0) {
			item = this.desenfileirar();

			soma += item.getChave();

			aux.enfileirar(item);
		}

		while (aux.tamanho != 0) {
			item = aux.desenfileirar();
			this.enfileirar(item);
		}

		media = ((double)soma) / this.tamanho;

		return media;
	}
}
