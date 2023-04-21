# 📃 Documentation
🧼[Postman SOAP API Docs](https://solar-moon-337367.postman.co/documentation/26735313-b649cbd2-73d2-4e0e-9b1c-65bc5ae50377/publish?workspaceId=730782f6-89af-45c9-8f0e-a2de3e3cf8dd)


📧[Postman RESTful API Docs](https://solar-moon-337367.postman.co/documentation/26735313-baf849a5-8acc-4ee3-a67f-b780ed3f4e6e/publish?workspaceId=730782f6-89af-45c9-8f0e-a2de3e3cf8dd)


# ⚙ Technologies used
* JAX-RS (Jersey)
* JAX-WS (Metro)
* JSON-B
* JAX-B
* Maven
* Tomcat
* Intellij IDEA Ultimate
* Postman
* SOAP-UI

# 🛠 Run with Maven
**Maven**

* Change the configuration of Tomcat in `pom.xml`. 
* Deploy the application using the following maven command:
```
mvn clean compile tomcat7:redeploy
```
* REST: change the `{{host}}` variable in the Postman collection environment variables to match the port you chose for your Tomcat deployment
* SOAP: import the project into SOAP UI

**MySQL**
* Create a database schema and provide the username and password in the persistence.xml
* Hibernate will not automatically create the tables for you 
* Database name [Sakila] 
