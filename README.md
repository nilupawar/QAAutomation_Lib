#Building automation framework Library

##How to use this lib - In local

    Prerequisite : must have following software installed
    -   Java/OpenJDK 11
    -   Maven 
    -   You must have internet connection or access your local/organizational central repo to download dependency library

    1. Clone this repo
        command -> git clone https://github.com/nilupawar/QAAutomation_Lib.git 

    2. Build library
        command -> mvn clean install
        
        After running this commnad artifact 'QAAutomation_Lib-<version-number>' must be added to your .m2 folder

    3. Import library into your project by adding following depdency in your pom file
        
                <dependency>
                    <groupId>org.practice.nilesh</groupId>
                    <artifactId>QAAutomation_Lib</artifactId>
                    <version>1.0.0-SNAPSHOT</version>             // Keep eye on version that you need
                </dependency> 

    4. You must include package path (com.nilesh.lib.core) of "CucumberHooks.java" in list of glues in Runner class of your project.
  

    - Refer to project "https://github.com/nilupawar/QAAutomation_SampleLibTest.git" to know how to use this library 



### Features to be implemented
    1. Validate TestConfig.properties files when project start
    -   This will make sure all required properties are present in TestConfig.properties file.Properties defined in TestConfig.properties will be overwritten by project specific TestConfig.properties file
    
    2. Implement locator definition in textfile ( yaml perfered )

    3. Annotation based PageElement object creation

    4. TestData connector to connect to multiple type of data provider

    

    
        