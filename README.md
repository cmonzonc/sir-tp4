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

### WS REST (Requetes disponibles)


## Author

* **MONZON, Christian** - *work* - [cmonzonc](https://github.com/cmonzonc)

See also the list of [contributors](https://github.com/diarranabe/backend-java-tp2_4/contributors) who participated in this project.

## License

This project is licensed under the GNU License.
