import java.util.ArrayList;
import java.util.List;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;
    private int numeroLojas;

    public Shopping(String nome, Endereco endereco, int maxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[maxLojas];
    }


    public String toString(){
        String result = "Nome do Shopping: " + getNome() +
                "\nEndreço: " + endereco.getNomeDaRua() + ", " + endereco.getNumero() + ", " + endereco.getCidade() +
                ", " + endereco.getEstado() + ", " + endereco.getCep() + ", " + endereco.getPais() +
                "\nNome das Lojas: ";

        for (Loja lojas : lojas){
            if (lojas != null){
                result += "\n" + lojas.getNome();
            }
        }

        return result;
    }


    /*
        Inserir uma loja no array lojas na primeira posição nula.
        Percorre o array lojas, se encontrar uma posição nula, insere a loja e retorna true.
        Se não encontrar, retorna false.
     */

    public boolean insereLoja(Loja loja){
        for (int i = 0; i < lojas.length; i++){
            if (lojas[i] == null){
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    /*
        Remove uma loja pelo nome do array lojas.
        Percorre o array lojas, se encontrar a loja pelo nome,
        define a posição como nula, ajusta o array para preencher o espaço vazio e retorna true.
        Se não encontrar, retorna false.
      */

    public boolean removeLoja(String nomeLoja){
        for (int i = 0; i < lojas.length; i++){
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)){
                lojas[i] = null;
                //ajusta o array para preencher o espaço vazio
                for (int j = i; j < lojas.length - 1; j++){
                    lojas[j] = lojas[j+1];
                    lojas[j +1 ] = null;
                }
                return true;
            }
        }
        return false;
    }

    /*
        Contar a quantidade de lojas de um tipo específico.
        Percorre o array lojas, verifica o tipo de cada loja e incrementa o contador se for do tipo especificado.
        Retorna -1 se o tipo for inválido.
        instanceof verifica se uma loja no array lojas é uma instância de uma classe específica
     */

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int contador = 0;
        for (Loja loja : lojas) {
            if (loja != null) {
                switch (tipoLoja.toLowerCase()) { //Converter para minúsculas para comparação insensível a maiúsculas
                    case "cosmético":
                        if (loja instanceof Cosmetico) {
                            contador++;
                        }
                        break;
                    case "vestuário":
                        if (loja instanceof Vestuario) {
                            contador++;
                        }
                        break;
                    case "bijuteria":
                        if (loja instanceof Bijuteria) {
                            contador++;
                        }
                        break;
                    case "alimentação":
                        if (loja instanceof Alimentacao) {
                            contador++;
                        }
                        break;
                    case "informática":
                        if (loja instanceof Informatica) {
                            contador++;
                        }
                        break;
                    default:
                        return -1; // Tipo inválido
                }
            }
        }
        return contador;
    }

    /*
        Encontra a loja do tipo Informatica que paga o maior valor de seguro de eletrônicos.
        Percorre o array lojas, encontra lojas do tipo Informatica e compara os valores de seguro para encontrar o maior.
        Retorna a loja com o maior valor de seguro ou null se não houver lojas desse tipo.
     */


    public Informatica lojaSeguroMaisCaro(){
        Informatica maisCaro = null;
        for (Loja loja: lojas){
            if (loja instanceof Informatica){
                Informatica informatica = (Informatica) loja;
                if (maisCaro == null || informatica.getSeguroEletronicos() > maisCaro.getSeguroEletronicos()){
                    maisCaro = informatica;
                }
            }
        }
        return maisCaro;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }




    /*
    Metodos para apresentar o menu, eles foram criados apenas para apresentar o menu e para não interfirir no validador,
     */


    public List<String> listarLojas() {
        List<String> nomesLojas = new ArrayList<>();
        for (Loja loja : lojas) {
            if (loja != null) {
                nomesLojas.add(loja.getNome());
            }
        }
        return nomesLojas;
    }

    public int quantiLojas(){
        int cont = 0;
        for (Loja loja : lojas){
            if (loja != null){
                cont++;
            }
        }
        return cont;
    }

    public boolean addProdutoLoja(String nomeLoja, Produto produto){
        for (Loja loja: lojas){
            if (loja != null && loja.getNome().equalsIgnoreCase(nomeLoja)){
                return loja.insereProduto(produto);
            }
        }
        return false;
    }

    /*public boolean delProdutoLoja(String nomeLoja, String nomeProduto){
        for (Loja loja: lojas){
            if (loja != null && loja.getNome().equalsIgnoreCase(nomeLoja)){
                return loja.removeProduto(nomeProduto);
            }
        }
        return false;
    }*/

    public boolean delProdutoLoja(String nomeLoja, String nomeProduto){
        for (Loja loja: lojas){
            if (loja != null && loja.getNome().equalsIgnoreCase(nomeLoja)){
                boolean sucesso = loja.removeProduto(nomeProduto);
                if (sucesso) {
                    System.out.println("Produto removido com sucesso.");
                    System.out.println(loja);
                }
                return sucesso;
            }
        }
        return false;
    }

    public Loja buscarLoja(String nome) {
        for (Loja loja : lojas) {
            if (loja != null && loja.getNome().equals(nome)) {
                return loja;
            }
        }
        return null;
    }


    public int quantidadeLojas(){
        return this.numeroLojas;
    }

    public int getNumeroLojas() {
        return numeroLojas;
    }

    public void setNumeroLojas(int numeroLojas) {
        this.numeroLojas = numeroLojas;
    }
}
