# Controladores

## DataController.kt

Essa classe possui um conjunto de métodos para armazenamento e tratamento de dados coletados da API do Google fit. A classe e seus métodos podem ser alterados para coleta dos dados desejados da API do Google Fit.

### Methods that can be changed

- setData(dataType: DataType, dataset: DataSet) - Seta dados do Google Fit nos atributos correspondentes nas classe usando um objeto DataSet 
- setData(dataType: DataType, datasets: List<DataSet>)  -  Seta dados do Google Fit nos atributos correspondentes nas classe usando uma lista de objetos DataSet 
- get<Attribute>():<Attribute Type> - Métodos get para os atributos 
- set<Attribute>():<Attribute Type> - Métodos set para os atributos
- getActivityDescription(value: Int): String - Retorna o tipo de atividade de acordoc o código da atividade codificada no GoogleFit
- fullLog() - Salva o Log com todos os dados coletados

## LoginController.kt

Essa classe apresenta um conjunto de métodos para controle de login usando a API do Google, para que seja possível o usuário fazer login usando a conta do google.

### Methods that can be changed

- signIn() - Solicita Login na API Google. A API chama o método de login implementado na classe GoogleApiUtil
- activityResult(requestCode: Int, data: Intent?) - Quanto retornar da requisição de Login volta a activity ou informa que o login falhou
- isLogged():Boolean - Retorna verdadeiro se o Login já foi executado

## ProfileController.kt
  
Essa classe apresenta métodos para coleta dos dados de perfil do usuário logado na conta google
  
### Methods that can be changed
  
- start() - Solicita Login na conta Google
- callLogin() - Chama a tela de Login (LoginACtivity)
- setName(textView: TextView) - seta atributo nome com o valor de um TextView
- getName():String - Utilizando a classe GoogleApiUtil, coleta nome do usuário no perfil da conta google, caso o usuário não esteja logado, chama a tela de login
- getEmail():String - Utilizando a classe GoogleApiUtil, coleta email do usuário no perfil da conta google, caso o usuário não esteja logado, chama a tela de login 
- setEmail(textView: TextView) - seta atributo email com o valor de um TextView
- isLogged():Boolean - Retorna verdadeiro se o Login já foi executado

## [path UpdateControllersSamples] 

## - AppsExternalParametersController.kt

Classe contendo métodos para euxiliar a liberação e download de novas releases da aplicação

### Methods that can be changed   

- adjustApp() - ajusta parâmetros (valores Constantes) da aplicação, caso haja mudança na release
- processExternalParams() - Veririfca se os parâmetros (exemplo, data de atualização) estão de acordo com a release mais recente
- downloadAndInstall(version: String) - baixa  e instala nova versão do app
- convertVersion(version: String): Int - Atualiza versão do app
  
  <b>obs.: Todos os valores a serem editados para uso desses métodos para seu app estão no objeto Constants.kt em model/utils/Constants.kt</b>

## New Controlers

Controladores são classes que podem ser usadas para pequenos tratamentos e para conectar activities ou fragments com algumas classe de modelo, contolados e tratando dados que são obtidos a partir de componentes na tela ou enviando dados que devem ser exibidos em componentes na tela. <b>Aconselhamos criar novos controles para tratamento de dados das de todas as telas que o desenvolvedor gerar</b>. 
