# JAX-RS and JAX-WS REST and SOAP Web Service on Sakila DB

>Sakila RESTful and SOAP web service built using JAX-RS and JAX-WS.

# 📃 Documentation
* 🧼[Postman SOAP API Docs](https://documenter.getpostman.com/view/26735313/2s93Y3ugGu)


* 📧[Postman RESTful API Docs](https://documenter.getpostman.com/view/26735313/2s93Y3v154)

# 📌 Sample REST Endpoints
| Endpoints                               | Method |                                      Notes |
|-----------------------------------------|:-------|-------------------------------------------:|
| /actors/                                | GET    |                             Get all Actors |
| /actors/                                | POST   |                              Create  Actor |
| /actors/{id}                            | GET    |                         Get a single Actor |
| /actors/{id}                            | PUT    |                             Edit the Actor |



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
* Database name [Sakila] [download](https://downloads.mysql.com/docs/sakila-db.zip)
