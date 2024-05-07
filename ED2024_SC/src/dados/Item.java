package dados;

public class Item {
	private int chave;
	private String[] dadosPessoas;
	
	// aqui podem ser declarados outros atributos conforme sua necessidade.
	
	//Construtor de objetos da classe Item
	public Item(int ch) {
		this.chave = ch;
	}
	//Modifica o valor do atributo chave
	public void setChave (int ch){
		this.chave = ch;
	}
	//Faz a leitura do valor do atributo chave
	public int getChave (){
		return this.chave;
	}

	/*
	 * Lista 06 - Questão 07
	 */
	public Item(int index, String nome) {
		String[] dadosPessoas = {Integer.toString(index), nome};
		
		this.dadosPessoas = dadosPessoas;
	}
	
	public String getNome() {
		return dadosPessoas[2];
	}
	public void setNome(String nome) {
		this.dadosPessoas[2] = nome;
	}
	public int getIndex() {
		return Integer.parseInt(dadosPessoas[1]);
	}
	public void setIndex(int index) {
		this.dadosPessoas[1] = Integer.toString(index);
	}
	public String[] getDadosPessoas() {
		return dadosPessoas;
	}
}
