package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Local {

    private String Identificador;
    private String nome;

    private Stack<ItemEntrega> itens = new Stack<>();

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String identificador) {
        Identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Stack<ItemEntrega> getItens() {
        return itens;
    }

    public void setItens(Stack<ItemEntrega> itens) {
        this.itens = itens;
    }
}
