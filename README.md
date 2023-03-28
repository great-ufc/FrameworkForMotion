# Framework Kotlin (for Assist Motion Process)

Esse framework foi desenvolvido em Kotlin e tem como objetivo auxiliar o desenvolvimento de aplicaçãoes IoHT autoadaptativas para dispositivos android. Nesse documento nós apresentamos os principais elementos que compõem esse framework e o manual de uso do mesmo.


# Descrição Geral

A Figura 1 mostra uma visão geral do framework padrão arquitetural MVC para composição de sua arquitetua, com a adaptação de separar a camada de View em duas, sendo uma camada View, composta pelas telas da aplicação, e uma outra camada contendo as Activities e Fragments que controlam o funcionamento das telas e seus componentes. Os compoenntes em laranja e amarelo são elementod do framework e podem ser customizados para cada aplicação. Os elementos em cinza são própios de cada aplicação e devem ser desenvolvidos pela equipe de desenvolvimento da aplicação que está usando o Framework.

<p align="center">
<img src="./Documentation/Images/VisaoGeral.png" width="50%" heigth="50%" >
</p>
  
  <p align="center">Figura 1. Visão Geral do framework</p>

As aplicações desenvolvidas usando nosso framework seguem o meta-modelo MAPE-K para implementação do loop de adaptação e para tal foram desenvolvidos módulos com classe para cada uma das etadas do loop MAPE-K. Além disso, o framework usa o padrão de software Observer para comunicação entre as classes principais de cada um dos módulos  do loop de adaptação MAPE-K. Para facilitar a composição da base de conhecimento da aplicação criamos classes que proveem métodos para download e utilização do grafo de classificação proposto pelos autores do framework que permite o relacionamento de diversos sensores, fetures baseadas nesses sensores, modelos inteligentes treinados com base nessas features e estados finais que representam padrões de movimentação ou estados de saúde que podem ser inferidos combase nos modelos inteligentes treinados. 

Também propomos o reuso do template de regras de adaptação proposto pelos autores para criação de um arquivo para definição das regras de adaptação da aplicação. As regras de adaptação nesse arquivo podem ser alteradas sem que seja necessário modificar diretamente a aplicação, permitindo que essa mudança ocorra mesmo com aplicação em  execução. Além disso, utilizamos também o framework SUCCEED (Junior, 2018) para auxiliar a construção das ações na etapa de Execução. Por fim, para manipulação dos dados do banco de dados SQL Lite no dispositivo criamos um conjunto de classes utiliando os padrões DAO e Repositório. 

[Clicando aqui você pode ver o Diagrama de Classes do framework](https://drive.google.com/file/d/1-QNAw4qUGligPNhtXTZ_DeecIpvcVMOX/view?usp=sharing)


# Fundamentação Teórica

Aqui apresentaremos uma breve fundamentação teórica sobre aplicações IoHT baseadas em dados de movimento e de Sistemas Auto Adaptativos, bem como a descriação dos elementos usados para compor o framework, contemplando padrões de projeto e artefatos de reúso.

### Sistemas IoHT baseados em padrões de movimento 


### Sistemas Auto Adaptivos

Os sistemas auto-adaptativos são capazes de monitorar e ajustar seu próprio comportamento em resposta às mudanças nas condições do ambiente, com o objetivo de melhorar sua eficiência e eficácia. Para o desenvolimento desses sistemas é necessário implementar um ciclo de adaptação que permita monitorar o contexto e a adaptar o comportamento da aplicação  quando desejado. Esse ciclo de adaptação costuma ser modelado com base no ciclo de gerenciamento MAPE-K proposto pela IBM no incício dos anos 2000 (IBM, 2003)

### Ciclo MAPE-K

O ciclo MAPE-K permite modelar o clico da adpatação e gerenciar a execução e as adaptações em sistemas auto-adaptativos. Ele permite que o sistema monitore e ajuste seu próprio comportamento em resposta a mudanças nas condições do ambiente.  O modelo consiste nas seguintes fases:

- Monitoramento 

Nessa etapa, o sistema monitora seu próprio comportamento e as condições do ambiente. Ele coleta dados e informações relevantes que serão analisadas para identificar o comportamento e possíveis mudanças que permitam planejar a execução da aplicação e possíveis adaptações, caso necessário.

- Análise

Nessa etapa, o sistema analisa os dados coletados na fase de Monitoramento para identificar padrões e resultados que permitam auxiliar o planejamento de ações, oportunidades de melhoria e possíveis adaptações necessárias. 

- Planejamento

Nessa etapa, com base na análise dos dados, o plano de ações que devem ser executadas pelo sitema é gerado. O plano pode incluir adaptações que modifiquem a maneira como o sistemas executa suas ações ou como desempenha tarefas internas ao sistema.

- Execução

Nesta fase, as ações planejadas são executadas pela aplicação. A execução deve ser cuidadosamente monitorada para garantir que as adaptações produzam os resultados esperados.

- Conhecimento (Knowledge)

Todas as etapas acima do ciclo podem ser assitidas por uma base de conhecimento que auxilie a tomada de decisões nas diversas fases do ciclo. Essa fase de conhecimento pode ser criada anteriomente a execução da aplicação. Ou criada a medida que a aplicação executa, com a possível adição de novas informações nessa base a cada ciclo.

### Padrão MVC

O padrão MVC (Model-View-Controller) é um padrão arquitetural de software que separa a aplicação em três componentes principais: Model, View e Controller. O objetivo desse padrão é dividir a lógica de negócios da interface do usuário, facilitando o desenvolvimento, manutenção e testes de aplicativos. OS componentes desse padrão são: 

- Model: é a camada responsável pela lógica de negócios e manipulação de dados. Ele contém as classes que representam os objetos do domínio da aplicação, bem como as regras de negócio que determinam como esses objetos se comportam e se relacionam entre si. O Model geralmente contém métodos para ler, criar, atualizar e excluir dados, bem como outras operações relacionadas.

- View: é a camada responsável pela interface do usuário. Ele apresenta os dados do Model em um formato compreensível para o usuário e fornece uma interface interativa para que o usuário possa interagir com a aplicação. O View pode ser implementado como uma página web, janela do aplicativo, relatório, entre outros.

- Controller: é a camada responsável por controlar o fluxo da aplicação e atuar como intermediário entre o Model e o View. Ele recebe as entradas do usuário e solicita as operações apropriadas ao Model para manipular os dados. Em seguida, ele atualiza a View para refletir as alterações. O Controller geralmente contém métodos para lidar com a entrada do usuário, gerenciar sessões, autenticação, autorização, entre outros.

O padrão MVC é amplamente utilizado em desenvolvimento de software, incluindo aplicações android. Ele permite que os desenvolvedores separem claramente a lógica de negócios da interface do usuário, facilitando a manutenção e testes de aplicativos. Além disso, o padrão MVC pode ser facilmente estendido para incluir outras camadas, como serviços web ou bancos de dados, para criar aplicativos mais complexos e escaláveis.

### DAO and Respository Patterns

Tanto o padrão DAO (Data Access Object) quanto o padrão Repositório são padrões de projeto de software que têm como objetivo fornecer uma abstração para o acesso a dados em um banco de dados. 

- O padrão DAO tem como objetivo principal isolar o código de acesso a dados do resto do código da aplicação, separando a lógica de negócios da lógica de acesso a dados. Ele consiste em duas partes principais: a interface DAO, que define as operações que podem ser realizadas no banco de dados, e a classe DAO, que implementa a interface DAO e contém as operações específicas para acessar um determinado tipo de entidade. Cada entidade do banco de dados geralmente tem sua própria classe DAO. 
- Já o padrão Repositório tem como objetivo fornecer uma abstração para o acesso a dados, como um objeto de coleção de entidades. Em vez de se concentrar em operações específicas do banco de dados, o Repositório fornece uma interface genérica para criar, ler, atualizar e excluir objetos de uma determinada entidade. Ele consiste em uma classe Repositório que contém as operações genéricas de acesso a dados para a entidade correspondente.

Para utilizar os dois padrões em conjunto, geralmente usa-se uma classe abstrata Repositório do qual as classes específicas de cada entidade herdam, juntamente com a interface de cada uma dessas classe de acesso a dados, como no padrão DAO. Assim nas classes de dados específicas de cada entidade implementamos apenas os métodos mais específicos para a entidade e reutilizamos as funções genéricas de acesso e manipulação dos dados da classe repositório.

### Observer Pattern

O padrão Observer é um padrão de projeto de software que define uma relação de dependência um-para-muitos entre objetos, de forma que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente. Ele é utilizado para implementar o que é conhecido como o padrão pub-sub (publicador-subscritor), onde um objeto observável (Observable) mantém uma lista de seus observadores (Observer) e notifica todos eles automaticamente quando ocorrem mudanças em seu estado interno.

O padrão Observer é utilizado em situações em que é necessário manter um estado consistente em vários objetos, sem que haja acoplamento entre eles. Isso significa que o objeto Sujeito não precisa conhecer seus Observadores, nem os Observadores precisam conhecer outros Observadores. Além disso, novos Observadores podem ser adicionados ou removidos facilmente sem afetar o objeto Sujeito.

Algumas vantagens do padrão Observer incluem a facilidade de extensão, uma vez que novos objetos podem ser adicionados facilmente sem afetar o código existente, e a separação clara das responsabilidades de cada objeto, tornando o código mais modular e fácil de manter.

### SUCCEEd

O Framework SUCCEEd (Junior, 2018) apresenta um conjunto de estruturas de modelagem para sistemas autoadaptativos, auxiliando a especificação de ações, estratégias e regras de adaptação. Ele pode auxiliar principalmente as etapas de planejamento e execução do loop de adaptação. Dentre de nosso framework utilizamos o SUCCEEd para auxiliar as especificação das ações, onde cada ação da aplicação herda da classe <i>Task2</i> do framework e implementa os métodos abstratos por ela fornecidos de modo a a permitie a utilização do modelo de orquestração de ações do SUCCEEd em nosso framework. 

### Grafo de classificação

We propose a model to build a classification graph that aims to provide a way to handle the interoperability of sensors and the analysis of these data, providing a solution that can be reused by several IoHT applications or that can be built focusing on a specific application, also allowing to minimize part of the cost of developing IoHT applications. The proposed classification graph relates sensors, features, classification algorithms, activities, or health situations. We combine common practices in the literature to create this artifact to recognize types of movement, risk situations, or health problems from data collected from datasets with sensor data related to IoHT solutions. Also, we can use the graph to help process activities related to requirements elicitation and choice of reusable components by indicating the sensors and possible health states that can be monitored by the sensors present in them. The classification graph is also possible as a knowledge base for IoHT applications, including self-adaptive IoHT applications. Finally, we present a process to optimize the classification graph based on sensors used for each application.

The code used to create a Classification Graph for the test application generted for test this framework available in : https://github.com/great-ufc/ClassificationGraphSolutionforIoHT

# User Manual

## Download the framework

Você deve começar fazendo o download desse [projeto git](https://github.com/great-ufc/FrameworkForMotion/archive/refs/heads/main.zip). O Peojeto contém A documentação do Framework, O Framework completo, que consta de um código de app android em kotlin, com todos os elementos do framework. Essa aplicação é executável como exemplo simples que pode ser usado para teste de funcionalidades, mas deve ser modificado pelo usuário para contemplar as especificidades e requistos da aplicação que se deseja desenvolver. Além do Framework e sua documentação, o projeto contém também exemplos de aplicações criadas usando o framework e o código de aplicação de API  Pyhton, usando Flask que pode ser utilizada para disponibilizar uma arquivo XML com as regras de adaptação da aplicação, seguindo um template específico. 

## First Steps

Uma vez feito o download do framework juntamente com todos os elementos e códigos que serão usados para auxiliar na construção de sua aplicação é preciso abrir o projeto no Android Studio, uma vez que o framework foi feito para construção de aplicações nativas para android e utilizanod a linguagem kotlin. Então você pode executá-la para verificar as fucnioalidade bases dos framework.  Recomendamos a princípio alterar nas "Strings" em "res/values/strings.xml" o nome do App para o nome que desejar. Além disso, outras informações também podém ser alteradas no string.xml

### Constants

Para cada aplicação uma série de valores constantes deve ser utilizado.  Então a princípio é importante que esse valores sejam alterados para sua aplicação específica. Verifique então o arquivo Constants.kt em "models/utils/Constants.kt". As constantes que devem ser alteradas obrigaotriamente são o email do administrador da aplicação, o endereço do servidor onde está hospedada a API de acesso ao grafo de classificação, caso queira o utilizar como base de conhecimento na constante "BACKEND_IP_PORT" e também, caso haja,  o endereço do servidor onde está hospedada a API de acesso ao template de regras de adaptação na constante "BACKEND_IP_PORT_ADAPTATION_RULES". As demais constantes são opcionais e devm ser alteradas apenas se for necessário de acordo com aplicação  ser desenvolvida. Você também pode, caso deseje,  adicionar outras contantes nesse arquivo Constants.kt.

### Autentificação para uso das APIs do Google

Esse framework disponibiliza suporte ao de uso de pelo menos uma da Google, o  que não impede que o desenvolvedor use outras APIs. Para utilizar essas APIS é obrigado criar uma chave/credencial Auth 2.0 em seua conta de desenvolvedor no Google Cloud (mesmo que não utiliza outros recursos da nuvem da Google). Para criar sua credencial Auth 2.0 recomendadmos seguir os passos da própria documentação oferecida pelo google, que pode ser acessada em: [https://developers.google.com/fit/android/get-api-key](https://developers.google.com/fit/android/get-api-key)

## Separação em Comentários

Ao longo das classes e outros objetos do framework há uma série de trechos de código que devem ou não ser alterados. Separamos quatro identificadores padrões para auxiliar na hosra de identificar o que não deve ser alterado (<b>//------Generated by the Framework and must not be changed-----//</b>), o que deve ser alterado para cada aplicação (<b>//------Generated by the Framework and must be changed-----//</b>), o que pode ser alterado, mas também pode ser mantido como está (<b>//------Generated by the Framework and can be changed-----//</b>) e o que é código do desenvolvedor da aplicação, então pode ser removido do exemplo e adicionado novo (<b>//------Generated by the User-----//</b>). 

Nesse último caso, sugerimos ao usuário do framework utilizar o comentário <b>//------Generated by the User-----//</b> com o nome ou nickname do desenvolvedor nos trechos novos que criar para facilitar a identificação e documentação do código criados exclusivamente pelo desenvolvedor. Assim é possível manter o código mais legível e serpar os trechos de código criados pelo desenvolvedor dos trechos alterados de acordo com o que consta no Framework. Além disso,  apesar de haver trechos com a maração <b>//------Generated by the Framework and must not be changed-----//</b>, nada impede que o desenvolvedor altere esses trechos, uma vez que o framework é de código aberto, mas é sugerido que esses trechos sejam mantidos para o uso das das vantagens de reúso e boas práticas de codificação fornecidas com o framework.

## Elementos do Framework

As classes e outros componentes do framework estão estruturados em uma série de pacotes seguindo o parão arquitetural Model-View-Controller com algumas adaptações. Todos os componentes visuais, incluindo as telas do app, como é padrão de aplicações android nativas estão no pacote <b> res </b>, sendo os componentes presentes nas pastas "layout", "navegation" e "values" os principais. Os "layouts", que correspondem as telas são dividios em Activities e Fragments e cada layout Activity e Fragment está ligada a uma classe Activitie ou Fragment presente no pacote <b> User Interface (ui) </b>. Os contoladores presentes no pacote <b> controllers </b> são usados para controle de informações relacionadas as activities.  Algumas actvities podem não ter contollers associados, caso o desenvolvedor não veja necessidade de tal. Além disso, por padrão disponibilizamos algumas classes controladoras (DataController, ProfileController e AppsExternalParametersController) que não são diretamente associadas a uma activities específicas, mas que contém elementos de controle úteis que podem ser associadas a uma ou mais activities para faciliatar o controle de dados do GoogleFit (DataController), do perfil da conta google (ProfileController) ou a disponibilização de novas releases do app ( AppsExternalParametersController). Finalmente o pacote <b> models </b> contém as classes relacionadas a conexão com APIs disponíveis em servidores na nuvem (pasta cloudConnection), ao processamento e manipulação de dados (pasta dao) e entidades (pasta entities), aos elementos do ciclo de adaptação MAPE-K (pasta mapek) e as classes e objetos úteis que contém métodos e constantes que podem ser usados por diferentes classes (pasta utils). 

### Coding and Reuse - Classes, Interfaces and Objects

A seguir detalhamos as classes e que trechos delas devem, ou não, ser alterados. Também apresentamos informações sobre quais novos elementos o desenvolvedor pode reusar e quais outros deve criar para usar o framework proposto como base para construir sua aplicação. Para ver os detalhes, basta clicar nos links de cada compoente do Framework abaixo.  


- [Views and Activities](./Documentation/UserInterface.md)

- [Controllers](./Documentation/Controller.md)

- [Models](./Documentation/Model.md)


# Referências

IBM. 2003. An architectural blueprint for autonomic computing. Tech. rep., IBM.

JUNIOR, B. R.; ANDRADE, R. M.; MAIA, M. E.; NOGUEIRA, T. P. Succeed: Support mechanism for creating and executing workflows for decoupled sas in iot. In: IEEE. 2018 IEEE 42nd Annual Computer Software and Applications Conference (COMPSAC). [S. l.], 2018. v. 2, p. 738–743.

] J. J. Rodrigues, D. B. D. R. Segundo, H. A. Junqueira, M. H. Sabino, R. M. Prince, J. Al-Muhtadi, and V. H. C. De Albuquerque, “Enabling technologies for the internet of health things,” IEEE Access, vol. 6, pp. 13 129–13 141, 2018

P. A. M. de Oliveira, R. M. Andrade, P. d. A. S. Neto, and B. S. Oliveira, “Internet of health things for quality of life: Open challenges based on a systematic literature mapping.” in HEALTHINF, 2022, pp. 397–40

H. Park, S. Hong, I. Hussain, D. Kim, Y. Seo, S. J. Park, Gait monitoring system for stroke prediction of aging adults, in: International Conference on Applied Human Factors and Ergonomics, Springer, 2020, pp. 93–97.

M. Haghi, K. Thurow, R. Stoll, Wearable devices in medical internet of things: scientific research and commercially available devices, Healthcare informatics research 23 (1) (2017) 4–15.

X. J. Cai, J. I. E. Ignacio, E. F. Mendoza, D. J. F. Rabino, R. P. G. Real, E. A. Roxas, Iot-based gait monitoring system for static and dynamic classification of data, in: 2018 IEEE 10th International Conference on Humanoid, Nanotechnology, Information Technology, Communication and Control, Environment and Management (HNICEM), IEEE, 2018, pp. 1–4.

S. Qiu, Z. Wang, H. Zhao, L. Liu, J. Li, Y. Jiang, G. Fortino, Body sensor network based robust gait analysis: Toward clinical and at home use, IEEE Sensors Journal.

I. L. de Ara ́ujo, L. Dourado, L. Fernandes, R. M. d. C. Andrade, P. A. C. Aguilar, An algorithm for fall detection using data from smartwatch, in: 2018 13th Annual Conference on System of Systems Engineering (SoSE), IEEE, 2018, pp. 124–131.

...
