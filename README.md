#  Project Structure
* Programming Language: JAVA [JavaSE - 1.7]
* IDE: Eclipse
* OS : macOs x
* Create a Maven project to build the program;
* Add all dependences in pom.xml regarding some frameworks that I used such as Cucumber to manage BDD, Rest-assured to call the web-service REST and added a json-schema-validator to validate JSON response format;

##  BDD requires a feature file to invoke the step definitions:

* Create the scenarios in feature file as per the requirements, so each step in feature file has to match a step definition in class file;
* Following the BDD practices for coding;
* Different annotations have been defined for test types.

# Manual Tests:
	1) Postman tool was used for Manual Tests. At the same time, scenarios were written in features files with the gherkin programming language.;
	2) You can view the test cases from the following file path. --> src/test/java/features
	3) The bugs found are stated in the "PROBLEM" tab below

# Automated Functional Testing:
	1) Both valid and invalid scenarios were written for functional tests. The scenarios specified with the @Smoke tag in the feature files are for functional testing.
	2) You can view valid test cases from the following file path. --> src/test/java/features/PositiveCasesReqresApi.feature
	3) You can view invalid test cases from the following file path. --> src/test/java/features/NegativeCasesReqresApi.feature
	4) Note: Test steps were written using only gherkin syntax for negative scenarios. But their stepdefinitions were not developed. In general, a dynamic and generic structure was designed. If desired, step definitions of negative scenarios can also be developed.
	

### Test Automation Framework Guidelines:

	1) Created pojo classes for APIs with bodies --> /src/main/java/pojo;
	2) Endpoints of APIs are defined as enums --> src/main/java/java_resources/APIResources.java;
	3) Different annotations have been defined for test types. --> src/test/java/features
	4) Stepdefinition classes have been developed for feature files --> src/test/java/step_definitions
	5) You can view the classes that manage helper, response and request in the following file path. --> src/test/java/test_resources
	6- You can view the application's logs in the following file path. --> ReqresTestAutomation/logging.txt

### Test Execution
* Execute from IDE by right clicking on features folder.
* run `mvn clean test` from command line.
* Can also be run from Maven using the following command: mvn test -Dcucumber.options="--tags @Smoke or @Users"
* You can also right click and run with junit.

### Execution screenshots
Execution screenshots are placed in screenshots folder (screenshots/TestExecution-Cucumber.mp4)
* Reports are generated and placed in target folder `target/cucumber-html-report.html`
* Sample reports look like this ! "target/TestReportScreenShot.png"

![Test Report Screenshot](https://github.com/aliboztemir/ReqresTestAutomation/blob/main/screenshots/TestReportScreenShot.png)

### Tools / libraries used :
* Cucumber
* Gherkin
* Rest Assured
* Maven
* Junit
* Allure Report

### [PROBLEM] During the tests, the following problems were seen.

