# Para probar


### Ejecutar
~~~
$ ./gradlew assemble
$ java -jar build/libs/microuservice-0.0.1-SNAPSHOT.jar
~~~
o simplemente
~~~
$ ./gradlew bootRun
~~~
### Curl's
`POST`
~~~
curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Lo que sea",
    "mail": "louesa@mail.com",
    "password": "1234aaBA",
    "phones": [
        {
            "number": "1111",
            "cityCode": "11",
            "countryCode": "11"
        }
    ]
}'
~~~
`PUT`
~~~
curl --location --request PUT 'http://localhost:8080/users/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Lo que sea",
    "mail": "louesa@maail.com",
    "password": "1234aA",
    "phones": [
        {
            "number": "1111",
            "cityCode": "11",
            "countryCode": "11"
        },
        {
            "number": "1111",
            "cityCode": "11",
            "countryCode": "11"
        }
    ]
}'
~~~
`GET`
~~~
curl --location 'http://localhost:8080/users/1'
~~~
`GET`
~~~
curl --location 'http://localhost:8080/users'
~~~
### Postman Collection
~~~
[MicroUSERvice.postman_collection](https://github.com/csrtld/microuservice/blob/master/MicroUSERvice.postman_collection.json)
~~~
### Swagger JSON
~~~
http://localhost:8080/v3/api-docs
~~~
### Swagger UI
~~~
http://localhost:8080/swagger-ui/index.html
~~~
### Data Base
~~~
http://localhost:8080/h2-console
---
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: <empty>
~~~
