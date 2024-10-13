package br.ifes.bsi.tpa.labirinto;

public class NodeResposta {
    NodeResposta filho;
    NodeResposta pai;
    Ponto posicao;

    public NodeResposta(Ponto p){
        this.posicao = p;
        this.filho = null;
        this.pai = null;
    }

}
