package dados;

public class Item {
	private int chave;
	
	/*
	 * Lista 06 - Questão 07
	 */
	private boolean isStringContructorUsed;
	private String nome; 
	
	// aqui podem ser declarados outros atributos conforme sua necessidade.
	
	//Construtor de objetos da classe Item
	public Item(int ch) {
		this.chave = ch;
		this.isStringContructorUsed = false;
	}
	//Modifica o valor do atributo chave
	public void setChave (int ch){
		this.chave = ch;
	}
	//Faz a leitura do valor do atributo chave
	public int getChave (){
		return this.chave;
	}

	// Lista 06 - Atividade 07
	public Item(String nome) {
		this.nome = nome;
		this.isStringContructorUsed = true;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	public boolean getIsStringConstructorUsed() {
		return this.isStringContructorUsed;
	}	
}
