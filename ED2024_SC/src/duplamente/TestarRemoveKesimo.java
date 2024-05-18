package duplamente;

import dados.Item;

public class TestarRemoveKesimo {

    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        ListaDupla lista2 = new ListaDupla();

        lista.inserirUltimo(new Item(2));
        lista.inserirUltimo(new Item(5));
        lista.inserirUltimo(new Item(6));
        lista.inserirUltimo(new Item(9));
        lista.inserirUltimo(new Item(4));

        lista2.inserirUltimo(new Item(1));
        lista2.inserirUltimo(new Item(5));
        lista2.inserirUltimo(new Item(8));
        lista2.inserirUltimo(new Item(7));

        lista.removeKesimo(2);
        lista.removeKesimo(3);

        lista2.removeKesimo(3);

        System.out.println(lista.toString());
        System.out.println(lista2.toString());

    }

}
