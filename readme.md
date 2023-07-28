# Automated Tests for the API Logitech Media Server

## General info
* Test 1. Set the volume and check that the volume value is set

## Technologies
Project is created with:
* Java 11
* Apache Maven 3.8.6 
* TestNG 7.8.0
* REST-assured 5.3.1
* Allure 2.22.1  

## Logitech Media Server

https://mysqueezebox.com/download
  
## Launch
to run the default test go to project dir and run:
```
mvn clean test
```

to view the Allure report:
```
allure serve $(pwd)/target/allure-results
```

