# Basic Rest Controller application which returns a message

## Index page will populate index.html under static folder

- GET http://localhost:8081/controller-basic/
- CURL Command: 
  > curl --location --request GET 'http://localhost:8081/controller-basic/'

## Get Message

- GET http://localhost:8081/controller-basic/api/v1/message
- CURL Command: 
  > curl --location --request GET 'http://localhost:8081/controller-basic/api/v1/message'

## Get Greeting Default

- http://localhost:8081/controller-basic/api/v1/greeting
- CURL Command: 
    > curl --location --request GET 'http://localhost:8081/controller-basic/api/v1/greeting'

## Get Greeting pass username

- http://localhost:8081/controller-basic/api/v1/greeting?name=User
- CURL Command: 
  > curl --location --request GET 'http://localhost:8081/controller-basic/greeting?name=user'
