# Web Application Test Automation

A Selenium WebDriver-based test automation framework for validating e-commerce web application functionality using the Page Object Model design pattern.

## 📋 Overview

This project automates end-to-end testing of a web application, covering user authentication, product selection, checkout process, and invoice viewing. The framework uses Java, Selenium WebDriver, and TestNG for comprehensive test execution and reporting.

## 🎯 Features

- **User Authentication**: Validates login functionality with valid credentials
- **Product Selection**: Tests product browsing and selection workflow
- **Checkout Process**: Verifies extras (shipping, warranty, discounts) and purchase confirmation
- **Invoice Management**: Validates invoice viewing and details
- **Page Object Model**: Organized test structure with separate page classes for maintainability
- **WebDriver Manager**: Automatic browser driver management
- **TestNG Framework**: Prioritized test execution with dependencies

## 🛠️ Technology Stack

- **Java 21**: Programming language
- **Selenium WebDriver 4.40.0**: Browser automation tool
- **TestNG 7.11.0**: Testing framework
- **WebDriverManager 6.3.3**: Automated driver management
- **Maven**: Build and dependency management
- **ChromeDriver**: Chrome browser automation

## 📁 Project Structure

```
WebApplication/
├── src/
│   ├── main/
│   │   ├── java/          # Main application source
│   │   └── resources/     # Configuration files
│   └── test/
│       └── java/
│           ├── LoginPage/
│           │   └── Login.java              # Login page object
│           ├── PurchasePage/
│           │   └── Purchase.java           # Purchase page object
│           ├── Extras/
│           │   └── ExtrasPage.java         # Extras page object
│           ├── ViewInvoice/
│           │   └── ViewInvoice.java        # Invoice page object
│           └── WebApplicationTest/
│               └── WebApplicationTest.java # Main test class
├── pom.xml                # Maven configuration
└── README.md              # This file
```

## 📄 Page Objects

### 1. **Login.java** - Authentication Module
Handles login functionality including:
- Clicking login button
- Entering email and password
- Submitting login form
- Verifying successful login with welcome message

### 2. **Purchase.java** - Product Selection Module
Manages product selection workflow:
- Learning materials navigation
- Device type selection (Phone, Tablet, etc.)
- Brand selection (Apple, Samsung, etc.)
- Storage capacity selection (128GB, 256GB, etc.)
- Color selection
- Quantity input
- Address entry
- Proceeding to checkout

### 3. **ExtrasPage.java** - Checkout Module
Handles additional purchase options:
- Shipping options selection (Express, Standard, etc.)
- Warranty selection (1 Year, 2 Year, etc.)
- Discount code application
- Purchase confirmation

### 4. **ViewInvoice.java** - Invoice Module
Manages post-purchase operations:
- Invoice viewing
- Invoice details retrieval

## 🧪 Test Cases

### Test 1: User Login
- **Priority**: 1
- **Description**: Verifies user can login with valid credentials
- **Test Data**: 
  - Email: `Okuhle@gmali.com`
  - Password: `@12345678`
- **Expected Result**: Welcome message displayed

### Test 2: Product Selection
- **Priority**: 2
- **Dependencies**: testLogin
- **Description**: Verifies product selection workflow
- **Actions**:
  - Navigate to Learning Materials
  - Select Web Automation Advanced course
  - Select device type: Phone
  - Select brand: Apple
  - Select storage: 128GB
  - Select color: Blue
  - Enter quantity: 2
  - Enter delivery address: 124 West Street

### Test 3: Extras and Checkout
- **Priority**: 3
- **Dependencies**: testProductSelection
- **Description**: Verifies extras selection and purchase completion
- **Actions**:
  - Select Express Shipping (+R25)
  - Select 1Year Warranty (+R49)
  - Apply discount code: save10
  - Confirm purchase
  - View invoice

## 🚀 Getting Started

### Prerequisites

- **Java 21** or higher
- **Maven 3.6+**
- **Chrome Browser** (for ChromeDriver)
- **Git** (optional, for version control)

### Installation

1. **Clone or navigate to the project directory**:
   ```bash
   cd C:\Users\Celebrate Mashaba\Documents\AutomationProject\WebApplication
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

3. **Build the project**:
   ```bash
   mvn clean package
   ```

## ▶️ Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -D test=WebApplicationTest
```

### Run Tests with Maven Surefire
```bash
mvn clean test -D skipITs=false
```

### Generate Test Report
```bash
mvn test -D surefire.reports.directory=target/surefire-reports
```

## 🔧 Configuration

The test automation is configured through:

- **pom.xml**: Maven dependencies and Java compiler settings
- **WebDriver Setup**: ChromeDriver initialization in `@BeforeClass` method
- **Page Factory**: WebElement locators defined via `@FindBy` annotations
- **Wait Mechanisms**: Thread.sleep() for synchronization (Thread.sleep() used; consider WebDriverWait for production)

### Application Under Test
- **URL**: `https://ndosisimplifiedautomation.vercel.app/`
- **Window**: Maximized browser window for optimal visibility

## 📝 Key Methods

### WebApplicationTest.java
- `setup()`: Initializes WebDriver and page objects
- `testLogin()`: Validates user login
- `testProductSelection()`: Tests product browsing and selection
- `testExtrasAndCheckout()`: Tests checkout workflow

### Login.java
- `clickLoginButton()`: Initiates login process
- `enterEmailAddress(String email)`: Inputs email
- `enterPassword(String password)`: Inputs password
- `clickSubmitButton()`: Submits login form
- `verifyLoginSuccess(String message)`: Asserts successful login

### Purchase.java
- `clickLearnButton()`: Navigates to learning section
- `clickLearningMaterialsButton()`: Accesses learning materials submenu
- `clickWebAutomationAdvanceButton()`: Selects Web Automation Advance course
- `selectDeviceType(String type)`: Selects device category
- `selectBrand(String brand)`: Selects device brand
- `selectStorageOption(String storage)`: Selects storage capacity
- `selectColor(String color)`: Selects device color
- `enterQuantity(int quantity)`: Inputs quantity
- `enterAddress(String address)`: Inputs delivery address
- `clickNextButton()`: Proceeds to next step

### ExtrasPage.java
- `Shipping(String shipping)`: Selects Express shipping option (+R25)
- `warranty(String warranty)`: Selects 1Year warranty option (+R49)
- `Discount(String discountCode)`: Applies discount code to purchase
- `confirmPurchase()`: Completes the purchase transaction

### ViewInvoice.java
- `viewInvoice()`: Navigates to purchase history and invoice view
- `View()`: Displays and opens the invoice details

## 🧩 Design Patterns

### Page Object Model (POM)
- Separates test logic from page interactions
- Centralizes element locators
- Improves test maintenance and readability
- Reduces code duplication

### Locator Strategy
- **XPath**: Used for complex element selection (e.g., Login button)
- **ID**: Used for stable form elements (e.g., Email and Password fields)
- **CSS Selectors**: Additional locator strategy for enhanced stability

## ⚠️ Notes and Best Practices

### Current Implementation
- Uses `Thread.sleep()` for synchronization
- Initializes WebDriver with 2-second initial delay
- Explicit waits between test actions

### Recommendations for Enhancement
1. **Replace Thread.sleep() with WebDriverWait**:
   ```java
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   ```

2. **Implement Screenshot Capture on Failure**:
   - Add listeners for test failures
   - Capture screenshots for debugging

3. **Use TestNG XML Configuration**:
   - Create testng.xml for better test organization
   - Define test groups and suites

4. **Add Logging**:
   - Implement SLF4J or Log4j for better debugging

5. **Use Properties File for Test Data**:
   - Externalize credentials and URLs
   - Support multiple environment configurations

6. **Implement Data-Driven Testing**:
   - Use TestNG data providers
   - Test with multiple user credentials

## 🐛 Troubleshooting

### ChromeDriver Not Found
- Ensure Chrome browser is installed
- WebDriverManager should automatically download the correct driver version

### Connection Timeout
- Verify internet connectivity
- Check if the application URL is accessible
- Increase wait times in the code if the application is slow

### Stale Element Reference
- Occurs when element is no longer attached to DOM
- Use explicit waits instead of Thread.sleep()
- Re-locate element after page refresh

### Element Not Clickable
- Element may be hidden or not visible
- Wait for element visibility before clicking
- Check if overlay or modal is blocking interaction

## 📊 Test Execution Flow

```
1. Setup Phase (@BeforeClass)
   ├─ Initialize ChromeDriver
   ├─ Navigate to application URL
   ├─ Maximize window
   └─ Initialize page objects

2. Test 1: Login (Priority 1)
   ├─ Click login button
   ├─ Enter credentials
   ├─ Submit form
   └─ Verify welcome message

3. Test 2: Product Selection (Priority 2, depends on Test 1)
   ├─ Click learn button
   ├─ Click learning materials button
   ├─ Click web automation advance button
   ├─ Select device type: Phone
   ├─ Select brand: Apple
   ├─ Select storage: 128GB
   ├─ Select color: Blue
   ├─ Enter quantity: 2
   ├─ Enter delivery address: 124 West Street
   └─ Proceed to checkout

4. Test 3: Checkout (Priority 3, depends on Test 2)
   ├─ Select shipping option
   ├─ Select 1Year warranty
   ├─ Apply discount
   ├─ Confirm purchase
   └─ View invoice
```

## 🤝 Contributing

For improvements or bug fixes:
1. Create a new branch
2. Make changes following the POM pattern
3. Test thoroughly
4. Submit for review

## 📞 Support

For issues or questions:
- Check the project structure and test logs
- Review WebDriver manager documentation
- Consult Selenium WebDriver best practices

## 📜 License

This project is part of the Automation Project series.

## 🔗 Related Links

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [WebDriverManager GitHub](https://github.com/bonigarcia/webdrivermanager)
- [Application URL](https://ndosisimplifiedautomation.vercel.app/)

---

**Last Updated**: March 7, 2026
**Version**: 1.0-SNAPSHOT
**Author**: Celebrate Mashaba
