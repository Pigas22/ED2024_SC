package filaCircular;

import dados.Item;

public class TestarCalculaMedia {

    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(2);
        double media;

        fila.enfileirar(new Item(13));
        fila.enfileirar(new Item(11));

        media = fila.calculaMedia();
        System.out.printf("Média da soma dos valores da Fila é: %.2f", media);

    }

}
