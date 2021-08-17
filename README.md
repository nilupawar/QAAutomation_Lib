# Building automation framework Library

## How to use this lib - In local

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

    4. Your junit running class must extend BaseJunitRunner class.
  

    - Refer to project "https://github.com/nilupawar/QAAutomation_SampleLibTest.git" to know how to use this library 

## Test Configurations

    Each test suite should have TestConfig.properties file in 'test -> resources' folder. ( Sample TestConfig.properties) file
    is present in this library's resources folder

    Following are the list of madatory properties which must be present and have a value assigned to it

    
    Following are the list of properties which are used for framework configuration. You can assign it them custom valid values
    If you don't specify these properties in your TestConfig.properties file then default values set in TestConfig class will be used
               
                - application_url
                - browserName    

    NOTE : Below list will not be kept upto date, if you need to see the list of default properties refer to TestConfig class    
           
                - maximiseBrowserWhenOpen
                - pageLoadTime
                - objectLoadTime
                - object.wait.time.micro
                - object.wait.time.macro
                - object.wait.time.reliable
                - object.wait.time.slow

### Features to be implemented

    1. DONE [17-Aug-2021] - Validate TestConfig.properties files when project start
    -   This will make sure all required properties are present in TestConfig.properties file.Properties defined in TestConfig.properties will be overwritten by project specific TestConfig.properties file
    
    2. Implement locator definition in textfile ( yaml perfered )

    3. Annotation based PageElement object creation

    4. TestData connector to connect to multiple type of data provider

    

    
        