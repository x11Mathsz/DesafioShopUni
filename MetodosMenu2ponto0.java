import java.util.List;
import java.util.Scanner;

public class MetodosMenu2ponto0 {

    static Scanner sc = new Scanner(System.in);

    public int solicitarInt(String msg){
        int valor = 0;
        boolean valorValido = false;
        while (!valorValido){
            System.out.print(msg);
            try {
                valor = Integer.parseInt(sc.nextLine());
                valorValido = true;
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
            }
        }
        return valor;
    }

    public double solicitarDouble(String msg){
        double valor = 0;
        boolean valorValido = false;
        while (!valorValido){
            System.out.print(msg);
            try{
                valor = Double.parseDouble(sc.nextLine());
                valorValido = true;
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
            }
        }
        return valor;
    }

    public void menuCriarLoja(Shopping shopping){
        int deci;

        do {
            deci = solicitarInt("\n\n\n\n-------------------------------------" +
                    "\n ==== Sistema do Shopping " + shopping.getNome()+ " ====" +
                    "\n===== Menu de controle de Lojas =====" +
                    "\n-------------------------------------" +
                    "\n(1) Registrar loja. " +
                    "\n(2) Remover loja. " +
                    "\n(3) Ver lojas registradas. " +
                    "\n(4) Atualizar loja" +
                    "\n(5) Quantidade de lojas por tipo. " +
                    "\n(6) Produtos. " +
                    "\n(7) Loja de informática com maior seguro." +
                    "\n(0) Sair. \n--> ");

            switch (deci){
                case 1:
                    insirirLoja(shopping, sc);
                    break;
                case 2:
                    removerLoja(shopping, sc);
                    break;
                case 3:
                    lerLojas(shopping);
                    break;
                case 4:
                    attLoja(shopping);
                    break;
                case 5:
                    quantidadeTipos(shopping);
                    break;
                case 6:
                    produtosLoja(shopping);
                    break;
                case 7:
                    lojasInformaticaSeguro(shopping);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha a opção correta...");
            }
        } while (deci != 0);
    }
    public void insirirLoja(Shopping shopping, Scanner sc){
        System.out.println("\n\n\n\n\n\n\n\n-------------------------------------" +
                "\n=======   Registro de Loja   =======" +
                "\n=====  Insira os dados da loja  ======" +
                "\n-------------------------------------");

        System.out.print("Nome da loja \n--> ");
        String nomeLoja = sc.nextLine();

        int quantidadeFuncionarios = solicitarInt("Quantidade de Funcionarios \n--> ");

        double salarioBase = solicitarDouble("Salário base dos funcionários (-1 para não informar) \n--> ");

        /*System.out.println(" Digite a data de Fundação ");
        int dia = solicitarInt("Dia \n--> ");
        int mes = solicitarInt("Mês \n--> ");
        int ano = solicitarInt("Ano \n--> ");*/

        Data dataFund = lerDataValida(sc, "fundação");

        System.out.println("===== Insira o endereço da loja =====");
        System.out.print("Nome da rua \n--> ");
        String nomeRua = sc.nextLine();
        System.out.print("Cidade \n--> ");
        String cidade = sc.nextLine();
        System.out.print("Estado \n--> ");
        String estado = sc.nextLine();
        System.out.print("País \n--> ");
        String pais = sc.nextLine();
        System.out.print("CEP \n--> ");
        String cep = sc.nextLine();
        System.out.print("Número \n--> ");
        String numero = sc.nextLine();
        System.out.print("Complemento \n--> ");
        String comple = sc.nextLine();

        Endereco enderecoLoja = new Endereco(nomeRua, cidade, estado, pais, cep, numero, comple);



        Loja novaLoja = null;
        while (novaLoja == null){
            int tipoLoja = solicitarInt("Digite o tipo da loja. \n(1) Cosmético \n(2) Vestuário " +
                    "\n(3) Bijuteria \n(4) Alimentação \n(5) Informática \n--> ");

            switch (tipoLoja){
                case 1:
                    System.out.println("Loja de Cosmético");
                    double taxaC = solicitarDouble("Informe a taxa de comercialização \n--> ");
                    int maxP = solicitarInt("Informe a quantidade maxima de produtos \n--> ");
                    if (salarioBase == -1){
                        novaLoja = new Cosmetico(nomeLoja, quantidadeFuncionarios, enderecoLoja, dataFund, taxaC, maxP);
                    } else {
                        novaLoja = new Cosmetico(nomeLoja, quantidadeFuncionarios, salarioBase, enderecoLoja,
                                dataFund, taxaC, maxP);
                    }
                    break;
                case 2:
                    System.out.println("Loja de Vestuário");
                    boolean lojaImport = solicitarSimOuNao(sc,"A loja possue algum produto importado? \n--> ");
                    int maxP1 = solicitarInt("Informe a quantidade maxima de produtos \n--> ");
                    if (salarioBase == -1){
                        novaLoja = new Vestuario(nomeLoja, quantidadeFuncionarios, enderecoLoja, dataFund, lojaImport, maxP1);
                    } else {
                        novaLoja = new Vestuario(nomeLoja, quantidadeFuncionarios, salarioBase, enderecoLoja,
                                dataFund, lojaImport, maxP1);
                    }
                    break;
                case 3:
                    System.out.println("Loja de Bijuteria");
                    double metaVendas = solicitarDouble("Informe a quantidade de meta de vendas \n--> ");
                    int maxP2 = solicitarInt("Informe a quantidade maxima de produtos \n--> ");
                    if (salarioBase == -1){
                        novaLoja = new Bijuteria(nomeLoja, quantidadeFuncionarios, enderecoLoja, dataFund, metaVendas, maxP2);
                    } else {
                        novaLoja = new Bijuteria(nomeLoja, quantidadeFuncionarios, salarioBase, enderecoLoja, dataFund,
                                metaVendas, maxP2);
                    }
                    break;
                case 4:
                    System.out.println("Loja de Alimentação");
                    System.out.println("Informe a data do alvara.");
                    Data dataAlv = lerDataValida(sc, "alvará");
                    int maxP3 = solicitarInt("Informe a quantidade maixma de produtos \n--> ");
                    if (salarioBase == -1){
                        novaLoja = new Alimentacao(nomeLoja, quantidadeFuncionarios, enderecoLoja, dataFund, dataAlv, maxP3);
                    } else {
                        novaLoja = new Alimentacao(nomeLoja, quantidadeFuncionarios, salarioBase, enderecoLoja, dataFund,
                                dataAlv, maxP3);
                    }
                    break;
                case 5:
                    System.out.println("Loja de Infromática");
                    double seguro = solicitarDouble("Informe o valor do seguro \n--> ");
                    int maxP4 = solicitarInt("Informe a quantidade maxima de produtos \n--> ");
                    if (salarioBase == -1){
                        novaLoja = new Informatica(nomeLoja,quantidadeFuncionarios, enderecoLoja, dataFund, seguro, maxP4);
                    } else {
                        novaLoja = new Informatica(nomeLoja, quantidadeFuncionarios, salarioBase, enderecoLoja, dataFund,
                                seguro, maxP4);
                    }
                    break;
                default:
                    System.out.println("Tipo inválido.");
            }
        }

        if (shopping.insereLoja(novaLoja)){
            System.out.println("Loja registrada com sucesso!");
        } else {
            System.out.println("Não foi possível registrar a loja, o sistema do shopping está cheio :(");
        }

    }

    //metodo para solicitar true ou false para produto importado
    public static boolean solicitarSimOuNao(Scanner sc, String msg){
        while (true){
            System.out.print(msg);
            String respota = sc.nextLine().toLowerCase();

            if (respota.equals("sim")){
                return true;
            } else if (respota.equals("não") || respota.equals("nao")) {
                return false;
            } else {
                System.out.println("Entrada invalida, digite 'sim' ou 'não' ");
            }
        }
    }

    public static void removerLoja(Shopping shopping, Scanner sc){

        System.out.print("Insira o nome da loja que deseja remover. \nCaso tenha digitado errado, digite 'cancelar'" +
                "\n--> ");
        String lojaRemovida = sc.nextLine();
        if (lojaRemovida.equalsIgnoreCase("cancelar")){

        } else {
            boolean removida = shopping.removeLoja(lojaRemovida);

            if (removida){
                System.out.println("Loja deletada!");
            } else {
                System.out.println("Loja não encontrada");
            }
        }

    }

    public static void lerLojas(Shopping shopping){
        int quantidade = shopping.quantiLojas();
        List<String> nomesLojas = shopping.listarLojas();

        System.out.println("\n\n\n\n------------------------------------------" +
                "\nQuantidade de lojas registradas: " + quantidade);
        System.out.println("Nomes das lojas \n------------------------------------------");
        for (String nome : nomesLojas){
            Loja loja = shopping.buscarLoja(nome);
            if (loja!= null){
                int quantidadeProdutos = 0;
                for (Produto produto : loja.getEstoqueProdutos()){
                    if (produto != null){
                        quantidadeProdutos++;
                    }
                }
                System.out.println("Nome da loja: " + nome + " - Quantidade de produtos: "+quantidadeProdutos +
                        "\nSalário base: " + loja.getSalarioBaseFuncionario() +
                        "\nGastos com sálario: " + loja.gastosComSalario()+
                        "\nEndereço " + loja.getEndereco().getNomeDaRua() + ", " + loja.getEndereco().getCidade() +
                        ", " + loja.getEndereco().getEstado() + ", " + loja.getEndereco().getPais() +
                        ", " + loja.getEndereco().getCep() + ", " + loja.getEndereco().getNumero() +
                        "\n------------------------------------------");
            }
        }
    }


    public void addProdutoEmLoja(Shopping shopping, Scanner sc){
        System.out.print("\n\n\n\n\n\n\n-------------------------------------" +
                "\n========= Adicionar produto =========" +
                "\n-------------------------------------" +
                "\nInsira o nome da loja onde deseja adicionar o produto, caso tenha digitado errado, digite 'cancelar'" +
                "\n--> ");
        String nomeL = sc.nextLine();

        if (nomeL.equalsIgnoreCase("cancelar")){

        } else{
            System.out.print("Insira o nome do produto \n--> ");
            String nomeP = sc.nextLine();

            double precoP = solicitarDouble("Insira o preço do produto \n--> ");

            Data dataValidade = lerDataValida(sc, "validade");

            if (dataValidade != null){
                Produto produto = new Produto(nomeP, precoP, dataValidade);
                Data dataReferencia = new Data(20, 10, 2023); //Data solicitada no desafio

                if (dataValidade.compareTo(dataReferencia) < 0 ){
                    System.out.println("Produto vencido! Não foi possivel adicionar");

                } else {
                    System.out.println("\nProduto não vencido!");

                    boolean produtoAdicionado = shopping.addProdutoLoja(nomeL, produto);
                    if (produtoAdicionado){
                        System.out.println("Produto adicionado com sucesso à loja " + nomeL);
                    } else {
                        System.out.println("Loja não encontrada ou limite de produtos atingido.");
                    }
                }
            } else {
                System.out.println("Data de validade inválida. Produto não adicionado.");
            }
        }
    }


    public void deleteProdutoLoja(Shopping shopping, Scanner sc){
        System.out.print("\n\n\n\n\n\n\n-------------------------------------" +
                "\n========= Deletar Produto =========" +
                "\n-------------------------------------" +
                "\nInsira o nome da loja onde deseja remover o produto, caso tenha digitado errado, digite 'cancelar'" +
                "\n--> ");
        String nomeL = sc.nextLine();

        if (nomeL.equalsIgnoreCase("cancelar")){

        } else {
            System.out.print("Digite o nome do produto que deseja deletar \n--> ");
            String nomeP = sc.nextLine();

            boolean produtoRemovido = shopping.delProdutoLoja(nomeL, nomeP);

            if (produtoRemovido){
                System.out.println("Produto removido com sucesso da loja " + nomeL);
            } else {
                System.out.println("Produto ou loja não encotrado, verifique e tente novamente;");
            }
        }
    }


    /*public void deleteProdutoLoja(Shopping shopping, Scanner sc){
        System.out.print("\n\n\n\n\n\n\n-------------------------------------" +
                "\n========= Deletar Produto =========" +
                "\n-------------------------------------" +
                "\nInsira o nome da loja onde deseja remover o produto \n--> ");
        String nomeL = sc.nextLine();

        System.out.print("Digite o nome do produto que deseja deletar \n--> ");
        String nomeP = sc.nextLine();

        boolean produtoRemovido = shopping.delProdutoLoja(nomeL, nomeP);

        if (produtoRemovido){
            System.out.println("Produto removido com sucesso da loja " + nomeL);
        } else {
            System.out.println("Produto ou loja não encotrado, verifique e tente novamente;");
        }
    }*/

    public static void imprimirProdutosLoja(Shopping shopping, Scanner scanner) {
        System.out.print("Digite o nome da loja \n--> ");
        String nomeLoja = scanner.nextLine();
        Loja loja = shopping.buscarLoja(nomeLoja);

        if (loja != null) {
            Produto[] produtos = loja.getEstoqueProdutos();
            System.out.println("\nProdutos da loja " + loja.getNome() + ":");
            for (Produto produto : produtos) {
                if (produto != null) {
                    System.out.println(produto);
                }
            }
        } else {
            System.out.println("Loja não encontrada.");
        }
    }

    public void produtosLoja(Shopping shopping){
        int deci;

        do {
            deci = solicitarInt("\n\n\n-------------------------------------" +
                    "\n==== Menu de produtos para Lojas ====" +
                    "\n-------------------------------------" +
                    "\nEscolha a opção desejada. " +
                    "\n(1) Adicionar produto em uma loja." +
                    "\n(2) Remover um produto de uma loja. \n(3) Imprime os produtos registrados na loja solicitada." +
                    "\n(4) Sair do menu. \n--> ");
            switch (deci){
                case 1:
                    addProdutoEmLoja(shopping, sc);
                    break;
                case 2:
                    deleteProdutoLoja(shopping, sc);
                    break;
                case 3:
                    imprimirProdutosLoja(shopping, sc);
                    break;
                case 4:
                    System.out.println("Voltando para o menu de criação de lojas :)");
                    break;
                default:
                    System.out.println("Escolha uma opção valida...");
            }
        } while (deci != 4);
    }

    public static void lojasInformaticaSeguro(Shopping shopping) {
        Informatica lojaMaisCaro = shopping.lojaSeguroMaisCaro();
        if (lojaMaisCaro != null) {
            System.out.println("\n------------------------------------------" +
                    "\nLoja de informática com o seguro mais caro");
            System.out.println(lojaMaisCaro);
            System.out.println("------------------------------------------");
        } else {
            System.out.println("Nenhuma loja de informática encontrada. ");
        }
    }

    public void quantidadeTipos(Shopping shopping){
        System.out.println("\n\n\n-------------------------------------" +
                "\nQuantidades de Lojas por tipo registradas");
        System.out.println("Quantidade de lojas de cosmético: " + shopping.quantidadeLojasPorTipo("cosmético"));
        System.out.println("Quantidade de lojas de vestuário: " + shopping.quantidadeLojasPorTipo("vestuário"));
        System.out.println("Quantidade de lojas de bijuteria: " + shopping.quantidadeLojasPorTipo("bijuteria"));
        System.out.println("Quantidade de lojas de alimentação: " + shopping.quantidadeLojasPorTipo("alimentação"));
        System.out.println("Quantidade de lojas de informática: " + shopping.quantidadeLojasPorTipo("informática"));
        System.out.println("-------------------------------------");
    }

    public static Data lerDataValida(Scanner sc, String tipoData){
        while (true) {
            System.out.print("Digite a data de " + tipoData + " (formato: DD/MM/AAAA)\n--> ");
            String dataInput = sc.nextLine();
            String[] dataParts = dataInput.split("/");
            if (dataParts.length == 3) {
                try {
                    int dia = Integer.parseInt(dataParts[0]);
                    int mes = Integer.parseInt(dataParts[1]);
                    int ano = Integer.parseInt(dataParts[2]);
                    if (Data.dataValida(dia, mes, ano)) {
                        return new Data(dia, mes, ano);
                    } else {
                        System.out.println("Data inválida. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato de data inválido. Tente novamente.");
                }
            } else {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }
    }

    public void attLoja(Shopping shopping){
        System.out.println("\n\n\nAtualização Loja");
        int deci;

        do {
            deci = solicitarInt("Digite a opção desejada. \n(1) Atualizar dados da loja. " +
                    "\n(2) Atualizar tipo da loja (*ATUALMENTE NÃO ESTA FUNCIONANDO*). \n(3) Voltar para o menu. \n--> ");
            switch (deci){
                case 1:
                    atualizarLoja(shopping, sc);
                    break;
                case 2:
                    atualizarTipoDaLoja(shopping, sc);
                    break;
                case 3:
                    System.out.println("Vontando para o menu");
                    break;
                default:
                    System.out.println("Opção ínválida");
            }

        } while (deci != 3);
    }

    public void atualizarLoja(Shopping shopping, Scanner sc) {
        System.out.print("\n\n\n\nAtualizar Loja \nDigite o nome da loja que deseja atualizar," +
                "caso tenha digitado errado, digite 'cancelar' \n--> ");
        String nomeLoja = sc.nextLine();

        if (nomeLoja.equalsIgnoreCase("cancelar")){
            System.out.println("Cancelado, voltando para o menu...");
        } else {
            Loja loja = shopping.buscarLoja(nomeLoja);

            if (loja == null) {
                System.out.println("Loja não encontrada.");
                return;
            }

            System.out.println("Atualizando informações da loja " + loja.getNome());

            System.out.print("Nome da loja (atual: " + loja.getNome() + ")\n--> ");
            String novoNome = sc.nextLine();
            if (novoNome.equalsIgnoreCase("cancelar")) {
                System.out.println("Operação cancelada.");
                return;
            }
            if (!novoNome.isEmpty()) {
                loja.setNome(novoNome);
            }

            int novaQuantidadeFuncionarios = solicitarInt("Quantidade de funcionários (atual: " +
                    loja.getQuantidadeFuncionarios() + ")\n--> ");
            if (novaQuantidadeFuncionarios != -1) {
                loja.setQuantidadeFuncionarios(novaQuantidadeFuncionarios);
            }

            double novoSalarioBase = solicitarDouble("Salário base dos funcionários (atual: " +
                    loja.getSalarioBaseFuncionario() + ")\n--> ");
            if (novoSalarioBase != -1) {
                loja.setSalarioBaseFuncionario(novoSalarioBase);
            }

            System.out.print("Nome da rua (atual: " + loja.getEndereco().getNomeDaRua() + ")\n--> ");
            String novaRua = sc.nextLine();
            /*if (novaRua.equalsIgnoreCase("cancelar")) {
                System.out.println("Operação cancelada.");
                return;
            }*/
            if (!novaRua.isEmpty()) {
                loja.getEndereco().setNomeDaRua(novaRua);
            }

            System.out.print("Cidade (atual: " + loja.getEndereco().getCidade() + ") \n--> ");
            String novaCidade = sc.nextLine();
            if (!novaCidade.isEmpty()) {
                loja.getEndereco().setCidade(novaCidade);
            }

            System.out.print("Estado (atual: " + loja.getEndereco().getEstado() + ") \n--> ");
            String novoEstado = sc.nextLine();
            if (!novoEstado.isEmpty()) {
                loja.getEndereco().setEstado(novoEstado);
            }

            System.out.print("País (atual: " + loja.getEndereco().getPais() + ") \n--> ");
            String novoPais = sc.nextLine();
            if (!novoPais.isEmpty()) {
                loja.getEndereco().setPais(novoPais);
            }

            System.out.print("CEP (atual: " + loja.getEndereco().getCep() + ") \n--> ");
            String novoCep = sc.nextLine();
            if (!novoCep.isEmpty()) {
                loja.getEndereco().setCep(novoCep);
            }

            System.out.print("Número (atual: " + loja.getEndereco().getNumero() + ") \n--> ");
            String novoNumero = sc.nextLine();
            if (!novoNumero.isEmpty()) {
                loja.getEndereco().setNumero(novoNumero);
            }

            System.out.print("Complemento (atual: " + loja.getEndereco().getComplemento() + ") \n--> ");
            String novoComplemento = sc.nextLine();
            if (!novoComplemento.isEmpty()) {
                loja.getEndereco().setComplemento(novoComplemento);
            }




            int novaQuantidadeMaxProdutos = solicitarInt("Quantidade máxima de produtos (atual: "
                    + loja.getMaxProdutos() + ")\n--> ");
            if (novaQuantidadeMaxProdutos != -1) {
                loja.setMaxProdutos(novaQuantidadeMaxProdutos);
            }

            System.out.println("Informações da loja " + loja.getNome() + " atualizadas com sucesso.");
        }

    }
    public void atualizarTipoDaLoja(Shopping shopping, Scanner sc){
        System.out.print("\n\n\n\nAtualizar Tipo da Loja \nDigite o nome da loja que deseja atualizar," +
                "caso tenha digitado errado, digite 'cancelar' \n--> ");
        String nomeLoja = sc.nextLine();

        if (nomeLoja.equalsIgnoreCase("cancelar")) {
            System.out.println("Operação cancelada.");
            return;
        }

        Loja loja = shopping.buscarLoja(nomeLoja);

        if (loja == null) {
            System.out.println("Loja não encontrada.");
            return;
        }

        int tipoLoja = solicitarInt("Digite o tipo da loja. \n(1) Cosmético \n(2) Vestuário " +
                "\n(3) Bijuteria \n(4) Alimentação \n(5) Informática \n(6) Cancelar \n--> ");

        switch (tipoLoja) {
            case 1:
                // Atualiza a loja como Cosmético
                if (!(loja instanceof Cosmetico)) {
                    System.out.println("Convertendo para Loja de Cosmético...");
                    loja = new Cosmetico(loja.getNome(), loja.getQuantidadeFuncionarios(),
                            loja.getSalarioBaseFuncionario(), loja.getEndereco(), loja.getDataFundacao(),
                            0.0, loja.getMaxProdutos());
                }
                Cosmetico cosmetico = (Cosmetico) loja;
                System.out.println("Loja Cosmético");
                double novaTaxaComercializacao = solicitarDouble("Taxa de comercialização (atual: " +
                        cosmetico.getTaxaComercializacao() + ")\n--> ");
                if (novaTaxaComercializacao != -1) {
                    cosmetico.setTaxaComercializacao(novaTaxaComercializacao);
                }
                break;
            case 2:
                // Atualiza a loja como Vestuário
                if (!(loja instanceof Vestuario)) {
                    System.out.println("Convertendo para Loja de Vestuário...");
                    loja = new Vestuario(loja.getNome(), loja.getQuantidadeFuncionarios(),
                            loja.getSalarioBaseFuncionario(), loja.getEndereco(), loja.getDataFundacao(),
                            false, loja.getMaxProdutos());
                }
                Vestuario vestuario = (Vestuario) loja;
                System.out.println("Loja Vestuário");
                boolean novoImportado = solicitarSimOuNao(sc, "A loja possui algum produto importado? (atual: " +
                        (vestuario.getProdutosImportados() ? "sim" : "não") + ")\n--> ");
                vestuario.setProdutosImportados(novoImportado);
                break;
            case 3:
                // Atualiza a loja como Bijuteria
                if (!(loja instanceof Bijuteria)) {
                    System.out.println("Convertendo para Loja de Bijuteria...");
                    loja = new Bijuteria(loja.getNome(), loja.getQuantidadeFuncionarios(),
                            loja.getSalarioBaseFuncionario(), loja.getEndereco(), loja.getDataFundacao(),
                            0.0, loja.getMaxProdutos());
                }
                Bijuteria bijuteria = (Bijuteria) loja;
                System.out.println("Loja Bijuteria");
                double novaMetaVendas = solicitarDouble("Meta de vendas (atual: " +
                        bijuteria.getMetaVendas() + ")\n--> ");
                if (novaMetaVendas != -1) {
                    bijuteria.setMetaVendas(novaMetaVendas);
                }
                break;
            case 4:
                // Atualiza a loja como Alimentação
                if (!(loja instanceof Alimentacao)) {
                    System.out.println("Convertendo para Loja de Alimentação...");
                    System.out.println("Informe a data do alvará.");
                    Data novaDataAlvara = lerDataValida(sc, "alvará");
                    loja = new Alimentacao(loja.getNome(), loja.getQuantidadeFuncionarios(),
                            loja.getSalarioBaseFuncionario(), loja.getEndereco(), loja.getDataFundacao(),
                            novaDataAlvara, loja.getMaxProdutos());
                }
                Alimentacao alimentacao = (Alimentacao) loja;
                System.out.println("Loja Alimentação");
                System.out.println("Informe a nova data do alvará.");
                Data novaDataAlvaraAtualizada = lerDataValida(sc, "alvará");
                if (novaDataAlvaraAtualizada != null) {
                    alimentacao.setDataAlvara(novaDataAlvaraAtualizada);
                }
                break;
            case 5:
                // Atualiza a loja como Informática
                if (!(loja instanceof Informatica)) {
                    System.out.println("Convertendo para Loja de Informática...");
                    loja = new Informatica(loja.getNome(), loja.getQuantidadeFuncionarios(),
                            loja.getSalarioBaseFuncionario(), loja.getEndereco(), loja.getDataFundacao(),
                            0.0, loja.getMaxProdutos());
                }
                Informatica informatica = (Informatica) loja;
                System.out.println("Loja Informática");
                double novoSeguro = solicitarDouble("Valor do seguro (atual: " +
                        informatica.getSeguroEletronicos() + ")\n--> ");
                if (novoSeguro != -1) {
                    informatica.setSeguroEletronicos(novoSeguro);
                }
                break;
            case 6:
                System.out.println("Operação cancelada.");
                return;
            default:
                System.out.println("Tipo de loja desconhecido.");
                return;
        }

        System.out.println("Tipo da loja atualizado com sucesso para " + loja.getNome());
    }







}
