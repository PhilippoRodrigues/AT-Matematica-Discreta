package model;

import java.util.Stack;

public class Caminhao {

    private String placa;
    private Local local;
    private ItemEntrega item;

    public Caminhao(String placa, Local local){
        this.placa = placa;
        this.local = local;
    }

    public Caminhao(String placa, Local local, ItemEntrega itemEntrega){
        this.placa = placa;
        this.local = local;
        this.item = itemEntrega;
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

    public ItemEntrega getItem() {
        return item;
    }

    public void setItens(ItemEntrega item) {
        this.item = item;
    }
}
