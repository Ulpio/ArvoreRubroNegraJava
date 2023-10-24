public class RubroNegra{
    Node raiz;
    Node folha;
    
    public RubroNegra(){
        this.folha = new Node(0);
        this.folha.cor = "Preto";
        this.raiz = this.folha;
    }

    public void inserir(int valor){
        Node novo = new Node(valor);
        Node y = this.folha;
        Node x = this.raiz;
        while(x != this.folha){
            y = x;
            if(novo.valor < x.valor){
                x = x.esquerda;
            }else{
                x = x.direita;
            }
        }
        novo.pai = y;
        if(y == this.folha){
            this.raiz = novo;
        }else if(novo.valor < y.valor){
            y.esquerda = novo;
        }else{
            y.direita = novo;
        }
        novo.esquerda = this.folha;
        novo.direita = this.folha;
        novo.cor = "Vermelho";
        this.inserirFixup(novo);
    }

    public void inserirFixup(Node z){
        while(z.pai.cor == "Vermelho"){
            if(z.pai == z.pai.pai.esquerda){
                Node y = z.pai.pai.direita;
                if(y.cor == "Vermelho"){
                    z.pai.cor = "Preto";
                    y.cor = "Preto";
                    z.pai.pai.cor = "Vermelho";
                    z = z.pai.pai;
                }else{
                    if(z == z.pai.direita){
                        z = z.pai;
                        this.rotacaoEsquerda(z);
                    }
                    z.pai.cor = "Preto";
                    z.pai.pai.cor = "Vermelho";
                    this.rotacaoDireita(z.pai.pai);
                }
            }else{
                Node y = z.pai.pai.esquerda;
                if(y.cor == "Vermelho"){
                    z.pai.cor = "Preto";
                    y.cor = "Preto";
                    z.pai.pai.cor = "Vermelho";
                    z = z.pai.pai;
                }else{
                    if(z == z.pai.esquerda){
                        z = z.pai;
                        this.rotacaoDireita(z);
                    }
                    z.pai.cor = "Preto";
                    z.pai.pai.cor = "Vermelho";
                    this.rotacaoEsquerda(z.pai.pai);
                }
            }
        }
        this.raiz.cor = "Preto";
    }

    public void rotacaoEsquerda(Node x){
        Node y = x.direita;
        x.direita = y.esquerda;
        if(y.esquerda != this.folha){
            y.esquerda.pai = x;
        }
        y.pai = x.pai;
        if(x.pai == this.folha){
            this.raiz = y;
        }else if(x == x.pai.esquerda){
            x.pai.esquerda = y;
        }else{
            x.pai.direita = y;
        }
        y.esquerda = x;
        x.pai = y;
    }

    public void rotacaoDireita(Node x){
        Node y = x.esquerda;
        x.esquerda = y.direita;
        if(y.direita != this.folha){
            y.direita.pai = x;
        }
        y.pai = x.pai;
        if(x.pai == this.folha){
            this.raiz = y;
        }else if(x == x.pai.direita){
            x.pai.direita = y;
        }else{
            x.pai.esquerda = y;
        }
        y.direita = x;
        x.pai = y;
    }

    public void buscar(int valor){
        Node x = this.raiz;
        while(x != this.folha && x.valor != valor){
            if(valor < x.valor){
                x = x.esquerda;
            }else{
                x = x.direita;
            }
        }
        if(x == this.folha){
            System.out.println("Valor não encontrado");
        }else{
            System.out.println("Valor encontrado");
        }
    }

    public void listar(){
        this.listar(this.raiz);
    }

    public void listar(Node x){
        if(x != this.folha){
            this.listar(x.esquerda);
            System.out.println(x.valor + x.cor);
            this.listar(x.direita);
        }
    }

}