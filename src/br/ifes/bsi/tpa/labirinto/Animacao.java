package br.ifes.bsi.tpa.labirinto;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Animacao extends JFrame {
    private int[][] labirinto;
    private JPanel[][] cells;
    private int playerRow, playerCol;
    private NodeResposta caminho;

    public Animacao(int[][] labirinto, NodeResposta caminho) {
        this.labirinto = labirinto;
        this.cells = new JPanel[labirinto.length][labirinto[0].length];
        this.caminho = caminho;
        initUI();
        iniciarAnimacao();
    }

    private void initUI() {
        // Configuração da janela e layout
        setTitle("Labirinto com Animação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(labirinto.length, labirinto[0].length));

        // Inicializa o labirinto gráfico
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                cells[i][j] = new JPanel();
                if (labirinto[i][j] == 0) {
                    cells[i][j].setBackground(Color.BLACK); // Paredes são pretas
                } else {
                    cells[i][j].setBackground(Color.WHITE); // Passagens são brancas
                }
                add(cells[i][j]);
            }
        }
        playerRow = 0;
        playerCol = 0;
        cells[playerRow][playerCol].setBackground(Color.RED); // Cor do "jogador"
        setSize(900, 900);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarAnimacao() {
        // Cria um timer que move o "jogador" a cada 500 milissegundos
        Timer timer = new Timer(250, e -> moverJogador());
        timer.start();
    }

    private void moverJogador() {

        if (this.caminho != null) {
            cells[playerRow][playerCol].setBackground(Color.WHITE);
            playerRow = this.caminho.posicao.linha;
            playerCol = this.caminho.posicao.coluna;
            cells[playerRow][playerCol].setBackground(Color.RED);

            this.caminho = this.caminho.pai;
        }
    }
}

