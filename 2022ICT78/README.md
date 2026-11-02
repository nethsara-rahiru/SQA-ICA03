
Tester 2022/ICT/78 — Selenium UI Testing: Task Manager

<div align="center">"Java" (https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
"Selenium" (https://img.shields.io/badge/Selenium-4.51.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
"JUnit" (https://img.shields.io/badge/JUnit-5.13.4-25A162?style=for-the-badge&logo=junit5&logoColor=white)
"Maven" (https://img.shields.io/badge/Maven-3-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
"Chrome" (https://img.shields.io/badge/Chrome-WebDriver-4285F4?style=for-the-badge&logo=googlechrome&logoColor=white)

Automated UI testing for a Task Manager web application using Selenium WebDriver, Java, JUnit 5, and Maven.

</div>

## Project Overview

This repository contains my individual Selenium UI automation work for the Task Manager application.

The objective is to verify application functionality, validate user inputs, test boundary conditions, and identify unexpected application behaviour.

## Scope

- Automate registration, login, and task-management user journeys.
- Cover positive, negative, and boundary inputs.
- Validate browser behavior and visible error messages.
- Keep Java/Selenium test scripts, assertions, execution logs, and screenshots.

## Existing materials

- `SeleniumUITestion_TaskManager/` — UI automation project.
- `Screen Shots/` — supporting test evidence.

The shared tracker documents outcomes, including partial passes for boundary-value tests.

## Test case tracking

Document at least five test cases, including scenario, preconditions, steps, input data, expected and actual results, status, and evidence.

- [Shared test dashboard](https://docs.google.com/spreadsheets/d/1xntmKoLF67ZUh8P6DqYbO3rtIwb53AHrxQc20ToV6T4/edit)
- [Main project README](../README.md)
- [Application under test](https://github.com/ArunPragas2001/TaskManager)

> Do not commit real passwords, access tokens, or other secrets.


## The testing covers:

- Positive testing
- Negative testing
- Boundary value analysis
- Functional testing
- Input validation testing

## Tester Information

Detail| Information
Student Name| U.G.H.S. Ranasingha
Registration Number| 2022/ICT/78
Course| Software Testing and Automation
Testing Area| Selenium Java – UI Testing
GitHub| "HarshiSRanasingha" (https://github.com/HarshiSRanasingha)

3. Application Under Test

Detail| Information
Application Name| Task Manager
Application Type| Web Application
Source Repository| "TaskManager – GitHub" (https://github.com/ArunPragas2001/TaskManager)
Base URL| "http://localhost:8000"
Registration Page| "http://localhost:8000/register.html"
Dashboard Page| "http://localhost:8000/dashboard.html"

The application provides user registration, login, task creation, task editing, task deletion, and task status management.

4. Tools and Technologies

Tool| Version
Java JDK| 21.0.13
Selenium WebDriver| 4.51.0
JUnit Jupiter| 5.13.4
Maven| Dependency and build management
IntelliJ IDEA| 2026.2.4
Google Chrome| Version 156

5. Project Structure

SeleniumUITestion_TaskManager/
│
├── pom.xml
├── README.md
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               └── Main.java
│   │
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java
│           │
│           └── tests/
│               ├── BrowserTest.java
│               ├── TC001_EmailValidationWithoutAtSign.java
│               ├── TC002_EmailValidationTestWithout_com.java
│               ├── TC003_PasswordLengthBoundaryTest.java
│               ├── TC004_TaskNameLengthBoundaryTest.java
│               ├── TC005_MoveTaskButtonTest.java
│               ├── TC006_EditTaskTest.java
│               ├── TC007_DeleteTaskTest.java
│               ├── TC008_TaskStatusDisplayTest.java
│               └── TC009_TaskCreationCancelTest.java
│
└── Screen Shots/
    ├── TC001_EmailValidationWithoutAtSign.png
    ├── TC002_EmailValidationTestWithout_com.png
    ├── TC003_PasswordLengthBoundaryTest.png
    ├── TC004_TaskNameLengthBoundaryTest.png
    ├── TC005_MoveTaskButtonTest.png
    ├── TC006_EditTaskTest.png
    ├── TC007_DeleteTaskTest.png
    ├── TC008_TaskStatusDisplayTest.png
    └── TC009_TaskCreationCancelTest.png

6. Automated UI Test Coverage

Nine automated test case classes were created to verify different application features and input conditions.

Test ID| Test Scenario| Scenario Type
T78/001| Email validation without the "@" symbol| Negative
T78/002| Email validation without ".com"| Negative
T78/003| Password length boundary testing| Boundary
T78/004| Task-name length boundary testing| Boundary
T78/005| Move a task between status columns| Positive
T78/006| Edit an existing task| Positive
T78/007| Delete an existing task| Positive
T78/008| Verify tasks appear under the correct status| Positive
T78/009| Cancel task creation without saving| Negative

7. Test Execution Summary

Test Case ID| Scenario| Execution Result
T78/001| Email validation without "@"| PASS
T78/002| Email without ".com"| PASS
T78/003| Password length boundary| 5 PASS / 1 FAIL
T78/004| Task-name length boundary| 4 PASS / 2 FAIL
T78/005| Move task| PASS
T78/006| Edit task| PASS
T78/007| Delete task| PASS
T78/008| Task status display| PASS
T78/009| Cancel task creation| PASS

Boundary testing observations:

- T78/003: The 13-character password was accepted even though rejection was expected under the assumed 6–12 character range.
- T78/004: The 2-character and 51-character task names were accepted even though rejection was expected under the assumed 3–50 character range.

These are unexpected results against the assumed limits. Confirm the actual application requirements before reporting them as defects.

8. Screenshots and Test Evidence

Screenshots are stored in the "Screen Shots" directory. Each screenshot is named according to its corresponding test case.

Test Case| Screenshot
T78/001| "TC001_EmailValidationWithoutAtSign.png"
T78/002| "TC002_EmailValidationTestWithout_com.png"
T78/003| "TC003_PasswordLengthBoundaryTest.png"
T78/004| "TC004_TaskNameLengthBoundaryTest.png"
T78/005| "TC005_MoveTaskButtonTest.png"
T78/006| "TC006_EditTaskTest.png"
T78/007| "TC007_DeleteTaskTest.png"
T78/008| "TC008_TaskStatusDisplayTest.png"
T78/009| "TC009_TaskCreationCancelTest.png"

9. Running Selenium Tests

Prerequisites

- Java JDK 21
- IntelliJ IDEA
- Maven
- Google Chrome
- Task Manager application

Step 1 – Clone the Repository

git clone https://github.com/HarshiSRanasingha/SeleniumUITestion_TaskManager.git

Step 2 – Open the Project

Open the project in IntelliJ IDEA and allow Maven to download the required dependencies.

Step 3 – Start the Application

Start the Task Manager application and verify that it is accessible at:

http://localhost:8000

Step 4 – Run All Test Cases

mvn clean test

Step 5 – Run an Individual Test Case

For example, to run T78/009:

mvn -Dtest=TC009_TaskCreationCancelTest test

Maven test reports are generated in:

target/surefire-reports/

10. Manual UI Test Cases

At least five UI test cases should be documented for this submission.

Each test case includes its scenario, preconditions, test steps, test data, expected result, actual result, pass/fail status, testing type, tester information, comments, and testing date.

T78/001 – Email Validation Without "@"

Field| Details
Feature| User Registration
Scenario| Remove "@" from the email address during registration
Scenario Type| Negative
Precondition| Registration page is open
Test Steps| 1. Enter a full name. 2. Enter an email without "@". 3. Enter a valid password. 4. Submit the form.
Test Data| Name: Harshi; Email: "harshigmail.com"; Password: "Test123"
Expected Result| The system displays an email validation error and does not create the account.
Actual Result| Browser displayed: "Please include an @ in the email address." Email validity and form validity were false.
Status| PASS
Tester| 2022/ICT/78
Comment| TC-001 PASSED. Invalid email was rejected by Chrome HTML5 validation. JUnit exited with code 0.
Date Tested| 2026-11-01

T78/002 – Email Without ".com"

Field| Details
Feature| User Registration
Scenario| Register using an email without ".com"
Scenario Type| Negative
Precondition| Registration page is open
Test Steps| 1. Enter a valid full name. 2. Enter an email without ".com". 3. Enter a password. 4. Submit the form.
Test Data| Name: Harshi; Email: "harshi@gmail"; Password: "Test123"
Expected Result| The application rejects the email and remains on the registration page.
Actual Result| Chrome accepted the email format, but application validation displayed: "User validation failed: email: Please add a valid email." The registration page remained open.
Status| PASS
Tester| 2022/ICT/78
Comment| TC-002 PASSED. Application-level validation rejected the email. JUnit exited with code 0.
Date Tested| 2026-11-01

T78/003 – Password Length Boundary Testing

Field| Details
Feature| User Registration
Scenario| Check password length during registration
Scenario Type| Boundary
Precondition| Registration page is open
Test Steps| 1. Enter a valid name and email address. 2. Enter the specified password. 3. Submit the registration form. 4. Check whether registration is accepted or rejected.
Test Data| Name: Harshi; Email: "harshi@gmail.com"; Password lengths: 5, 6, 7, 11, 12, and 13 characters.
Expected Result| Under the assumed 6–12 character range, 5 and 13 characters should be rejected, while 6, 7, 11, and 12 characters should be accepted.
Actual Result| 5 characters: Rejected. 6 characters: Accepted. 7 characters: Accepted. 11 characters: Accepted. 12 characters: Accepted. 13 characters: Accepted.
Status| 5 PASS / 1 FAIL
Tester| 2022/ICT/78
Comment| TC-003: Five of six password boundary executions passed. The 13-character password was accepted although rejection was expected under the assumed range.
Date Tested| 2026-11-01

Individual boundary test data:

Test ID| Password| Length| Expected| Actual| Status
T78/003-01| "Test1"| 5| Reject| Rejected| PASS
T78/003-02| "Test12"| 6| Accept| Accepted| PASS
T78/003-03| "Test123"| 7| Accept| Accepted| PASS
T78/003-04| "Test1234567"| 11| Accept| Accepted| PASS
T78/003-05| "Test12345678"| 12| Accept| Accepted| PASS
T78/003-06| "Test123456789"| 13| Reject| Accepted| FAIL

T78/004 – Task-Name Length Boundary Testing

Field| Details
Feature| Task Management
Scenario| Check task-name character length
Scenario Type| Boundary
Precondition| User is registered and logged in; dashboard is open
Test Steps| 1. Register, log in, and open the dashboard. 2. Enter a task name with the specified character length. 3. Submit the task creation form. 4. Check whether the task is created.
Test Data| Task-name lengths: 2, 3, 4, 49, 50, and 51 characters.
Expected Result| Under the assumed 3–50 character range, a 2-character and 51-character task name should be rejected. The other values should be accepted.
Actual Result| 2 characters: Accepted. 3 characters: Accepted. 4 characters: Accepted. 49 characters: Accepted. 50 characters: Accepted. 51 characters: Accepted.
Status| 4 PASS / 2 FAIL
Tester| 2022/ICT/78
Comment| TC-004: Four of six task-name boundary executions passed. The 2-character and 51-character names were accepted outside the assumed range.
Date Tested| 2026-11-01

Individual boundary test data:

Test ID| Task Name Length| Expected| Actual| Status
T78/004-01| 2| Reject| Accepted| FAIL
T78/004-02| 3| Accept| Accepted| PASS
T78/004-03| 4| Accept| Accepted| PASS
T78/004-04| 49| Accept| Accepted| PASS
T78/004-05| 50| Accept| Accepted| PASS
T78/004-06| 51| Reject| Accepted| FAIL

T78/005 – Move Task Between Status Columns

Field| Details
Feature| Task Management
Scenario| Check the action button on a task card
Scenario Type| Positive
Precondition| User is logged in and at least one task exists
Test Steps| 1. Register a new user and open the dashboard. 2. Create a Selenium task in Pending. 3. Click Move to In Progress. 4. Verify that the task moves to In Progress and the next action changes to Move to Completed.
Test Data| Task: Selenium task; Initial status: Pending; Action: Move to In Progress; Deadline: 2027-12-31 12:00; Priority: Medium
Expected Result| The task moves from Pending to In Progress and shows the next available Move to Completed action.
Actual Result| Registration and dashboard opened successfully. The task was created in Pending. The Move button was clicked successfully, and the task appeared in In Progress with the next action displayed.
Status| PASS
Tester| 2022/ICT/78
Comment| TC-005 PASSED. Task movement was verified successfully. JUnit exited with code 0.
Date Tested| 2026-11-01

T78/006 – Edit an Existing Task

Field| Details
Feature| Task Management
Scenario| Check whether a task can be edited after creation
Scenario Type| Positive
Precondition| User is logged in and at least one task exists
Test Steps| 1. Register and open the dashboard. 2. Create a task. 3. Click Edit. 4. Change the task title. 5. Change priority to High and save. 6. Refresh the page and verify the changes persist.
Test Data| Original task: Selenium task; Updated title: Edited Selenium task; Updated priority: High
Expected Result| The task title and priority are updated, saved, and remain displayed after browser refresh.
Actual Result| Task was created, edited, and saved successfully. The updated title and High priority remained after refreshing the page.
Status| PASS
Tester| 2022/ICT/78
Comment| TC-006 PASSED. Task details were updated and persisted after refresh.
Date Tested| 2026-11-01

T78/007 – Delete an Existing Task

Field| Details
Feature| Task Management
Scenario| Check whether a task can be deleted using the delete button
Scenario Type| Positive
Precondition| User is logged in and at least one task exists
Test Steps| 1. Register and open the dashboard. 2. Create a task. 3. Click Delete. 4. Confirm deletion in the dialog. 5. Verify the task disappears. 6. Refresh the dashboard and verify it remains absent.
Test Data| Existing task: Selenium task
Expected Result| A confirmation dialog is displayed. After confirmation, the selected task is removed and remains absent after refresh.
Actual Result| Confirmation dialog appeared. Deletion was accepted, the task disappeared from the dashboard, and it remained absent after refresh.
Status| PASS
Tester| 2022/ICT/78
Comment| TC-007 PASSED. Task deletion and persistence after refresh were verified. JUnit exited with code 0.
Date Tested| 2026-11-01

T78/008 – Verify Task Status Display

Field| Details
Feature| Task Management
Scenario| Verify that tasks are displayed in the correct dashboard columns based on their status
Scenario Type| Positive
Precondition| Taskium application is running at "http://localhost:8000". Chrome browser and Selenium WebDriver are configured.
Test Steps| 1. Register a user. 2. Open the dashboard. 3. Create a task with Pending status. 4. Create a task with In Progress status. 5. Create a task with Completed status. 6. Verify each task appears in its corresponding dashboard column.
Test Data| Pending Test Task; Progress Test Task; Completed Test Task
Expected Result| Each task is displayed in the correct dashboard column according to its selected status.
Actual Result| All three tasks were created and displayed in their correct columns: Pending, In Progress, and Completed.
Status| PASS
Tester| 2022/ICT/78
Comment| TC-008 PASSED. All three task statuses were verified successfully. JUnit exited with code 0.
Date Tested| 2026-11-01

T78/009 – Cancel Task Creation

Field| Details
Feature| Task Management
Scenario| Verify that a user can cancel task creation without saving
Scenario Type| Negative
Precondition| Application is running; user can register and access the dashboard
Test Steps| 1. Register a new user. 2. Open the dashboard. 3. Click Add Task. 4. Enter task details. 5. Click Cancel. 6. Verify the modal closes. 7. Check that the task does not appear. 8. Refresh the dashboard and verify that the task remains absent.
Test Data| Task: Cancelled Selenium Task; Deadline: 2027-12-31; Priority: Medium; Status: Pending
Expected Result| The task creation modal closes, the task is not saved, and it remains absent after refreshing the dashboard.
Actual Result| Modal opened, task details were entered, and Cancel was clicked. The modal closed and the task was absent before and after refresh.
Status| PASS
Tester| 2022/ICT/78
Comment| TC-009 PASSED. Task creation was cancelled successfully and no task was saved. JUnit exited with code 0.
Date Tested| 2026-11-01

Shared Test Case Tracker: "Open Google Sheets" (https://docs.google.com/spreadsheets/d/1xntmKoLF67ZUh8P6DqYbO3rtIwb53AHrxQc20ToV6T4/edit)

Main Group Repository: "README.md" (../README.md)