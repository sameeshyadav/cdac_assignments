1.Create java se project
2. Add external Jars.--spring & hibenrate jars --in user lib
3. Create spring-config.xml --- in <resources> --add namespaces --beans & context
Add tags -- context:annotation-config,context:component-scan.

4. Create separate hibernate configuration file(under <resources>) & import it in main config file -- add bean,context,p,tx namespaces to hibernate cfg xml file

8. Configuration steps for persistence.

8.1 create database properties file & store it under run-time class path(either directly under src or under source folder<resources>) --consists of ---driver class name,db url, user name & password & dialect.

8.2 Supply  location of db properties file using 
<context:property-placeholder location="classpath:/db.properties" />

8.3 Create data source bean(conn pool) --- using apache supplied cn pool based datasource.

<bean id="dataSource" 
	class="org.apache.commons.dbcp2.BasicDataSource"
		p:driverClassName="${jdbc.driver}" p:url="${jdbc.url}" 
		p:username="${jdbc.username}"
		p:password="${jdbc.password}" 
		p:initialSize="1" p:maxTotal="2"
		destroy-method="close">
	</bean>
	
8.4 Create Hibernate session factory bean
<bean id="sessionFactory"
		class="org.springframework.orm.hibernate5.LocalSessionFactoryBean"
		p:packagesToScan="com.app.pojos" p:dataSource-ref="dataSource">
		<property name="hibernateProperties">
			<value>
				hibernate.dialect=${jdbc.dialect}
				hibernate.format_sql=true
				hibernate.show_sql=true
				hibernate.hbm2ddl.auto=update
			</value>
		</property>
	</bean>
	

8.5 Declare transaction mgr bean by injecting session factory bean ref into it.
<bean id="transactionManager"
		class="org.springframework.orm.hibernate5.HibernateTransactionManager"
		p:sessionFactory-ref="sessionFactory">
	</bean>
	
8.6
To enable annotated transaction supprt(spring container managed txs)
<tx:annotation-driven/>
This finishes config steps.

9. Identify persistence requirements -- create annotated pojos or use rev eng to generate it.(class level annotation --- @Entity & @Id --mandatory)


10. Create DAO layer i/f & add implementation class -- annotate DAO layer with @Repository annotation.

Inject (using @AutoWired or @Resource) , hib's session factory into DAO impl bean.

Simply use ready made session factory instance to --- get current session --- use Session api for CRUD(eg --- createQuery,save,update,delete )

11. Create Service layer (optional but recommended --- since u can keep tx management dtls separate from DAO layer)
Create service i/f & its implementation class. -- annotated with @Service class level annotation. 
This layer simply invokes DAO layer methods , by autowiring DAO instance.
Additional method level annotation or  class level annotation
org.springframework.transaction.annotation.Transactional
@ can supply --- readonly sts,tx propagation,isolation,timeout,rollback rules etc.

12. Create a Tester --- 
12.1 Create ApplicationContext -- ClasspathXmlApplicationContext ---spring-config file
12.2 Get service bean & call B.L method 
12.3 Close Ctx to release resources.
-------------------------------


















