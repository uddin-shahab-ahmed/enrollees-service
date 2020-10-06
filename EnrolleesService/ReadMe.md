# Getting Started

# Project Structure

 Root -
        Controller -
			FrontController		-
			DependantController -
		Service -
			EnroleeService
			DependentService
		Service Implemntation
			EnroleeServiceImpl
			DependentServiceImpl
		Repository
			EnrolleesRepository
			DependentsRepository
		Model
			Enrollee
			Dependent
		
#Contents
1. Supports 5 API for enrolle operation
 a. get all enrolees -> http://localhost:port/enrollees/getAll
 b. add an enrolle -> http://localhost:port/enrollees/add
 c. get an enrolle -> http://localhost:port/enrollees/get/{enrolleeId}
 d. modify and anyrollee data -> http://localhost:port/enrollees/modify/{enrolleeId}
 e. delete an enrollee ->  http://localhost:port/enrollees/delete/{enrolleeId}
 
These APIs are present in FrontController class.
 
2. Supports 5 APIs for enrolee dependent 
	a. get all dependents -> http://localhost:port/dependents/getAll
	b. get dependent ->  http://localhost:port/dependents/get/{enrolleeId}
	c. add dependent ->  http://localhost:port/dependents/add/{enrolleeId}
	d. modify the dependent -> http://localhost:port/dependents/modify/{enrolleeId}
	e. delete dependent -> http://localhost:port/dependents/delete/{dependentId}

3. Integrated with log4j2 (spring-boot-starter-log4j2)

4. Configured H2 and mysql database   
   By default H2 in-memory database is enabled in application.properties, There is a mysql section to uncomment and use.
   For mySql database, either install locally or thru Docker `docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest`
   
# How to Run
1. `mvn test` to run the testcases

2. `mvn spring-boot:run` to run the code from CLI
   To do From Eclipse IDE, src/main/java/com/example/demo/EnrolleesServiceApplication.java right-click and run.

