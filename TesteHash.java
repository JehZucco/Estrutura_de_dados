import java.util.Hashtable;
import java.util.Scanner;

public class TesteHash {
    public static void main(String[] args) {

        //instancia um objeto do tipo scanner que lê e armazena em uma variável o que o usuário digitar no teclado
        Scanner teclado = new Scanner(System.in);

        //Instancia um objeto do tipo hashtable, que recebe uma String como chave e um objeto do tipo Produto como valor
        Hashtable<String, Produto> hash = new Hashtable<>();

        //Instancia 3 novos produtos
        Produto abacate = new Produto("abacate", 2.56);
        Produto maca = new Produto("maçã", 2.48);
        Produto laranja = new Produto("laranja", 1.84);

        //Insere os protudos na hashtable
        hash.put(abacate.getNome(), abacate);
        hash.put(maca.getNome(), maca);
        hash.put(laranja.getNome(), laranja);

        //Itera sobre todos os objetos da hashtable e imprime cada um deles
        //de acordo com o método toString
        System.out.println("Produtos armazenados na hashtable:");
        for(String key : hash.keySet()){
         System.out.println(hash.get(key));
        }
        System.out.println("--------------------------------------------------");
        System.out.println();

        /*
        Pede ao usuário o nome do produto que ele quer pesquisar, em seguida guarda esta entrada
        na variável entradaUsuário. Então a variável resultadoPesquisa recebe o retorno do método
        hash.get, que, por sua vez, recebe como parâmetro o que o usuário digitou no teclado.
        O nome do produto é a chave para achar o produto, assim, se o usuário digitou corretamente,
        o método retorna o objeto do tipo produto que corresponde ao nome digitado.
        Ou seja, se o usuário digitou abacate, quando chega na ultima linha a variável
        resultadoPesquisa tá valendo "Nome: abacate, Preço: 2.56", porém queremos só o preço,
        por isso resultadoPesquisa.getPreco().
        */
        System.out.println("Qual produto deseja pesquisar?");
        String entradaUsuario = teclado.next();
        Produto resultadoPesquisa = hash.get(entradaUsuario);
        System.out.println(resultadoPesquisa.getPreco());

    }
}
