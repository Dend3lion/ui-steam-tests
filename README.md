# Test automation project for [Steam](https://store.steampowered.com/)

<p align="center"><a href="https://store.steampowered.com/"><img src="media/images/Steam_Logo.png" align="center" height="200" alt="Steam"/></a></p>  

## :bookmark_tabs: Contents
- [Technologies and tools](#computer-technologies-and-tools)
- [Features](#star2-features)
- [Test cases](#clipboard-test-cases)
- [Running tests locally](#rocket-running-tests-locally)
- [Build in Jenkins](#-build-in-jenkins)
- [Test results in Allure report](#-test-results-in-allure-report)
- [Test management in Allure TestOps](#-test-management-in-allure-testops)
- [Integration with Jira](#-integration-with-jira)
- [Notification of test results in Telegram](#-notification-of-test-results-in-telegram)
- [Test video from Selenoid](#-test-video-from-selenoid)


## :computer: Technologies and tools
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/images/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/images/Java.svg"></a>
<a href="https://github.com/allure-framework"><img width="6%" title="Allure Report" src="media/images/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/images/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/images/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/images/JUnit5.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/images/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="7%" title="Selenoid" src="media/images/Selenoid.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/images/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/images/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/images/Telegram.svg"></a>
<a href="https://www.atlassian.com/software/jira/"><img width="5%" title="Jira" src="media/images/Jira.svg"></a>
</p>

Automated tests are written in the `Java` language using `JUnit 5` and `Selenide`. The project is built with `Gradle`. 
For remote execution, a task is implemented in `Jenkins` to generate an `Allure report` and send the results to `Telegram` using a bot. 
Remote execution is carried out in `Selenoid`. 
To manage test scenarios and manually initiate test runs, `Allure TestOps` is utilized, and the results of their completion are linked to `Jira` issues.

## :star2: Features
- `Parameterized tests`: Efficiently validates test logic across diverse scenarios with varied input values for comprehensive coverage
- `Page Objects`: Uses the pattern for improved test organization and maintenance
- `Chain of Invocations`: Establishes a clear and traceable path for test scenarios by implementing a cohesive series of Allure steps.
- `Configuration files`: Provides various configurations for seamless test execution in different environments using `Owner library` through Java properties files
- `Parameterized build`: Enables easy configuration and customization of test runs.
- `Parallel Execution`: Speeds up tests, providing faster feedback and reduced time
- `Custom Allure listener`: Captures screenshots, videos, browser console logs, and page source code for comprehensive test reporting
- `Allure TestOps integration`: Unifies test reporting, analytics and launch management
- `Jira Integration`: Streamlines issue tracking, collaboration, and integrates Allure for test case and launch management
- `Autotests as Documentation`: Provides real-time insight into project functionality

## :clipboard: Test cases

- :white_check_mark: Add game to cart
- :white_check_mark: Remove game from cart
- :white_check_mark: Remove all items from cart
- :white_check_mark: Go to genre page from genres sidebar
- :white_check_mark: Language selection changes main navbar locale
- :white_check_mark: Search dropdown contains searched game
- :white_check_mark: Search page contains searched
- :white_check_mark: Go to game page from search results

## :rocket: Running tests locally

### Local launch

```bash
gradle clean test -Denv=local
```

### Remote launch

```bash
gradle clean test -Denv=remote
```

### Parametrized remote launch

```bash
gradle clean test
-Dbrowser=${browser}
-DbrowserVersion=${browserVersion}
-DbrowserSize=${browserSize}
-DremoteUrl=${remoteUrl}
```
> `${browser}` - browser name (_default - <code>chrome</code>_).
>
> `${browserVersion}` - browser version number (_default - <code>100.0</code>_).
>
> `${browserSize}` - browser window size (_default - <code>1980x1080</code>_).
>
> `${remoteUrl}` - address of the remote server on which the tests will be run.
>

## <img alt="Jenkins" width="5%" src="media/images/Jenkins.svg"/> Build in [Jenkins](https://jenkins.autotests.cloud/job/ui-steam-tests/)
<p align="center">  
<img src="media/images/Jenkins_Screenshot.png" alt="Jenkins" width="950"/></a>  
</p>

## <img alt="Allure Report" width="5%" src="media/images/Allure_Report.svg"/> Test results in [Allure report](https://jenkins.autotests.cloud/job/ui-steam-tests/allure/)
<p align="center">  
<img src="media/images/AllureReport_Main.png" alt="Allure Report main page" width="950"/></a>  
</p>
<p align="center">  
<img src="media/images/AllureReport_Tests.png" alt="Allure Report suites page" width="950"/></a>  
</p>

## <img alt="Allure TestOps" width="4%" src="media/images/AllureTestOps.svg"/> Test management in [Allure TestOps](https://allure.autotests.cloud/project/4010/dashboards)
<p align="center">  
<img src="media/images/AllureTestOps_Main.png" alt="Allure Report main page" width="950"/></a>  
</p>
<p align="center">  
<img src="media/images/AllureTestOps_Tests.png" alt="Allure Report suites page" width="950"/></a>  
</p>

## <img alt="Jira" width="4%" src="media/images/Jira.svg"/> Integration with [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1091)
<p align="center">  
<img src="media/images/Jira_Task.png" alt="Jira task page" width="950"/></a>  
</p>


## <img alt="Telegam" width="5%" src="media/images/Telegram.svg"/> Notification of test results in [Telegram](https://play.google.com/store/apps/details?id=org.telegram.messenger&hl=ru&gl=US)
<p align="center">  
<img src="media/images/Telegram_Bot.png" alt="Telegram bot" width="300"/></a>  
</p>

## <img alt="Selenoid" width="5%" src="media/images/Selenoid.svg"/> Test run in [Selenoid](https://aerokube.com/selenoid/)
<p align="center">  
<img src="media/gifs/Test_Video.gif" alt="Test Video" width="950"/></a>  
</p>
