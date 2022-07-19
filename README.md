# Durstexpress QA Task

This project contains a few e2e tests and api tests which uses Gradle as a build automation tool.    

## Getting Started

It can be run on macOS, Windows or Linux platform.

### Prerequisites

Follow these instructions: https://gradle.org/install/ and install Gradle based on your OS.
Afterwards, you should try to add Gradle Wrapper: https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:adding_wrapper (```
                                                                                                                                     $ gradle wrapper
                                                                                                                                     ```).
Also, Java 11(or 8) should be available on your machine.

For running e2e tests on your local machine, you need Chrome(version 103) and Firefox(version 102) which are already installed and running on your machine.

If you want to run tests using docker containers, make sure docker(https://docs.docker.com/engine/install/) and docker-compose(https://docs.docker.com/compose/install/) are already installed and running (latest versions).

For running API tests, https://github.com/BestBuy/api-playground should be up and running on port 3030.

```
git clone https://github.com/bestbuy/api-playground/
cd api-playground
npm install
npm start
```
Best Buy API Playground started at http://localhost:3030

## Running the tests(locally)

After cloning the repository, on the command line navigate to the project root directory and run:(it runs api tests and e2e tests)
```
./gradlew clean test  // on windows without './'
```

The default browser is Chrome. For running test on Firefox, you should pass proper property: 
```
./gradlew clean test -Dgeb.env=firefox
```

If you would like to run only api tests, use:
```
./gradlew clean test -Dgroup=api
```

If you would like to run only e2e tests(ex. on Firefox), use:
```
 ./gradlew clean test -Dgroup=e2e -Dgeb.env=firefox
```

## Running the tests using docker containers

Make sure docker is up and running. Also, docker-compose must have been already installed.

For creating a selenium hub and connecting one chrome node and firefox node to it you need to run:
```
 docker-compose -f docker-compose.yml up -d
```
Afterwards, you check in your browser localhost:4444 and then click on console to check the available connected nodes to the hub.

For running e2e tests using selenium hub using chrome, run:
```
 ./gradlew clean test -Dgroup=e2e -Dgeb.env=remoteChrome
```
and for running using firefox, run:
```
 ./gradlew clean test -Dgroup=e2e -Dgeb.env=remoteFirefox
```

At the end run:
```
 docker-compose down
```
in order to get rid of selenium hub and created containers.

## Test Reports

Allure test report(http://allure.qatools.ru/) at the end of test run is created and can be found at /build/reports/allure-report/index.html.

Test steps can be found in behaviour section. Also, the graph section gives useful information about test run time. In case of failed e2e tests, screenshots are taken and attached to this report.

Another available test report is the default test report by GEB and can be found in /build/reports/tests/test(open the index file with any browser).

