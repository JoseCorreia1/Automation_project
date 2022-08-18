
# Web Automated Tests

This project is a template to create tests for the Web platforms. The tests assist in verifying the stability of the environments and also help us understand what features
are not working as expected. By default, Maven is used to execute all the commands for this repository. 

## Setting up the application
Clone the respository from bitbucket with the following command

```bash 
git clone git@github.com:diogo-brandao1/web-automation-template.git

cd web-automation-template
```

## Install the dependencies 

```bash
mvn install
```
## Installing Plugins - IntelliJ IDE

In the event that you are using IntelliJ, you will need to install the following plugins on your IDE: Java and Gherkin Substeps InteliJ plugins. 

## Project Setup & Driver Information

To run the project on either linux, windows or MaC operating systems, you require to have a driver that is specific to your operating system. The different driver configuration properties for different operating systems can be found in the directory `src/test/resources`. The drivers required by selenium to run your project can be found in the directory `drivers` in the project root. 

## Running tests in Different Environments

The way this project has been set up, the tests can be run in different environments either TEST, UXT or UAT. these environments can be added when the need arises. The configuration for which environments are currently supported can be found in the `pom.xml` file under the `<profiles>` section as shown below

```xml
<profiles>
        <profile>
            <id>test</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <env>test</env>
            </properties>
        </profile>

        <profile>
            <id>uat</id>
            <properties>
                <env>uat</env>
            </properties>
        </profile>

        <profile>
            <id>uxt</id>
            <properties>
                <env>uxt</env>
            </properties>
        </profile>
    </profiles>
```

When running our tests, we need to select the default environment by selecting which profile we will use to run our tests. As shown above, the default profile/environment is the `test` environment. 

The following command can be used to execute tests in the UXT environment as we have defined the `-Puxt` which will be interpreted to mean that we are askin maven to use the `UXT` profile. These profiles have configuration which are defined in the directory `src/test/resources/env`

```bash
mvn clean verify -Puxt -Dcucumber.options="--tags @uxt" 
```

From the command above we have also passed the options which determine which set of data to use when running our tests `-Dcucumber.options="--tags @uxt" `. This section tells Cucumber and maven that we want to use the test data that is tagged as  `@uxt`. 

In our tests, we have defined data for different eenvironments as we are separating the tests to run independently by every defined environment.

```gherkin
Scenario Outline: Business - Do the login with correct credentials
    Given i am in the business login page
    And i change the language to english
    And change language successfully
    Then i want to login with "<username>" and "<password>"
    And i confirm i am in select context page

  @test
    Examples:
      | username | password |
      | business.company | Password1* |

  @uxt
    Examples:
      | username | password |
      | uxt.company | Password1* |

  @uat
    Examples:
      | username | password |
      | uat.company | Password1* |

```

In the above `Scenario Outline`, we can run our tests with any set of the defined data above, either `@test` or `@uxt` or `@uat`. These configurations can be changed when excuting commands on the command line. 

**N.B** It is important to note that the profile defined should automatically correspond with the data provided for that environment. e.g `mvn clean verify -Puxt -Dcucumber.options="--tags @uxt"` Will only run test data for UXT enviornment using the UXT profile. when this command is run with deferring profiles and the test data, the tests will automatically fail, as it willl execute in an environment with invalid test data. 

## Running tests - Using the terminal
The following GIF shows how you can run tets using the IDE terminal 

![ Terminal test run ](./assets/test-run-cli.gif)

## Running tests on IntelliJ - Using the IDE
The following GIF shows how you can run tets using the IDE and cucumber. 

![ IDE test run ](./assets/test-run-intellij.gif)

It is important to note, that with the configuration on the GIF done, you can run, whole folders like `business` or even subfolders like `auth` and even single `.feature` files, just by right clicking and using the run option for cucumber as long as you have the plugins mentioned above installed. 

## Contributing

To contribute to this repository, create a branch from the master branch, then make your changes and create a pull request against the master branch. 

Before creating a pull request, make sure you run your tests locally and ensure that they are passing before creating a pull request. 


### Need further help? ###

Feel free to contact Diogo Brandão (Bring's Automation Web Specialist) or Pedro Silveira (The QA team leader)
