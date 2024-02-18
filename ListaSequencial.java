public class ListaSequencial {
        int tamanho;
        int registro[];

        int nroElem;
        //construtor:
        public ListaSequencial(int tamanho) {
            this.tamanho = tamanho;
            this.registro = new int[tamanho + 1];
        }

        static void inicializaListaSequencial(ListaSequencial l) {
            l.nroElem = 0;
        }

        static void exibirLista(ListaSequencial l) {
            int i;
            System.out.println("Lista: ");
            for (i = 0; i < l.nroElem; i++) {
                System.out.print(l.registro[i]+", ");
            }
            System.out.print("fim.");
            System.out.println();
        }
        //inserir elementos na lista no índice escolhido pelo usuário,
        //podendo ter duplicação
        static boolean inserirElemListSeq(int ch, int i, ListaSequencial l) {
            int j;
            if ((l.nroElem >= l.tamanho) || (i < 0) || (i > l.nroElem))
                return false; //lista cheia ou índice inválido
            if((l.nroElem > 0) && (i < l.nroElem))//se a lista estiver vazia ou se o i já for o índice após o último elemento
                                                    //pula esse for e insere diretamente no índice indicado
                {
                for (j = l.nroElem; j > i; j--) { //esse for arrasta todos os elementos após o índice indicado uma posição
                                                    // a mais para abrir espaço no índice indicado
                    l.registro[j] = l.registro[j - 1];
                }
            }
                l.registro[i] = ch;
                l.nroElem++;
            return true;
        }
        static int tamanhoLista(ListaSequencial l){
            return l.nroElem;
        }
        static int buscaSeq(int chave, ListaSequencial l){
            int i = 0;
            while(i < l.nroElem){
                if(chave == l.registro[i]){
                    //System.out.println("Registro encontrado no índice: " + i +" ");
                    return i;
                }else
                    i++;
            }
           // System.out.println("Não encontrado.");
        return -1;
        }
        //pesquisa qual é o n-ésimo elemento da lista
        static int buscaNesimoElem(ListaSequencial l, int n){
            if(n <= l.nroElem)
                return l.registro[n-1];else
                System.out.print("Está vazio");
                return -1;
        }
        static boolean excluiElem(int chave, ListaSequencial l){
            int pos; int j;
            pos = buscaSeq(chave, l);
            if(pos == -1) return false;
            for(j = pos; j < l.nroElem - 1; j++){
                l.registro[j] = l.registro[j+1];
            }
            l.nroElem--;
            return true;
        }
        //inserção em lista ordenada com sentinela sem duplicação
           static boolean inserirElemListaOrd(int chave, ListaSequencial l){
                int i = 0;
                if(l.nroElem >= l.tamanho) { //  verifica se a lista está cheia
                    return false;
                }
                l.registro[l.nroElem] = chave; //cria uma sentinela na posição seguinte ao último elemento
                while (l.registro[i] < chave){ //while pra achar o índice onde deve ser inserido,
                    i++;                       //que será passado como parâmetro pro método insertirListaSeq
                }
                //verifica se saiu do while pela sentinela ou por ter achado um elemento igual:
                if((l.registro[i] == chave) && (i < l.nroElem))
                    return false; else
                        return (inserirElemListSeq(chave, i, l));
            }
            //a famosa busca binária (só funciona em lista ordenada)
            static int buscaBin(int ch, ListaSequencial l){
                int inf = 0;
                int sup = l.nroElem - 1;
                int meio;
                while (inf <= sup){
                    meio = ((inf + sup)/2);
                    if(l.registro[meio] == ch) return meio; //achou!
                    else{
                        if (l.registro[meio] <  ch) inf = meio + 1;
                        else sup = meio -1;
                    }
                }
                return -1;
            }

        public static void main(String[] args) {
            ListaSequencial teste;
            teste = new ListaSequencial(50);
            inicializaListaSequencial(teste);

            System.out.println("Testando adicionar elementos e acessá-los:");
            inserirElemListSeq(33, 0, teste);
            inserirElemListSeq(44, 1, teste);
            inserirElemListSeq(56, 0, teste);
            inserirElemListSeq(33, 0, teste);
            exibirLista(teste);
            System.out.println("-------------------------------------------------");

            System.out.println("Testando indagar sobre atributos da lista:");
            System.out.println("Tamanho da lista: " + tamanhoLista(teste) + " elementos.");
            System.out.println("--------------------------------------------------");

            System.out.println("Testando pesquisar um elemento da lista:");
            buscaSeq(33, teste);
            System.out.println(buscaSeq(56, teste));
            System.out.println(buscaSeq(99, teste));
            System.out.println("........");
            buscaSeq(56, teste);
            buscaSeq(99, teste);
            System.out.println("---------------------------------------------------");
            System.out.println("Testando acessar um elemento da lista:");
            System.out.println(buscaNesimoElem(teste, 2));
            System.out.println(buscaNesimoElem(teste, 6));
            System.out.println("---------------------------------------------------");
            System.out.println("Excluir elemento da lista e exibi-la após isso pra confirmar:");
            excluiElem(44, teste);
            exibirLista(teste);
            System.out.println("Tamanho da lista: " + tamanhoLista(teste) + " elementos.");
            System.out.println("---------------------------------------------------");
            System.out.println("Testando inserie elementos em lista ordenada:");
            ListaSequencial testeOrdenada;
            testeOrdenada = new ListaSequencial(50);
            inserirElemListaOrd(2, testeOrdenada);
            inserirElemListaOrd(1, testeOrdenada);
            inserirElemListaOrd(1, testeOrdenada);
            exibirLista(testeOrdenada);
            System.out.println("Elemento encontrado no índice: " + buscaBin(2, testeOrdenada));
            System.out.println("Elemento encontrado no índice: " + buscaBin(5, testeOrdenada));
        }
    }

