# Modelo

- Summary
- - [CloudConnection](#path-cloudConnection)
- - [Entities](#path-entities)
- - [MAPE-k](#path-mapek)
- - - [Monitoring](#monitoring)
- - - [Analysis](#analysis)
- - - [Planning](#planning)
- - - [Execution](#execution)
- - - [Knowledge](#knowledge)
- - [Utils](#path-utils)


## [path cloudConnection]

### KnowledgeDownload.kt

#### Código que não deve ser alterado

#### Código que pode ser alterado

#### Código que deve ser Alterado

#### Código a ser gerado pelo usuário


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


