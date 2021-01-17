### themoviedb api

**How to run the application:**

1. import the *movie.sql* file to mysql.
2. run the code:
```
gradle build
gradle bootRun
```

3. configure the ports as needed. The default port for mysql is 2222 while the default port for the server is 9991.
*application.properties:*
```
spring.datasource.url= jdbc:mysql://localhost:2222/moviesdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&rewriteBatchedStatements=true
spring.datasource.username= root
spring.datasource.password= root

spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect

Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

server.port = 9991
```
4. Swagger
	>localhost:9991/swagger-ui.html




