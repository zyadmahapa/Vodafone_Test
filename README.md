# Swag Labs Login Automation

This project automates the login scenario on the Swag Labs website (https://www.saucedemo.com/) using Java and Selenium WebDriver.

## Prerequisites

Java Development Kit (JDK) installed

Selenium WebDriver library

ChromeDriver executable

TestNG

### Getting Started

download the source code.

Set up your Java project in your integrated development environment (IDE)  IntelliJ IDEA.

Configure the project to include the Selenium WebDriver library.

Open the Maven file and put in the dependencies selenium-java version and webdrivermanager version

Download the ChromeDriver executable compatible with your Chrome browser version.

## Running the Tests

To run the tests, execute the test suite using Maven:
## Project Structure

- **src/main/java**: Contains reusable components and utilities.
- **src/test/java**: Contains test scripts and test data.
- **src/test/resources**: Contains configuration files and test data files (Excel).
## Test Scenario

1. Open https://www.bing.com
2. Type and search for “Vodafone”
3. Scroll down and go to the next page
4. Count the number of results displayed on the second page (ignore any maps, videos, or images)
5. Scroll down and go to the next page
6. Validate if the number of results on page 2 is equal to page 3 or not
7. Close the browser window
## Authors
ZyadAlaa
