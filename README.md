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


1. Git clone project in your local machine https://github.com/ravisahani2893/expense-tracker
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



# Testing Rest API via Postman

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

3. Create Category
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

4. List Category

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

5. Create Payment Type
``` javascript
API : {{url}}/api/paymenttype

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Request:
{
    "type":"UPI"
}

Response:
{
    "id": 6,
    "type": "UPI",
    "createdAt": "2022-05-18T13:43:28.901+00:00",
    "updatedAt": "2022-05-18T13:43:28.901+00:00",
    "active": true
}

```

6. List Payment Type

``` javascript
API : {{url}}/api/paymenttype

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
[
    {
        "id": 6,
        "type": "UPI",
        "createdAt": "2022-05-18T13:43:29.000+00:00",
        "updatedAt": "2022-05-18T13:43:29.000+00:00",
        "active": true
    }
]

```

7. Create Expense
``` javascript
API : {{url}}/api/expense

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Request:

{
    "amount":100,
    "expenseDescription":"Health Product",
    "paymentId":6,
    "categoryId":6
}

Response:
{
    "id": 5,
    "category": {
        "id": 6,
        "name": "Health Care",
        "createdAt": "2022-05-18T13:38:59.000+00:00",
        "updatedAt": "2022-05-18T13:38:59.000+00:00",
        "active": true
    },
    "payment": {
        "id": 6,
        "type": "UPI",
        "createdAt": "2022-05-18T13:43:29.000+00:00",
        "updatedAt": "2022-05-18T13:43:29.000+00:00",
        "active": true
    },
    "expenseAmount": 100,
    "expenseDescription": "Health Product",
    "createdAt": "2022-05-18T13:47:35.915+00:00",
    "updatedAt": "2022-05-18T13:47:35.915+00:00"
}

```

8. List User Expense

``` javascript
API : {{url}}/api/expense

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
[
    {
        "id": 5,
        "expenseAmount": 100.00,
        "expenseDescription": "Health Product",
        "categoryName": "Health Care",
        "paymentType": "UPI",
        "createdAt": "2022-05-18",
        "updatedAt": "2022-05-18"
    }
]

```

9. List User Expense by Date Filter

``` javascript
API : {{url}}/api/expense?fromDate=2022-05-01&toDate=2022-05-20

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
[
    {
        "id": 5,
        "expenseAmount": 100.00,
        "expenseDescription": "Health Product",
        "categoryName": "Health Care",
        "paymentType": "UPI",
        "createdAt": "2022-05-18",
        "updatedAt": "2022-05-18"
    }
]

```

10. List User Current Month Expense

``` javascript
API : {{url}}/api/expense/currentmonth

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
[
    {
        "id": 5,
        "expenseAmount": 100.00,
        "expenseDescription": "Health Product",
        "categoryName": "Health Care",
        "paymentType": "UPI",
        "createdAt": "2022-05-18",
        "updatedAt": "2022-05-18"
    }
]

```

11. List User Expense By Category

``` javascript
API : {{url}}/api/expense/currentmonth

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
[
    {
        "id": 5,
        "expenseAmount": 100.00,
        "expenseDescription": "Health Product",
        "categoryName": "Health Care",
        "paymentType": "UPI",
        "createdAt": "2022-05-18",
        "updatedAt": "2022-05-18"
    }
]

```

12. List User Expense By Category and Date Filter

``` javascript
API : {{url}}/api/expense/category/6?fromDate=2022-05-01&toDate=2022-05-20

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
[
    {
        "id": 5,
        "expenseAmount": 100.00,
        "expenseDescription": "Health Product",
        "categoryName": "Health Care",
        "paymentType": "UPI",
        "createdAt": "2022-05-18",
        "updatedAt": "2022-05-18"
    }
]

```

13. List User Current Month Expense By Category 

``` javascript
API : {{url}}/api/expense/currentmonth/category/6

Headers:
{
    "Authorization":"Bearer {{token}}"
}

Response:
[
    {
        "id": 5,
        "expenseAmount": 100.00,
        "expenseDescription": "Health Product",
        "categoryName": "Health Care",
        "paymentType": "UPI",
        "createdAt": "2022-05-18",
        "updatedAt": "2022-05-18"
    }
]

```
