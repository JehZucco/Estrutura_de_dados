/*
Simulação de uma aplicação simples para pesquisar preço de produtos em um mercado

Criação da classe produto. Como é apenas um exercício para treinar o uso da hashtable só dois atributos
são necessários: nome e preço do produto
* */
public class Produto {
   public String nome;
   public double preco;

    //construtor, assim toda vez que que um novo produto for instanciado será necessário
    //já atribuir nome e preço, pois são atributos indispensáveis para o funcionamento da aplicação
    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    //métodos get para a classe hashtable poder fazer uso dos atributos. Como os atributos estão públicos,
    //é possível acessá-los diretamente, nesse caso os métodos get servem apenas para fins de prática
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    //Sobrescrita do método toString pra facilitar a impressão do conteúdo de um objeto
   @Override
    public String toString(){
        return "Nome: " + this.nome + ", " +
                "Preço: " + this.preco;
    }

}
