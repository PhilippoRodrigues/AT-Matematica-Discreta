package model;

public class ItemEntrega {

    private Integer identificador;
    private String nome;

    public ItemEntrega(Integer identificador, String nome){
        this.identificador = identificador;
        this.nome = nome;
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
}
