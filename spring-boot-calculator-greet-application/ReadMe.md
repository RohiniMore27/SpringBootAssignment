# Read me file for the Calculator and Greet Application projecy. Details of how to compile, build and deploy are below

## How to build?
Go to the path where pom.xml is located  and open command line. Use the following command to build the project.

command - **mvn clean install**
			
## How to run from command line?
 After building the project use the following command to run the spring boot app with java -jar command

command - ** java -jar target\projectname.jar **  

example: ** java -jar target\spring-boot-calculatoor-greet-application-0.0.2-SNAPSHOT.jar ** 


## How to start the service from inside IDE?
Select base class "CalculatorAndGreetUserApplication" and run as java application.

## Sample Request and Response

Request: http://localhost:9356/greetapi/v1/hello
Response: { Hello World!! }

Request: http://localhost:9356/greetapi/v1/hello?name=Rohini
Response: { Hello Rohini!! }

Request: http://localhost:9356/calculatorapi/v1/addition?number1=2.0&number2=5.0
Response: { "answer": 2.0, "detail": "2.0 + 5.0 = 7.0" } 

Request: http://localhost:9356/calculatorapi/v1/subtraction?number1=2.0&number2=5.0
Response: { "answer": -3.0, "detail": "2.0 - 5.0= -3.0" } 

Request: http://localhost:9356/calculatorapi/v1/multiplication?number1=2.0&number2=5.0 
Response: { "answer": 10.0, "detail": "2.0 * 5.0 = 10.0" } 

Request: http://localhost:9356/calculatorapi/v1/division?number1=2.0&number2=5.0 
Response: { "answer": 0.4, "detail": "2.0 - 5.0 = 0.4" } 

Request: http://localhost:9356/calculatorapi/v1/square/{5} 
Response: { "answer": 25, "detail": "square of 5 = 25" } 

Request: http://localhost:9356/calculatorapi/v1/squareroot/{225} 
Response: { "answer": 15, "detail": "squareroot of 225 = 15" } 

Request: http://localhost:9356/calculatorapi/v1/factorial/{5} 
Response: { "answer": 120, "detail": "5! = 120" } 

Request: http://localhost:9356/calculatorapi/v1/min-max 
Body { "numbers" : [10,-5,7,15,-7,-6,16,19,-15,9,77,-28,27] } 
Response: { "min": -28, "max": 77 }



