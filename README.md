# ContinuousTests

## Description

This projects was created to show step-by-step of how to implement a pyramid of testing into a java spring boot template. The user can see all the step to master unit, integration and e2e tests into the application.

## Requirements

- JAVA 11 +

## How to Install and Run

> I choose Intellij IDE to build the tutorial, so if you want to build in another one, be careful with the configurations.

Open Intellij and use `import as maven project` to open project and wait the install finish.

> If the deps don't start to install, click with the right button in the files:
app/pom.xml and tests/e2e-tests/pom.xml and then `Add as Maven`.

## Additional

The project have their own database, so it's not necessary to start or configure a new one.
To change the database insert, it's possible to update de file `app/src/main/resources/data.sql`.
