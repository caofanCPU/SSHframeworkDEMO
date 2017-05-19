# [SSHframeworkDEMO](https://github.com/caofanCPU/SSHframeworkDEMO)


## Components
- Development Environment
- Jars List Required
- Operation Mechanism
- Configuration Information By XML
- Source code in java

### Development Environment  
- [Struts 2.5.10.1](http://struts.apache.org/)  
- [Spring 4.2.3](http://repo.spring.io/libs-release-local/org/springframework/spring/4.2.3.RELEASE/)  
- [Hibernate 5.2.2.10](http://hibernate.org/orm/)  
- [Tomcat 9.0](http://tomcat.apache.org/download-70.cgi)  
- [JDK 1.8.0.2](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  
- [Eclipse Neon 4.6.0](https://www.eclipse.org/downloads/eclipse-packages/)  
- [MySQL 5.7](https://www.mysql.com/downloads/)

### Jars List Required
- [Jars list](https://github.com/caofanCPU/SSHframeworkDEMO/blob/master/docs/SSHjarsList.txt)
### Configuration Information By XML
- Web应用配置：[web.xml](https://github.com/caofanCPU/SSHframeworkDEMO/tree/master/WebContent/WEB-INF/web.xml)  
- Struts拦截器动作配置：[struts.xml](https://github.com/caofanCPU/SSHframeworkDEMO/blob/master/src/struts.xml)
- Spring业务管理配置：[applicationContext.xml](https://github.com/caofanCPU/SSHframeworkDEMO/blob/master/src/applicationContext.xml)
- (Optional) Hibernate持久化配置：[Hibernate.cfg.xml](https://github.com/caofanCPU/SSHframeworkDEMO/blob/master/src/Hibernate.cfg.xml)  
- 校验配置：[RegisterAction-validation.xml](https://github.com/caofanCPU/SSHframeworkDEMO/blob/master/src/com/xyb/sshdemo/action/RegisterAction-validation.xml)  
- 实体映射配置：[User.hbm.xml](https://github.com/caofanCPU/SSHframeworkDEMO/blob/master/src/com/xyb/sshdemo/beans/User.hbm.xml)
## Highlights

![SSH framework jars required](http://opqyer7zj.bkt.clouddn.com/17-5-19/74442682-file_1495163405363_178d1.png)
### Operation Mechanism  

![SSH framework operation mechanism](http://opqyer7zj.bkt.clouddn.com/17-5-19/50450107-file_1495164135898_4656.png)  

![SSH framework getting configure information](http://opqyer7zj.bkt.clouddn.com/17-5-19/54262098-file_1495163405095_3453.png)  

![SSH framework DEMO result](http://opqyer7zj.bkt.clouddn.com/17-5-19/93210679-file_1495163404962_1034f.png)  

## Bugs with solutions
- &ensp;&emsp;&ensp;&emsp;If you use JDBC with `c3p0-0.9.5.2.jar` and get a lot of errors, try to rollback to **`c3p0-0.9.1.2.jar`**, besides, you need to add
[`mchange-commons-java-0.2.6.jar`](http://www.java2s.com/Code/Jar/m/Downloadmchangecommonsjava026jar.htm).
 
- &ensp;&emsp;&ensp;&emsp;With an error called:  "*org.hibernate.MappingException: Unknown entity:com.xyb.sshdemo.beans.User*", try to fix codes in keyword  **`ServiceRegistry`**. It's  Hibernate 5.2.10 has conceled `ServiceRegistry` that you can use `SessionFactory` directly which is not allowed under Hibernate 4.3.5.  

- &ensp;&emsp;&ensp;&emsp;With an error called "*Tomcat starts timeout and can't to restart in 45 seconds*"，try to open a file named `servers.xml` which is located in ../eclipse/**your work space name**/.metadata/.plugins/org.eclipse.wst.server.core/servers.xml and  find keyword "start-timeout", and modify it's value with "100" and more.

- &ensp;&emsp;&ensp;&emsp;log4j can't work:  
*"org.springframework.beans.factory.BeanCreationException:  
Error creating bean with name 'dataSource' defined in ServletContext resource [/WEB-INF/classes/applicationContext.xml]:  
Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException:  
Failed to instantiate [com.mchange.v2.c3p0.ComboPooledDataSource]: Constructor threw exception;nested exception is java.lang.NoClassDefFoundError: com/mchange/v2/log/jdk14logging/ForwardingLogger  
Caused by: Cannot locate the chosen ObjectFactory implementation: spring - [unknown location]"*  
&ensp;&emsp;&ensp;&emsp;I haven't solve this problem, in my searching for helps with StackOverflow, many answers point the version compatibility issues with it. If you know how to salve it, welcome to contact me at **xyb5to0ZCY@gmail.com**.
		

