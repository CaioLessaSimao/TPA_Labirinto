package br.ifes.bsi.tpa.labirinto;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CSVMatrixReader reader = new CSVMatrixReader("input.csv");
            int[][] matrix = reader.getMatrix();
            int rows = reader.getRows();
            int cols = reader.getCols();

            Ponto pEntrada = new Ponto(0,0);
            Node entrada = new Node(pEntrada);
            Grafo grafo = new Grafo(entrada, rows, cols);
            grafo.encontrarFilhos(matrix, entrada);
            NodeResposta caminho = Grafo.inverteEstrutura(grafo.saida);

            SwingUtilities.invokeLater(() -> {
                Animacao lab = new Animacao(matrix, caminho);
            });

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}   