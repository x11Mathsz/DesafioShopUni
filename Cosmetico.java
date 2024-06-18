public class Cosmetico extends Loja{

    private double taxaComercializacao;

    //construtor com todos os atributos
    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
                     Data dataDeFundacao, double taxaComercializacao, int maxProdutos){
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataDeFundacao, maxProdutos);
        this.taxaComercializacao = taxaComercializacao;
    }

    //construtor que define -1 para o salario
    public Cosmetico(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataDeFundacao,
                     double taxaComercializacao, int maxProdutos){
        super(nome, quantidadeFuncionarios, endereco, dataDeFundacao, maxProdutos);
        this.taxaComercializacao = taxaComercializacao;
    }

    @Override //sobrecita
    public String toString(){
        return super.toString() + "\nTaxa de Comercialização: " + taxaComercializacao;
    }

    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }


}
