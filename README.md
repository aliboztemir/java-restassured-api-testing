# Java API Test Automation with RestAssured and Cucumber

## Overview
This repository contains an API test automation project built with Java, RestAssured, Cucumber, Maven, JUnit, and Allure Reporting.

It demonstrates an earlier implementation of API automation practices, including BDD scenarios, reusable request/response utilities, POJO-based request models, endpoint abstraction, JSON schema validation, logging, and test reporting.

The project uses the Reqres public REST API as the sample system under test.

## Historical Context
This is an older portfolio project preserved to show earlier Java API automation experience.

It is not intended to represent a current enterprise-grade framework. The repository is kept as part of a broader automation engineering portfolio, showing previous work with Java, RestAssured, Cucumber, Maven, and API validation.

## Tech Stack

- Java 8
- Maven
- RestAssured 4.3.3
- Cucumber 6
- Gherkin
- JUnit 4
- JSON Schema Validator
- Jackson Databind
- Gson
- Apache POI
- Allure Report
- Postman for manual API checks

## Project Structure

```
src/main/java
+-- pojo
|   +-- CreateUser.java
|   +-- PatchUser.java
|   +-- PutUser.java
+-- java_resources
    +-- APIResources.java
    +-- ExternalData.java
    +-- Payloads.java
    +-- global_data.properties

src/test/java
+-- cucumber_options
|   +-- TestRunner.java
+-- features
|   +-- PositiveCasesReqresApi.feature
|   +-- NegativeCasesReqresApi.feature
+-- step_definitions
|   +-- BlingStepDefinition.java
|   +-- BlingInValidStepDefinition.java
|   +-- Hooks.java
+-- test_resources
    +-- BlingReqSpecs.java
    +-- BlingRespSpecs.java
    +-- Utilities.java
```

## Testing Approach
The project follows a BDD-style API testing approach.

Feature files define API scenarios in Gherkin, and step definition classes implement the executable automation logic.

The framework includes:

- Positive API scenarios
- Negative API scenarios
- Smoke test tagging
- User API test tagging
- Request and response helper classes
- POJO models for request bodies
- API endpoint definitions through enums
- External data and payload management
- JSON response schema validation
- HTML and Allure reporting

## Manual Testing
Postman was used for initial manual API validation.

The same API behaviors were later represented as Gherkin scenarios under:

```
src/test/java/features
```

## Automated Testing
Automated scenarios are organized in feature files:

```
src/test/java/features/PositiveCasesReqresApi.feature
src/test/java/features/NegativeCasesReqresApi.feature
```

The positive scenarios include implemented step definitions.

Some negative scenarios were documented in Gherkin format as test design coverage but were not fully automated in the original implementation.

## Running Tests
Run all tests:

```
mvn clean test
```

Run tests by Cucumber tag:

```
mvn test -Dcucumber.filter.tags="@Smoke"
```

Tests can also be executed from the IDE using the JUnit runner via `TestRunner.java`.

## Reporting
Cucumber HTML reports are generated under:

```
target/
```

Example report:

```
target/cucumber-reports.html
```

Allure reporting is configured via `maven-surefire-plugin` in `pom.xml` and results are generated under:

```
target/allure-results
```

To serve the Allure report locally:

```
allure serve target/allure-results
```

## Logging
Execution logs are written to:

```
logging.txt
```

## Notes
This repository is intentionally kept close to its original structure. The purpose is to preserve an earlier Java API automation implementation rather than modernize it into a current framework.

For newer examples of API testing and test architecture, see the more recent C#, Python/FastAPI, and Playwright-based repositories in this portfolio.