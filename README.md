# <strong>magento.softwaretestingboard.com</strong>
Ready-to-use UI Test Automation Architecture using Java and Selenium WebDriver.


This repository contains an automated testing framework for a web application, utilizing Selenium WebDriver, TestNG, and Allure for reporting. The project is structured to provide a scalable and maintainable testing environment.

### **Project Structure**
![Capture](https://github.com/kowshik78/selenium-java-POM-testNG-automation-architecture/assets/27826457/a30af22f-f2a1-452f-a852-4eee735fbe63)
### **Key Components**
- utils/ConfigProperties.java: Manages configuration properties from config.properties.
- utils/Constant.java: Stores constant values used across tests, including a random email generator.
- pages Package: Contains page object models (POMs) representing different pages of the web application.
- tests Package: Contains test classes for each functional area of the web application.
### **Setup Instructions**
- Clone the repository:
- The project requires Java 8 or higher.
- Install dependencies, download necessary driver

### **Test Design and Methodology**
- Each page class in the pages package represents a web page and encapsulates its elements and behaviors. This helps in maintaining the tests by separating the test logic from the page structure.
- Factory methods in the test classes (BaseTest.java and others) are used to initialize the WebDriver and page objects, ensuring proper setup and teardown processes for each test.
- ConfigProperties.java: Loads configuration settings from config.properties file.
- Tests are organized in TestNG test suites defined in testng.xml, which allows for flexible test execution and grouping.

# **Overview of Test Classes in tests Package**
### 1. BaseTest.java 
- Acts as the base class for all test classes, providing setup and teardown methods for initializing WebDriver and managing test environment configurations.
- @BeforeMethod and @AfterMethod annotations: Used to set up and tear down the WebDriver instance before and after each test method.
- Integration with ConfigProperties.java: Ensures tests are executed under the correct environment configurations loaded from config.properties.
### 2. CreateAccountPageTest.java
- Tests the functionality related to creating a new user account on the application.
- testCreateNewAccountValid(): Validates the creation of a new account with valid data.
- testCreateNewAccountInvalid(): Verifies the handling of invalid inputs during account creation.
### 3. ChangePasswordTest.java
- Tests the functionality related to changing the user password.
- testChangePasswordValid(): Validates the process of changing the password with valid current and new passwords.
- testChangePasswordInvalid(): Verifies the behavior when incorrect or invalid password inputs are provided.
### 4. LoginTest.java
- Tests the login functionality of the application.
- testLoginValid(): Validates successful login with correct credentials.
- testLoginInvalid(): Verifies the handling of unsuccessful login attempts with incorrect credentials.
### 5. ChangeBillingAddressTest.java
- Tests the functionality related to changing the billing address in the user account settings.
- testChangeBillingAddressValid(): Validates the process of updating the billing address with valid inputs.
- testChangeBillingAddressInvalid(): Verifies the handling of errors or validation checks during address update attempts.
### 6. HomeTest.java
- Tests various functionalities on the homepage of the web application.
- locatorTest(): Checks the presence and functionality of specific UI elements (locators) on the homepage.
- subscribeclickTest(): Verifies the subscription functionality on the homepage.
### 7. SubscriberTest.java
- Tests the subscriber functionality, which may involve managing newsletter subscriptions or email notifications.
- Methods specific to subscriber functionality, which could include subscribing, unsubscribing, or verifying subscription status.
### 8. cartAddTest.java
- Tests operations related to adding items to the shopping cart.
- Methods for adding items to the cart, validating cart contents, and checking cart functionality such as quantity updates or removals.
### 9. CompareListTest.java
- Tests functionalities related to comparing lists of products or items.
- compareCart(): Validates the comparison of items in the shopping cart.
- compareProductWithTable(): Verifies the comparison of product details with specified criteria or against a reference table.
### 10. RandomDropListTest.java
- Tests functionalities that involve random or dynamic dropdown lists on the application.
- Methods for interacting with dropdown lists, selecting options, and verifying dropdown behavior under various scenarios.
### 11. MyOrderTest.java
- Tests functionalities related to managing user orders or purchase history.
- Methods for verifying order history, checking order statuses, or validating order details against expected outcomes.
