public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        if (dataValida(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("DATA INVALIDA! Definindo data para 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    /*
    O método verificaAnoBissexto verfica o ano do objeto,
    utilizando o método estático "verficaAnoBissexto(int ano)" para verificação.
     */
    public boolean verificaAnoBissexto(){
        return verificaAnoBissexto(this.ano);
    }

    /*
    O método estático, verifica se um ano é bissexto se ele for divisivel por 4,
    se for divisivél por 100 não é bissexto, ao menos que seja divisível por 400
     */
    private static boolean verificaAnoBissexto(int ano){
        if ( ano % 2 == 0){
            if ( ano % 100 == 0){
                return ano % 400 == 0;
            }
            return true;
        }
        return false;
    }

    //O método diasNoMes retorna o numero de dias em um mês especifico de um determinado ano,
    // considerando a variação dos dias em fevereiro dependendo se o ano é bissexto
    private static int diasNoMes(int mes, int ano){
        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31; // Janeiro, março, maio, julho, agosto, outubro e dezembro têm 31 dias
            case 4: case 6: case 9: case 11:
                return 30; // Abril, junho, setembro e novembro têm 30 dias
            case 2: //Fevereiro tem 28 dias, exceto em anos bissextos, quando tem 29 dias
                return (verificaAnoBissexto(ano)) ? 29 : 28; // "?" operador ternario
            default:
                return 0; // é impossivel chegar aqui, mas está aqui por segurança...
        }
    }

    //metodo para verificar se a data é valida
    public static boolean dataValida(int dia, int mes, int ano){
        if (mes < 1 || mes > 12){
            return false;
        }
        if (mes < 1 || dia > diasNoMes(mes, ano)){
            return false;
        }
        return true;
    }

    public String toString(){
        return "Data: " + getDia() + "/" + getMes() + "/" +getAno();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dataValida(dia, this.mes, this.ano)){
            this.dia = dia;
        } else {
            System.out.println("Dia inválido!");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (dataValida(this.dia, mes, this.ano)){
            this.mes = mes;
        } else {
            System.out.println("Mês inválido!");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (dataValida(this.dia, this.mes, ano)){
            this.ano = ano;
        } else {
            System.out.println("Ano inválido!");
        }
    }

    //metodo apenas para comparar a data de validade na parte de criação de produto

    public int compareTo(Data outra) {
        if (this.ano != outra.ano) {
            return this.ano - outra.ano;
        }
        if (this.mes != outra.mes) {
            return this.mes - outra.mes;
        }
        return this.dia - outra.dia;
    }
}
