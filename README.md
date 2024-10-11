# Expedia Flight Test Home Task

This repository contains a test automation framework for Expedia's flight booking functionality. It uses Java, Selenium WebDriver, and TestNG, with Maven for dependency management. The framework is designed to automate searching for flights and verify results.

## Prerequisites

- **Java JDK 21**: Download from Oracle or install using Homebrew:
  ```bash
  brew install openjdk@21
  echo 'export PATH="/usr/local/opt/openjdk@21/bin:$PATH"' >> ~/.zshrc
  source ~/.zshrc
  ```

- **Maven**: Install using Homebrew:
  ```bash
  brew install maven
  ```

- **Google Chrome**: Ensure the latest version is installed.

- **ChromeDriver**: Managed automatically by `WebDriverManager` in the project.

- **VPN (Recommended)**: For users outside the United States, connecting to an American server using a VPN will ensure accurate results.

## Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/komar1811/expedia-flight-test-home-task.git
   cd expedia-flight-test-home-task
   ```

2. **Install Dependencies**:
   Run Maven to download and install the required dependencies:
   ```bash
   mvn clean install
   ```

3. **Configure VPN**:
   Connect to a VPN with a US-based server if you are outside the USA.

## Running the Tests

To run all tests, execute:
```bash
mvn test
```

To run a specific test class (e.g., `MainPageTest`):
```bash
mvn -Dtest=MainPageTest test
```

## Test Configuration

Update `test_config.properties` with necessary test data:
- **departureAirport**: IATA code for the departure airport.
- **arrivalAirport**: IATA code for the arrival airport.
- **flightDate**: Define the flight date(s) as needed.

## Project Structure

- **src/main/java**: Contains custom utilities and page objects, including:
    - `CustomElementLocatorFactory`
    - `CustomFieldDecorator`
    - `CustomWebElement`
    - `MyPageFactory`
- **src/test/java**: Contains test class `MainPageTest`.
- **test_config.properties**: Configuration file for flight search parameters.

---