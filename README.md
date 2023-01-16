This is a demo spring boot application to manage person details

This application uses postgres database. Before running this application, configure the database credentials inside application.properties file.
Set the datasource url, username and password inside the application.properties as shown below.

`spring.datasource.url=jdbc:postgresql://localhost:5432/demo    
spring.datasource.username=postgres  
spring.datasource.password=password`

After doing following changes, you can build project using **mvn package clean** command. When executed successfully, a jar file named using the parent directory name of project is generated inside targets folder.

Then you can run the jar file using **java -jar filename.jar" command. Just replace filename with the name of generated jar file.
