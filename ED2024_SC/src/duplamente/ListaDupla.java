package duplamente;

import dados.Item;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;

	public ListaDupla(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos(){
		return this.quantNos;
	}

	public NoDupla getPrim(){
		return this.prim;
	}

	public NoDupla getUlt(){
		return this.ult;
	}

	public void setQuantNos(int valorNovo){
		this.quantNos = valorNovo;
	}

	public void setPrim(NoDupla novoNo){
		this.prim = novoNo;
	}

	public void setUlt(NoDupla novoNo){
		this.ult = novoNo;
	}

	public boolean eVazia (){
		return (this.prim == null);
	}

	//insere um novo nó no final da lista ou se a lista estiver vazia, insere
	// o primeiro nó na lista
	public void inserirUltimo (Item elem){
		NoDupla novoNo = new NoDupla (elem);
		if (this.eVazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	//retorna o endereço do nó que está contendo o valor a ser procurado.
	public NoDupla pesquisarNo (int chave){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave))
			atual = atual.getProx();
		return atual;
	}

	//remove um determinado nó em qualquer posição na lista.
	public boolean removerNo (int chave){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave()!= chave)){
			atual = atual.getProx();
		}
		if (atual == null)
			return false;
		else
			if (atual == this.prim){
				this.prim = prim.getProx();
				if (this.prim == null) //se a lista tem somente um nó
					this.ult=null;
				else
					this.prim.setAnt(null);
			}
			else
				if (atual == this.ult){
					this.ult = this.ult.getAnt();
					this.ult.setProx(null);
				}
				else {
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
		this.quantNos--;
		return true;
	}

	public String toString(){
		String msg="";
		NoDupla atual = this.prim;
		while (atual != null){
			if (atual.getInfo().getIsStringConstructorUsed()) {
				msg += atual.getInfo().getNome()+"; ";
			} else {
				msg += atual.getInfo().getChave()+"\n";				
			}
			atual = atual.getProx();
		}
		return msg;
	}


	// Atividade 04 - Questão 06 

	// Gabarito da Prof
	public void juntaLista(ListaDupla lista2) {
		this.ult.setProx(lista2.prim);
		lista2.prim.setAnt(this.ult);
		this.ult = lista2.ult;

		lista2.prim = null;
		lista2.ult = null;
		this.quantNos += lista2.quantNos;

		lista2.quantNos = 0;
	}

	// Funciona, mas não é o que ela quer.
	public void copiaLista (ListaDupla lista2) {
		NoDupla atualLista2 = lista2.prim;

		while (atualLista2 != null) {
			int itemLista2 = atualLista2.getInfo().getChave();

			this.inserirUltimo(new Item(itemLista2));

			atualLista2.getProx();
			atualLista2.setAnt(null);
		}

	}

	// Atividade 04 - Questão 07
	public ListaDupla partirListaAoMeio() {
		ListaDupla novaLista = new ListaDupla(); // crio uma lista nova;
		int tamanho = this.quantNos; // tamanho é a divisão do tamanho da lista original;
		int meio = tamanho / 2; // metade da lista. 

		NoDupla atual = this.prim;
		int cont = 0;

		while(atual != null && cont < meio) {
			atual = atual.getProx();
			cont++;
		} // enquanto o cont é menor que meio ele ganha mais um;

		novaLista.prim = atual; // nó atual que é o médio aponta para o primeiro;
		novaLista.ult = this.ult; // 
		novaLista.quantNos = this.quantNos - meio;

		this.ult = atual.getAnt();
		this.ult.setProx(null);
		this.quantNos = meio;

		return novaLista;

	}


	// Atividade 04 - Questão 08
	public int retornarMaiorElem() {
		if(this.eVazia()) {
			System.out.println("A lista está vazia.");
		}

		NoDupla atual = this.prim;
		int maiorValor = atual.getInfo().getChave();

		while(atual != null) {
			int valorAtual = atual.getInfo().getChave();
			if(valorAtual > maiorValor) {
				maiorValor = valorAtual;
			}
			atual = atual.getProx();
		}
		return maiorValor;
	}

	// Atividade 04 - Questão 09
	public double calcularMedia () {
		double media = 0;

		NoDupla atual = this.prim;

		if (this.eVazia()) {
			return -999999;

		} else {
			while (atual != null) {
				media += atual.getInfo().getChave();

				atual = atual.getProx();
			}

			media = media / this.quantNos;

			return media;
		}
	}

	// Atividade 04 - Questão 10
	public boolean removerZeros() {
		if (this.eVazia()){
			return false;
		} else {
			int cont = 0;
			NoDupla atual = this.prim;
			while (atual != null) {
				if (atual.getInfo().getChave() == 0) {
					if (atual == this.prim) {
						this.prim = this.prim.getProx();
						if (atual == this.ult) {
							this.ult = null;
						}else {
							this.prim.setAnt(null);
						}
					}else {
						if (atual==this.ult) {
							this.ult = this.ult.getAnt();
							this.ult.setProx(null);
						}else {
							atual.getAnt().setProx(atual.getProx());
							atual.getProx().setAnt(atual.getAnt());
						}
					}
					this.quantNos--;
					cont++;
				}
				atual = atual.getProx();
			}
			if (cont == 0) {
				return false;
			}else {
				return true;
			}
		}
	}


	// Atividade 04 - Questão 11
	public void removerRepetidos() {
		if (this.eVazia()) {
			System.out.println("A lista está vazia.");
			return;
		}

		NoDupla atual = this.prim;

		while (atual != null) {
			int chaveAtual = atual.getInfo().getChave();

			// Verifica se o valor atual já ocorreu antes na lista
			NoDupla verificar = atual.getProx();
			while (verificar != null) {
				if (verificar.getInfo().getChave() == chaveAtual) {
					// Remove o nó repetido
					NoDupla anterior = verificar.getAnt();
					NoDupla proximo = verificar.getProx();

					if (anterior != null) {
						anterior.setProx(proximo);
					} else {
						this.prim = proximo;
					}

					if (proximo != null) {
						proximo.setAnt(anterior);
					} else {
						this.ult = anterior;
					}

					verificar = proximo;

					this.quantNos--;
				} else {
					verificar = verificar.getProx();
				}
			}
			atual = atual.getProx();
		}

		if (this.quantNos == 0) {
			System.out.println("Não foram encontrados valores repetidos na lista.");
		}
	}
	
	
	// Atividade 04 - Questão 12
	/*
	 * Os dados de um grupo de atletas foram organizados em uma lista linear duplamente encadeada. 
	 * O campo de informação de cada elemento da lista apresenta o nome e a altura de um atleta. 
	 * A lista está organizada em ordem alfabética de atletas. Implemente um método para mostrar 
	 * os nomes dos atletas com altura maior que 2 metro.
	 */
	public String maiores2Metros () {
		NoDupla atual = this.prim;
		
		
		while (atual != null) {
			
		}
		
		
		
		
		return this.toString();
	}
	
	
	
	

	// Atividade 04 - Questão 13
	public void listaEnlatados (ListaDupla L2) {
		NoDupla atual = this.prim;

		while (atual != null) {
			if (atual.getInfo().getChave() > 100) {
				L2.inserirUltimo(new Item(atual.getInfo().getChave()));
			}

			atual = atual.getProx();
		}

	}

	// Atividade 04 - Questão 14
	/* 
	 * Uma frase pode ser representada por uma lista linear duplamente encadeada, 
	 * sendo que o campo de informação de cada nó da lista contém um único caractere. 
	 * Implemente um método para saber a palavra que está armazenada na lista encadeada é palíndroma 
	 * (São aquelas palavras ou frases que são iguais quando lidas de frente para trás e de trás para frente).
	 */
	public boolean ehPolindroma() {
		NoDupla atualIni = this.prim;
		NoDupla atualFim = this.ult;
		
		String palavra = "";
		String palavraInversa = "";
		
		while (atualIni != null) {
			palavra += (char)atualIni.getInfo().getChave();
			palavraInversa += (char)atualFim.getInfo().getChave();
			
			atualIni = atualIni.getProx();
			atualFim = atualFim.getAnt();
		}
		
		if (palavra.compareTo(palavraInversa) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	// Atividade 04 - Questão 15
	public void organizaLista(int num) {
		NoDupla novoNo = new NoDupla(new Item(num));

		if (novoNo.getInfo().getChave() 
				< this.prim.getInfo().getChave()) {
			/*
			 * 1° - Verifique se o novo valor é menor que o valor do primeiro nó, 
			 * se sim, insira o novo nó antes do primeiro
			 */
			novoNo.setProx(this.prim);
			this.prim = novoNo;

		} else if (novoNo.getInfo().getChave() 
				> this.ult.getInfo().getChave()) {
			/*
			 * 2° - Verifique se o novo valor é maior que o valor do último nó, 
			 * se sim, insira o novo nó depois do último. 
			 */
			novoNo.setAnt(this.ult);
			this.ult = novoNo;
		} else {
			/*
			 * 3° - se não for nenhuma das possibilidades anteriores, 
			 * caminhe na lista até achar a posição correta para inserir o novo nó. 
			 * A lista tem que permanecer ordenada depois da nova inserção
			 */

			NoDupla atual = this.prim;

			while (atual != null) {
				if (novoNo.getInfo().getChave() 
						> atual.getInfo().getChave()) {
					novoNo.setAnt(atual.getAnt());
					atual.getAnt().setProx(novoNo);

					novoNo.setProx(atual);
					atual.setAnt(novoNo);
				}

				atual.getProx();	
			}
		}

		this.quantNos++;
	}
}


