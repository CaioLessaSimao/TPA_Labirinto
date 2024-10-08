import java.util.ArrayList;

public class Arvore {
    Node raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void geraArvore(int[][] matriz){
        Ponto p = new Ponto(0, 0);
        this.raiz = new Node(p);

    }
}
