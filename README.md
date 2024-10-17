

## Welcome to SausceDemo Framework!



## Prerequisites (if running locally)

 - [ ] Repository has been cloned
 - [ ] A JDK has been configured
 - [ ] Download and install a JDK
 - [ ] Download Maven
 



## Steps to configure it locally

 - [ ] Once installed add the following environmental variable for your account (Example: JAVA_HOME = C:\Program Files\Java\jdk-11.0.12)
 - [ ] Add this to your existing PATH environmental variable for your account (Example: %JAVA_HOME%\bin)
 - [ ] To confirm successful configuration open a terminal and execute this command javac -version, you should be presented with the version of the java compiler.
 - [ ] Maven has been configured
 - [ ] Download Maven
 - [ ] Extract the contents and move it to a suitable location
 - [ ] Add the following environment variable for your account (Example: MAVEN_HOME = C:\Maven\apache-maven-3.6.3)
 - [ ] Add this to your existing PATH environmental variable for your account (Example: %MAVEN_HOME%\bin)
 - [ ] To confirm successful configuration open a terminal and execute this command mvn -version, you should be presented with details including the maven version.
 - [ ] The browser you wish to run the tests on is installed on your local machine
 

## Executing the tests locally

 - [ ] Open a terminal and navigate to the repository: If you are using windows use the command e.g., cd sauceDemo, the git clone the repo
 - [ ] Run the tests using maven, after you clone the repositery locally, open it in IntellJ, then open the terminal and run the command: mvn test
 - [ ] OR using testng.xml right click run
 - [ ] also you run it using the class TestRunner, repeat the same steps of the previous method till the step of opening the project in the intellJ, then open TestRunner.class and right click and select run
 - [ ] You can run one feature file only by adding a tag, e.g., "@test" before the Scenario keyword in the feature file and adding the same exact tag as a value in testrunner class, to be tags= "@test" 

## *Profiles*

 We have one profile which includes the Production data

## *Tags*

 1. Run tests which are tagged with e.g., "@smoke"  using this command: mvn test -D cucumber.filter.tags="@smoke" 
 2. Run tests which are tagged with either e.g., "@smoke"  or "@checkout"   using this command:  mvn -D cucumber.filter.tags="@smoke or @exports"
 3. Skip tests which are tagged with e.g., "@smoke"  mvn test -D cucumber.filter.tags="not @smoke"

    


## *Report*

*TestNg report*: A report will be generated after each run in this path {project_path}\test-output\index.html, and you select which browser you would like to display on
*Screenshots*: Screenshots are captured at the end of each test and are embedded at the bottom of each test within the report. They can also be retrieved from the pathToRepository\target\failsafe-reports directory.




# Resources  

 - Selenium
 - Cucumber
 - Maven

