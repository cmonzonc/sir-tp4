# Backend TP4 (Include TP2)

Les objectifs de ce travail pratique sont les suivants :
- Comprendre les mécanismes des Servlet
- Réaliser une application  Web en utilisant Combinant JPA et les Servlet
- Comprendre les principes d’une architecture Rest
- Comprendre les bénéfices d’un framework comme Jersey

## Getting Started

#### Design
Please refer to the [design](docs/design.md) for more information.

### Prerequisites

```
- Java
- Git Flow
- Maven 
- Hibernate
- Apache Tomcat 7
- Jersey
- CURL/Postman
- Swagger

```

### Installation

1. Configuration server 

Le fichier a modifier (persistence.xml) se trouve sur le dossier "src/main/resources/META-INF". La section à modifier (persistence-unit) s'appelle "mysql"

            <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
            <property name="hibernate.connection.password" value="[YOUR_DATABASE_PASSWORD]"/>
            <property name="hibernate.connection.url" value="jdbc:mysql://localhost/[YOUR_LOCAL_DATABASE]"/>
            <property name="hibernate.connection.username" value="[YOUR_DATABASE_PASSWORD]"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>

2. Démarrez votre serveur de base de données et créez une base de données vide en utilisant le même nom configuré à l'étape précédente.

3. Lancer l'application "tp2-4 (5)" [Maven], cette execution sera lancée en utilisant le goal 

```
GOAL : tomcat7:run
```

Un serveur de servlet et un serveur Web REST (JAX RS) seront lancés:
- Les services Servlet s'exécutent dans le répertoire racine: "http://localhost:8080/"
- Les services REST sont exécutés dans le répertoire: "http://localhost/rest/"


### Servlet (Services disponibles)

| Address | Description | Method |
| :---         |     :---:      |          ---: |
| git status   | git status     | git status    |
| git diff     | git diff       | git diff      |

### WS REST (Requetes disponibles)

| Address | Method | Functionality | CURL Command  |
| :---  |  :---:  |          ---: |          ---: |
| /home | GET | Return the list of all registered homes  | "curl --request GET  --url http://localhost:8080/rest/home" |
| /person | GET   | Return the list of all registered persons | "curl --request GET --url http://localhost:8080/rest/person" | 
| /person/{identifier} | GET   | Return a person asociated with the provided identifier | "curl --request GET --url http://localhost:8080/rest/home/id/{identifier}" | 
| /device | POST   | Register a device in the service | "curl --request POST --url http://localhost:8080/rest/device --header 'content-type: application/x-www-form-urlencoded' --data 'name=test&power=300&type=electronic&unit=watt&location=living" | 
| /person | POST   | Register a new person in the system | "curl --request POST --url http://localhost:8080/rest/person --header 'content-type: application/x-www-form-urlencoded' --data 'email=christian%40asd.com&lastname=Julien&firstname=dor%C3%A9'" | 
| /home | POST  | Register a new home in the service | "curl --request POST --url http://localhost:8080/rest/home --header 'content-type: application/x-www-form-urlencoded' --data 'size=124&rooms=3&name=%22Christian'\''s%20home%22'" | 

## Author

* **MONZON, Christian** - *work* - [cmonzonc](https://github.com/cmonzonc)


## License

This project is licensed under the GNU License.
