## Dependencies Used
- Spring boot version: 3.1.10
- java version : 17
- spring-boot-starter-data-jpa
- embedded database: h2
- spring-boot-starter-web


## Controller

- Index page
  > http://localhost:8080/
### Room Controller
- Room Reservation Controller to 
- GET reservation for certain date where date is optional request param
> http://localhost:8080/reservations

> GET http://localhost:8080/reservations/v1

> GET http://localhost:8080/reservations?date="2024-04-07'

### Guest Controller
> GET http://localhost:8080/guests



## Rest Controller
### reservations
> GET http://localhost:8080/api/reservations
> GET http://localhost:8080/api/reservations?date=2022-01-01
### guests
> GET http://localhost:8080/api/guests
#### Add Guest
>  curl --location --request POST 'http://localhost:8080/api/guests' \
--header 'Content-Type: application/json' \
--data-raw '{
"firstName": "Ray",
"lastName": "Ryan",
"emailAddress": "rryan@xinhuanet.com",
"address": "2872 Marquette Street",
"country": "United States",
"state": "NY",
"phoneNumber": "1-(235)314-9800"
}'
### rooms
> GET  http://localhost:8080/api/rooms
