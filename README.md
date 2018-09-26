## Introduction
This example builds a simple REST API. (retrieve, update, delete and insert a person)

##  Keywords
Maven <br>
Java 1.8 <br>
Spring Boot <br>
Spring Data REST<br>
Asciidoctor <br>
H2 (in memory db)<br>

## Building this Project

This project is built with Maven (http://maven.apache.org) so make sure you have an up-to-date installation of Maven
before proceeding.

Clone this project, change to the root SDO directory and run

```bash
mvn clean install
```

to build the binary of this project.


## Execute the application
```bash
java -jar  target/sdo-rest-api-0.0.1-SNAPSHOT.jar
```
or
```bash
mvn spring-boot:run
```

## Welcome page
The root shows a welcome page
```bash
http://localhost:8080
```

## REST API example
Retrieve the list of people
```bash
curl --request GET http://localhost:8080/api/people
```

Query by person id
```bash
curl --request GET http://localhost:8080/api/person/101
```

Add a list of people
```bash
curl --header "Content-Type: application/json" --request POST -d '{  
   "person":[     {
      "first_name": "Cinzia",
      "last_name": "Bianchi",
      "age": "19",
      "favourite_colour": "yellow"
    },
    {
      "first_name": "Sarah",
      "last_name": "Robinson",
      "age": "54",
      "favourite_colour": "blue"
    } ]
}' http://localhost:8080/api/addpeople
```

Update the info for a list of people

```bash
curl --header "Content-Type: application/json" --request PUT \
-d '{  
   "person":[     {
      "id":1 ,
      "first_name": "Cinzia",
      "last_name": "Doe",
      "age": "27",
      "favourite_colour": "purple"
    }]
}' http://localhost:8080/api/updatepeople
```

Delete a list of people by ids
```bash
curl --header "Content-Type: application/json" --request DELETE \
-d '{  
   "person":[     {
      "id":1 
    }]
}' http://localhost:8080/api/deletepeople
```

## REST API 404 example
If the person is not present, the status code is 404.

```bash
curl -I --request GET http://localhost:8080/api/person/1

HTTP/1.1 404
Content-Length: 0
Date: 
```

## ASCIIDOCTOR
Next step is integrate ASCIIDOCTOR into the code in order to create the REST API docs.
