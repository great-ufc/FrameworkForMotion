# KREATION: Kotlin fRamework for sElf-AdapTive Internet Of health thiNgs applications

This framework was developed in Kotlin and aims to assist the development of self-adaptive IoHT applications for Android devices. In this document, we present the main elements that compose this framework and the user manual for it.


# Overview

Figure 1 shows an overview of the framework components. We use the pattern MVC for the composition of its architecture, adapting the View layer into two layers, one being the View layer, composed of the application screens, and another layer containing the Activities and Fragments that control the operation of the screens and their components. The components in orange and yellow are elements of the framework and can be customized for each application. The elements in gray are specific to each application and must be developed by the development team of the application that is using the Framework.

<p align="center">
<img src="./Documentation/Images/VisaoGeral.png" width="50%" heigth="50%" >
</p>
  
  <p align="center">Figure 1. Overview of the framework</p>

Applications developed using our framework follow the MAPE-K meta-model (IBM, 2003) for implementing the adaptation loop, and for that purpose, modules were developed with a class for each of the stages of the MAPE-K loop. In addition, the framework uses the Observer software pattern (ANDRÉ, 2013) for communication between the main classes of each of the MAPE-K adaptation loop modules. To facilitate the composition of the application's knowledge base, we have created classes that provide methods for downloading and using the classification graph proposed by the framework authors, which allows for the relationship of various sensors, features based on these sensors, intelligent models trained based on these features, and final states that represent movement patterns or health states that can be inferred based on the trained intelligent models.

We also propose the reuse of the adaptation rules template proposed by the authors for creating a file to define the adaptation rules of the application. The adaptation rules in this file can be changed without directly modifying the application, allowing for changes to be made even when the application is running. Additionally, we also use the SUCCEED framework (Junior, 2018) to assist in building the actions in the Execution stage. Finally, for manipulating the data in the SQLite database on the device, we created a set of classes using the (Data Access Object)(NOCK, 2004) and Repository (PRAJAPATI, 2019) patterns. 

[Clicking here you can see the Class Diagram of the framework](https://drive.google.com/file/d/1-QNAw4qUGligPNhtXTZ_DeecIpvcVMOX/view?usp=sharing)


# Background

Here we will present a brief theoretical foundation on IoHT applications based on movement data and Self-Adaptive Systems, as well as a description of the elements used to compose the framework, including design patterns and reuse artifacts.

### Internet of Health Things systems based on motion patterns 

The Internet of Health Things (IoHT) is a term used to describe the various types of connected devices and sensors that are used to monitor and track data, and health conditions (Rodrigues et al., 2018). These devices range from wearables such as fitness trackers and smartwatches to medical equipment such as heart monitors and insulin pumps to apps and services that allow users to track their diet and exercise. The data collected by these devices is then analyzed to gain insights into a person’s health status and to help them make informed decisions about their quality of life and health (Oliveira et al. 2022). 

In recent years, the use IoHT applications that identify movement patters turned common. The IoHT applications, in particular, use devices for monitoring different physiological data of patients, allows identifying not only pre-existing health problems but also possible situations of health risk, such as falls or stroke (Park et al. 2016) (Haghi et al. 2017) (Cai et al. 2018) (Qiu et al. 2018) (De Araújo et al. 2018).

### Self-adaptive System

Self-adaptive systems are capable of monitoring and adjusting their own behavior in response to changes in environmental conditions, with the goal of improving their efficiency and effectiveness. To develop these systems, it is necessary to implement an adaptation cycle that allows for monitoring the context and adapting the application's behavior when desired. This adaptation cycle is typically modeled based on the MAPE-K management cycle proposed by IBM in the early 2000s (IBM, 2003).

### MAPE-K Loop

The MAPE-K Loop (IBM, 2003) allows modeling the adaptation cycle and managing the execution and adaptations in self-adaptive systems. It enables the system to monitor and adjust its own behavior in response to changes in the environmental conditions. The model consists of the following phases:

- Monitoring 

In this phase, the system monitors its own behavior and the environmental conditions. It collects relevant data and information that will be analyzed to identify behavior and possible changes that allow planning the application's execution and possible adaptations if necessary.

- Analysis

In this phase, the system analyzes the data collected in the Monitoring phase to identify patterns and results that assist in planning actions, opportunities for improvement, and possible necessary adaptations.

- Planning

In this phase, based on the analysis of the data, a plan of actions that the system must execute is generated. The plan may include adaptations that modify the way the system performs its actions or internal tasks.

- Execution

In this phase, the planned actions are executed by the application. The execution must be carefully monitored to ensure that the adaptations produce the expected results.

- Knowledge

All the above phases of the cycle can be assisted by a knowledge base that assists in decision-making in the various phases of the cycle. This knowledge phase can be created before the application's execution or created as the application executes, with the possible addition of new information to this base at each cycle.

### Model-View-Control Pattern

The Model-View-Controller (MVC) (BUCANEK, 2009) pattern is a software architectural pattern that separates an application into three main components: Model, View, and Controller. The purpose of this pattern is to divide business logic from the user interface, making it easier to develop, maintain, and test applications. The components of this pattern are:

- Model: It is the layer responsible for business logic and data manipulation. It contains the classes that represent application domain objects, as well as business rules that determine how these objects behave and relate to each other. The Model usually contains methods to read, create, update, and delete data, as well as other related operations.

- View: It is the layer responsible for the user interface. It presents the Model data in a format understandable to the user and provides an interactive interface for the user to interact with the application. The View can be implemented as a web page, application window, report, among others.

- Controller: It is the layer responsible for controlling the application flow and acting as an intermediary between the Model and the View. It receives user inputs and requests the appropriate operations to the Model to manipulate data. Then, it updates the View to reflect the changes. The Controller usually contains methods to handle user input, manage sessions, authentication, authorization, among others.

The MVC pattern  is widely used in software development, including Android applications. It allows developers to clearly separate business logic from the user interface, making it easier to maintain and test applications. In addition, the MVC pattern can be easily extended to include other layers, such as web services or databases, to create more complex and scalable applications.

### DAO and Respository Patterns

Both the DAO (Data Access Object) pattern (NOCK, 2004) and the Repository pattern (PRAJAPATI, 2019) are software design patterns that aim to provide an abstraction for accessing data in a database.

The main goal of the DAO pattern is to isolate the data access code from the rest of the application code, separating the business logic from the data access logic. It consists of two main parts: the DAO interface, which defines the operations that can be performed on the database, and the DAO class, which implements the DAO interface and contains the specific operations for accessing a particular type of entity. Each entity in the database typically has its own DAO class.

On the other hand, the Repository pattern aims to provide an abstraction for data access, such as a collection object of entities. Instead of focusing on specific database operations, the Repository provides a generic interface for creating, reading, updating, and deleting objects of a particular entity. It consists of a Repository class that contains generic data access operations for the corresponding entity.

To use both patterns together, an abstract Repository class is usually used, which is inherited by specific entity classes, along with the interface of each of these data access classes, as in the DAO pattern. This way, in the specific data classes of each entity, we only implement the most specific methods for the entity and reuse the generic data access and manipulation functions of the Repository class.

### Observer Pattern

The Observer pattern (ANDRÉ, 2013) is a software design pattern that defines a one-to-many dependency relationship between objects, such that when an object changes state, all its dependents are automatically notified and updated. It is used to implement what is known as the pub-sub (publisher-subscriber) pattern, where an observable object maintains a list of its observers and automatically notifies all of them when changes occur in its internal state.

The Observer pattern is used in situations where it is necessary to maintain a consistent state across multiple objects, without coupling them. This means that the Subject object does not need to know its Observers, nor do the Observers need to know other Observers. Additionally, new Observers can be easily added or removed without affecting the Subject object.

Some advantages of the Observer pattern include ease of extension, since new objects can be easily added without affecting existing code, and clear separation of responsibilities for each object, making the code more modular and easier to maintain.

### SUCCEEd

The SUCCEEd Framework (Junior, 2018) presents a set of modeling structures for self-adaptive systems, assisting in the specification of actions, strategies, and adaptation rules. It can mainly assist in the planning and execution stages of the adaptation loop. Within our framework, we use SUCCEEd to assist in the specification of actions, where each action of the application inherits from the <i>Task2</i> class of the framework and implements the abstract methods provided by it, allowing the use of SUCCEEd's action orchestration model in our framework.

### Grafo de classificação

We propose a model to build a classification graph that aims to provide a way to handle the interoperability of sensors and the analysis of these data, providing a solution that can be reused by several IoHT applications or that can be built focusing on a specific application, also allowing to minimize part of the cost of developing IoHT applications. The proposed classification graph relates sensors, features, classification algorithms, activities, or health situations. We combine common practices in the literature to create this artifact to recognize types of movement, risk situations, or health problems from data collected from datasets with sensor data related to IoHT solutions. Also, we can use the graph to help process activities related to requirements elicitation and choice of reusable components by indicating the sensors and possible health states that can be monitored by the sensors present in them. The classification graph is also possible as a knowledge base for IoHT applications, including self-adaptive IoHT applications. Finally, we present a process to optimize the classification graph based on sensors used for each application.

The code used to create a Classification Graph for the test application generted for test this framework available in : https://github.com/great-ufc/ClassificationGraphSolutionforIoHT

# User Manual

## Download the framework

You should start by downloading this git project (https://github.com/great-ufc/FrameworkForMotion/archive/refs/heads/main.zip). The project contains the Framework documentation and the complete Framework code for an Android app in Kotlin, including all the Framework elements. This application is executable as a simple example that can be used for testing functionalities, but it should be modified by the user to meet the specificities and requirements of the application being developed. In addition to the Framework and its documentation, the project also contains examples of applications created using the Framework and the code for a Python API application using Flask that can be used to provide an XML file with the adaptation rules of the application, following a specific template.

Note: After downloading the framework, you can change the project name from <i>FrameworkKotlin</i> to your app name before opening the project in Android Studio.

## First Steps

After downloading the framework along with all the elements and codes that will be used to assist in the construction of your application, it is necessary to open the project in Android Studio, as the framework was made for native Android application development using the Kotlin language. Then, you can run it to check the basic functionalities of the framework. We recommend initially changing the app name in the "Strings" in "res/values/strings.xml" to the desired name. In addition, other information can also be changed in string.xml. 

### Constants

For each application, a series of constant values should be used. Therefore, it is important to initially modify these values for your specific application. Check the Constants.kt file in "models/utils/Constants.kt". The constants that must be changed are the email of the application administrator, the server address where the API for accessing the classification graph is hosted, if you want to use it as a knowledge base in the "BACKEND_IP_PORT" constant, and also, if any, the server address where the API for accessing the adaptation rules template is hosted in the "BACKEND_IP_PORT_ADAPTATION_RULES" constant. The other constants are optional and should only be changed if necessary according to the application being developed. You can also add other constants to this Constants.kt file if desired.

### Authentication for using Google APIs

This framework provides support for at least one Google API, but it does not prevent developers from using other APIs. To use these APIs, it is necessary to create an Auth 2.0 key/credential in your developer account on Google Cloud (even if you do not use other Google Cloud resources). To create your Auth 2.0 credential, we recommend following the steps provided in the Google documentation, which can be accessed at: https://developers.google.com/fit/android/get-api-key

## Significant Comments

Throughout the classes and other objects of the framework, there are several code snippets that should or should not be changed. We have separated four standard identifiers to assist in identifying what should not be changed (<b>//------Generated by the Framework and must not be changed-----//</b>), what should be changed for each application (<b>//------Generated by the Framework and must be changed-----//</b>), what can be changed but can also be kept as it is (<b>//------Generated by the Framework and can be changed-----//</b>), and what is the application developer's own code, which can be removed from the example and new code added (<b>//------Generated by the User-----//</b>).

In the latter case, we suggest that the user of the framework use the comment <b>//------Generated by the User-----//</b> with the name or nickname of the developer in the new snippets created to facilitate the identification and documentation of code created exclusively by the developer. This way, it is possible to keep the code more readable and separate the code snippets created by the developer from the altered snippets according to what is specified in the framework. Additionally, although there are code snippets marked with <b>//------Generated by the Framework and must not be changed-----//</b>, nothing prevents the developer from changing these snippets, as the framework is open source. However, it is suggested that these snippets be kept for the advantages of reuse and good coding practices provided with the framework.

## Framework Elements

The classes and other components of the framework are structured into a series of packages following the Model-View-Controller architectural pattern with some adaptations. All visual components, including app screens, as is standard for native Android applications, are located in the <b>res</b> package, with the components in the "layout", "navigation", and "values" folders being the main ones. The "layouts", which correspond to screens, are divided into Activities and Fragments, and each Activity or Fragment layout is linked to an Activity or Fragment class in the <b>User Interface (UI)</b> package. The controllers present in the <b>controllers</b> package are used for information control related to the activities. Some activities may not have associated controllers if the developer does not see the need for them. Additionally, we provide some controller classes by default (DataController, ProfileController, and AppsExternalParametersController) that are not directly associated with a specific activity but contain useful control elements that can be associated with one or more activities to facilitate control of GoogleFit data (DataController), the Google account profile (ProfileController), or the availability of new app releases (AppsExternalParametersController). Finally, the <b>models</b> package contains classes related to connection with APIs available on cloud servers (in the cloudConnection folder), data processing and manipulation (in the dao folder), entities (in the entities folder), MAPE-K adaptation cycle elements (in the mapek folder), and useful classes and objects that contain methods and constants that can be used by different classes (in the utils folder).

### Coding and Reuse - Classes, Interfaces and Objects

Below we detail the classes and which parts of them should or should not be modified. We also provide information on which new elements the developer can reuse and which ones they should create to use the proposed framework as a basis for building their application. To see the details, simply click on the links of each component of the Framework below.

- [Views and Activities](./Documentation/UserInterface.md)

- [Controllers](./Documentation/Controller.md)

- [Models](./Documentation/Model.md)


# References

IBM. An architectural blueprint for autonomic computing. Tech. rep., 2003. IBM.

JUNIOR, Belmondo RAA et al. Succeed: Support mechanism for creating and executing workflows for decoupled SAS in IoT. In: 2018 IEEE 42nd Annual Computer Software and Applications Conference (COMPSAC). IEEE, 2018. p. 738-743.

RODRIGUES, Joel JPC et al. Enabling technologies for the internet of health things. Ieee Access, v. 6, p. 13129-13141, 2018.

DE OLIVEIRA, Pedro Almir Martins et al. Internet of Health Things for Quality of Life: Open Challenges based on a Systematic Literature Mapping. In: HEALTHINF. 2022. p. 397-404.

PARK, Hongkyu et al. Gait monitoring system for stroke prediction of aging adults. In: Advances in Human Factors in Wearable Technologies and Game Design: Proceedings of the AHFE 2019 International Conference on Human Factors and Wearable Technologies, and the AHFE International Conference on Game Design and Virtual Environments, July 24-28, 2019, Washington DC, USA 10. Springer International Publishing, 2020. p. 93-97

HAGHI, Mostafa; THUROW, Kerstin; STOLL, Regina. Wearable devices in medical internet of things: scientific research and commercially available devices. Healthcare informatics research, v. 23, n. 1, p. 4-15, 2017.

CAI, Xiorence J. et al. IoT-based gait monitoring system for static and dynamic classification of data. In: 2018 IEEE 10th International Conference on Humanoid, Nanotechnology, Information Technology, Communication and Control, Environment and Management (HNICEM). IEEE, 2018. p. 1-4.

QIU, Sen et al. Body sensor network-based robust gait analysis: Toward clinical and at home use. IEEE Sensors Journal, v. 19, n. 19, p. 8393-8401, 2018.

DE ARAUJO, Italo Linhares et al. An algorithm for fall detection using data from smartwatch. In: 2018 13th Annual Conference on System of Systems Engineering (SoSE). IEEE, 2018. p. 124-131.

NOCK, Clifton. Data access patterns: database interactions in object-oriented applications. Boston: Addison-Wesley, 2004.

PRAJAPATI, Mukesh. ASP. NET MVC-generic repository pattern and unit of work. International Journal Of All Research Writings, v. 1, n. 1, p. 23-30, 2019.

ANDRÉ, Étienne. Observer patterns for real-time systems. In: 2013 18th International Conference on Engineering of Complex Computer Systems. IEEE, 2013. p. 125-134.

BUCANEK, James. Model-view-controller pattern. Learn Objective-C for Java Developers, p. 353-402, 2009.
