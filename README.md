💼 Recommended Section Order for README.md

🏷️ Project Overview / Introduction
Brief one-paragraph explanation of what the framework tests.

🧱 Project Structure & Framework Architecture 
Describes folders, layers (UI, API, DB, E2E), and design principles.

🧪 Test Case Naming & ID Convention
Explains how tests map to Jira IDs and naming standards.

📊 Reporting and Logging Standards
Describes reporting integration (Allure, Extent, CI/CD), including examples and screenshots.

⚙️ Execution Guide / Command Examples
How to run tests from command line, IDE, or Jenkins.

🔄 CI/CD Integration
Pipeline setup and report publishing.

🧠 Best Practices / Maintenance Guidelines
How to keep framework clean and scalable.


🧱 Project Structure & Framework Architecture
📂 Directory Layout
GroupAutoFramework/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/automation/framework/
│   │   │       ├── base/                 # Core parent classes (BaseTest, BasePage, BaseApi, BaseDB)
│   │   │       ├── pages/                # Page Object classes for UI automation
│   │   │       ├── api/                  # REST API clients and endpoints
│   │   │       ├── db/                   # Database query and validation classes
│   │   │       ├── pojo/                 # Plain Old Java Objects for data mapping
│   │   │       └── utils/                # Utility helpers (ConfigReader, DriverFactory, WaitHelper, etc.)
│   │   │
│   │   └── resources/
│   │       ├── config/                   # Environment and property files
│   │       │   ├── global.properties
│   │       │   ├── qa.properties
│   │       │   └── staging.properties
│   │       ├── testdata/                 # JSON, CSV, Excel, or static data files
│   │       └── locators/                 # Optional shared element locators
│   │
│   ├── test/
│   │   ├── java/
│   │   │   └── com/automation/framework/
│   │   │       ├── runners/              # Cucumber or TestNG runner classes
│   │   │       ├── steps/                # Cucumber step definitions
│   │   │       ├── tests/                # Organized by layer
│   │   │       │   ├── ui/               # UI regression and smoke tests
│   │   │       │   ├── api/              # API validation and functional tests
│   │   │       │   ├── db/               # Database consistency checks
│   │   │       │   └── e2e/              # End-to-End business flow tests
│   │   │       └── hooks/                # Global setup/teardown and screenshot capture
│   │   │
│   │   └── resources/
│   │       ├── features/                 # Gherkin BDD feature files
│   │       └── testng.xml                # Suite configuration for TestNG execution
│
├── reports/
│   ├── allure-results/
│   ├── allure-report/
│   ├── extent-report.html
│   └── logs/
│
├── target/                               # Compiled output and temporary files
├── pom.xml                               # Maven dependency and build configuration
└── README.md

🧠 Layer Descriptions
Layer	Purpose	Key Components
Base Layer	Core functionality shared by all modules — WebDriver setup, waits, teardown, API clients, DB connections.	BaseTest, BasePage, BaseApi, BaseDB
UI Layer	Automates user interface interactions using Selenium and Page Object Model.	Classes under pages/ and tests under tests/ui/
API Layer	Validates REST endpoints with RestAssured.	Classes under api/ and tests under tests/api/
Database Layer	Performs backend data verification via JDBC.	db/ classes and tests/db/
E2E Layer	Combines UI, API, and DB for full workflow validation.	tests/e2e/
Utils Layer	Contains reusable tools like property readers, loggers, random data generators, and driver factories.	utils/
Resources	Configuration, test data, and feature files for BDD scenarios.	config/, testdata/, features/
🧩 Design Principles

POM (Page Object Model):
Keeps UI locators and actions in dedicated page classes for reusability and readability.

BDD (Behavior-Driven Development):
Uses Gherkin feature files with Given-When-Then syntax for business-friendly test descriptions.

Multi-Layer Support:
Supports UI, API, and Database layers with shared reporting and test data sources.

CI/CD Ready:
Designed for integration with Jenkins, GitHub Actions, and Allure/Extent reporting.

Scalable Structure:
Easily extendable for additional modules or environments without breaking existing code.

🚀 Example Test Flow
Feature File  →  Step Definition  →  Page/API/DB Class  →  Base/Utils  →  Reports


Example:

Scenario: Verify user creation via UI and API
Given user logs into the application
When user creates a new record
Then verify record is available through API


🧭 Framework Architecture: Multi-Layer Automation (UI, API, DB, E2E)

The framework is built for full-stack testing — combining user interface, backend API, and database validation under one ecosystem.
It ensures robust coverage of healthcare workflows and supports true end-to-end (E2E) verification.

⚙️ 1. UI Layer – Web Automation

Purpose: Validate user workflows via browser automation.
Tools: Selenium WebDriver, Cucumber
Location: src/main/java/.../pages

Responsibilities:

Interact with page elements using Page Object Model (POM)

Execute form inputs, button clicks, and visual validations

Support multiple browsers and environments

🌐 2. API Layer – Backend Validation

Purpose: Verify REST APIs for data exchange and logic consistency.
Tools: RestAssured, JSON
Location: src/main/java/.../api

Responsibilities:

Perform CRUD operations via REST calls

Validate status codes, headers, and JSON payloads

Reuse POJO models for serialization/deserialization

🗄️ 3. Database Layer – Data Verification

Purpose: Validate backend data integrity after UI/API actions.
Tools: JDBC, SQL (PostgreSQL / MySQL / Oracle)
Location: src/main/java/.../db

Responsibilities:

Execute queries and fetch results from the database

Validate inserted/updated/deleted records

Support parameterized SQL queries and data comparison

🔄 4. End-to-End (E2E) Layer – Cross-System Testing

Purpose: Chain multiple layers (UI → API → DB) to verify complete business flows.
Tools: Cucumber (BDD)
Location: src/test/java/.../e2e

Responsibilities:

Combine UI actions, API validations, and DB checks

Represent real-world user journeys

Ensure data flows correctly across all system layers

🧩 Example E2E Scenario

Feature:

Scenario: Verify patient record created via UI appears in API and Database
Given user logs in to OpenMRS via UI
When user registers a new patient
Then verify patient appears in API response
And verify patient record exists in database


Step Definitions:

@Then("verify patient appears in API response")
public void verifyPatientInApi() {
PatientApi api = new PatientApi();
api.verifyPatientExists(patientName);
}

@And("verify patient record exists in database")
public void verifyPatientInDatabase() {
DbUtils.verifyPatientInDB(patientName);
}


✅ Result:
This scenario validates the full patient registration flow through UI, API, and database — ensuring system consistency end-to-end.

🧠 Key Notes
Principle	Description
Scalability	Modular design enables easy addition of new pages, APIs, and features.
Maintainability	Business logic (pages/steps) is separated from technical setup (base/utils).
Reusability	Shared components are used across UI, API, and DB layers.
CI/CD Ready	Maven layout and reporting support Jenkins, Bamboo, and GitHub Actions pipelines.
Traceability	Jira test IDs and Allure/Extent reports ensure full traceability across layers.
🚀 Recommended Tech Stack Summary
Layer	Technology	Purpose
UI	Selenium WebDriver, TestNG/Cucumber	Web and UI automation
API	RestAssured, JSON, TestNG	Backend service testing
DB	JDBC, SQL	Data validation
E2E	Cucumber (Gherkin)	Cross-system end-to-end testing
Reports	Allure / Extent Reports	Execution and reporting
CI/CD	Jenkins / GitHub Actions	Continuous integration pipeline
✅ Summary

This structure and architecture provide:

A clean separation of concerns (Base, UI, API, DB, Steps)

Support for multi-layer validation in healthcare applications

Easy integration with Jira, Allure, and Jenkins

A professional foundation for enterprise-level SDET frameworks



🧪 Test Case Naming and ID Convention
📘 Overview

This document defines the test case naming and identification strategy used across automation and manual testing for consistency, traceability, and Jira integration.
The goal is to maintain a clear one-to-one relationship between test cases, automation scripts, and Jira issues.

🧱 1. Test Case ID Format

Each test case must have a unique, descriptive identifier following this format:

<PROJECT>-<MODULE>-<TESTTYPE>-<SEQUENCE>

Example:
HCM-LOGIN-FUNC-001
HCM-PATIENT-NEG-007
HCM-API-BILL-004

Component	Description
PROJECT	Project acronym (e.g., HCM for Health Care Management)
MODULE	Functional module name (e.g., LOGIN, PATIENT, BILL)
TESTTYPE	Category of the test (Functional, Negative, API, Regression, etc.)
SEQUENCE	Incremental numeric ID starting from 001
🧩 2. Supported Test Types
Code	Type	Description
FUNC	Functional	Positive workflow scenarios
NEG	Negative	Invalid input and edge case validation
REG	Regression	Core tests for release validation
INT	Integration	Cross-module or multi-service flows
API	API testing	REST/SOAP endpoint verification
SEC	Security	Authentication and authorization
PER	Performance	Load and response time checks
UI	UI validation	Layout, visibility, and accessibility
⚙️ 3. Test Case Title Format

Each test case should have a descriptive name following this convention:

Verify <action> <expected result>

Examples:

Verify login with valid credentials successfully redirects to dashboard

Verify patient cannot be created without last name

Verify API returns 400 for invalid request payload

🧠 4. Example Test Case List
Test ID	Test Name	Description
HCM-PATIENT-FUNC-001	Verify patient creation with valid data	Ensures a new patient record is created successfully
HCM-PATIENT-NEG-002	Verify validation for missing first name	Confirms proper error handling for blank required fields
HCM-LOGIN-SEC-003	Verify unauthorized user cannot access dashboard	Checks access control and security handling
HCM-BILL-API-004	Verify POST /bill creates invoice successfully	Validates API endpoint behavior and response
🧩 5. Integration with Jira and IntelliJ

Each automated test should reference its Jira issue key either in:

The annotation:

@Test(description = "Verify patient creation", testName = "HCM-PATIENT-FUNC-002")


Or as a comment:

// Jira Test ID: HCM-PATIENT-FUNC-002


This enables IDEs (such as IntelliJ with the Jira plugin) to make test IDs clickable, opening the corresponding Jira ticket directly from the code.

🧰 6. Traceability in Reports

To maintain visibility across systems (Jira, Jenkins, Allure, Extent Reports):

Always log the Test ID in the report output.

Reporter.log("Executing Test: HCM-PATIENT-FUNC-002");


Ensure the same ID exists in:

Test code

Jira test case

Test reports

This guarantees end-to-end traceability.

🧩 7. Best Practices

IDs must be unique and permanent. Never reuse or renumber existing ones.

Keep module names short but meaningful (LOGIN, CLAIMS, PROFILE, etc.).

Use uppercase letters for all components.

Maintain a shared document or Jira dashboard to track assigned IDs.

Apply the same convention to both manual and automated tests for consistency.

✅ Summary
Benefit	Description
Clarity	Each test name and ID is self-descriptive
Traceability	One-click linking between code, reports, and Jira
Scalability	Supports large enterprise projects and multiple modules
Standardization	Matches conventions used in major organizations (e.g., AmEx, CVS, Amazon)



📊 Reporting and Logging Standards

This framework integrates with Allure and Extent Reports for real-time result visualization, and uses structured logging to ensure full traceability between Jira test IDs, Cucumber features, and execution reports.

🧩 1. Reporting Tools Overview
Tool	Purpose	Integration
Allure Report	Detailed, visual, and interactive report showing steps, screenshots, logs, and attachments.	Integrated via Maven plugin and Cucumber annotations.
Extent Reports	HTML-style reports with pass/fail counts, execution time, and screenshots.	Configured in CucumberRunner and BaseTest classes.
⚙️ 2. Allure Report Configuration

Add dependencies in pom.xml:

<dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-cucumber7-jvm</artifactId>
    <version>2.21.0</version>
</dependency>


Add Maven plugin:

<plugin>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-maven</artifactId>
    <version>2.11.2</version>
    <configuration>
        <resultsDirectory>target/allure-results</resultsDirectory>
        <reportDirectory>target/allure-report</reportDirectory>
    </configuration>
</plugin>


Generate the report:

mvn clean test
mvn allure:serve


Output:
Allure opens a browser with test history, steps, attachments, and linked Jira test IDs.

🌐 3. Extent Reports Integration

Add dependencies in pom.xml:

<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
</dependency>


Extent configuration file (extent-config.xml):

<configuration>
  <reportName>Healthcare Automation Test Report</reportName>
  <encoding>utf-8</encoding>
  <theme>standard</theme>
  <timelineEnabled>true</timelineEnabled>
</configuration>


Initialize in BaseTest or CucumberRunner:

ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent-report.html");
ExtentReports extent = new ExtentReports();
extent.attachReporter(spark);

extent.createTest("HCM-PATIENT-FUNC-001")
.assignCategory("UI Test")
.log(Status.PASS, "Patient created successfully");
extent.flush();

🧠 4. Linking Reports with Jira Test IDs

Each test (or Cucumber scenario) includes its Jira test ID in metadata:

@Test(description = "Verify patient creation", testName = "HCM-PATIENT-FUNC-001")


or

@HCM-PATIENT-FUNC-001
Scenario: Verify patient creation with valid data


This ID is automatically visible in Allure and Extent reports, allowing one-click mapping between:

Code → Report → Jira Ticket

🪶 5. Screenshot and Log Capture

Screenshots:
Captured automatically for failed steps:

@After
public void tearDown(Scenario scenario) {
if (scenario.isFailed()) {
final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
scenario.attach(screenshot, "image/png", "Failure Screenshot");
}
}


Logs:
Each step is logged using Log4j or ExtentLogger, generating both console and file output under /reports/logs.

🔄 6. Report Output Paths
Report Type	Location
Allure Raw Results	target/allure-results/
Allure Report	target/allure-report/
Extent Report (HTML)	reports/extent-report.html
Logs	reports/logs/
✅ 7. CI/CD Integration

Both reports can be automatically generated in Jenkins, GitHub Actions, or Bamboo:

mvn clean test
mvn allure:report


Configure the Jenkins Allure plugin to read from target/allure-results

Post-execution, Jenkins will display Allure or Extent HTML reports directly in the build page

💡 Summary

Allure → ideal for dynamic BDD reporting with detailed step tracking.

Extent → perfect for managerial dashboards and visual HTML results.

Both support Jira traceability, screenshot embedding, and CI/CD publishing.



▶️ Run & Execution Guide

This section explains how to execute tests from the command line, IDE, or CI/CD pipeline.
The framework supports tag-based, module-based, and suite-based execution using Maven, TestNG, and Cucumber runners.

🧩 1. Maven Commands

Run all tests:

mvn clean test


Run specific feature or tag:

mvn test -Dcucumber.filter.tags="@UI"
mvn test -Dcucumber.filter.tags="@API"
mvn test -Dcucumber.filter.tags="@DB"
mvn test -Dcucumber.filter.tags="@E2E"


Run smoke or regression suite:

mvn test -Dcucumber.filter.tags="@Smoke"
mvn test -Dcucumber.filter.tags="@Regression"


Rebuild and open Allure report:

mvn clean test
mvn allure:serve

⚙️ 2. TestNG Suite Execution

You can manage multiple suites in the src/test/resources/testng.xml file.

Example:

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenMRS Regression Suite" parallel="tests" thread-count="2">
    <test name="UI Tests">
        <classes>
            <class name="com.healthcare.openmrs.runners.UITestRunner" />
        </classes>
    </test>
    <test name="API Tests">
        <classes>
            <class name="com.healthcare.openmrs.runners.ApiTestRunner" />
        </classes>
    </test>
</suite>


Run via Maven:

mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml

🧪 3. Tagging Strategy for Cucumber Features

Each .feature file supports tags to identify test types, layers, and priority.

Example:

@UI @Smoke @HCM-PATIENT-FUNC-001
Feature: Patient Registration

Scenario: Verify patient creation with valid data
Given user logs in to OpenMRS via UI
When user registers a new patient
Then verify patient appears in API response
And verify patient record exists in database

Tag	Meaning
@UI	UI tests using Selenium
@API	Backend API validation
@DB	Database-level verification
@E2E	Full end-to-end business flows
@Smoke	Critical path quick checks
@Regression	Comprehensive coverage for stable builds
🧠 4. Running Specific Layers
Layer	Command	Example
UI	mvn test -Dcucumber.filter.tags="@UI"	Runs Selenium-based UI scenarios
API	mvn test -Dcucumber.filter.tags="@API"	Runs RestAssured tests
DB	mvn test -Dcucumber.filter.tags="@DB"	Runs JDBC-based validations
E2E	mvn test -Dcucumber.filter.tags="@E2E"	Runs full workflow scenarios
🖥️ 5. Run from IntelliJ IDEA

Open the project in IntelliJ.

Navigate to your runner (e.g., CucumberRunner.java or TestNGRunner.java).

Right-click → Run.

For specific tests, use IntelliJ’s Run Configuration:

Add VM option: -Dcucumber.filter.tags=@Smoke

Or use -DsuiteXmlFile=... to specify TestNG suite.

🔄 6. Jenkins / CI/CD Execution

In CI/CD pipelines, include the following build steps:

mvn clean test -Dcucumber.filter.tags="@Regression"
mvn allure:report


Then configure the Allure Jenkins Plugin to point to:

target/allure-results


Jenkins Output:

Allure HTML report

Extent HTML report

Console logs with timestamps and test IDs

📦 7. Example Parallel Execution (Optional)

Add parallel support in CucumberRunner.java:

@CucumberOptions(
features = "src/test/resources/features",
glue = "com.healthcare.openmrs.steps",
tags = "@Regression",
plugin = {"pretty", "json:target/cucumber.json"},
monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
@DataProvider(parallel = true)
public Object[][] scenarios() {
return super.scenarios();
}
}


Run parallel execution:

mvn test -Dcucumber.filter.tags="@Regression"

✅ 8. Summary
Mode	Command Example	Report Output
UI	mvn test -Dcucumber.filter.tags=@UI	Allure + Extent
API	mvn test -Dcucumber.filter.tags=@API	Allure + Extent
DB	mvn test -Dcucumber.filter.tags=@DB	Allure + Extent
E2E	mvn test -Dcucumber.filter.tags=@E2E	Allure + Extent
Full Suite	mvn clean test	Complete combined report


🔄 CI/CD Integration

This section explains how to integrate the automation framework into a CI/CD pipeline using Jenkins, GitHub Actions, or Bamboo for automated test execution and reporting.

⚙️ Jenkins Pipeline Example
pipeline {
agent any
parameters {
string(name: 'TAGS', defaultValue: '@Regression', description: 'Cucumber tags to execute')
string(name: 'ENV', defaultValue: 'qa', description: 'Target environment (dev/qa/prod)')
}
stages {
stage('Checkout') {
steps { git 'https://github.com/your-org/GroupAutoFramework.git' }
}
stage('Build & Test') {
steps { sh 'mvn clean test -Dcucumber.filter.tags="${TAGS}" -Denvironment="${ENV}"' }
}
stage('Generate Reports') {
steps { sh 'mvn allure:report' }
}
}
post {
always {
allure includeProperties: false, results: [[path: 'target/allure-results']]
publishHTML([reportDir: 'reports', reportFiles: 'extent-report.html', reportName: 'Extent Report'])
}
}
}

🧩 CI/CD Highlights
Feature	Description
Automatic Execution	Triggers on each push or scheduled build.
Parameterized Builds	Supports dynamic tags (@Smoke, @Regression, @E2E) and environment selection (dev, qa, prod).
Reports Integration	Publishes both Allure and Extent reports after every build.
Notifications	Slack or Jira notifications for failures or unstable builds.
🌐 Environment Configuration

Define environment URLs and credentials in:

src/main/resources/config/Configurations.properties


Example:

base.url.dev=https://dev.openmrs.org
base.url.qa=https://qa.openmrs.org
base.url.prod=https://prod.openmrs.org


Run specific environments from command line:

mvn test -Denvironment=qa -Dcucumber.filter.tags="@E2E"

📊 Report Publishing in Jenkins
Report Type	Path	Plugin
Allure Report	target/allure-results/	Allure Jenkins Plugin
Extent HTML Report	reports/extent-report.html	HTML Publisher Plugin
Logs & Screenshots	reports/logs/	Workspace Archive
🚀 CI/CD Benefits

Continuous feedback on test health

Environment-based automation with minimal setup

Unified reporting directly in Jenkins/GitHub dashboards

Scalable execution (parallel threads, distributed agents)

🧠 Best Practices / Maintenance Guidelines

This section outlines how to keep the automation framework clean, maintainable, and scalable as the project evolves.

🧩 Code Organization
Area	Recommendation
Structure	Keep reusable logic (pages, api, db, utils) in src/main/java; test logic in src/test/java.
Naming	Use consistent test naming and IDs (e.g., HCM-PATIENT-FUNC-001).
Modularity	One class per page or service; avoid redundant locators or methods.
⚙️ Version Control

Use Git Flow branching model:
main → develop → feature/<name> → Pull Request → Merge.

Require code reviews for all test updates.

Link commits and pull requests to Jira test IDs.

🧾 Reporting Hygiene

Include Jira IDs in Cucumber tags or TestNG annotations.

Keep test names descriptive and unique.

Ensure Allure and Extent reports remain synchronized across runs.

Maintain historical report backups in CI/CD for traceability.

🔐 Configuration & Secrets
Item	Best Practice
Credentials	Store in Jenkins credentials or environment variables (never commit to Git).
Properties	Use .gitignore to exclude personal or environment-specific property files.
Sensitive Data	Mask tokens, passwords, and database credentials in logs and reports.
🧰 Dependency Management

Keep dependencies in pom.xml up to date.

Re-run smoke tests after every library upgrade.

Validate WebDriver and RestAssured compatibility with browser and API versions.

🔄 Scalability & Reliability
Area	Practice
Parallel Execution	Enable Cucumber/TestNG parallel mode via @DataProvider.
Retry Logic	Implement retry analyzers for flaky tests.
Dockerization	Run Selenium Grid and APIs inside Docker containers for reproducible results.
Environment Profiles	Separate configs for dev, qa, staging, and prod.
💡 Continuous Improvement

Integrate SonarQube for code quality analysis.

Add OWASP/ZAP for API security validation.

Extend automation to mobile (Appium) or cloud testing (BrowserStack, LambdaTest).

Collect metrics with Allure TestOps or TestRail integration.

✅ Maintenance Summary
Focus	Goal
Clean Architecture	Maintain a clear POM + BDD separation.
Scalable Framework	Handle multi-layer (UI, API, DB) test expansion.
Consistent Reporting	Preserve traceability from code to Jira.
Long-Term Stability	Regular dependency updates and CI monitoring.
