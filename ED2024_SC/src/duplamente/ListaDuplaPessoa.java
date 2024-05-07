package duplamente;

import dados.Pessoa;

public class ListaDuplaPessoa {
	private NoDuplaPessoa prim;
	private NoDuplaPessoa ult;
	private int quantNos;

	public ListaDuplaPessoa (){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos(){
		return this.quantNos;
	}

	public NoDuplaPessoa getPrim(){
		return this.prim;
	}

	public NoDuplaPessoa getUlt(){
		return this.ult;
	}

	public void setQuantNos(int valorNovo){
		this.quantNos = valorNovo;
	}

	public void setPrim(NoDuplaPessoa novoNo){
		this.prim = novoNo;
	}

	public void setUlt(NoDuplaPessoa novoNo){
		this.ult = novoNo;
	}

	public boolean eVazia (){
		return (this.prim == null);
	}

	//insere um novo nó no final da lista ou se a lista estiver vazia, insere
	// o primeiro nó na lista
	public void inserirUltimo (Pessoa elem){
		NoDuplaPessoa novoNo = new NoDuplaPessoa (elem);
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
	public NoDuplaPessoa pesquisarNo (String nome){
		NoDuplaPessoa atual = this.prim;
		while ((atual != null) 
				&& (atual.getInfoPessoa()
						.getNome()
						.equals(nome))) {
			atual = atual.getProx();			
		}

		return atual;
	}

	//remove um determinado nó em qualquer posição na lista.
	public boolean removerNo (String nome){
		NoDuplaPessoa atual = this.prim;
		while ((atual != null) 
				&& (atual.getInfoPessoa()
						.getNome()
						.equals(nome))) {

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
		String msg="Pessoas:\n"
				+ "";
		NoDuplaPessoa atual = this.prim;
		while (atual != null){
			msg += atual.getInfoPessoa().getNome()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}

}
