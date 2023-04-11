# Views e Activities (User Interface - UI)

## Views [path res]

The <b>res</b> package contains the visual elements of each screen in the application. However, the proposed framework does not include any specific elements for building screens, as we understand that the way each screen should be constructed depends exclusively on the application. It is up to the developers and UX designers of the application development team to define these visual elements. The only restriction of the framework is the requirement that the app has at least one main screen for initiating sensor data collection and the adaptation cycle, thus linking this screen to the MainActivity class. This screen does not need to be the first screen of the application. In fact, if necessary, we suggest having a screen prior to this for the user to log in.

## User Interface [path ui]

This package contains Activities and Fragments that control the screens of the application and their components

### [path CommonActivities] BaseActivity.kt

Base class for use of the Main Activity and by the controller and model classes. It contains the necessary elements for manipulating device information, sensors, and data storage that are required for building self-adaptive IoHT applications.

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

- onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) - Method called when the activity is launched
- showLongToast(text: String, isCenter: Boolean) - Displays a long message in a Toast
- showShortToast(text: String, isCenter: Boolean) - Displays a short message in a Toast
- showToast(text: String, mode: Int, isCenter: Boolean) - Displays the message in a Toast

### [path CommonActivities] - LoginActivity.kt
  
Example Activity class for a Login screen using Google account.
  
> Attributes
> - loginController: LoginController

#### Methods that must not be changed
  
- onCreate(savedInstanceState: Bundle?) - Method called when the activity is launched
- onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)  - Method called when the screen to which the Activity is associated is called or when returning to this screen receiving the result of an Intent

#### Optional componnent
  
btnSignIn: Button - Google account login button

### MainActivity.ht
  
Example of a class for controlling the main screen of the App. Every Android App built with this framework must have an Activity related to a main screen that will start the MAPE-K loop and be used for sensor data collection. It is possible to collect sensors in other screens, in which case it is suggested that any screen that collects sensor data for the application be associated with an Activity that inherits the <i>BaseActivity.kt</i> class.

> Framework Attributes
> - sensorManager: SensorManager
> - mAccelerometer : Sensor
> - mGyroscope : Sensor
> - dbPessoa: IPessoaRepository (Person DBEntity Sample)

```Change these attributes for specific app customize```
  
> User customize attributes (all optionals) (Only for app Framework Sample)
> - googleFitStepData:GoogleFitStepData
> - textview_first: TextView
> - textview_second: TextView
> - textview_third: TextView
> - button: Button
> - buttonStart: Button
> - buttonStartMonitoring: Button
> - buttonStop: Button
> - buttonChangeBattery: Button
> - appBarConfiguration: AppBarConfiguration
> - binding: ActivityMainBinding
> - stop:Boolean
> - fitstepInfo: String
  
```If you run the Framework without changing anything, it will generate an example application to test some of the framework's features.```
  
#### Methods that must not be changed
  
- override fun onCreate(savedInstanceState: Bundle?) - Method called when the activity is launched. Some lines of code/elements in this method are mandatory, while the remaining lines of the class can or should be customized for the application to be developed. The mandatory elements are:
> MAPE-K initiate
   ```
   val monitor = DataManagement(this) 
   val analysis = DataAnalysis(this)
   val planning = PlanningRolesManagement(this)
   val execution = ExecuteActions(this)
   monitor.observers += analysis
   analysis.observers += planning
   planning.observers += execution
   execution.observers += monitor
   ```
  
#### Methods that must  be changed

- onAccuracyChanged(sensor: Sensor?, accuracy: Int) - Executes when the accuracy of the sensor is changed. It is a mandatory method for activities that inherit from <i>SensorEventListener</i>. This listener is used for sensor data collection events on the device.

#### Methods that can be changed
  
- override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) - Method called when the screen associated with the Activity is called or when returning to this screen receiving the result of an Intent.

#### User customize Methods (Optional) (Only for app Framework Sample)
  
- oAuthErrorMsg(requestCode: Int, resultCode: Int) - Displays error message accessing Google Fit
- onCreateOptionsMenu(menu: Menu): Boolean - Create Navigation Menu Options
- onOptionsItemSelected(item: MenuItem): Boolean - Performs action when selecting an element from the Navigation Menu
- onSupportNavigateUp(): Boolean - Create Navigation Menu
- onResume() - Runs when the activity's screen is in the foreground
- onPause() - Runs when the activity's screen leaves the foreground
- onSensorChanged(event: SensorEvent ?) - Runs when sensors collect a value
  
  
### Other Activities 

For each screen of the application, it is common to have an associated activity for controlling the components of these screens. It is up to the development team to design and implement these other activities if necessary.
