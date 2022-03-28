package main;

import model.Caminhao;
import model.ItemEntrega;
import model.Local;

import java.util.*;

public class EntregaCaminhaoMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<ItemEntrega> itens = new ArrayList<>();
        ArrayList<Local> locais = new ArrayList<>();
        ArrayList<Caminhao> caminhoes = new ArrayList<>();

        List<Local> itensLocaisEntrega = new ArrayList<>();

        int escolha;

        while (true) {

            System.out.println("\n                  ======================================================");
            System.out.println("                  |         [1] Inserir ponto de entrega                |");
            System.out.println("                  |         [2] Inserir item de entrega                 |");
            System.out.println("                  |         [3] Inserir caminhão                        |");
            System.out.println("                  |         [4] Associar item a ponto de entrega        |");
            System.out.println("                  |         [5] Associar ponto de entrega a caminhão    |");
            System.out.println("                  |         [6] Realizar entregas                       |");
            System.out.println("                  |         [0] Sair                                    |");
            System.out.println("                  =======================================================\n");

            System.out.print("Escolha a opção desejada: ");
            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    System.out.printf("Insira o identificador do local: ");
                    Integer identificadorLocal = scan.nextInt();
                    System.out.printf("Insira o nome do local: ");
                    scan.nextLine();
                    String nomeLocal = scan.nextLine();

                    locais.add(new Local(identificadorLocal, nomeLocal));
                    break;
                case 2:
                    System.out.printf("Insira o identificador do item: ");
                    Integer identificadorItem = scan.nextInt();
                    System.out.printf("Insira o nome do item: ");
                    scan.nextLine();
                    String nomeItem = scan.nextLine();

                    itens.add(new ItemEntrega(identificadorItem, nomeItem));
                    break;
                case 3:
                    System.out.printf("Insira a placa do caminhão: ");
                    scan.nextLine();
                    String placaCaminhao = scan.nextLine();
                    Caminhao caminhao = new Caminhao(placaCaminhao, null, null);
                    scan.nextLine();

                    caminhoes.add(caminhao);
                    break;
                case 4:
                    int j = 0;
                    for (ItemEntrega item : itens) {
                        System.out.println("(" + j + ") " + "ID: " + item.getIdentificador() + " | " + "Nome: " + item.getNome());
                        j++;
                    }

                    System.out.println("Selecione um item para ser associado com o local: ");
                    int itemAssociacao = scan.nextInt();

                    int k = 0;
                    for (Local local : locais) {
                        System.out.println("(" + k + ") " + "ID: " + local.getIdentificador() + " | " + "Nome: " + local.getNome());
                        k++;
                    }

                    System.out.println("Selecione um local para ser associado com o item escolhido: ");
                    int localAssociacao = scan.nextInt();

                    Integer idLocalEscolhido = locais.get(localAssociacao).getIdentificador();
                    String nomeLocalEscolhido = locais.get(localAssociacao).getNome();

                    Integer idItemEscolhido = itens.get(itemAssociacao).getIdentificador();
                    String nomeItemEscolhido = itens.get(itemAssociacao).getNome();

                    ItemEntrega itemEntrega = new ItemEntrega(idItemEscolhido, nomeItemEscolhido);

                    itensLocaisEntrega.add(new Local(idLocalEscolhido, nomeLocalEscolhido, itemEntrega));

                    System.out.println(itensLocaisEntrega.get(0).getIdentificador());
                    System.out.println(itensLocaisEntrega.get(0).getNome());
                    System.out.println(itensLocaisEntrega.get(0).getItem().getIdentificador());
                    System.out.println(itensLocaisEntrega.get(0).getItem().getNome());

                    itens.remove(itemAssociacao);
                    System.out.println(itens.size());
                    System.out.println(itens.get(0).getNome());

                    break;
                default:
            }
        }
    }
}