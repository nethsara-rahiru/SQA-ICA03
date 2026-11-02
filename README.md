# SQA ICA03 — Software Testing and Automation

Group assignment for Software Quality Assurance at the **University of Vavuniya**, documenting automated UI testing, API testing, and performance testing of a sample Task Manager application.

## Project links

- **Application under test:** [TaskManager](https://github.com/ArunPragas2001/TaskManager)
- **Test-case tracker and dashboard:** [SQA ICA03 — Google Sheets](https://docs.google.com/spreadsheets/d/1xntmKoLF67ZUh8P6DqYbO3rtIwb53AHrxQc20ToV6T4/edit)

> This repository serves as the shared workspace for test scripts, evidence, reports, and assignment documentation. Test-case status and evidence should be verified against the tracker; a recorded “Pass” does not necessarily mean a defect-free application.

## Application under test

Our group selected **[TaskManager](https://github.com/ArunPragas2001/TaskManager)** as the application under test for this Software Quality Assurance assignment. It was originally developed as a **previous-semester individual project** by our team member **T. A. Pragas (2022/ICT/90)** ([GitHub: ArunPragas2001](https://github.com/ArunPragas2001)).

The project is a task-management application with a RESTful API using **Node.js, Express.js, and MongoDB**. For this group assignment, we use it to practice and document **Selenium UI testing, Postman API testing, and Apache JMeter performance testing**. The original application repository remains separate from this repository, which contains the team's testing work and evidence.

## Course lecturer

This group assignment was assigned by **Ms. Sivasoruby Kanapathipillai**, Faculty of Applied Science, University of Vavuniya. [Lecturer profile](https://fas.vau.ac.lk/dps/staff/ms-sivasoruby-kanapathipillai/).

## Team and responsibilities

| Student ID | Team member | Assigned area | Tool |
| --- | --- | --- | --- |
| 2022/ICT/62 | B.A.N.R. Bulathsinhala | Performance testing | Apache JMeter |
| 2022/ICT/63 | G.M.S.A. Gunarathna | API testing | Postman |
| 2022/ICT/70 | W.A.U.D. Wijayakoon | API testing | Postman |
| 2022/ICT/78 | U.G.H.S. Ranasingha | UI testing | Selenium (Java) |
| 2022/ICT/90 | T.A. Pragas | UI testing | Selenium (Java) |

## Testing scope

### UI testing — Selenium with Java

Automate the following user journeys:
1. User registration/sign-up.
2. User login.
3. At least one additional application feature (such as task creation or status changes).

Include valid, invalid, and boundary-value inputs as applicable, together with assertions and supporting screenshots or execution logs.

### API testing — Postman

Test CRUD operations on at least one resource in the application:
- **POST:** Create a resource.
- **GET:** Retrieve resource data.
- **PUT/PATCH:** Update a resource.
- **DELETE:** Remove a resource.

Also check relevant authentication, authorization, validation, and error-response behavior.

### Performance testing — Apache JMeter

1. Select a suitable application endpoint (the team tracker uses the login API).
2. Run a load test with **10 virtual users**.
3. Repeat with **25 virtual users**, where feasible.
4. Compare **response time, throughput, and error percentage**.
5. Explain notable results and limitations.

Additional load levels may be tested, but the required comparison should remain clearly documented. Keep the number of threads, ramp-up period, loop count, HTTP request details, environment, and test data with each result.

## Test-case documentation

Each team member should prepare **at least five test cases**. Record:

| Field | Purpose |
| --- | --- |
| Test Case ID | Unique reference |
| Scenario | Behavior being tested |
| Preconditions | Required application state |
| Steps | Reproducible execution instructions |
| Test data | Input values and request details |
| Expected result | Required behavior |
| Actual result | Observed behavior |
| Status | Pass, Fail, or Partial Pass |
| Tester | Responsible group member |
| Evidence / comments | Screenshots, logs, defects, or notes |

The [Google Sheets tracker](https://docs.google.com/spreadsheets/d/1xntmKoLF67ZUh8P6DqYbO3rtIwb53AHrxQc20ToV6T4/edit) contains a dashboard, member assignments, task requirements, and individual tester worksheets.

## Running the tests

**Application:** Follow the setup and execution instructions in the [TaskManager repository](https://github.com/ArunPragas2001/TaskManager). Start the application before running tests that target its local server.

**API:** Open the team's Postman collection (when added to this repository), set the appropriate base URL and authentication variables, then execute the requests and record their actual responses.

**UI:** Open the relevant Java/Selenium test project (when added), configure the browser and application URL, and run the automated test suite. Preserve screenshots and test-run output as evidence.

**Performance:** Open the team's JMeter `.jmx` test plan (when added). For command-line runs, use a locally installed JMeter executable:

```bash
jmeter -n -t "Test Plan 01.jmx" -l results.jtl -e -o HTMLReport
```

The output directory must not already contain a report. Use distinct results files and report directories for different load levels. Do not commit passwords, JWT tokens, or other sensitive account data.

## Test findings and reporting

The current tracker documents both successful checks and failed or partially passing validation scenarios. For each discovered defect, retain the input, expected versus actual behavior, reproducible steps, and supporting evidence. The final report should summarize coverage, defects, load-test measurements, limitations, and recommendations.

## Collaboration

- Add scripts, collections, screenshots, results, and reports with descriptive filenames.
- Keep the tracker updated when a test is run or its outcome changes.
- Use meaningful Git commits and review changes before merging.
- Avoid committing secrets, personal credentials, generated dependencies, or unnecessarily large temporary artifacts.

---

**Coursework repository — SQA ICA03 · University of Vavuniya**
