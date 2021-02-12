# Spring Recipe Sample Application [![CircleCI](https://circleci.com/gh/shubhamshukla7794/spring5-recipes-app.svg?style=svg)](https://app.circleci.com/pipelines/github/shubhamshukla7794/spring5-recipes-app)
This repo contains the project **My Recipes App** a spring sample application developed while undergoing an online course called [Spring Framework 5: Beginner to Guru](https://www.udemy.com/spring-framework-5-beginner-to-guru).



## Running My Recipe App locally
Petclinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/shubhamshukla7794/spring5-recipes-app.git
cd spring5-recipes-app
./mvnw package
java -jar target/*.jar
```

You can then access the application here: http://localhost:8080/
![Home](https://user-images.githubusercontent.com/37581959/107751407-60d8f600-6d43-11eb-9ad4-f8e3922e04f6.png)


## Working with Recipe App in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 11 or newer.
* Your preferred IDE.

## Database configuration

In its default configuration, Recipe App uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is automatically exposed at `http://localhost:8080/h2-console`
and it is possible to inspect the content of the database using the `jdbc:h2:mem:testdb` url.


## Application

**Show Recipe by Category**
![Category Show](https://user-images.githubusercontent.com/37581959/107751488-7817e380-6d43-11eb-958d-cb313f60a75d.png)

**View Recipe**
![Recipe Show](https://user-images.githubusercontent.com/37581959/107751533-85cd6900-6d43-11eb-8b22-840768e9f663.png)

**Recipe Ingredients**
![Recipe Ingredients](https://user-images.githubusercontent.com/37581959/107751565-9251c180-6d43-11eb-99c2-fb8eaa5fd92a.png)

**Update Recipe**
![Recipe 1 Update](https://user-images.githubusercontent.com/37581959/107751784-d93fb700-6d43-11eb-80c5-8cacc4dee2f0.png)

**Add a new Recipe**
![Recipe New](https://user-images.githubusercontent.com/37581959/107751800-e361b580-6d43-11eb-947a-51b3eae2c52e.png)

**New Recipe - add Ingredients and Upload Image **
![Recipe New Update](https://user-images.githubusercontent.com/37581959/107751873-f7a5b280-6d43-11eb-84ea-207f8b696896.png)

##  Author
Project created by :
**SHUBHAM KUMAR SHUKLA**