public class Vestuario extends Loja{

    private boolean produtosImportados;
    //construtor com todos os atributos
    public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
                     Data dataFundacao, boolean produtosImportados, int maxProdutos) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, maxProdutos);
        this.produtosImportados = produtosImportados;
    }

    //construtor que define -1 para o salario
    public Vestuario(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao,
                     boolean produtosImportados, int maxProdutos) {
        super(nome, quantidadeFuncionarios, endereco, dataFundacao, maxProdutos);
        this.produtosImportados = produtosImportados;
    }

    @Override
    public String toString(){ // sobrescrita com operador ternario
        return super.toString() + "\nProdutos Importados: " + (produtosImportados ? "Sim" : "Não");
    }

    public boolean getProdutosImportados() {
        return produtosImportados;
    }

    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }


}
