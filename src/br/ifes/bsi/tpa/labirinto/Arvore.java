package br.ifes.bsi.tpa.labirinto;

import java.util.ArrayList;

public class Arvore {
    Node raiz;
    ArrayList<Node> visitados;

    public Arvore(){
        this.raiz = null;
    }

    public void geraArvore(int[][] matriz){
        Ponto p = new Ponto(0, 0);
        this.raiz = new Node(p);
        this.visitados = new ArrayList<>();
    }
}
