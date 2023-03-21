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

## Views e Activities

### Código que não deve ser alterado

### Código que pode ser alterado

### Código que deve ser Alterado

### Código a ser gerado pelo usuário


## Controladores

### Código que não deve ser alterado

### Código que pode ser alterado

### Código que deve ser Alterado

### Código a ser gerado pelo usuário


## Modelo

### Código que não deve ser alterado

### Código que pode ser alterado

### Código que deve ser Alterado

### Código a ser gerado pelo usuário
