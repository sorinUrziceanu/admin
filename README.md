## Used technologies ##

- Java EE 7 [``jdk1.8.0_111``](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- Apache Maven [``apache-maven-3.3.9``](https://maven.apache.org/download.cgi/)
- Application server  [``WildFly-10.1.0.Final``](http://wildfly.org/staging/downloads/)
- Database [``PostgreSQL 9.6.2``](https://www.postgresql.org/)
- Schema migration tool [``FlyWay ``](https://flywaydb.org/)
- IDE [``IntelliJ IDEA``](www.jetbrains.com/)


## Environment configuration ##

- Create database: ``admin -- user: admin -- pass: admin1`` 
- Add postgreSQL JDBC driver in WildFly: create structure ``\wildfly-10.1.0.Final\modules\system\layers\base\org\postgres\main`` and copy there the file [``postgresql``](https://jdbc.postgresql.org/) and create the file ``module.xml`` with the following content (by changing the jar name):

```xml
<module xmlns="urn:jboss:module:1.0" name="org.postgres">
	<resources>
		<resource-root path="postgresql-9.4-1201.jdbc4.jar"/>
    </resources>
    <dependencies>
		<module name="javax.api"/>
		<module name="javax.transaction.api"/>
	</dependencies>
</module>
```

- Add datasource to standalone.xml:

```xml
.............

<datasource jndi-name="java:jboss/datasources/Administration" pool-name="Administration" enabled="true" use-java-context="true">
                    <connection-url>jdbc:postgresql://localhost:5432/admin</connection-url>
                    <driver>postgresql</driver>
                    <pool>
                        <min-pool-size>10</min-pool-size>
                        <max-pool-size>20</max-pool-size>
                    </pool>
                    <security>
                        <user-name>admin</user-name>
                        <password>admin1</password>
                    </security>
                    <validation>
                        <check-valid-connection-sql>SELECT 1</check-valid-connection-sql>
                        <validate-on-match>false</validate-on-match>
                        <background-validation>false</background-validation>
                    </validation>
                    <statement>
                        <prepared-statement-cache-size>50</prepared-statement-cache-size>
                    </statement>
                </datasource>

.............

<driver name="postgres" module="org.postgres">
	<xa-datasource-class>org.postgresql.xa.JdbcDataSource</xa-datasource-class>
</driver>

.............
```

## Run the application ##

- From $PROJECT_HOME\database\flyway-4.1.0 run ``fylway migrate``
- From $PROJECT_HOME run ``mvn clean install`` and deploy the ``admin.ear`` from the ``ear`` module
- From Browser ``localhost:8080/jsf/index.xhtml`` 

