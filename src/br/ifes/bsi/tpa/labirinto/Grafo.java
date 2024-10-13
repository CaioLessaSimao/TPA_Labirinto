package br.ifes.bsi.tpa.labirinto;

import java.util.ArrayList;

public class Grafo {
    Node entrada, saida;
    ArrayList<Node> visitados;

    public Grafo(Node entrada, Node saida){
        this.entrada = entrada;
        this.saida = saida;
        this.visitados = new ArrayList<>();
    }

    public void geraGrafo(int[][] matriz){
        for (int linha = 0; linha < matriz.length; linha++){
            for (int coluna = 0; coluna < matriz[1].length; coluna++){

            }
        }
    }


}
