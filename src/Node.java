public class Node {
    String cor;
    int valor;
    Node esquerda;
    Node direita;
    Node pai;

    //Node for a RedBlackTree
    public Node(int valor) {
        this.valor = valor;
        this.cor = "Vermelho";
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
