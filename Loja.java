public class Loja {

    private String nome;

    private int quantidadeFuncionarios;

    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto [] estoqueProdutos;


    //construtor com todos os atributos
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
                Data dataFundacao, int maxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[maxProdutos];
    }

    //construtor que define -1 para o salario
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int maxProdutos) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[maxProdutos];

    }

    //metodos de acessos


    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    //metodo toString

    public String toString(){
        String result = "Loja: " + getNome() +
                "\nQuantidade de Funcionarios: " + getQuantidadeFuncionarios() +
                "\nSalario Base: " + getSalarioBaseFuncionario() +
                "\nEndereço: " + endereco.getNomeDaRua() + ", " + endereco.getNumero() + ", " + endereco.getCidade() +
                ", " + endereco.getEstado() + ", " + endereco.getCep() + ", " + endereco.getPais() +
                "\nData: " + dataFundacao.getDia() + "/" + dataFundacao.getMes() + "/" + dataFundacao.getAno() +
                "\nEstoque de Produtos: ";

        for (Produto produto : estoqueProdutos){
            if (produto != null){
                result += "\n-" + produto.getNome() + "(Preço: " + produto.getPreco() + ")";
            }
        }
        return result;
    }

    public double gastosComSalario(){
        if ( salarioBaseFuncionario >= 0 ){
            return this.quantidadeFuncionarios * this.salarioBaseFuncionario;
        }
        return -1;
    }

    public char tamanhoDaLoja(){
        if (quantidadeFuncionarios <= 10){
            return 'P';
        } else if (quantidadeFuncionarios <= 30) {
            return 'M';
        } else {
            return 'G';
        }
    }




    // Metodos para loja
    public void imprimeProdutos(){
        for (Produto produto : estoqueProdutos){
            if ( produto != null){
                System.out.println("Nome: " + produto.getNome() + " Preço: " + produto.getPreco());
            }
        }
    }

    public boolean insereProduto(Produto produto){
        for (int i = 0; i < estoqueProdutos.length; i++){
            if (estoqueProdutos[i] == null){
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return  false;
    }

    public boolean removeProduto(String nomeProduto){
        for (int i = 0; i < estoqueProdutos.length; i ++){
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equals(nomeProduto)){
                estoqueProdutos[i] = null;

                for (int j = i; j < estoqueProdutos.length -1; j++){
                    estoqueProdutos[j] = estoqueProdutos[j+1];
                    estoqueProdutos[j + 1] = null;
                }
                return true;
            }
        }
        return false;
    }



    public int getMaxProdutos() {
        return estoqueProdutos.length;
    }

    public void setMaxProdutos(int maxProdutos) {
        Produto[] novoEstoque = new Produto[maxProdutos];
        System.arraycopy(estoqueProdutos, 0, novoEstoque, 0, Math.min(estoqueProdutos.length, maxProdutos));
        this.estoqueProdutos = novoEstoque;
    }

}
