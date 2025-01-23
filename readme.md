# Drone dispatcher service

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is a sample Drone Dispatcher program.
You can view your drones, add new drones and load some different medication to idle drones according to their maximum 
load 
weight.

## Technologies
Project is created with:
* Java 19 (Oracle OpenJDK)
* Spring Boot 3.0.0
* Spring MVC 6.0.0
* Spring Security 6.0.0
* In-memory DB (H2) 2.1.214
* Maven 3.8.1
* Thymeleaf 3.1.0
* Lombok 1.18.24
* JUnit 5.9.1

## Setup
To test this project locally:
* Navigate to the program folder and run
```
$ mvn spring-boot:run

```
* Open "http://localhost:8082/drones" in your browser
* Use user1:password1 credentials
* Enjoy
