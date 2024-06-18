public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    //contrutos
    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    //metodos de acessos

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Nome produto: " + getNome() +
                "\nPreço: " + getPreco() +
                "\nData de validade: " + getDataValidade();
    }

    // metododo que verifica se o produto está vencido em relação a uma data fornecida
    public boolean estaVencido(Data dataAtual) {
        if (this.dataValidade.getAno() < dataAtual.getAno()) {
            return true;
        } else if (this.dataValidade.getAno() == dataAtual.getAno()) {
            if (this.dataValidade.getMes() < dataAtual.getMes()) {
                return true;
            } else if (this.dataValidade.getMes() == dataAtual.getMes()) {
                return this.dataValidade.getDia() < dataAtual.getDia();
            }
        }
        return false;
    }
}
