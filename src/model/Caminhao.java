package model;

import java.util.Stack;

public class Caminhao {

    private String placa;
    private Local local;
    private Stack<ItemEntrega> itens = new Stack<>();

    public Caminhao(String placa, Local local, Stack<ItemEntrega> itemEntrega){
        this.placa = placa;
        this.local = local;
        this.itens = itemEntrega;
    }

    public Caminhao(String placa, Local local){
        this.placa = placa;
        this.local = local;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Stack<ItemEntrega> getItens() {
        return itens;
    }

    public void setItens(Stack<ItemEntrega> itens) {
        this.itens = itens;
    }
}
