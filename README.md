# API Contatos

### Índice
1. Objetivo
2. Tecnologias
3. Configuração do Wildfly
4. Configuração para rodar no servidor embarcado Tomcat pelo Spring
5. Acesso

### 1. Objetivo
API reponsável por manipular contatos. 

### 2. Tecnologias 
* Spring boot
* Java 8
* Maven
* Lombok
* Wildfly 24
* SQL Server

### 3. Configuração do Wildfly para rodar em um servidor ou local
* Configuração do datasource no arquivo standalone.xml:

```
 <datasource jta="true" jndi-name="java:/comp/env/jdbc/contatosDatasource" pool-name="contatosDatasource" enabled="true" use-ccm="false">
	<connection-url>jdbc:sqlserver://NomeServidorOuIP;DatabaseName=Contatos</connection-url>
	<driver>sqlserver</driver>
	<pool>
		<min-pool-size>10</min-pool-size>
		<max-pool-size>50</max-pool-size>
		<prefill>false</prefill>
		<use-strict-min>false</use-strict-min>
		<flush-strategy>FailingConnectionOnly</flush-strategy>
	</pool>
	<security>
		<user-name>seuLoginBD</user-name>
		<password>suaSenhaBD</password>
	</security>
	<validation>
		<valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mssql.MSSQLValidConnectionChecker"/>
		<check-valid-connection-sql>select 1</check-valid-connection-sql>
		<validate-on-match>true</validate-on-match>
		<background-validation>true</background-validation>
		<background-validation-millis>100</background-validation-millis>
	</validation>
	<timeout>
		<set-tx-query-timeout>true</set-tx-query-timeout>
		<blocking-timeout-millis>5000</blocking-timeout-millis>
		<idle-timeout-minutes>10</idle-timeout-minutes>
	</timeout>
	<statement>
		<prepared-statement-cache-size>0</prepared-statement-cache-size>
		<share-prepared-statements>false</share-prepared-statements>
	</statement>
</datasource>
```

### 4. Configuração para rodar a API no servidor embarcado Tomcat pelo Spring

Adicione as configurações diretamente no arquivo de propriedades que esta localizado "...src/main/resources/application-dev.properties" no projeto.
* Desta forma você esta colocando as infomações do banco diretamente no projeto:

```
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=Contatos;encrypt=true;trustServerCertificate=true;
spring.datasource.username=seulogin
spring.datasource.password=seusenha
```

### 5. Acesso
* Acesso ao link da documentação Swagger depois que a API estiver implantada: `http://SERVIDOR:PORTA/contatos-api/swagger-ui.html#/`
Caso rode a API pela IDE:`http://SERVIDOR:PORTA/swagger-ui.html#/`
* Dentro da pasta do projeto você encontrará uma pasta "...Doc/ImportPostman" que terá uma coleção JSON para importar no Postman.
* Dentro da pasta "...Doc/BackupBD" terá um backup do banco de dados usado.
