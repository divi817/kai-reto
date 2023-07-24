# Reto técnico Prices
Welcome! REST API developed in Java with Spring Boot, using maven as dependency manager. We coded focusing on DDD, Hexagonal Architecture, and 
more good practices. Our application uses a h2 in-memory database that gets data ingested on runtime.

## Build & run

Thanks to the Spring Boot Maven Plugin, we can easily run our Spring Boot application
without needing to create an executable JAR or WAR file. 
First of all, make sure you have Maven installed on your system. Otherwise, install it, then open a terminal in the root
directory of your Spring Boot project (where your `pom.xml` is) and run the following Maven command:

`mvn spring-boot:run`

This command will build your project and start the application. Now, you should be able to access your Spring Boot application 
at its default port (usually 8080) by opening a web browser and navigating to http://localhost:8080. 

You can test our endpoints via swagger at http://localhost:8080/swagger-ui/ or using curl, here's an example about our 
endpoint in PricesController:

`curl -X GET "http://localhost:8080/prices?brand_id=1&date=2020-12-12T18%3A40&product_id=35455" -H "accept: */*"`

It should respond:

`
{
"product_id": 35455,
"brand_id": 1,
"price_list": 4,
"start_date": "2020-06-15-16:00:00",
"end_date": "2020-12-31-23:59:59",
"price": 38.95
}
`

And last, but not least, for running all the tests in our project, you should use the following command:

`mvn test`