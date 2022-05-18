# Expense Tracker System

Expense Tracker System  will keep  track of Income-Expense on a day to day basics.

# Technologies Used
1. Spring Boot
2. Spring Security
3. Spring Data JPA
4. JWT
5. MySQL Database
6. Hibernate
7. Maven
8. Spring Boot Devtools

# Prerequisites
Java 1.8 or greater, Spring boot 2.0 or greater, Maven, IntelliJ or Eclipse

# Getting Started

Follow the step below to get the application up and running on your local machine for development and testing purpose.


1. Git clone project in your local machine https://github.com/mohyehia/spring-boot-reset-password.git.
2. Import the project in Eclipse.
3. Create database with name ```expense_tracker``` in MySQL Workbench.
4. Run the application.
5. Once application is up and running.Execute below queries.
 ``` javascript
   INSERT INTO roles(name) VALUES('ROLE_USER');
   INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
   INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
 6. Access the application by url http://localhost:9001 in any web browser.



# Test services via Postman

1. User Registration
``` javascript
API : {{url}}/api/auth/signup

Request:
{
    "username":"testuser",
    "email":"testuser@gmail.com",
    "password":"123456"
}

Response:
{
    "message": "User registered successfully!"
}

```

2. User Login
``` javascript
API : {{url}}/api/auth/signin

Request:
{
    "username":"testuser",
    "password":"123456"
}

Response:
{
    "id": 3,
    "username": "testuser",
    "email": "testuser@gmail.com",
    "roles": [
        "ROLE_USER"
    ],
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0dXNlciIsImlhdCI6MTY1Mjg4MDk4NiwiZXhwIjoxNjUyOTY3Mzg2fQ.xMy8xN9cv7YTkDJ0zPZMo_INpDMZqdKnYAhgLTLfYHB-VWtmdhqOQ1kh-5yx6P6Wwc_QyM1JA_j8zksd4o5OWw",
    "tokenType": "Bearer"
}

```

3. List Category

``` javascript
API : {{url}}/api/category

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
{
    "userId": 3,
    "categories": [
        {
            "id": 6,
            "name": "Health Care",
            "createdAt": "2022-05-18T13:38:59.000+00:00",
            "updatedAt": "2022-05-18T13:38:59.000+00:00",
            "active": true
        }
    ]
}

```

4. Create Category
``` javascript
API : {{url}}/api/category

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Request:
{
    "name":"Health Care"
}

Response:
{
    "id": 6,
    "name": "Health Care",
    "createdAt": "2022-05-18T13:38:58.527+00:00",
    "updatedAt": "2022-05-18T13:38:58.527+00:00",
    "active": true
}

```