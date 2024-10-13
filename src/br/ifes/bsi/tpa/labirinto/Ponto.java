package br.ifes.bsi.tpa.labirinto;

public class Ponto {
    int linha;
    int coluna;

    public Ponto(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public void imprimir(){
        System.out.println("linha: " + linha + " " + "coluna: " + coluna);
    }
}
