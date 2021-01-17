### themoviedb api

**How to run the application:**

1. import the *movie.sql* file to mysql.
2. run the code:
	> gradle build
	> gradle bootRun

3. configure the ports as needed: 
	*mysql default port: 2222
	*server port: 9991

application.properties:
>spring.datasource.url= jdbc:mysql://localhost:2222/moviesdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&rewriteBatchedStatements=true
>spring.datasource.username= root
>spring.datasource.password= root
>
>spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
>
>spring.jpa.hibernate.ddl-auto= update
>
>server.port = 9991

4. Swagger
	>localhost:9991/swagger-ui.html




