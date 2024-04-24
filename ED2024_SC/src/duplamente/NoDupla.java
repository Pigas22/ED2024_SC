package duplamente;

import dados.Item;
import dados.Pessoa;


public class NoDupla {
	private Item info;
	private Pessoa infoPessoa;
	private NoDupla prox;
	private NoDupla ant;
	
	public NoDupla (Item elem){
		this.info = elem;
		this.prox = null;
		this.ant = null;
	}
	public Item getInfo (){
		return this.info;
	}
	
	
	public NoDupla (Pessoa pessoa) {
		this.infoPessoa = pessoa;
		this.prox = null;
		this.ant = null;
	}
	public Pessoa getInfoPessoa() {
		return this.infoPessoa;
	}
	
	
	public NoDupla getProx(){
		return this.prox;
	}
	
	public NoDupla getAnt(){
		return this.ant;
	}
	
	public void setProx(NoDupla novoNo){
		this.prox = novoNo;
	}
	
	public void setAnt(NoDupla novoNo){
		this.ant = novoNo;
	}
}
