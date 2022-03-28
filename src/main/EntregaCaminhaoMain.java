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
        Stack<Caminhao> caminhoesEntrega = new Stack<>();

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
                    caminhoes.add(caminhao);
                    break;
                case 4:
                    int j = 0;
                    for (ItemEntrega item : itens) {
                        System.out.println("(" + j + ") " + "ID: " + item.getIdentificador() + " | " + "Nome: " + item.getNome());
                        j++;
                    }

                    if (itens.size() == 0)
                        System.out.println("Não há mais cadastros de itens para serem associados a um local");

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

                    break;
                case 5:

                    j = 0;
                    for (Local itemLocalEntrega : itensLocaisEntrega) {
                        System.out.println("(" + j + ") " + "ID: " + itemLocalEntrega.getIdentificador() + " | Nome: " + itemLocalEntrega.getNome() + "| Nome do item: " + itemLocalEntrega.getItem().getNome());
                        j++;
                    }

                    System.out.println("Selecione um local para ser associado ao caminhão: ");
                    int itemLocalAssociacao = scan.nextInt();

                    if (itensLocaisEntrega.size() == 0)
                        System.out.println("Não há mais cadastros de itens para serem associados a um caminhão");

                    k = 0;
                    for (Caminhao itemCaminhao : caminhoes) {
                        System.out.println("(" + k + ") " + "Placa: " + itemCaminhao.getPlaca());
                        k++;
                    }

                    System.out.println("Selecione um caminhão para ser associado com o local escolhido: ");
                    int caminhaoAssociacao = scan.nextInt();

                    Integer idItemLocalEscolhido = itensLocaisEntrega.get(itemLocalAssociacao).getIdentificador();
                    String nomeItemLocalEscolhido = itensLocaisEntrega.get(itemLocalAssociacao).getNome();

                    ItemEntrega itemCaminhaoEscolhido = itensLocaisEntrega.get(itemLocalAssociacao).getItem();

                    String placaEscolhida = caminhoes.get(caminhaoAssociacao).getPlaca();

                    Local local = new Local(idItemLocalEscolhido, nomeItemLocalEscolhido, itemCaminhaoEscolhido);

                    caminhoesEntrega.push(new Caminhao(placaEscolhida, local));

                    System.out.println(caminhoesEntrega.size());

                    System.out.println("------------------------------------------");
                    for (Caminhao itemCaminhao: caminhoesEntrega){
                        System.out.println("Caminhão: " + itemCaminhao.getPlaca() + " | Local: " + itemCaminhao.getLocal().getNome() + " | item: " + itemCaminhao.getLocal().getItem().getNome());
                        System.out.println("------------------------------------------");
                    }

//                    System.out.println(caminhoesEntrega.get(0).getPlaca());
//                    System.out.println(caminhoesEntrega.get(0).getLocal().getIdentificador());
//                    System.out.println(caminhoesEntrega.get(0).getLocal().getNome());
//                    System.out.println(caminhoesEntrega.get(0).getLocal().getItem().getIdentificador());
//                    System.out.println(caminhoesEntrega.get(0).getLocal().getItem().getNome());

                    itensLocaisEntrega.remove(itemLocalAssociacao);

                    System.out.println("Tamanho da lista de locais: " + itensLocaisEntrega.size());
                    break;
                case 6:

                    break;
                default:
            }
        }
    }
}