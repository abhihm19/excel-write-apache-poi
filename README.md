# Spring Boot Excel Writer Using Apache POI

## Description

This Spring Boot project demonstrates how to write employee details to an Excel spreadsheet using the Apache POI library in Java. The Apache POI library provides a set of Java APIs for manipulating Microsoft Office files, including Excel spreadsheets.

In this project, we provide a Spring Boot application that writes a list of employee details to an Excel file. You can use this project as a reference for writing Excel files in your own Spring Boot applications.

## Prerequisites

Before using this project, make sure you have the following prerequisites:

- Java Development Kit (JDK)
- Maven
- Excel file containing employee details

## Usage

1. Clone this repository to your local machine:
    ```
   git clone https://github.com/abhihm19/excel-write-apache-poi.git
    ```
3. Navigate to the project directory:
   ```
   cd excel-write-apache-poi
   ```
5. Build and run the Spring Boot application using the following command:
    ```
   ./mvnw spring-boot:run
    ```
7. API Endpoint: GET
   ```
   localhost:8080/write
   ```
In the same directory, an excel file will be generated after the above endpoint is hit which contains a list of employee details.



