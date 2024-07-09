===== DESAFIO SHOP =====

Durante o semestre, aprenderemos diversas funcionalidades e aspectos da programação. Como desafio final da disciplina, você deverá implementar um sistema que utilizará todos os conteúdos que abordaremos durante as semanas.

Neste contexto, para o desafio de Laboratório I você deverá desenvolver um...
Gerenciador de Lojas de um Shopping Center

![8cb1923d-2df8-4b9c-80d1-21da5e277bdf](https://github.com/x11Mathsz/DesafioShopUni/assets/166771138/aa5b65e7-80d0-474e-a54e-b9e017da16cc)

Um dos locais mais visitados nos finais de semana, especialmente em época de festas, são os Shoppings. Além de climatizados e comumente seguros, são locais onde é possível encontrar uma grande variedade de lojas e atividades para todas as idades.

Neste contexto, o desafio de Laboratório I será o desenvolvimento de um gerenciador de lojas em um Shopping Center.

Um Shopping pode ter diversas lojas de diferentes segmentos (vestuário, alimentação, lazer, cinema, serviços etc.). A imagem abaixo ilustra a estrutura de um Shopping para a finalidade do sistema a ser desenvolvido.


Cada "quadrado" representa um determinado espaço no Shopping, que poderá (ou não) ser alugado por alguma loja. No exemplo acima, temos um Shopping com 20 espaços para locação, nomeados de E0 a E20.

Desta forma, você deverá implementar um sistema que gerencie as lojas presentes no shopping, bem como alterações nas lojas, emissões de relatórios e diversos outros aspectos referentes ao assunto.






===== APRESENTAÇÃO =====

Olá, meu nome é Matheus Christopher Viegas de Faveri, e esse é o meu trabalho de Lab 1 do curso de ADS da Universidade do Vale do Rio dos Sinos.

O objetivo desse trabalho foi desenvolver um sistema em Java para gestão de lojas dentro de um shopping center.

Irei explicar como alguns metodos principais funcionam...

===== CLASSE DATA =====

Irei começar falando primeiro sobre a Classe data, que tem o objetivo de implementar uma classe para representar e validar datas.
O construtor inicia os atributos do dia, mes e ano. Depois ele verifica se é uma data valida
caso a data seja invalida ele define para a data padrão que foi solicitado no desafio 01/01/2000.

O método dataValida verifica se uma data é válida, verifica se o mês está entre o mês 1 e o mês 12, e também verifica se o dia esta dentro do numero de dias do mês e ano, utilizando o método "diasNoMes".

O método diasNoMes retorna o numero de dias em um mês especifico de um determinado ano, considera a variação dos dias em fevereiro dependendo se o ano é bissexto.

O método verificaAnoBissexto verfica o ano do objeto, utilizando o método estático "verficaAnoBissexto(int ano)" para verificação.

O método estático, verifica se um ano é bissexto se ele for divisivel por 4, se for divisivél por 100 não é bissexto, ao menos que seja divisível por 400.


==== CLASSE PRODUTO =====

Agora vamos falar sobre a classe Produto, o objetivo desta classe é gerenciar informações e operações relacionadas a produtos, incluindo verificação de validade.
O método principal desta classe é "estaVencido" que verifica se o produto está vencido em relacão à uma data fornecida, ele compara o ano, mês e dia da "dataValidade" com a "dataAtual", retornando true se o produto estiver vencido, false caso contrario.

===== CLASSE LOJA =====

Classe Loja, tem o objetivo de gerenciar informações e operações relacionadas a uma loja, incluindo funcionários e produtos.

"endereço" é um objeto de Endereço contendo as informações do endereço da loja, dataFundacao: Objeto Data contendo a data de fundação da loja,
e estoqueProdutos: Array de objetos Produto representando o estoque de produtos da loja.

Ele possui dois contrutor, sendo que um é construtor alternativo que define o salarioBase com -1 quando não especificado.

Os métodos principais são, gastosComSalrio que calcula os gastos totais com salarios dos funionarios. Se 'salarioBaseFuncionario' não for negativo, multiplica pela quantidade de funcionários.
Caso contrario retorna -1 se salarioBaseFuncionario for negativo, indicando que não está definido.
Este método permite calcular os custos salariais da loja de maneira simples, com tratamento para o caso em que o salário base não foi definido.

Método tamanhoDaLoja, Determina o tamanho da loja baseado na quantidade de funcionários, retornando 'P' para pequenas (<= 10 funcionários), 'M' para médias (<= 30 funcionários), e 'G' para grandes (mais de 30 funcionários)

Método imprimeProdutos, imprime no console os nomes e preços de todos os produtos em estoque, percorrendo todos os elementos de da coleção do array, facilitando a visualização rápida dos produtos disponíveis na loja, muito útil para inventário e controle de estoque.

Método isereProduto, insere um produto no array "estoqueProdutos" na primeira posição nula, ele retorna "true" se a inserção for bem-sucedida, e "false se não houver espaço. Garantindo a adição de novos produtos ao estoque se houver espaço disponível.

Método removeProduto, remove um produto pelo nome do array "estoqueProdutos", define a posição como nula e ajusta o array para preencher o espaço vazio retornando "true", se não encontrar o produto retorna "false".

O método toString retorna uma representação textual da loja, incluindi nome, quantidade de funcionarios, salario base, endereço, data de fundão e estoque de produtos, proporcionando um visão completa da loja.

===== CLASSE SHOPPING =====


Classe shopping, tem o ojetivo de gerenciar um shopping, suas lojas e funcionalidades relaciondas, endereço é um objeto "Endereço" contendo informações do endereço do shopping, lojas é um Array de objetos "Loja" representando as lojas do shopping.

O construtor recebe nome do shopping, endereço e a quantidade máxima de lojas que o shopping pode ter.

Os métodos principais da Classe Shopping são, insereLoja este método insere uma loja no array "lojas" na primeira posição nula, precorrendo o array "lojas", se encontrar uma posição nula insere a loja e retorna "true".
se não encontrar retorna "false", garantindo que a loja seja adicionada apenas se houver espaço disponível no array.

Método removeLoja, remove uma loja pelo nome do array "lojas", percorre o array "lojas" se encontrar a loja pelo nome, define a posição como nula e ajusta o array array para preencher o espaço vazio, retornando "true", se não encotrar retorna "false", este método assegura que o array de lojas seja ajustado corretamente após a remoção de uma loja, mantendo a consistência dos dados.

Método quantidadeLojasPorTipo, conta a quantidade de lojas de um tipo especifico, percorrendo o array "lojas", verefica o tipo de cada lojas e incrementa o contador se for do tipo especificado, retorna "-1" se o tipo for ínvalido.
Este método facilita a análise da composição do shopping em termos de tipos de lojas.

Método lojaSeguroMaisCaro, encontra a loja do tipo "Informpatica" que paga o maior valor de seguro de eletronicos, percorre o array "lojas", encotrando as lojas do tipo "informática" e comparando os valores de seguro para encotrar
o maior, retornando a loja com maior seguro ou "null" se não houver lojas desse tipo.
Este método é útil para identificar quais lojas de informática possuem maiores custos de seguro, o que pode ser relevante para a administração do shopping em termos de segurança e negociações de contratos.

Método toString, retorna uma representação textual do shopping, incluindo o nome, endereço e nomes das lojas, este método fornece uma visão geral do shopping, permitindo a fácil visualização das informações principais.
