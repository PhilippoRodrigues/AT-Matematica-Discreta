package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Caminhao {

    private String placa;
    private List<Local> locais = new ArrayList<>();
    private Stack<ItemEntrega> itens = new Stack<>();
}
