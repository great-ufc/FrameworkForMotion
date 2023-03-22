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
mesmos, no caso de não usar o grafo, decidir como construir a representação de sua base de conhecimento para  aplicação. Nessa 
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
  
Entidade que representa a aresta que liga o Sensor a Feature

> Attributes
> - vSensor: VerticeSensor
> - vFeature: VerticeFeature
> - contexts: MutableList<Context>?

### EdgeFeatureModel.kt
  
Entidade que representa a aresta que liga a Feature e o Modelo

> Attributes
> - vFeature:VerticeFeature
> - vModel: VerticeModel
> - contexts: MutableList<Context>?

### EdgeModelsFinalStatus.kt

Entidade que representa a aresta que liga o Modelo e o FinalStatus

> Attributes
> - vModel: VerticeModel
> - vFinalStatus: VerticeFinalStatus
> - probability:Double?

### KnowledgeRepresentation.kt

Entidade para Representação da Base de Conhecimento

> Attributes
> - edgeSensorFeature: MutableList<EdgeSensorFeature>
> - edgeFeaturesModel: MutableList<EdgeFeatureModel>
> - edgeModelsFinalStatus: MutableList<EdgeModelsFinalStatus>

### ResultEntry.kt
  
Entidade que representa o resultado da análise, contemplando o contexto atual, a probabilidade tido como resultado da análise e estado final 

> Attributes
> - context:MutableList<Context>
> - probability: Double
> - finalStatus:String

### VerticeSensor.kt

Entidade que representa o sensor na base de conhecimento

> Attributes
> - typeSensor: String

### VerticeFeature.kt

Entidade que representa a feature na base de conhecimento

> Attributes
> - feature: Double
> - featureName:ValuesFeatures

### ValuesFeatures.kt

Entidade que representa o valor da feature na base de conhecimento

> Attributes
> - finalStatus:String

### VerticeModel.kt

Entidade que representa o modelo na base de conhecimento

> Attributes
> - modelName: String
> - inFeature:Int
> - outFeature: Int
> - model:Interpreter?
  
#### Methods that must not be changed.

- setSmartModel(newmodel: Interpreter?) - Instancia o modelo inteligenge treinado.

### VerticeFinalStatus.kt

Entidade que representa o estado final na base de conhecimento

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
  
Classes relacionados ao módulo d emonitoramento

### - DataManagement.kt (main module class)
  
Classe principal do módulo de monitoramento. Gerencia o monitoramento dos dados

> Attributes
> - context: BaseActivity
> - dataCollectTime:Long
> - googleFitAllData:GoogleFitGetAllData?
> - observers: MutableList<IMonitorObserver> 
  
#### Methods that must be changed

- Monitoring() - gerencia o monitoramento, obtendo os dados coletados dos sensores. Quando a janela de coleta é atingida informa a classe principal do módulo de análise (executa método sendUpdateEvent())

> O usuário deve informar quais os sensores são coletados. O dados coletados devem ser armazenados em um atributo compartilhado da Activity principal (é possível usar o DataController)
  
- update() - executa quando a classe principal do módulo de execução informa que as ações foram executadas (executa método sendUpdateEvent())

### - ICollectorData.kt

### - CollectACC.kt

### - CollectGyr.kt

### - CollectEnergy.kt

### - [GoogleFit] GoogleFitAPI.kt

### - [GoogleFit/Samples] GoogleFitGetAllData.kt

### - [GoogleFit/Samples] GoogleFitStepData.kt

### [observers]

All Observer Interfaces were created specifically to enable the use of the observer pattern by the main classes of the modules of the adaptation cycle (monitoring, analysis, planning and execution) and must not be changed. If you want to use the observer pattern for other classes, please create new observer interfaces (in a package other than mapek) for the classes you want.

The "Observer" interface corresponds to observer classes that will execute the <update()> method when the class with the corresponding "Observable" interface that is being observed executes the <sendUpdateEvent()> method.

Also, classes with interface "Observable" add their observers (classes with interface "Observer") using method <add()>.

### [analysis]

### - DataAnalysis.kt (main module class)

### - FeatureExtraction.kt 

### - FeatureFunctions.kt 

### [planning]

### - PlanningRolesManagement.kt (main module class)

### - ReadAdaptationXML.kt

### [execution]

### - ExecuteActions.kt (main module class)

### - Action.kt

A User app actions class template. Import methods from class Task2 from SUCCEED framework

### - TextAction.kt, AudioAction.kt, LightAction.kt, VibrationAction.kt  (Optional)

A sample app actions class. Import methods from class Task2 from SUCCEED framework. Can be excluded by user.

### [knowledge]

### - KnowledgeManagement.kt (main module class)

## [path utils]

### Constants.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### Cryptography.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### DateUtil.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### GoogleApiUtil.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### PermissionUtil.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### Animations.kt (Optional)

Have a string animation method for base sample application in the framework. Can be excluded by user.


