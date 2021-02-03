# DataSynthesis-Java
Java implemented codebase for implementing DataSynthesis. This codebase enables connectivity and all capabilities within Data Tier. We have also included the data tier within this to ensure updates to data tier are carried through

## Starting DataSynthesis
This is a Quarkus application (https://quarkus.io/) that can easily be run by the following 2 ways

### 1. Containers
We have setup a combination of container images orchestrated using [docker-compose](https://docs.docker.com/compose/install/)

#### Included Services
* **MySQL** - running on port 3306
* **Quarkus** - Http://localhost:8080

#### Getting Started
You can start the application stack by doing:
```
docker-compose up
```
The stack can be stopped by `Ctrl+C` or by
```
docker-compose down
```

### 2. Running Locally
If you already have a valid MySQL database and would like to run this locally you'll need to set the database credentials.  This can be done in 2 ways:
* A. Setting Environment Variables the following environment variables and running `mvn quarkus:dev`
```
DATABASE_HOST
DATABASE_USERNAME
DATABASE_PASSWORD
```
* B. Overriding the quarkus properties on the command line:
```
quarkus.datasource.username
quarkus.datasource.password
quarkus.datasource.jdbc.url
```

For example:
```
mvn -Dquarkus.datasource.username=lskywalker \
    -Dquarkus.datasource.password=jedi \
    -Dquarkus.datasource.jdbc.url=jdbc:mysql://10.210.21.77:3306/datasynthesis \
    quarkus:dev
``` 