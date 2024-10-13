package br.ifes.bsi.tpa.labirinto;

import java.util.ArrayList;

public class Node {
    Node pai;
    ArrayList<Node> filhos;
    Ponto posicao;

    public Node(Ponto p){
        this.pai = null;
        this.filhos = new ArrayList<>();
        this.posicao = p;
    }

    public Node(Node pai, Ponto p){
        this.pai = pai;
        this.filhos = new ArrayList<>();
        this.posicao = p;
    }
}
