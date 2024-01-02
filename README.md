
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

### 1 - Run from Runner class to get Extent and Cucumber reports or from CLI/Terminal '''mvn test -Dtest=Runner'''
#### ExtentHtml Report
#### ExtentPdf Report
#### Spark Report
#### Cucumber Report

### 2 -  With the help of Hooks class and @After method it takes screenshot of the failed scenarios and attaches to the reports, ExtentHtml, ExtentPdf, Spark and Cucumber Report.

### 3 -  To run in parallel mode use maven test/verify/install. It wil run parallel test execution according to the tags written in Runner and TestRunner classes.

### 4 -  Run smoke tests with Jenkins using the mvn code -> mvn test -Dtest=Runner -Dcucumber.filter.tags="@smoke"
![1-extentHtml](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/6bf9ec3c-9bca-485d-a6a8-4a7c6c85a17e)
![2-extentpdf](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/039b25c9-b957-4e8e-99f5-2b9198782d3f)
![3-spark](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/98b618d1-d901-42d6-84b8-33f9b1a848c5)
![4-cucumber reporting](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/6370fe2b-a0c8-4bf1-a68c-1807059b51fe)
![5-Jenkins_anaekran](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/a15c3219-fe36-4c2d-9b5d-c5ac6ae6e9eb)
![6-Jenkins-report](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/9666cfc5-ee8f-4fd5-8213-e25474285c6c)
![7-Jenkins-mailto](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/acaef8d5-3553-4ee3-baa4-a7329b0e2848)
![8-Jenkins-mailfoto](https://github.com/AlpArslan11/CucumberBDD_ParallelTestExecution_ExtentReports/assets/101150339/0fc32091-aad0-4e68-ae2c-d60da05fe888)

