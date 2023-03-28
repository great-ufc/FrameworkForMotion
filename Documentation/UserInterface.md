# Views e Activities (User Interface - UI)

## Views [path res]

O pacote <b>res</b> contém os elmentos visuais de cada tela da aplicação. O Framework proposto no entanto não apresenta nenhum elemento específico para contrução de views, pois entendemos que a maneira como cada tela deve ser sontruída depende exclusivamente de cada aplicação e cabe aos desenvolvedores e UX Designers do time de desenvolvimento da aplicação definir quais elmentos visuais a aplicação irá utilizar. A única restrição do framework é a necessidade de o app tenha ao menos uma tela principal que inicie a coleta de dados e o ciclo de adaptação, linkando assim essa tela a classe MainActivity. Essa tela não precisa ser a primeira tela da aplicação, inclusive, caso necessário sugerimos haver uma tela anterior a esta para que o usuário efetue login, mas é importante que exista uma tela principal (MainActivity) para o APP, como é de praze parq aulquer aplicação mobile.

## User Interface [path ui]

Contém as Activities e Fragmentos que controlam as telas da aplicação e seus componentes

### [path CommonActivities] BaseActivity.kt

Classe base para uso da Activity Principal e pelas classes controladoras e modelo. Contem elementos necessários para manipulação de informações do dispositivos, sensores e armazenamento de dados que são necessáris para construção da aplicação IoHT autoadaptativas.

> Attributes
> - toast: Toast
> - dataController: DataController
> - baseDirectory:String
> - assetManager: AssetManager
> - knowledgeRepresentation: KnowledgeRepresentation?
> - energy: Double?
> - actions: MutableList<String>
> - sensors: MutableList<typeSensor
> - datas: MutableList<ValuesSensor>
> - googleFitAPI: GoogleFitAPI
> - knowledgeManagement: KnowledgeManagement
> - collectAcc: CollectAcc
> - finalStatus: String

#### Methods that must not be changed

- onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) - Método chamado quando a activity é lançada
- showLongToast(text: String, isCenter: Boolean) - Apresenta uma mensagem longa em um Toast
- showShortToast(text: String, isCenter: Boolean) - Apresenta uma mensagem curta em um Toast
- showToast(text: String, mode: Int, isCenter: Boolean) - Apresenta a mensagem em um Toast

### [path CommonActivities] - LoginActivity.kt
  
Classe Activity exemplo para tela de Login usando a conta Google
  
> Attributes
> - loginController: LoginController

#### Methods that must not be changed
  
- onCreate(savedInstanceState: Bundle?) - Método chamado quando a activity é lançada
- onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)  - Método chamado quando a tela ao qual está associada a Activity é chamada ou quando volta-se para esta tela recebendo o resultado de uma Intent

#### Optional componnent
  
btnSignIn: Button - Botão de Login na conta Google

### MainActivity.ht
  
Exemplo de classe referente ao controle da tela principal do App. Todo App Android contruído com esse framework tem de ter uma Activity relacionada  uma tela principal que irá iniciar o loop MAPE-K e será usada para coleta de dados dos sensores. É possível coletar sensores em outras telas, nesse caso é sugerido que qualquer tela que colete dados de sensores para aplicação, tenha associado uma Activity que herde a calsse <i>BaseActivity.kt</i> 

> Framework Attributes
> - sensorManager: SensorManager
> - mAccelerometer : Sensor
> - mGyroscope : Sensor
> - dbPessoa: IPessoaRepository (Person DBEntity Sample)

´´´ Change these attributes for specific app customize´´´
  
> User customize attributes (all optionals)
  
  
#### Methods that must not be changed

#### Methods that must  be changed

#### Código que deve ser Alterado

#### Methods that can be changed

  
Para cada tela da aplicação é comum se ter uma cativity associada para controle do componente dessas telas. Cabe a equipe de desenvolvimento projetar e implementar essas outras activities, caso necessário.
