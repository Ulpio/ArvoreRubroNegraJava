public class Main {
    public static void main(String[] args) throws Exception {
        RubroNegra arvore = new RubroNegra();
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(15);
        arvore.inserir(17);
        arvore.inserir(40);
        arvore.inserir(50);
        arvore.inserir(60);
        arvore.inserir(70);
        arvore.inserir(65);
        arvore.listar();
        arvore.buscar(48);
    }
}
