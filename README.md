# Framework Kotlin (for Assist Motion Process)

# Descrição Geral

*Visão Geral*
![](./Documentation/Images/VisaoGeral.png)


[Diagrama de Classes](https://drive.google.com/file/d/1-QNAw4qUGligPNhtXTZ_DeecIpvcVMOX/view?usp=sharing)

### MVC

## Sistemas Auto Adaptivos

## Ciclo MAPE-K

### Monitoramento

### Análise

### Planejamento

### Execução


# Manual de Uso

## First Steps

Uma vez feito o download do framework juntamente com todos os elementos e códigos que serão usados para auxiliar na construção de sua aplicação também é disponibilizada uma aplicação exemplo. Então você pode executá-la para verificar as fucnioalidade bases dos framework.  Recomendamos a princípio alterar nas "Strings" em "res/values/strings.xml" o nome do App para o nome que desejar. Além disso, outras informações também podém ser alteradas no string.xml

### Constants

Para cada aplicação uma série de valores constantes deve ser utilizado.  Então a princípio é importante que esse valores sejam alterados para sua aplicação específica. Verifique então o arquivo Constants.kt em "models/utils/Constants.kt". As constantes que devem ser alteradas obrigaotriamente são o email do administrador da aplicação, o endereço do servidor onde está hospedada a API de acesso ao grafo de classificação, caso queira o utilizar como base de conhecimento na constante "BACKEND_IP_PORT" e também, caso haja,  o endereço do servidor onde está hospedada a API de acesso ao template de regras de adaptação na constante "BACKEND_IP_PORT_ADAPTATION_RULES". As demais constantes são opcionais e devm ser alteradas apenas se for necessário de acordo com aplicação  ser desenvolvida. Você também pode, caso deseje,  adicionar outras contantes nesse arquivo Constants.kt.

### Autentificação para uso das APIs do Google

Esse framework disponibiliza suporte ao de uso de pelo menos uma da Google, o  que não impede que o desenvolvedor use outras APIs. Para utilizar essas APIS é obrigado criar uma chave/credencial Auth 2.0 em seua conta de desenvolvedor no Google Cloud (mesmo que não utiliza outros recursos da nuvem da Google). Para criar sua credencial Auth 2.0 recomendadmos seguir os passos da própria documentação oferecida pelo google, que pode ser acessada em: [https://developers.google.com/fit/android/get-api-key](https://developers.google.com/fit/android/get-api-key)

## Separação em Comentários

Ao longo das classes e outros objetos do framework há uma série de trechos de código que devem ou não ser alterados. Separamos quatro identificadores padrões para auxiliar na hosra de identificar o que não deve ser alterado (<b>//------Generated by the Framework and must not be changed-----//</b>), o que deve ser alterado para cada aplicação (<b>//------Generated by the Framework and must be changed-----//</b>), o que pode ser alterado, mas também pode ser mantido como está (<b>//------Generated by the Framework and can be changed-----//</b>) e o que é código do desenvolvedor da aplicação, então pode ser removido do exemplo e adicionado novo (<b>//------Generated by the User-----//</b>). 

Nesse último caso, sugerimos ao usuário do framework utilizar o comentário <b>//------Generated by the User-----//</b> com o nome ou nickname do desenvolvedor nos trechos novos que criar para facilitar a identificação e documentação do código criados exclusivamente pelo desenvolvedor. Assim é possível manter o código mais legível e serpar os trechos de código criados pelo desenvolvedor dos trechos alterados de acordo com o que consta no Framework. Além disso,  apesar de haver trechos com a maração <b>//------Generated by the Framework and must not be changed-----//</b>, nada impede que o desenvolvedor altere esses trechos, uma vez que o framework é de código aberto, mas é sugerido que esses trechos sejam mantidos para o uso das das vantagens de reúso e boas práticas de codificação fornecidas com o framework.

## Elementos do Framework e Padrões de Software

As classes e outros componentes do framework estão estruturados em uma série de pacotes seguindo o parão arquitetural Model-View-Controller com algumas adaptações. Todos os componentes visuais, incluindo as telas do app, como é padrão de aplicações android nativas estão no pacote <b> res </b>, sendo os componentes presentes nas pastas "layout", "navegation" e "values" os principais. Os "layouts", que correspondem as telas são dividios em Activities e Fragments e cada layout Activity e Fragment está ligada a uma classe Activitie ou Fragment presente no pacote <b> User Interface (ui) </b>. Os contoladores presentes no pacote <b> controllers </b> são usados para controle de informações relacionadas as activities.  Algumas actvities podem não ter contollers associados, caso o desenvolvedor não veja necessidade de tal. Além disso, por padrão disponibilizamos algumas classes controladoras (DataController, ProfileController e AppsExternalParametersController) que não são diretamente associadas a uma activities específicas, mas que contém elementos de controle úteis que podem ser associadas a uma ou mais activities para faciliatar o controle de dados do GoogleFit (DataController), do perfil da conta google (ProfileController) ou a disponibilização de novas releases do app ( AppsExternalParametersController). Finalmente o pacote <b> models </b> contém as classes relacionadas a conexão com APIs disponíveis em servidores na nuvem (pasta cloudConnection), ao processamento e manipulação de dados (pasta dao) e entidades (pasta entities), aos elementos do ciclo de adaptação MAPE-K (pasta mapek) e as classes e objetos úteis que contém métodos e constantes que podem ser usados por diferentes classes (pasta utils). 

A seguir detalhamos as classes e que trechos delas devem, ou não ser alteradas, bem como informações sobre quais novos elementos o desenvolvedor pode criar para usar o framework proposto como base para construir sua aplicação. Para ver os detalhes, clicar no link correspodente do elemento sobre o qualquer ler sobre.  


- [Views and Activities](./Documentation/UserInterface.md)

- [Controllers](./Documentation/Controladores.md)






## Modelo



#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário
