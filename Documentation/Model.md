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

#### Methods that can be changed

- update(mutableList: MutableList<VerticeFeature>, context: BaseActivity): KnowledgeRepresentation - Método que solicita o download do grafo otimizado para aplicação e gera o objeto no formato da entidade KnowledgeRepresentation com base no grafo. Também baixa os modelos treinados e adiciona a referêcia dos modelos ao objeto KnowledgeRepresentation criado.
  - Você não precisa fazer nenhuma alteração nessa classe se não for desetável, mas o endereço do servidor para reuisição do grafo otimizado está salvo nas Constantes LAST_OPTIMIZE_GRAPH_ADDRESS (requisita o último grafo otimizado) e OPTIMIZE_GRAPH_ADDRESS (Solicita um novo grafo otimzado para os sensores e o threshold informado). Essas constantes devem ser alteradas para tratar o link do servidor com  aplicação do grafo de classificação que estiver sendo utilizada. 
- updateKnowledgeRepresentationTfLite(knowledgeRepresentation: KnowledgeRepresentation, context: BaseActivity):KnowledgeRepresentation -  Instancia os modelos treinandos no objeto KnowLedgeRepresentation que utilizem a extensão TfLite.
- loadModelFile(model:String,manager: AssetManager): MappedByteBuffer? - Instancia um modelo TfLite
- downloadXML(url:String, context: BaseActivity):String - Executa download do grafo de classificação, salva no dispositivo e retorna o conteúdo do arquivo XML como string
- downloadModels(knowledgeRepresentation: KnowledgeRepresentation, context: BaseActivity) - Executa download dos modelos inteligentes treinados
- downloadModel(url: URL, outputFileName: String, context: BaseActivity) - Executa o download de uma aquivo e salva no dispositivo
- readXMLGraph(xml: String, featuresList: MutableList<VerticeFeature>? = null): KnowledgeRepresentation - Constrói o objeto KnowLedgeRepresentation com base no arquivo XML que representa o Grafo de cLassificação otimizado que foi baixado

<i>Note: If you don't use a trained model in TfLite format, you can add another method in this class for the trained model format you want to use.</i>

## [path entities]

### AdaptationRules.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### Context.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### EdgeSensorFeature.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### EdgeFeatureModel.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### EdgeModelsFinalStatus.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### KnowledgeRepresentation.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### ResultEntry.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### VerticeSensor.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### VerticeFeature.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### ValuesFeatures.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### VerticeModel.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### VerticeFinalStatus.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### [sensors] 

### - typeSensor.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### - ValuesACC.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

### - ValuesSensor.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário

## [path mapek]

### [monitoring]

### - DataManagement.kt (main module class)

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

### - KnowledgeMAnagement.kt (main module class)

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


