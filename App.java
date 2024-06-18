import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        MetodosMenu2ponto0 metodos = new MetodosMenu2ponto0();




        System.out.print("Digite seu nome \n--> ");
        String nomeU = sc.nextLine();

        System.out.println("\n\n\n\n\n\n\n\n\n\n _______________________________________________" +
                "\n|           Olá Prof "+ nomeU + "                    |" +
                "\n| Sejá bem-vindo ao humilde sistema.  :)       |" +
                "\n| Desafio Laboratório I (GR96002-00611)        |" +
                "\n| Aluno: Matheus Christopher Viegas de Faveri  |" +
                "\n _______________________________________________");
        System.out.println("\n------------------------------------" +
                "\n ========= CRIAÇÃO SHOPPING ========" +
                "\n------------------------------------");
        System.out.print("Por favor, insira o nome do shopping \n--> ");
        String nomeShopping = sc.nextLine();

        System.out.println("Por favor, insira o endereço do shopping");
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
        String complemento = sc.nextLine();

        Endereco enderecoShopping = new Endereco(nomeRua, cidade, estado, pais, cep, numero, complemento);

        int maxLojas = metodos.solicitarInt("Quantidade máxima de lojas que deseja registrar \n--> ");

        Shopping shopping = new Shopping(nomeShopping, enderecoShopping, maxLojas);

        metodos.menuCriarLoja(shopping);
    }
}
