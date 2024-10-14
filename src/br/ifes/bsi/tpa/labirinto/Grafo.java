package br.ifes.bsi.tpa.labirinto;

public class Grafo {
    Node entrada, saida;
    int[][] visitados;
    int rows, cols;

    public Grafo(Node entrada, int rows, int cols){
        this.entrada = entrada;
        this.rows = rows-1;
        this.cols = cols-1;
        this.visitados = new int[rows][cols];
    }

    public void encontrarFilhos(int[][] matriz, Node atual){

        int row = atual.posicao.linha;
        int col = atual.posicao.coluna;
        Node n = null;

        //adiciona pontos verticais
        if ( row - 1 >= 0){
            if (matriz[row-1][col] == 1 && naoVisitado(row-1, col)){
                n = createNode(row-1, col, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }
        if ( row + 1 <= rows){
            if (matriz[row+1][col] == 1 && naoVisitado(row+1, col)){
                n = createNode(row+1, col, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }

        //adiciona pontos horizontais
        if ( col - 1 >= 0){
            if (matriz[row][col-1] == 1 && naoVisitado(row, col-1)){
                n = createNode(row, col-1, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }if ( col + 1 <= cols){
            if (matriz[row][col+1] == 1 && naoVisitado(row, col+1)){
                n = createNode(row, col+1, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }

        //adiciona pontos diagonais superiores
        if ( row - 1 >= 0 && col - 1 >= 0){
            if (matriz[row-1][col-1] == 1 && naoVisitado(row-1, col-1)){
                n = createNode(row-1, col-1, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }
        if ( row - 1 >= 0 && col + 1 <= cols){
            if (matriz[row-1][col+1] == 1 && naoVisitado(row-1, col+1)){
                n = createNode(row-1, col+1, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }

        //adiciona pontos diagonais inferiores
        if ( row + 1 <= rows && col - 1 >= 0){
            if (matriz[row+1][col-1] == 1 && naoVisitado(row+1, col-1)){
                n = createNode(row+1, col-1, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }
        if ( row + 1 <= rows && col + 1 <= cols){
            if (matriz[row+1][col+1] == 1 && naoVisitado(row+1, col+1)){
                n = createNode(row+1, col+1, atual);
                atual.filhos.add(n);
                verificaEncontrouSaida(n);
                encontrarFilhos(matriz, n);
            }
        }
    }

    private Node createNode(int row, int col, Node pai){
        Ponto p = new Ponto(row, col);
        Node n = new Node(p);
        n.pai = pai;

        return n;
    }

    private boolean naoVisitado(int row, int col){
        if (row == 0 && col == 0){return false;}

        if (visitados[row][col] == 0){
            visitados[row][col] = 1;
            return true;
        }
        return false;
    }

    private void verificaEncontrouSaida(Node n){
        if (n.posicao.coluna == cols){
            saida = n;
        }
    }

    public static NodeResposta inverteEstrutura(Node saida) {
        NodeResposta atual = new NodeResposta(saida.posicao);

        for (Node n = saida.pai; n != null; n = n.pai) {
            atual.filho = new NodeResposta(n.posicao);
            atual.filho.pai = atual;
            atual = atual.filho;
        }

        //imprimirResposta(atual);

        return atual;

    }

    /*
    public static void imprimirResposta(NodeResposta lista) {
        NodeResposta atual = lista;
        while (atual != null) {
            atual.posicao.imprimir();
            atual = atual.pai;
        }
    }
    */
}
