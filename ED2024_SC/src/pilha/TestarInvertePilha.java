package pilha;

import dados.Item;

public class TestarInvertePilha {

    public static void main(String[] args) {
        PilhaContig pilha = new PilhaContig(2);
        PilhaContig pilha2 = new PilhaContig(2);


        pilha.empilhar(new Item(4));
        pilha.empilhar(new Item(2));
        String msgAntes = pilha.toString();

        pilha2.empilhar(new Item(7));
        pilha2.empilhar(new Item(9));
        String msgAntes2 = pilha2.toString();

        pilha.invertePilha();
        String msg = pilha.toString();

        pilha2.invertePilha();
        String msg2 = pilha2.toString();


        System.out.println(msgAntes + " | " + msg);
        System.out.println(msgAntes2 + " | " + msg2);
    }

}
