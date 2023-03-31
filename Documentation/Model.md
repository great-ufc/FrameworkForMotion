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

This folder contains the classes that must be created, if necessary, for connection with an external server application that may or may not be in a cloud environment. 

### KnowledgeDownload.kt

This class contains the methods for downloading the classification graph, creating the object in the format of the <i>KnowledgeRepresentation</i> entity based on this graph, and downloading the trained intelligent models from the server. 

```diff
We recommend the use of the classification graph, however, developers are not obligated to use it, and in case they do not use 
the graph, it is up to them to decide how to construct the representation of their knowledge base for the application. In this 
situation, this class becomes optional.
```

#### Methods that can be changed

- update(mutableList: MutableList<VerticeFeature>, context: BaseActivity): KnowledgeRepresentation - A method that requests the download of the optimized graph for application and generates the object in the format of the <i>KnowledgeRepresentation</i> entity based on the graph. It also downloads the trained models and adds the reference of the models to the created <i>KnowledgeRepresentation</i> object.
  - <i>You do not need to make any changes to this class if it is not desirable, but the server address for requesting the optimized graph is saved in the constants LAST_OPTIMIZE_GRAPH_ADDRESS (requests the last optimized graph) and OPTIMIZE_GRAPH_ADDRESS (requests a new optimized graph for the sensors and the threshold informed). The value of these constants should be changed to the link of the server that contains the classification graph application that the developers are using, if they are using the classification graph. </i> 
- updateKnowledgeRepresentationTfLite(knowledgeRepresentation: KnowledgeRepresentation, context: BaseActivity):KnowledgeRepresentation -  Instantiate training models on the <i>KnowLedgeRepresentation</i> object that use the TfLite extension.
- loadModelFile(model:String,manager: AssetManager): MappedByteBuffer? - Instantiate a TfLite model.
- downloadXML(url:String, context: BaseActivity):String - Download the classification graph, save it on the device and return the content of the XML file as a string.
- downloadModels(knowledgeRepresentation: KnowledgeRepresentation, context: BaseActivity) - Download the trained smart models.
- downloadModel(url: URL, outputFileName: String, context: BaseActivity) - Download a file and save it on the device.
- readXMLGraph(xml: String, featuresList: MutableList<VerticeFeature>? = null): KnowledgeRepresentation - Builds the KnowLedgeRepresentation object based on the XML file that represents the optimized classification graph that has been downloaded.

<i>Note: If you don't use a trained model in TfLite format, you can add another method in this class for the trained model format you want to use.</i>

## [path dao]
  
This folder contains the data access classes for the SQL Lite database, where we use the DAO and Repository design patterns.

### [data]

### - UnityofWork.kt
  
> Attributes
> - dbHelper: SQLiteOpenHelper
  
Class for transaction control for database change operations.
  
#### Methods that must not be changed.

- transaction() - start transaction for database change operation.
- commit() - end transaction for database change operation.
- rollback() - undo operations performed during transaction for database change operation.
  
### [DBEntities]

### - Pessoa.kt
  
> Attributes
> - id: Int
> - nome:String
  
#### Class that can be changed
  
  Example of <i>Person</i> entity for the database.
  
### [interfaces]
  
Interfaces for DAO and Repository design patterns. For each entity, you should create an interface.
  
### - IPessoaRepository.kt

Interface para PessoaRepository
  
- Add(pessoa: Pessoa) - Add a record in the table referring to Entity Person.
- GetPersonById(id: Int): Pessoa - Returns a record from the Person table.
- getAll(): MutableList<Pessoa> - Returns all records from the Person table.

### - IRepository.kt
  
Interface for Repository
  
- Add(cValues:ContentValues):Int - Add new record to table.
- GetById(id:Int): Cursor - Returns a record from a table.
- GetAll(): Cursor - Returns all records from the table.
- Update(id:Int, info:String, valor:Boolean):Boolean - Update a record.
- Update(id:Int, info:String, valor:Byte):Boolean - Update a record.
- Update(id:Int, info:String, valor:ByteArray):Boolean - Update a record.
- Update(id:Int, info:String, valor:Double):Boolean - Update a record.
- Update(id:Int, info:String, valor:Float):Boolean - Update a record.
- Update(id:Int, info:String, valor:Int):Boolean - Update a record.
- Update(id:Int, info:String, valor:Short):Boolean - Update a record.
- Update(id:Int, info:String, valor:String):Boolean - Update a record.
- Remove(id:Int): Boolean - Remove a record.
- RemoveAll(): Boolean - Remove all records.
- SaveChanges() - Confirm operation.

### - IUnityofWork.kt
  
Interface for IUnityofWork
  
- transaction() - start transaction for database change operation.
- commit() - end transaction for database change operation.
- rollback() - undo operations performed during transaction for database change operation.

### [repository]

This folder contains all classes related to repository classes for manipulation of database tables.

### - Repository.kt

Abstract base repository class for DAO pattern.
  
> Attributes
> - ctx: Context
> - TABLE_NAME:String
> - lstColunms: MutableList<Triple<String,String,Boolean>>?

#### Methods that must not be changed.

- Add(cValues:ContentValues):Int - Add new record to table.
- GetById(id:Int): Cursor - Returns a record from a table
- GetAll(): Cursor - Returns all records from the table.
- Update(id:Int, info:String, valor:Boolean):Boolean - Update a record.
- Update(id:Int, info:String, valor:Byte):Boolean - Update a record.
- Update(id:Int, info:String, valor:ByteArray):Boolean - Update a record.
- Update(id:Int, info:String, valor:Double):Boolean - Update a record.
- Update(id:Int, info:String, valor:Float):Boolean - Update a record.
- Update(id:Int, info:String, valor:Int):Boolean - Update a record.
- Update(id:Int, info:String, valor:Short):Boolean - Update a record.
- Update(id:Int, info:String, valor:String):Boolean - Update a record.
- Remove(id:Int): Boolean - Remove a record.
- RemoveAll(): Boolean - Remove all records.
- SaveChanges() - Confirm operation.

### - [EntityRepositoriesSamples] PessoaRepository.kt

DAO class for manipulation of the Person table.
  
> Attributes
> - context: Context
  
#### Methods that can be changed
  
- Add(pessoa: Pessoa) - Add a record in the table referring to Entity Person.
- GetPersonById(id: Int): Pessoa - Returns a record from the Person table.
- getAll(): MutableList<Pessoa> - Returns all records from the Person table.
  
## [path entities]

Folder containing the entities of the application.
  
### AdaptationRules.kt

Entity related to the set of adaptation rules.

> Attributes
> - adaptationList:MutableList<Adaptation>  
  
### - class Adaptation
  
Adaptation entity.
  
> Attributes
> - action:String
> - contextList: MutableList<context>

### - class context
  
Entity context for adaptation rules.
  
> Attributes
> - name:String
> - signal:String
> - value: String

### Context.kt
  
Entity that represents the context collected by the application.
  
> Attributes
> - name:String
> - value:Any

### EdgeSensorFeature.kt
  
Entity that represents the edge that connects the Sensor to Feature for knowledge representation based on the classification graph proposed by the framework authors.

> Attributes
> - vSensor: VerticeSensor
> - vFeature: VerticeFeature
> - contexts: MutableList<Context>?

### EdgeFeatureModel.kt
  
Entity that represents the edge connecting the Feature and the Model for knowledge representation based on the classification graph proposed by the authors of the framework.

> Attributes
> - vFeature:VerticeFeature
> - vModel: VerticeModel
> - contexts: MutableList<Context>?

### EdgeModelsFinalStatus.kt

Entity that represents the edge that connects the Model and the FinalStatus for knowledge representation based on the classification graph proposed by the framework authors.

> Attributes
> - vModel: VerticeModel
> - vFinalStatus: VerticeFinalStatus
> - probability:Double?

### KnowledgeRepresentation.kt

Entity for Knowledge Base Representation.

> Attributes
> - edgeSensorFeature: MutableList<EdgeSensorFeature>
> - edgeFeaturesModel: MutableList<EdgeFeatureModel>
> - edgeModelsFinalStatus: MutableList<EdgeModelsFinalStatus>

#### Methods that can be changed 
  
> As designed, this class represents the same elements as the classification graph proposed by the framework authors. If the developer wants to propose a different way of representing knowledge for the application, it is recommended to modify these entities by changing their attributes.
  
### ResultEntry.kt
  
Entity that represents the analysis result, including the current context, the probability as the analysis result, and the final state.

> Attributes
> - context:MutableList<Context>
> - probability: Double
> - finalStatus:String

### VerticeSensor.kt

Entity that represents the sensor in the knowledge base for knowledge representation based on the classification graph proposed by the framework authors.

> Attributes
> - typeSensor: String

### VerticeFeature.kt

Entity that represents the feature in the knowledge base for knowledge representation based on the classification graph proposed by the framework authors.

> Attributes
> - feature: Double
> - featureName:ValuesFeatures

### ValuesFeatures.kt

Entity that represents the value of the feature in the knowledge base for knowledge representation based on the classification graph proposed by the framework authors.

> Attributes
> - finalStatus:String

### VerticeModel.kt

Entity representing the model in the knowledge base for knowledge representation based on the classification graph proposed by the authors of the framework.

> Attributes
> - modelName: String
> - inFeature:Int
> - outFeature: Int
> - model:Interpreter?
  
#### Methods that must not be changed.

- setSmartModel(newmodel: Interpreter?) - Instantiate the trained intelligent model.

### VerticeFinalStatus.kt

Entity that represents the final status in the knowledge base for knowledge representation based on the classification graph proposed by the framework authors.

> Attributes
> - finalStatus:String

### [sensors]
  
This folder contains the entities specific for handling sensors manipulation.

### - typeSensor.kt

Enumerator that identifies the type of sensor.

> Type Sensors
> - ACC
> - GYR
> - GPS
> - WIFI
> - MIC

### - ValuesACC.kt

Entity that represents the accelerometer values.

> Attributes
> - eixoX:Double
> - eixoY:Double
> - eixoZ:Double

### - ValuesSensor.kt

Entity representing the generic sensor value.

> Attributes
> - idSensor:String
> - value:Any

## [path mapek]
  
In this package are the modules related to the MAPE-K loop

### [monitoring]
  
Classes related to the monitoring module.

### - DataManagement.kt (main module class)
  
Class main for the monitoring module. Manages the monitoring of data.

> Attributes
> - context: BaseActivity
> - dataCollectTime:Long
> - googleFitAllData:GoogleFitGetAllData?
> - observers: MutableList<IMonitorObserver> 
  
#### Methods that must not be changed
  
- update() - This method executes when the main class of the execution module informs that the actions have been executed (by calling the sendUpdateEvent() method).
  
#### Methods that must be changed

- Monitoring() - Manages the monitoring by obtaining the data collected from the sensors. When the collection window is reached, it informs the main class of the analysis module (executes the sendUpdateEvent() method).

> The user must inform which sensors are being collected. The collected data should be stored in a shared attribute of the main Activity (it's possible to use the DataController)

### - ICollectorData.kt
  
Interface for data collection classes from android device sensors
  
#### Methods that must not be changed

- collectData(event: SensorEvent?):Any - data collection method.
- FormatData(value:String):Any - method to treat the data to later generate the features.
- getValueData(): String - get method for collected values.

### - CollectACC.kt
  
Class for accelerometer sensor data collection
  
> Attributes
> - myData:String
  
#### Methods that must not be changed

- collectData(event: SensorEvent?):Any - method of collecting data from the accelerometer sensor that is instantiated in the main activity.
- FormatData(value:String):Any - method to treat the data to later generate the features.
- getValueData(): String - get method for collected values

### - CollectGyr.kt
  
Class for gyroscope sensor data collection
  
> Attributes
> - myData:String
  
#### Methods that must not be changed

- collectData(event: SensorEvent?):Any - method of collecting data from the gyroscope sensor that is instantiated in the main activity.
- FormatData(value:String):Any - method to treat the data to later generate the features.
- getValueData(): String - get method for collected values

### - CollectEnergy.kt
  
Class for collecting cell phone battery level

> Attributes
> - energy: Double
  
#### Methods that must can be changed

- collectEnergy(context: BaseActivity):Double - Collects and displays the current battery level of the device,

### - [GoogleFit] GoogleFitAPI.kt
  
Class with the basic methods for connection and data collection from Google Fit.

> Attributes
> - activity: BaseActivity

#### Methods that must not be changed
  
- requestFitPermission() - Request permission to access the Google Fit API
  
> You need an Auth 2.0 credential to access the Google APIs. We recommend following the steps in the documentation provided by Google, which can be accessed at: https://developers.google.com/fit/android/get-api-key
  
- oAuthPermissionsApproved() - checks if the application already has access to the Google Fit API.  

 - getGoogleAccount() - requests user access permission to google account.
  
- getFitnessOptions() - records what API data you want to collect.

### - [GoogleFit/Samples] GoogleFitGetAllData.kt
  
Example class for collecting various data from Google Fit
  
> Attributes
> - activity: BaseActivity
  
#### Methods that can be changed
  
- checkPermissionAndGetData() - Check permission to access Google Fit data, if not, request access.
- getData(context: Context, dataController: DataController) - Collects data from Google Fit and populates DataController object.
- getDataStatic(context: Context, dataController: DataController) -  Collects data and sets collection interval.
- getDataStatic(context: Context, dataController: DataController, beginDate: Long, endDate: Long) - Collect Measures, Calories, Heart Rate and Sleep from Google Fit
- accessGoogleFit(dataType: DataType, context: Context, dataController: DataController, beginDate: Long, endDate: Long) - access data from Google Fit
- getBodyMeasures(dataType: DataType, context: Context, dataController: DataController) - Collect Measurements (e.g. Weight and Height) recorded in Google Fit
- getHeartRate(context: Context, dataController: DataController, beginDate: Long, endDate: Long) - Collects Heart Rate Values recorded in Google Fit
- accessSleepData(context: Context, dataController: DataController, beginDate: Long, endDate: Long) - Collects Sleep Quality Values recorded in Google Fit

### - [GoogleFit/Samples] GoogleFitStepData.kt

Example class for data collection regarding Google Fit step count.
  
> Attributes
> - activity: BaseActivity
  
#### Methods that can be changed
  
- fitSignIn(requestCode: Int) - Check permission to access Google Fit data, if not, request access.
- performActionForRequestCode(requestCode: Int) - Collects step count data from Google Fit
- insertAndReadData() - Records historical data
- insertData(): Task<Void> - Collects Google Fit data and records it in a DataSet object
- readHistoryData(): Task<DataReadResponse> -  Google Fit historical data collection
- insertFitnessData(): DataSet - Collects Google Fit step count data and records it in a DataSet object
- queryFitnessData(): DataReadRequest - Query list of collected step count data
- printData(dataReadResult: DataReadResponse) - Displays data collected from Google Fit
- dumpDataSet(dataSet: DataSet) - Save data log
- DataPoint.getStartTimeString(): String - Returns collection start time
- DataPoint.getStartTimeString(): String - Returns collection end time
- deleteData() - Deletes from the API the data that has already been collected
- updateAndReadData() - Updated search historical data
- updateData() - Updates search for data to collect from Google Fit
- updateFitnessData(): - Update search for step count data to collect from Google Fit

### [observers]

All Observer Interfaces were created specifically to enable the use of the observer pattern by the main classes of the modules of the adaptation cycle (monitoring, analysis, planning and execution) and must not be changed. If you want to use the observer pattern for other classes, please create new observer interfaces (in a package other than mapek) for the classes you want.

> The "Observer" interface corresponds to observer classes that will execute the <update()> method when the class with the corresponding "Observable" interface that is being observed executes the <sendUpdateEvent()> method.

> Also, classes with interface "Observable" add their observers (classes with interface "Observer") using method <add()>.

### [analysis]
  
Classes related to the analysis module

### - DataAnalysis.kt (main module class)
  
Main class of the analysis module. Manages context analysis

> Attributes
> - context:BaseActivity
> - contextList:MutableList<Context>
> - myFeatures:MutableList<VerticeFeature>
> - observers: MutableList<IAnalysisObserver>
  
#### Methods that must not be changed

- setContextList(energy:Double) - Fills List of Context values (these values must be analyzed to identify whether or not adaptation is required)
- setFeatureList(features:MutableList<VerticeFeature>) - Fill out a list of features for analysis and indicate the result to be presented. These features may or may not be part of the context that affects the choice of actions and planning of adaptations.
-  update() - It executes when the main class of the monitoring module informs that the dataset to be analyzed has already been collected and formatted (executes the sendUpdateEvent() method).
  
#### Methods that must be changed

-   featureAnalysis() - Main method of the class. Based on the knowledge base and/or features, it performs analysis of the features and context and indicates to its observers (planning module) the result to be presented and whether it is necessary to execute app actions adaptation. This analysis of actions is based on the previously designed adaptation rules present in the code or in a file.
  > The author proposes a model of an xml file for specifying the adaptation rules, this xml file can be made available locally or for download from a server, in this second case the use of an API is proposed. An example of this API and file can be seen [here](../AdaptationRulesApi)
  
- CurrentContextManager(listContext:MutableList<Context>, planRoles: PlanningRolesManagement):Boolean - This function evaluates whether there has been a change in the context that requires adaptation in the actions performed by the application.
  
- KnowLedgeAnalysis(listContext:MutableList<Context>, knowledgeRepresentation:KnowledgeRepresentation ):ResultEntry - Analyzes features and context based on the knowledge base and returns the output that should be presented to the user.
  > You are not required to use the knowledge base for analysis as suggested, creating your own analysis method is possible. If you use the knowledge base, you can use the analysis generated from the classification graph, as suggested. Or, you can perform a different and specific analysis for the application without using the classification graph. 

### - FeatureExtraction.kt 

Class responsible for extracting features that are used for analyzing data from sensors.
  
> Attributes
> - context:BaseActivity
  
#### Methods that must not be changed
  
- SMV(axisX:Double, axisY:Double, axisZ:Double):Double - The Triaxial sensor data processing compiles the values from the three sensors into a single value based on the average of the squares of each axis value. This value is used for preprocessing the triaxial sensor values for subsequent feature extraction.
  
#### Methods that must be changed
  
- featureDataExtraction():MutableList<VerticeFeature> - Extract features based on raw data collected from sensors.
  > The developer must generate a method for preprocessing raw data, if necessary, before extracting features. In the base example, preprocessing of triaxial sensor values, such as accelerometers and gyroscopes, is proposed using the value of the average of the squares of the axis values (square mean values - smv).

- getFeatures(values:MutableList<Any>?): MutableList<VerticeFeature> - Returns list of features based on raw or preprocessed data from sensors.
  > The developer should modify this method to extract the necessary features for analysis. In case of using the knowledge base generated from the suggested classification graph, it is necessary that the features are the same as those used as input for the trained intelligent models.
  
### - FeatureFunctions.kt
  
Class that contains a set of data processing methods for feature extraction. Other methods can be added by the developer.
  
#### Methods that must not be changed
  
- Mean(values: MutableList<Double>?):Double - Returns the Arithmetic Mean of a list of real values
- Max(values: MutableList<Double>?):Double - Returns the Maximum value from a list of real values
- Min(values: MutableList<Double>?):Double - Returns the Minnor value from a list of real values
- STD(values: MutableList<Double>?):Double - Returns the Standard Deviation from a list of real values
- Kurtosis(values: MutableList<Double>?):Double - Returns the Kurtosis value from a list of real values
- Skewness(values: MutableList<Double>?):Double - Returns the Skewness value from a list of real values
- Entropy(values: MutableList<Double>?):Double - Returns the Entropy value from a list of real values
- MAD(values: MutableList<Double>?):Double - Returns the Mean Absolute Deviation from a list of real values
- median(l:Int, n:Int):Int - Returns the Median value of a list of values
- IQR(values: MutableList<Double>?): Double - Returns the Interquartile Range value from a list of real values

### [planning]
  
Classes related to the planning module.

### - PlanningRolesManagement.kt (main module class)
  
Main class of the planning module. Manages action planning.
  
> Attributes
> - context:BaseActivity
> - adaptationActions:MutableList<String>
> - resultEntry:ResultEntry?
> - changeContext:Boolean
> - observers: MutableList<IPlanningObserver>

#### Methods that must not be changed
  
- Plan() - Main method of the class. This method is responsible for planning the actions that will be executed by the application. If the analysis module does not indicate that adaptation is necessary, the execution module is called without a new planning being done. Otherwise, the method for planning and choosing new actions based on adaptation rules is called. 
- update() - Executes when the main class of the analysis module informs that the analysis of context and features has already been executed (executes the sendUpdateEvent() method).
  
#### Methods that must be changed
  
- ChoiceActions(contexts:MutableList<Context>):MutableList<String> - Method responsible for planning and selecting the actions that must be executed by the application in case there is a need for adaptation or if it is the first execution of the MAPE-K loop.
> The adaptation rules can be defined in the code by the developer or in a separate document. In the base example, we use an XML file where the adaptation rules are specified following the template proposed by the framework authors. This file can be made available locally or for download from a server, in which case an API is proposed to be used. An example of this API and the file can be seen [here](../AdaptationRulesApi)

### - ReadAdaptationXML.kt (Optional)

Class responsible for reading the file containing the adaptation rules. This class is optional if the developer chooses not to use a file to represent the adaptation rules.
  
#### Methods that must not be changed
  
- readXML(context:BaseActivity) - Reads a file with the adaptation rules, fills an <i>AdaptationRules</i> object, and returns that object.
- downloadXML(url:String):String - Downloads the file with the adaptation rules template using the API on the server. 

### [execution]
  
Classes related to the execution module.
  
### - ExecuteActions.kt (main module class)
  
Main class of the planning module. Manages action planning.
  
> Attributes
> - context:BaseActivity
> - dynamicActions:MutableList<String>
> - resultEntry:ResultEntry?
> - observers: MutableList<IExecutionObserver>

#### Methods that must not be changed
- update() - Executes when the main class of the planning module informs that the planning has been completed (executes sendUpdateEvent() method).
  
#### Methods that can be changed
  
- activitiesExecute() - Main method of the class. Responsible for executing the actions of the application.
> You can modify the way you check if adaptation has occurred and the order in which you execute actions, but you can keep the same procedure and only change the final wait time for a new MAPE-K loop to start.

#### Methods that must be changed
-  getActions(actions:MutableList<String>, currentActions:MutableList<String>):MutableList<Task2> - Select the actions to be performed.
> You should inform here the main actions that are executed by your application.
 
### - Action.kt

A User app actions class template. Import methods from class Task2 from SUCCEED framework. 
> The Developer can create new application-specific actions/behaviors or a generic action based on this class and to execute it, you must instantiate an object of this class to the <i>getActions()</i> method of the <i>ExecuteActions</i> class. i> and add to the file with the adaptation rules or the application's own adaptation logic generated by the developers if a file with the adaptation rules is not used.
  
#### Methods that must be changed

- evaluate(p0: Any?) - Evaluate the data provided for action execution (usually a ResultEntry object) to initiate execution, prioritize actions, or perform some processing.
- executar() - Method responsible for executing the action. The developer can design the action execution to present different behaviors, according to what was evaluated in the <i>evaluate()</i> method.
- retorno() - Optional method used to execute an action after returning the action executed in the <i>execute()</i> method.
- recebeToken(p0: Any?) e retornaToken() - Optional methods for information traffic as a specific Token when executing and finishing execution.

### - TextAction.kt, AudioAction.kt, LightAction.kt, VibrationAction.kt  (Optional)

A sample app actions class. Import methods from class Task2 from SUCCEED framework. Can be excluded by user.

### [knowledge]
  
Classes related to knowledge management.

### - KnowledgeManagement.kt (main module class)
  
Main class of the knowledge management module. Manages the knowledge base

> Attributes
> - context:BaseActivity

#### Methods that can be changed

- knowledgeManager(myfeatures:MutableList<VerticeFeature>): KnowledgeRepresentation - Creates and returns a KnowledgeRepresentation object representing the knowledge base, for use by the modules in the MAPE-K loop.
> You can modify this method if you do not want to use the classification graph proposed by the authors of the framework as the knowledge base.
  
- datasetUpdate(myFeatures: MutableList<VerticeFeature>): KnowledgeRepresentation - Optional method that instantiates a KnowledgeRepresentation object based on the classification graph available on the server.
  
- loadModelFile(fileDescriptor: AssetFileDescriptor): MappedByteBuffer - Instantiate Tensorflow Lite intelligent model .tflite
  
- buildlocalKnowledgeRepresentationLocal(knowledgeRepresentation: KnowledgeRepresentation, myFeatures: MutableList<VerticeFeature>): KnowledgeRepresentation - Optional method to create a knowledge base for testing purposes.
  
- datasetUpload() - Optional method for sending data to the server, in order to provide application data to the classification graph system, allowing the graph to be updated with this data.
  
## [path utils]

### Constants.kt

System constants that are used by other classes in the application. 
  
#### Methods that must be changed
  
> You should change the values of the constants for your application according to what needs to be implemented. If necessary, you should create new constants for the application.

### Cryptography.kt
  
Utility class with different methods for encrypting data.
  
> Constants 
> - AES_KEY_SIZE: 256 (AES Encryption Key Size)
> - RSA_CIPHER_ALG = "RSA/ECB/PKCS1Padding" (RSA Algorithm)
> - AES_CIPHER_ALG = "AES/CBC/PKCS5Padding" (AES Algorithm)
  
#### Methods that must not be changed

- encryptWithRSA(context: Context, input: String): String - encryption using RSA algorithm
- getRSAPublicKey(context: Context): PublicKey - Returns RSA encryption public key
- getKeyAsBase64(key: SecretKey): String - Returns base 64 encryption key
- generateRandomAESKey(): SecretKey - Generate random AES key
- generateIv(): IvParameterSpec - Generates parameters for base 16 encryption
- encryptWithAES(key: SecretKey, iv: IvParameterSpec, input: String): String - encryption using AES algorithm

### DateUtil.kt

This contains methods for formatting and requesting data used in the DataController.
 
#### Methods that can be changed
  
- getBeginDateForRegisters(): Date - Returns current date
- getEndDateForRegisters(): Date - Returns current time
- getBeginDateForRegistersLong(): Long - Returns current date to milliseconds
- getBeginDateForRegistersLong(): Long - Returns current time to milliseconds
- getSecondsFormatted(seconds: Long) - Convert milliseconds to seconds

### GoogleApiUtil.kt
  
This class contains utility methods for accessing the application user's API and Google account.

> Attributes
> - context:BaseActivity
> - account: GoogleSignInAccount?
> - client: GoogleSignInClient
  
> Has an <i>init</i> constructor method

#### Methods that must not be changed

- signIn() - Google account login request
- googleResult(data: Intent?): Boolean? - Returns result of login request
- isLogged():Boolean - Check if user is logged into any Google account
- getName(): String  - Returns username logged into the Google account
- getEmail(): String  - Returns email of the user logged into the Google account
- getImage(): Uri?  - Returns user image in Google account

### PermissionUtil.kt

This class contains methods for checking and requesting access permissions to the internal storage and hardware components of an Android device.
  
#### Methods that can be changed

- checkDevicePermission(context: BaseActivity) : Boolean - Check access permission to android device internal storage and sensors.
-  requetPermission(context: BaseActivity) - Request access to android device internal storage and sensors.

### Animations.kt (Optional)

Have a string animation method for base sample application in the framework. Can be excluded by user.


