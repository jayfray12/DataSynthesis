# Java-APIs
Java implemented codebase for implementing DataSynthesis.  
This codebase enables connectivity and all capabilities within Data Tier. We have also included the data tier within this to ensure updates to data tier are carried through

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

## Liquibase
[Liquibase](https://www.liquibase.com/) is used to help track, version and deploy database schema changes.  We are utilizing the [liquibase maven plugin](https://docs.liquibase.com/tools-integrations/maven/home.html) to simplify the use of liquibase.

**NOTE:  Do NOT edit any database tables directly or any changesets already defined.  The app will fail to start if any changes are made outside of liquibase or any changes are made to an already deployed changset.**

### Diff
You can diff 2 databases and have liquibase generate a file with the differences.  Follow these basic steps to perform a diff.
1.  Deploy current code into a database
      -  This can be done by using docker-compose
2.  Deploy current code into another database
3.  Make changes to second database (i.e. add columns, indexes, etc.)
4.  Run diff (see example below) command against both databases
5.  Copy everything after the first line `databaseChangeLog:` in the specified `diffChangeLogFile` and paste it into the `changeLog-master.yaml` file.
6.  Make necessary changes to hibernate classes
7.  Re-run docker-compose to install new changes
      - Login to database and very changes are there
8.  Run the tests to ensure everything is valid

A sample diff command:
```
mvn liquibase:diff \
-Dliquibase.referenceUrl="jdbc:mysql:<IP OR HOSTNAME>:<PORT>/<databasename>" \
-Dliquibase.referenceUsername=<USERNAME> \
-Dliquibase.referencePassword=<PASSWORD> \
-Dliquibase.referenceDriver=com.mysql.cj.jdbc.Driver \
-Dliquibase.diffChangeLogFile=src/main/resources/liquibase-diffChangeLog.yaml
```
The differences will be placed in the `src/main/resources/liquibase-diffChangeLog.yaml` file.
NOTE:  by default the original/old database will utilized the properties in the [pom.xml](pom.xml) file (properties: driver, url, username, password).  To override this add those parameters on the command line above and don't forget to prefix them with `-Dliquibase.`

#### Useful Diff links
- [Maven Liquibase Plugin diff](https://docs.liquibase.com/tools-integrations/maven/commands/maven-diff.html)