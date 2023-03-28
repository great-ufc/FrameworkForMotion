# Modelo

- Summary
  - [CloudConnection](#path-cloudConnection)
  - [Entities](#path-entities)
  - [MAPE-k](#path-mapek)
    - [Monitoring](#monitoring)
    - [Analysis](#analysis)
    - [Planning](#planning)
    - [Execution](#execution)
    - [Knowledge](#knowledge)
  - [Utils](#path-utils)


## [path cloudConnection]

Essa pasta contém as classes que devem ser criadas, se necessário, para conexão com uma aplicação em servidor externo que pode ou não está em um nuvem. 

### KnowledgeDownload.kt

Essa clase contém o métodos para download do grafo de classificação, a criação do objeto no formato da entidade KnowledgeRepresentation com base nesse grafo e o download dos modelos inteligentes treinados no servidor. 

```diff
Nós recomendamos o uso do grafo de classificação, no entanto os desenvolvedores não são obrigados a utilizá-lo, cabendo aos 
mesmos, no caso de não usar o grafo, decidir como construir a representação de sua base de conhecimento para aplicação. Nessa 
situação essa classe se torna opcional.
```

#### Methods that can be changed

- update(mutableList: MutableList<VerticeFeature>, context: BaseActivity): KnowledgeRepresentation - Método que solicita o download do grafo otimizado para aplicação e gera o objeto no formato da entidade KnowledgeRepresentation com base no grafo. Também baixa os modelos treinados e adiciona a referêcia dos modelos ao objeto KnowledgeRepresentation criado.
  - <i>Você não precisa fazer nenhuma alteração nessa classe se não for desejável, mas o endereço do servidor para requisição do grafo otimizado está salvo nas Constantes LAST_OPTIMIZE_GRAPH_ADDRESS (requisita o último grafo otimizado) e OPTIMIZE_GRAPH_ADDRESS (solicita um novo grafo otimzado para os sensores e o threshold informado). O valor dessas constantes devem ser alterados para o link do servidor que contém a aplicação do grafo de classificação que os desencolvedores estiverem usando, caso usem o grafo de classificação. </i> 
- updateKnowledgeRepresentationTfLite(knowledgeRepresentation: KnowledgeRepresentation, context: BaseActivity):KnowledgeRepresentation -  Instancia os modelos treinandos no objeto KnowLedgeRepresentation que utilizem a extensão TfLite.
- loadModelFile(model:String,manager: AssetManager): MappedByteBuffer? - Instancia um modelo TfLite
- downloadXML(url:String, context: BaseActivity):String - Executa download do grafo de classificação, salva no dispositivo e retorna o conteúdo do arquivo XML como string
- downloadModels(knowledgeRepresentation: KnowledgeRepresentation, context: BaseActivity) - Executa download dos modelos inteligentes treinados
- downloadModel(url: URL, outputFileName: String, context: BaseActivity) - Executa o download de uma aquivo e salva no dispositivo
- readXMLGraph(xml: String, featuresList: MutableList<VerticeFeature>? = null): KnowledgeRepresentation - Constrói o objeto KnowLedgeRepresentation com base no arquivo XML que representa o Grafo de cLassificação otimizado que foi baixado

<i>Note: If you don't use a trained model in TfLite format, you can add another method in this class for the trained model format you want to use.</i>

## [path dao]
  
Essa pasta contém as classes de acesso a dados ddo banco SQL Lite, onde utilizamos os padrões DAO e Repository.

### [data]

### - UnityofWork.kt
  
> Attributes
> - dbHelper: SQLiteOpenHelper
  
Classe para controle de trasação para operações de mudança no banco de dados
  
#### Methods that must not be changed.

- transaction() - inicia transação para operação de mudança no banco de dados
- commit() - finaliza transação para operação de mudança no banco de dados
- rollback() - desfaz operações executadas durante a transação para operação de mudança no banco de dados
  
### [DBEntities]

### - Pessoa.kt
  
> Attributes
> - id: Int
> - nome:String
  
#### Class that can be changed
  
Exemplo de entidade Pessoa para o Banco de Dados
  
### [interfaces]
  
Interfaces para padeão DAO e Repositorio. Para cada entidaade você deve criar uma interface.
  
### - IPessoaRepository.kt

Interface para PessoaRepository
  
- Add(pessoa: Pessoa) - Adiciona um registor na tabela referente a Entidade Pessoa
- GetPersonById(id: Int): Pessoa - Retorna um registro da tabela Pessoa
- getAll(): MutableList<Pessoa> - Retorna todos os registros da tabela Pessoa

### - IRepository.kt
  
Interface para Repository
  
- Add(cValues:ContentValues):Int - Adiciona novo registro na tabela
- GetById(id:Int): Cursor - Retorna um registro de uma tabela
- GetAll(): Cursor - Retorna todos os registros da tabela
- Update(id:Int, info:String, valor:Boolean):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Byte):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:ByteArray):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Double):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Float):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Int):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Short):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:String):Boolean - Atualiza um registro
- Remove(id:Int): Boolean - Remove um registro
- RemoveAll(): Boolean - Remove todos os registros
- SaveChanges() - Confirma operação

### - IUnityofWork.kt
  
Interface para IUnityofWork
  
- transaction() - inicia transação para operação de mudança no banco de dados
- commit() - finaliza transação para operação de mudança no banco de dados
- rollback() - desfaz operações executadas durante a transação para operação de mudança no banco de dados

### [repository]

Nessa pasta estão todas as classes referentes as classes repositórios para manipulação das tabelas do banco de dados

### - Repository.kt

Classe abstrata repositório base para as demais classes do padrão DAO
  
> Attributes
> - ctx: Context
> - TABLE_NAME:String
> - lstColunms: MutableList<Triple<String,String,Boolean>>?

#### Methods that must not be changed.

- Add(cValues:ContentValues):Int - Adiciona novo registro na tabela
- GetById(id:Int): Cursor - Retorna um registro de uma tabela
- GetAll(): Cursor - Retorna todos os registros da tabela
- Update(id:Int, info:String, valor:Boolean):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Byte):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:ByteArray):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Double):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Float):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Int):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:Short):Boolean - Atualiza um registro
- Update(id:Int, info:String, valor:String):Boolean - Atualiza um registro
- Remove(id:Int): Boolean - Remove um registro
- RemoveAll(): Boolean - Remove todos os registros
- SaveChanges() - Confirma operação

### - [EntityRepositoriesSamples] PessoaRepository.kt

Classe DAO para manipulação da tabela Pessoa
  
> Attributes
> - context: Context
  
#### Methods that can be changed
  
- Add(pessoa: Pessoa) - Adiciona um registor na tabela referente a Entidade Pessoa
- GetPersonById(id: Int): Pessoa - Retorna um registro da tabela Pessoa
- getAll(): MutableList<Pessoa> - Retorna todos os registros da tabela Pessoa
  
## [path entities]

Pasta contendo as entidades da aplicação 
  
### AdaptationRules.kt

Entidade referente ao conjunto de regras de adaptação

> Attributes
> - adaptationList:MutableList<Adaptation>  
  
### - class Adaptation
  
Entidade adaptação
  
> Attributes
> - action:String
> - contextList: MutableList<context>

### - class context
  
Entidade contexto para regras de adaptação
  
> Attributes
> - name:String
> - signal:String
> - value: String

### Context.kt
  
Entidade que representa o contexto coletado pela aplicação

> Attributes
> - name:String
> - value:Any

### EdgeSensorFeature.kt
  
Entidade que representa a aresta que liga o Sensor a Feature para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - vSensor: VerticeSensor
> - vFeature: VerticeFeature
> - contexts: MutableList<Context>?

### EdgeFeatureModel.kt
  
Entidade que representa a aresta que liga a Feature e o Modelo para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - vFeature:VerticeFeature
> - vModel: VerticeModel
> - contexts: MutableList<Context>?

### EdgeModelsFinalStatus.kt

Entidade que representa a aresta que liga o Modelo e o FinalStatus para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - vModel: VerticeModel
> - vFinalStatus: VerticeFinalStatus
> - probability:Double?

### KnowledgeRepresentation.kt

Entidade para Representação da Base de Conhecimento.

> Attributes
> - edgeSensorFeature: MutableList<EdgeSensorFeature>
> - edgeFeaturesModel: MutableList<EdgeFeatureModel>
> - edgeModelsFinalStatus: MutableList<EdgeModelsFinalStatus>

#### Methods that can be changed 
  
> Da maneira que foi concebida, essa classe representa os mesmos elementos do grafo de classificação proposto pelos autoes do framework. Caso o desenvolvedor queira propor uma maneira deiferente de representação de Conhcimento para a aplicação é interessante que modifique essas entidade, alterando os atributos da mesma.
  
### ResultEntry.kt
  
Entidade que representa o resultado da análise, contemplando o contexto atual, a probabilidade tido como resultado da análise e estado final 

> Attributes
> - context:MutableList<Context>
> - probability: Double
> - finalStatus:String

### VerticeSensor.kt

Entidade que representa o sensor na base de conhecimento para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - typeSensor: String

### VerticeFeature.kt

Entidade que representa a feature na base de conhecimento para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - feature: Double
> - featureName:ValuesFeatures

### ValuesFeatures.kt

Entidade que representa o valor da feature na base de conhecimento para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - finalStatus:String

### VerticeModel.kt

Entidade que representa o modelo na base de conhecimento para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - modelName: String
> - inFeature:Int
> - outFeature: Int
> - model:Interpreter?
  
#### Methods that must not be changed.

- setSmartModel(newmodel: Interpreter?) - Instancia o modelo inteligenge treinado.

### VerticeFinalStatus.kt

Entidade que representa o estado final na base de conhecimento para representação de conhecimento com base no grafo de classificação proposto pelos autores do framework

> Attributes
> - finalStatus:String

### [sensors]
  
Nessa pasta estão as entidades específicas para manipulação dos sensores

### - typeSensor.kt

Enumerador que identifica o tipo de sensor

> Type Sensors
> - ACC
> - GYR
> - GPS
> - WIFI
> - MIC

### - ValuesACC.kt

Entidade que representa os valores do acelerômetro

> Attributes
> - eixoX:Double
> - eixoY:Double
> - eixoZ:Double

### - ValuesSensor.kt

Entidade que representa o valor do sensor genérico

> Attributes
> - idSensor:String
> - value:Any

## [path mapek]
  
Nesse pacote estão o módulos referentes ao ciclo MAPE-K

### [monitoring]
  
Classes relacionados ao módulo de monitoramento

### - DataManagement.kt (main module class)
  
Classe principal do módulo de monitoramento. Gerencia o monitoramento dos dados

> Attributes
> - context: BaseActivity
> - dataCollectTime:Long
> - googleFitAllData:GoogleFitGetAllData?
> - observers: MutableList<IMonitorObserver> 
  
#### Methods that must not be changed
  
- update() - executa quando a classe principal do módulo de execução informa que as ações foram executadas (executa método sendUpdateEvent())
  
#### Methods that must be changed

- Monitoring() - gerencia o monitoramento, obtendo os dados coletados dos sensores. Quando a janela de coleta é atingida informa a classe principal do módulo de análise (executa método sendUpdateEvent())

> O usuário deve informar quais os sensores são coletados. O dados coletados devem ser armazenados em um atributo compartilhado da Activity principal (é possível usar o DataController)

### - ICollectorData.kt
  
Interface para classes de coleta de dados dos sensores do dispositivo android
  
#### Methods that must not be changed

- collectData(event: SensorEvent?):Any - método de coleta dos dados
- FormatData(value:String):Any - método para tratar os dados para posteriormente gerar as features
- getValueData(): String - método get para os valores coletados

### - CollectACC.kt
  
Classe para coleta de dados do sensor de acelerômetro
  
> Attributes
> - myData:String
  
#### Methods that must not be changed

- collectData(event: SensorEvent?):Any - método de coleta dos dados do sensor de acelerômetro que é instanciado na activity principal
- FormatData(value:String):Any - método para tratar os dados para posteriormente gerar as features
- getValueData(): String - método get para os valores coletados

### - CollectGyr.kt
  
Classe para coleta de dados do sensor de giroscópio
  
> Attributes
> - myData:String
  
#### Methods that must not be changed

- collectData(event: SensorEvent?):Any - método de coleta dos dados do sensor de giroscópio que é instanciado na activity principal
- FormatData(value:String):Any - método para tratar os dados para posteriormente gerar as features
- getValueData(): String - método get para os valores coletados

### - CollectEnergy.kt
  
Classe para coleta do nível de bateria do celular

> Attributes
> - energy: Double
  
#### Methods that must can be changed

- collectEnergy(context: BaseActivity):Double - coleta e apresenta o nível atual de bateria do celular

### - [GoogleFit] GoogleFitAPI.kt
  
Classe com os métodos bases para conexão e coleta de dados do Google Fit

> Attributes
> - activity: BaseActivity

#### Methods that must not be changed
  
- requestFitPermission() -  Requisita permissão para acesso no Google Fit API
  
> Você precisa de uma credencial Auth 2.0 para acesso das APIs do Google. Recomendadmos seguir os passos da própria documentação oferecida pelo google, que pode ser acessada em: https://developers.google.com/fit/android/get-api-key
  
- oAuthPermissionsApproved() - verifica se a aplicação já possui acesso a Google Fit API  

 - getGoogleAccount() - requisita permissão de acesso do usuário a conta do google
  
- getFitnessOptions() - registra quais dados da API você deseja coletar

### - [GoogleFit/Samples] GoogleFitGetAllData.kt
  
Exemplo de classe para coleta de diversos dados do Google Fit
  
> Attributes
> - activity: BaseActivity
  
#### Methods that can be changed
  
- checkPermissionAndGetData() - Verifica permissão de acesso aos dados do Google Fit, se não houver requisita acesso
- getData(context: Context, dataController: DataController) - Coleta dados do Google Fit e preenche objeto DataController
- getDataStatic(context: Context, dataController: DataController) -  Coleta dados e define intervalo de coleta
- getDataStatic(context: Context, dataController: DataController, beginDate: Long, endDate: Long) - Coleta medidas, Calorias, Batimentos cardíacos e Sono do Google Fit
- accessGoogleFit(dataType: DataType, context: Context, dataController: DataController, beginDate: Long, endDate: Long) -  acessa dados do GoogleFit
- getBodyMeasures(dataType: DataType, context: Context, dataController: DataController) - Coleta Medidas (e.g. Peso e ALtura) registradas no Google Fit
- getHeartRate(context: Context, dataController: DataController, beginDate: Long, endDate: Long) - Coleta Valores de Batimento Cardíaco registrados no Google Fit
- accessSleepData(context: Context, dataController: DataController, beginDate: Long, endDate: Long) - Coleta Valores de Qualidade de Sono registrados no Google Fit

### - [GoogleFit/Samples] GoogleFitStepData.kt

Exemplo de classe para coleta de dados referente a contagem de passos do Google Fit
  
> Attributes
> - activity: BaseActivity
  
#### Methods that can be changed
  
- fitSignIn(requestCode: Int) - Verifica permissão de acesso aos dados do Google Fitt, se não houver requisita acesso
- performActionForRequestCode(requestCode: Int) - Coleta dados de contagem dos passos do Google Fit
- insertAndReadData() - registra dados históricos
- insertData(): Task<Void> - Coleta dos dados do Google Fit e registra em um objeto DataSet
- readHistoryData(): Task<DataReadResponse> -  Coleta dos dados históricos do Google Fit
- insertFitnessData(): DataSet - Coleta dos dados de contagem de passos do Google Fit e registra em um objeto DataSet
- queryFitnessData(): DataReadRequest - Consulta lista de dados de contagem de passos coletados
- printData(dataReadResult: DataReadResponse) - Apresenta dados coletados do Google Fit
- dumpDataSet(dataSet: DataSet) - Salva log dos dados
- DataPoint.getStartTimeString(): String - Retorna tempo inicial da coleta
- DataPoint.getStartTimeString(): String - Retorna tempo final da coleta
- deleteData() - Deleta da API os dados que já foram coletados
- updateAndReadData() - Atualizada pesquisa dados históricos
- updateData() - Atualiza pesquisa pelos dados a serem coletados do Google Fit
- updateFitnessData(): - Atualiza pesquisa pelos dados de contagemd e passos a serem coletados do Google Fit

### [observers]

All Observer Interfaces were created specifically to enable the use of the observer pattern by the main classes of the modules of the adaptation cycle (monitoring, analysis, planning and execution) and must not be changed. If you want to use the observer pattern for other classes, please create new observer interfaces (in a package other than mapek) for the classes you want.

> The "Observer" interface corresponds to observer classes that will execute the <update()> method when the class with the corresponding "Observable" interface that is being observed executes the <sendUpdateEvent()> method.

> Also, classes with interface "Observable" add their observers (classes with interface "Observer") using method <add()>.

### [analysis]
  
Classes relacionados ao módulo de análise

### - DataAnalysis.kt (main module class)
  
Classe principal do módulo de análise. Gerencia a análise do contexto

> Attributes
> - context:BaseActivity
> - contextList:MutableList<Context>
> - myFeatures:MutableList<VerticeFeature>
> - observers: MutableList<IAnalysisObserver>
  
#### Methods that must not be changed

- setContextList(energy:Double) - Preenche Lista de valores de Contexto (esses valores devem ser anaálisados para identificar se é preciso ou não que seja planejada uma adaptação)
- setFeatureList(features:MutableList<VerticeFeature>) - Preenche lista de feeatures para análise e indicação do resultado a ser apresentado. Essas feeatures podem ou não fazer parte do contexto que afeta aescolha das ações e planejamento de adaptações
-  update() - executa quando a classe principal do módulo de monitoramento informa que o conjunto de dados que serão analisados já foram coletados e formatados (executa método sendUpdateEvent())
  
#### Methods that must be changed

-   featureAnalysis() - Método principal da classe. Com base na base de conhecimento e/ou nas features executa análise das features e do contexto e indica aos seu observadores (modulo de planejamento) o resultado a ser apresentado e se épreciso ou não executar a adaptação das ações do app. Essa análisa das ações é feita com base nas regras de adaptação previamente projetadas e presentes no código ou em um arquivo.
  > O autor propõe um modelo de um arquivo xml para especificação das regras de adaptação, esse arquivo xml pode ser disponibilizado localmente ou para download a partir de um servidor, nesse segundo caso é proposto o uso de uma API. Um exemplo dessa API e do arquivo pode ser visto [aqui](../AdaptationRulesApi)
  
- CurrentContextManager(listContext:MutableList<Context>, planRoles: PlanningRolesManagement):Boolean - Avalia se houve uma mudança no contexto que necessite que seja feita uma adaptação nas ações executadas pela aplicação.
  
- KnowLedgeAnalysis(listContext:MutableList<Context>, knowledgeRepresentation:KnowledgeRepresentation ):ResultEntry - Analisa features e contexto com base na base de conhecimento e retorna a saída que deve ser apresentada ao usuário
  > Você não é obrigado a utilizar a base de conhecimento para análise, como sugerido, criando seu próprio método de análise. Caso use a base de conhecimento, é possível usar a nálise da base de conhecimento gerada a patir do grafo de classificação, como sugerido. Ou fazer uma nálise diferente e específica para aplicação sem o uso do grafo de classificação. 

### - FeatureExtraction.kt 

Classe responsável pela extração das features que são usadas para análise dos dados sos sensores
  
> Attributes
> - context:BaseActivity
  
#### Methods that must not be changed
  
- SMV(axisX:Double, axisY:Double, axisZ:Double):Double - Tratamento de dado de sensores Triaxial, compilando os valores dos três sensores em apenas um valor com base na média dos quadrados dos valores de cada eixo. Esse valor é usado para preprocessamento dos valores dos sensores tiaxiais para posterior extração de features.
  
#### Methods that must be changed
  
- featureDataExtraction():MutableList<VerticeFeature> - Extrai features com base nos dados brutos coletados dos sensores
  > O Desensolvedor deve gerar um métodos de preprocessamento dos dados brutos, caso preciso, antes de extrair as features. No exemplo base é proposto o preproessamento de valores de sensores triaxiais, como accelelerômetros e giroscóvpios, usando o valor da média dos quadrados dos valores dos eixos (square mean values - smv)

- getFeatures(values:MutableList<Any>?): MutableList<VerticeFeature> - Retorna lista de features com base nos dados brutos ou preprocessados dos sensores
  > O desenvolvedor deve modificar esse método para extrair as features que for necessa´rias para  anaálise. No caso de usar a base de conhecimento gerada a partir do grafo de classificação sugerido, é preciso que as features sejaam as mesma usadas como entrada para os modelos inteligentes treinados.
  
### - FeatureFunctions.kt
  
Classe que contém um conjunto de métodos de tratamento de dados para extração de features. Outros métodos podem ser adicionados pelo desenvolvedor.
  
#### Methods that must not be changed
  
- Mean(values: MutableList<Double>?):Double - Retorna a Média aritmética de uma lista de valores reais
- Max(values: MutableList<Double>?):Double - Retorna o Maior valor de uma lista de valores reais
- Min(values: MutableList<Double>?):Double - Retorna o Menor valor de uma lista de valores reais
- STD(values: MutableList<Double>?):Double - Retorna o Desvio padrão de uma lista de valores reais
- Kurtosis(values: MutableList<Double>?):Double - Retorna o valor de Kurtosis de uma lista de valores reais
- Skewness(values: MutableList<Double>?):Double - Retorna o valor de Skewness de uma lista de valores reais
- Entropy(values: MutableList<Double>?):Double - Retorna o valor de Entropia de uma lista de valores reais
- MAD(values: MutableList<Double>?):Double - Retorna o Desvio médio absoluto de uma lista de valores reais
- median(l:Int, n:Int):Int - Retorna do valor da Mediana de uma lista de valores
- IQR(values: MutableList<Double>?): Double - Retorna o valor do Intervalo Interquatil de uma lista de valores reais

### [planning]
  
Classes relacionados ao módulo de planejamento

### - PlanningRolesManagement.kt (main module class)
  
Classe principal do módulo de planejamento. Gerencia o planejamento de ações
  
> Attributes
> - context:BaseActivity
> - adaptationActions:MutableList<String>
> - resultEntry:ResultEntry?
> - changeContext:Boolean
> - observers: MutableList<IPlanningObserver>

#### Methods that must not be changed
  
- Plan() - Principal método da classe. Esse método é responsável pelo planejamento das ações que serão executas pela aplicação. Caso no módulo de análise não seja indicado que é ncessário uma adaptação, é chamdo o módulo de execução sem que um novo planejamento seja feito, casoc contrário o método de planejamento e escolha de novas ações com base nas regras de adaptação é chamada. 
- update() - executa quando a classe principal do módulo de análise informa que a análise do contexto e features já foi executada (executa método sendUpdateEvent())
  
#### Methods that must be changed
  
- ChoiceActions(contexts:MutableList<Context>):MutableList<String> - Método responsável pelo planejemnto e escolha das ações que devem ser executadas pela aplicação caso seja necessário haver alguma adaptação ou caso seja a primeira execução do loop MAPE-K.
> As regras de adaptação podem ser definidas no código pelo desensolvedor ou em um documento a parte. No eemplo base usamos um aquivo xml onde são especificadas as regras de adaptação seguindo o template proosto pelos autores do framework. Esse arquivo pode ser disponibilizado localmente ou para download a partir de um servidor, nesse segundo caso é proposto o uso de uma API. Um exemplo dessa API e do arquivo pode ser visto [aqui](../AdaptationRulesApi)

### - ReadAdaptationXML.kt (Optional)

Classe responsável pela leitura do arquivo que contém as regras de adaptação. Essa classe é opcional caso o desenvolvedor opite por não utilizar um arquivo para representação das regras de adaptação.
  
#### Methods that must not be changed
  
- readXML(context:BaseActivity) - Ler arquivo com as regras de adapção, preenche um objeto <i>AdaptationRules</i> e retorna esse objeto
- downloadXML(url:String):String - Baixa o arquivo com o template de regras de adaptação usando a API no servidor. 

### [execution]
  
Classes relacionados ao módulo de execução
  
### - ExecuteActions.kt (main module class)
  
Classe principal do módulo de planejamento. Gerencia o planejamento de ações
  
> Attributes
> - context:BaseActivity
> - dynamicActions:MutableList<String>
> - resultEntry:ResultEntry?
> - observers: MutableList<IExecutionObserver>

#### Methods that must not be changed
- update() - executa quando a classe principal do módulo de planejamento informa que o planejamento foi finalizado (executa método sendUpdateEvent())
  
#### Methods that can be changed
  
- activitiesExecute() -  método principal da classe. Reponsável pela execução das ações da aplicação. 
> Você pode modificar a maneira como verifica se ocorreu adaptação e a ordem que executa as ações, mas pode manter o mesmo procesidmento e só alterar o tempo final de espera para que um novo loop MAPE-K reinicie

#### Methods that must be changed
-  getActions(actions:MutableList<String>, currentActions:MutableList<String>):MutableList<Task2> - Seleciona as ações que devem ser executadas
> Você deve informar aqui as ações principais que são executas pela sua aplicação
 
### - Action.kt

A User app actions class template. Import methods from class Task2 from SUCCEED framework. 
> The Developer can create new application-specific actions/behaviors or a generic action based on this class and to execute it, you must instantiate an object of this class to the <i>getActions()</i> method of the <i>ExecuteActions</i> class. i> and add to the file with the adaptation rules or the application's own adaptation logic generated by the developers if a file with the adaptation rules is not used.
  
#### Methods that must be changed

- evaluate(p0: Any?) - Avalia os dados informados para execução da ação (geralmente um objeto ResultEntry) para inciar a execução, priorizar ação ou fazer algum tratamento. 
- executar() - Método responsável por executar a ação. O desenvolvedor pode projetar a execução da ação de modo a apresentar diferentes comportamentos, de acordo com o que foi avaliado no método <i>evaluate()</i>.
- retorno() - Método opcional usado para executar uma ação após retorno da ação executadano método <i>executar()</i>
- recebeToken(p0: Any?) e retornaToken() - Métodos opcionais para tráfego de infromação como Token específica ao executar e ao terminar execução

### - TextAction.kt, AudioAction.kt, LightAction.kt, VibrationAction.kt  (Optional)

A sample app actions class. Import methods from class Task2 from SUCCEED framework. Can be excluded by user.

### [knowledge]
  
Classes relacionados a gerência de conhecimento

### - KnowledgeManagement.kt (main module class)
  
Classe principal do módulo de gerência de conhecimento. Gerencia a base de conhecimento

> Attributes
> - context:BaseActivity

#### Methods that can be changed

- knowledgeManager(myfeatures:MutableList<VerticeFeature>): KnowledgeRepresentation - instancia e retorna um objeto KnowledgeRepresentation, representando a base de conhecimento, para uso pelos módulos do ciclo MAPE-K
> Você pode modificar esse método, caso não queira usar como base de conhecimento o grafo de classificação proposto pelos autores do framework
  
- datasetUpdate(myFeatures: MutableList<VerticeFeature>): KnowledgeRepresentation - método opcional que instancia um objeto KnowledgeRepresentation com base no grafo de classificção diponível no seridvor.
  
- loadModelFile(fileDescriptor: AssetFileDescriptor): MappedByteBuffer - instancia modelo inteligente Tensorflow Lite .tflite
  
- buildlocalKnowledgeRepresentationLocal(knowledgeRepresentation: KnowledgeRepresentation, myFeatures: MutableList<VerticeFeature>): KnowledgeRepresentation - método opcional para criar uma base de conhecimento para testes
  
- datasetUpload() - método opcional para envio de dados paro o servidor, com a finalidade de prover dados da aplicação para o sistema do grafo de classificação permiteindo que o grafo seja atualizado com esses dados. 
  
## [path utils]

### Constants.kt

Constantes do sistema que ssão utilizadas pela demais classes para aplicação  
  
#### Methods that must be changed
  
> Você deve alterar os valores das constantes para sua aplicação de acordo com o que deve ser implementado. Caso julgue necessário, você deve criar novas constantes para a aplicação.

### Cryptography.kt
  
Classe utilitária com diferentes métodos para criptografar dados
  
> Constants 
> - AES_KEY_SIZE: 256 (AES Encryption Key Size)
> - RSA_CIPHER_ALG = "RSA/ECB/PKCS1Padding" (RSA Algorithm)
> - AES_CIPHER_ALG = "AES/CBC/PKCS5Padding" (AES Algorithm)
  
#### Methods that must not be changed

- encryptWithRSA(context: Context, input: String): String - encriptação usando algoritmo RSA
- getRSAPublicKey(context: Context): PublicKey - Retorna chave pública de encriptação RSA
- getKeyAsBase64(key: SecretKey): String -  Retorna chave de encriptação com base 64
- generateRandomAESKey(): SecretKey - Gera chave AES aleatória
- generateIv(): IvParameterSpec - Gera parâmetros para criptografia com base 16
- encryptWithAES(key: SecretKey, iv: IvParameterSpec, input: String): String - encriptação usando algoritmo AES 

### DateUtil.kt

Contém métodos para formatação e requisição de dados usados no DataController
 
#### Methods that can be changed
  
- getBeginDateForRegisters(): Date - Retorna data atual
- getEndDateForRegisters(): Date - Retorna hora atual
- getBeginDateForRegistersLong(): Long - Retorna data atual para milisegundos
- getBeginDateForRegistersLong(): Long - Retorna hora atual para milisegundos
- getSecondsFormatted(seconds: Long) - Converte milisegundos para segundos

### GoogleApiUtil.kt
  
Contém métodos utilitários para acesso a API e conta Google do usuário da aplicação

> Attributes
> - context:BaseActivity
> - account: GoogleSignInAccount?
> - client: GoogleSignInClient
  
> Has an <i>init</i> constructor method

#### Methods that must not be changed

- signIn() - Reuisição de login na conta Google
- googleResult(data: Intent?): Boolean? - Retorna resultado da requisição de login
- isLogged():Boolean - Verifica se usuário está logado em alguma ocnta Google
- getName(): String  - Retorna nome do usuário logado na conta Google
- getEmail(): String  - Retorna email do usuário logado na conta Google
- getImage(): Uri?  - Retorna imagem do usuário na conta Google

### PermissionUtil.kt

Contém métodos para verificação e requisição de permissões de acesso ao armazenamento interno e aos componentes de hardware do dipositivo android
  
#### Methods that can be changed

- checkDevicePermission(context: BaseActivity) : Boolean - Verifica permissão de acesso ao armazenamento interno e aos sensores do dipositivo android
-  requetPermission(context: BaseActivity) - Requisita acesso ao armazenamento interno e aos sensores do dipositivo android

### Animations.kt (Optional)

Have a string animation method for base sample application in the framework. Can be excluded by user.


