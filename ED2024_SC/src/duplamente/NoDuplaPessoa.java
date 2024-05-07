package duplamente;

import dados.Pessoa;

public class NoDuplaPessoa {
	private Pessoa infoPessoa;
	private NoDuplaPessoa prox;
	private NoDuplaPessoa ant;
	
	/*
	 * Lista 06 - Questão 07
	 */
	public NoDuplaPessoa (Pessoa pessoa) {
		this.infoPessoa = pessoa;
		this.prox = null;
		this.ant = null;
	}
	
	public Pessoa getInfoPessoa() {
		return this.infoPessoa;
	}
	
	public NoDuplaPessoa getProx(){
		return this.prox;
	}
	
	public NoDuplaPessoa getAnt(){
		return this.ant;
	}
	
	public void setProx(NoDuplaPessoa novoNo){
		this.prox = novoNo;
	}
	
	public void setAnt(NoDuplaPessoa novoNo){
		this.ant = novoNo;
	}
}

