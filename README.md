
![Untitled-1](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/f4bb0f39-d196-443f-86b4-e120b40dffcd)




## Dependencies 
#### JDK 17
#### selenium-java 4.16.1
#### cucumber-java 7.14.0
#### cucumber-junit7.14.0
#### tech.grasshopper - extentreports-cucumber7-adapter 1.14.0
#### maven-failsafe-plugin 3.0.0-M7
#### maven-surefire-plugin 3.0.0-M7
#### maven-cucumber-reporting 5.0.0

### 1 - Run from Runner class to get Extent and Cucumber reports or from CLI/Terminal mvn test -Dtest=Runner 
#### ExtentHtml Report
#### ExtentPdf Report
#### Spark Report
#### Cucumber Report

### 2 -  With the help of Hooks class and @After method it takes screenshot of the failed scenarios and attaches to the reports, ExtentHtml, ExtentPdf, Spark and Cucumber Report.

### 3 -  To run in parallel mode use maven test/verify/install. It wil run parallel test execution according to the tags written in Runner and TestRunner classes.

### 4 -  Run smoke tests with Jenkins using the mvn code -> mvn test -Dtest=Runner -Dcucumber.filter.tags="@smoke"
