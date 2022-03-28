package model;

public class Local {

    private Integer identificador;
    private String nome;

    private ItemEntrega item;

    public Local(Integer identificador, String nome){
        this.identificador = identificador;
        this.nome = nome;
    }

    public Local(Integer idLocalEscolhido, String nomeLocalEscolhido, ItemEntrega item){
        this.identificador = idLocalEscolhido;
        this.nome = nomeLocalEscolhido;
        this.item = item;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ItemEntrega getItem() {
        return item;
    }

    public void setItem(ItemEntrega item) {
        this.item = item;
    }
}