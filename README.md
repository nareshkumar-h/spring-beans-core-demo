# Spring IOC Container 
* The Spring IoC container is at the core of the Spring Framework.

#### Inversion of Control (IoC) principle.
* IoC is also known as dependency injection (DI). 
* The container will create the objects, wire them together, configure them, and manage their complete life cycle from creation till destruction. 
* The Spring container uses dependency injection (DI) to manage the components that make up an application.

* The container then injects those dependencies when it creates the bean. 


* This process is fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes, or a mechanism such as the Service Locator pattern.

#### Bean Declaration (beans.xml)
```
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd">
    
	<bean id="helloBean" class="com.naresh.demo.HelloBean">
		
	</bean>
</beans>
  ```


#### Two types of containers :
* BeanFactory container
* ApplicationContext container

#### BeanFactory
* It maintains a registry of different beans and their dependencies.
* The BeanFactory enables you to read bean definitions and access them using the bean factory.
* Example
```
ClassPathResource resource = new ClassPathResource("beans.xml");
BeanFactory factory = new XmlBeanFactory(resource);
HelloBean obj =  factory.getBean("helloBean", HelloBean.class);
obj.hello();
```
* Note: XmlBeanFactory is Deprecated.

#### ApplicationContext Container
* ApplicationContext container adds more enterprise-specific functionality such as the ability to resolve textual messages from a properties file and the ability to publish application events to interested event listeners.
* The ApplicationContext container includes all functionality of the BeanFactory container, so it is generally recommended over the BeanFactory.

* Example
```
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
HelloBean obj =  ctx.getBean("helloBean", HelloBean.class);
obj.hello();
```

#### Bean Factory vs ApplicationContext Container
* A bean factory is fine to simple applications, but to take advantage of the full power of the Spring framework, you may want to move up to Springs more advanced container, the application context.

#### Instantiate a Container
* Instantiating a Spring IoC container is straightforward. 
```
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
```

#### Stop the Container
```
((ClassPathXmlApplicationContext) ctx).close();
```

#### What is DI ?
* While Dependency injection is a pattern used to create instances of objects that other objects rely on without knowing at compile time which class will be used to provide that functionality

#### Types of Dependency Injection
* Constructor Based Injection
* Setter Based Injection

#### Constructor Based Injection
```
<bean id="accountDAO" class="com.naresh.dao.AccountDAO"
		scope="prototype">
		<constructor-arg index="0" ref="dataSource" />
	</bean>

	<bean name="dataSource"
		class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="driverClassName"
			value="oracle.jdbc.driver.OracleDriver" />
		<property name="url"
			value="jdbc:oracle:thin:@trainingdb.cmqwe8vrjnur.us-east-1.rds.amazonaws.com:1521:orcl" />
		<property name="username" value="naresh" />
		<property name="password" value="password" />

	</bean>
```
```
public class AccountDAO {

	private DataSource dataSource;
	
	public AccountDAO(DataSource dataSource) {
		System.out.println("AccountDAO -> Constructor Based Injection ");
		this.dataSource = dataSource;
	}
}
```

#### Setter Based Injection
```
<bean id="transactionDAO" class="com.naresh.dao.TransactionDAO">
		<property name="name" value="naresh" />
	</bean>
```
```
public class TransactionDAO {

	private String name;
	
	public void setName(String name) {
		System.out.println("TransactionDAO- setter based injection");
		this.name = name;
	}
}
```
