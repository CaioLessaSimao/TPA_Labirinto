package br.ifes.bsi.tpa.labirinto;

import java.util.ArrayList;

public class Node {
    Node pai;
    ArrayList<Node> filhos;
    Ponto posicao;
    int valor;

    public Node(Ponto p){
        this.pai = null;
        this.filhos = null;
        this.posicao = p;
        this.valor = -1;
    }

    public Node(Node pai, Ponto p){
        this.pai = pai;
        this.filhos = null;
        this.posicao = p;
    }

    public void encontrarFilhos(Node n, Node raiz, int[][] Matriz){};

    public boolean encontrouSaida(Node n, Node raiz, int[][] Matriz){
        return false;
    };


}
