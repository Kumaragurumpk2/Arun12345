Instructions:
·    It is a controlled book test. Please follow the guidelines provided by Invigilator.
·    Launch STS and import the provided projects in the examId folder with name InfyTravel_ToTrainee
Note: Make sure there are no spaces in directory (workspace or project names)
·    You must implement the requirements in this project.
·    Right click on project → Maven → Update Project… → Check the box “Force Update of Snapshots/Releases” and Click Ok.
·    The code will be evaluated only after submitting it to the submission folder (server).
·    If the timestamp of the file is greater than the submission time, then the test will not be evaluated. 
·    You are not supposed to use any network resources.
·    Any method signature should not be modified or commented, or new method should not be added in the provided project.
·    Follow the given class diagrams.
·    Non-Adherence to guidelines may lead to ZERO mark.
·    Modify database credentials and connection url in application.yml file if required.
·    Execute the provided table script in src/main/resources folder.
·    You need to submit the entire project. Please make sure that all the changes made in the project are saved properly. Save all files in STS and save in Hands-on client.
Cross-check updated files in the examId folder. This folder will only be used for submission by the hands-on client.
(Note: Improper submission or submitting the code with structural or compilation error(s) may lead to zero marks being awarded)
Problem Statement:
In this assessment, you would be building the microservice application EmployeeMS and VehicleMS where CRUD operations for InfyTravel can be done. The requirement is to use the concepts of Spring Boot and Spring Microservices to implement the following functionalities:
1.    Retrieve the employee details based on the email Id.
2.    Fetch all the vehicle details based on vehicle type.

Project Structure provided:

VehicleMS
 

GatewayMS
 


EmployeeMS

After running the application, find the sample inputs in EmployeeMS and Vehicle MS (src/main/resources/MSInputData.txt)

Note: Add an appropriate annotation in the DTO and Entity classes of each Services to generate getters and setters.

Artifacts Description:
VehicleMS:
1.    Entity class (partially implemented)
     
·    com.infy.vehicle.entity.Vehicle.java
                          
o    This class is partially implemented. 
o    Annotate this class with proper annotation to declare it as an entity class with vehicleId as the primary key.
o    Map this entity class and its attributes to the vehicle table using proper annotations.
o    Generate the values for vehicleId using the IDENTITY strategy.

2.    Repository
·    com.infy.vehicle.repository.VehicleRepository.java
o    This interface should extend the appropriate repository interface.
o    Define a repository method to retrieve all vehicles of a given vehicleType, and return the result as a List<Vehicle>.
o    Implement the method using a native query in Query annotation with a stored procedure defined as part of the vehicle_db schema, GetAllVehiclesByType in Vehicle_TableScript.sql inside src/main/resources.

3.    Service Class(Partially implemented)
·    com.infy.vehicle.service.VehicleServiceImpl.java
Implement this class according to the class diagram and the description given below:
                                   
o    Annotate it with the appropriate stereotype annotation with the value vehicleService.
o    Annotate it with necessary annotation to manage transactions with appropriate import.
o    Inject the VehicleRepository and ModelMapper object using the proper annotation.
           Method Description:
·    public VehicleDTO getVehicle (Integer vehicleId):
o    This method is already implemented. Uncomment the logic after required implementation.

·    public List<VehicleDTO> getAllVehicle(String vehicleType):
o    This method is used to retrieve all vehicle details based on the given vehicleType. 
o    Invoke the appropriate method of the vehicleRepository by passing vehicleType, which returns a List<Vehicle> object. 
o    If no vehicle details are found (i.e., the returned list is empty), throw a VehicleException with the message Service.VEHICLETYPE_NOT_FOUND. 
o    Otherwise, sort the list of Vehicle objects in ascending order of vacancies. 
o    Convert each Vehicle object into a VehicleDTO object using ModelMapper. 
o    While populating the VehicleDTO, ensure that the vehicleType is converted to uppercase. 
o    Finally, return the list of populated VehicleDTO objects.

4.    API Class(Partially implemented)
·    com.infy.vehicle.api.VehicleAPI.java
Implement this class according to the class diagram and description given below:

                   

o    Annotate this class with appropriate annotation to declare it as a REST controller class.
o    Annotate this class with the base URL “/vehicles”.
o    Inject VehicleService objects with appropriate annotations.
o    The below method’s functionality has been already implemented. Add the appropriate annotations.

·    public ResponseEntity<VehicleDTO > getVehicle (Integer vehicleId)
o    This method is used to get the vehicle based on vehicleId.
o    It accepts a GET request with the URI /vehicle and the vehicleId is passed as a request parameter.
·    public ResponseEntity<List<VehicleDTO >> getAllVehicle (String vehicleType)
o    This method is used to get the list of vehicles of given vehicleType.
o    It accepts a GET request with the URI  /{vehicleType}, where vehicleType is passed as a path variable.
5.    Test Class
com.infy.vehicle.VehicleAPITest.java
o    Implement this class to test the methods of VehicleAPI class using JUnit 5, Mockito and mockMVC as per the class diagram given below: 
                                                
o    Annotate this test class to execute Spring Boot-API test targeting VehicleAPI class and use appropriate annotations for mocking using Mockito. 
o    Inject the MockMvc object  and mock the VehicleService using the appropriate annotations 
o    Annotate the methods with appropriate annotation to mark them as JUnit 5 test cases.
Method Description: 
public void testGetVehicleMethod()
o    This test case verifies that the getVehicle controller method correctly returns the vehicle details for a given vehicleId. 
o    Configure Mockito to return a VehicleDTO object when the getVehicle(101) method of the VehicleService is invoked. 
o    Perform a GET request to the URI /vehicles/vehicle with the vehicleId passed as a request parameter. 
o    Use appropriate assertions to verify that: 
o    The HTTP response status is OK (200). The response body contains the expected vehicle details such as: 
§    vehicleId with value 101
§    vehicleType with value "TwoWheeler"
§    vacancies with value 20

EmployeeMS:
6.    Application class (Partially implemented)
This is the Spring Boot starter class of the application. 
This class is partially implemented, and the implementation should be completed appropriately based on the class diagram and description given below.
                                 

·    This is the Spring Boot starter class of the application.
·    Instantiate the load balanced WebClient.Builder, and ModelMapper bean.

Note: Add an appropriate annotation in the DTO and Entity classes of each Services to generate getters and setters.

7.    Entity class (partially implemented)

·    com.infy.employee.entity.Employee.java

o    This class is partially implemented. 
o    Annotate this class with proper annotation to declare it as an entity class with employeeId as the primary key.
o    Map this entity class and its attributes to the Employee table using proper annotations.
o    Generate the values for employeeId using the IDENTITY strategy.

8.    DTO class 
com.infy.employee.dto.EmployeeDTO.java (Partially Implemented)

o    This is a DTO (Data Transfer Object) class that holds Employee details.
o    Use appropriate annotations from the Java Bean Validation API to validate the attributes according to the description given below.
(Note: The validation message should not be hard-coded. It should be read from the ValidationMessages.properties file)
§    employeeName:
If employeeName is not provided then set “Please enter employee’s name“ as the validation message.
The name can comprise of multiple words with each word beginning with a capital letter followed by lower characters. If invalid, set “Invalid employee name” as the validation message.

§    emailId:
If emailId is not provided then set “Please enter employee email Id” as the validation message.
if it is provided, it can contain one or more alphabets or numbers or . (dot) character followed by the string ‘@abc.com’. If invalid, set “Invalid employee email Id” as the validation message.

§    designation:
If designation is not provided then set “Please enter employee designation” as the validation message.
If it is provided, it should be only with these designations SeniorEngineer or Analyst or Associate. If invalid, set “Invalid employee designation” as the validation message.

§    dateOfBirth:
If dateOfBirth is not provided then set “Please enter employee dateOfBirth” as the validation message. 
If it is provided it should be a past date else set the message as “Invalid employee dateOfBirth”.
§    JobLevel:
If jobLevel is not provided then set “Please enter employee Job Level” as the validation message


9.    Repository 
·    com.infy.employee.repository.EmployeeRepository.java (partially implemented)
o    This interface should extend the appropriate repository interface.
o    Define a  method using method name approach (to be implemented).
§    The method should accept emailId attribute of an Employee class as parameter and return the employee object as Optional<Employee>.


10.    Service Class(partially implemented)
·    com.infy.employee.service.EmployeeServiceImpl.java
Implement this class according to the class diagram and the description given below:
                           
o    Annotate it with the appropriate stereotype annotation with the value employeeService.
o    Annotate it with necessary annotation to manage transactions.
o    Inject the EmployeeRepository, ModelMapper object using the proper annotation.
Method Description:
·    public EmployeeDTO getEmployee(String emailId)
o    This method is used to retrieve employee details for vehicle registration.
o    Invoke the appropriate function of the EmployeeRepository interface by passing the emailId. 
o    If employee details are not available, the method throws an EmployeeException with the message Service.EMPLOYEE_NOT_FOUND. 
o    If employee details are found: 
§    The Employee entity is converted into an EmployeeDTO using ModelMapper.
§    The employee’s vehicleId is used to populate a VehicleDTO.
§    The VehicleDTO is set inside the EmployeeDTO.
§    Return the above populated EmployeeDTO object.

·    public List<EmployeeDTO> getEmployeesWithVehicles()
o    This method is already implemented. Uncomment the logic after required implementation.
·    public Integer addEmployee(EmployeeDTO employeeDTO)
o    This method is already implemented. Uncomment the logic after required implementation.
11.    API Class 
·    com.infy.employee.api.EmployeeAPI.java
Implement this class according to the class diagram and description given below:


o    Annotate this class with appropriate annotation to declare it as a REST controller class.
o    Annotate this class with appropriate annotation so that all its methods are mapped with the base URL “/employees”.
o    Inject EmployeeService, Web client Builder and Environment objects with appropriate annotations.

Method Description:
·    public ResponseEntity<EmployeeDTO> getEmployee (String emailId)
o    This method is used to get the employee details based on the given emailId.
o    It accepts GET request with URI as ‘/employee/{emailld}’, emailId received as the URI parameter in the method.
o    Invoke the service class method getEmployee().
o    Invoke the appropriate Webclient Builder class method by passing vehicleId as an argument. (Note : Fetch the port number by performing Service Discovery for VehicleMS. Retrieve the vehicleId from EmployeeDTO object) 
o    Set the VehicleDTO retrieved in the previous step to EmployeeDTO. 
o    Return an object of ResponseEntity with the EmployeeDTO object as a response with the HTTP response status as OK.
o    Write a fallback method with method name getEmployeeFallBack if the above web client call fails. 
o    Inside the fallback method set the parameters of EmployeeDTO as below:
"employeeId": 0, 
"employeeName": "Fallback method",
o    Return an object of ResponseEntity with the EmployeeDTO object created above as a response and the HTTP response status as OK.
NOTE: To check your fallback method implementation, send the request by sending a request to the URL who has a vehicleId : 999.
Insert the below entry in Employee database and then try the below URL
INSERT INTO employee(employee_id, name, email_id, designation, date_of_birth,Job_level, vehicle_id) VALUES (1004, 'Sarah', 'sarah@abc.com', 'SeniorEngineer', '1990-05-15', 4, 999);
<http://localhost:8000/employees/employee/sarah@abc.com>
·    public ResponseEntity<List<EmployeeDTO>> getEmployeesWithVehicleDetails()
o    This method is used to fetch employee details along with their associated vehicle information
o    It accepts a GET REST endpoint mapped to /with-vehicles. 
o    The method invokes the getEmployeesWithVehicles() method of the EmployeeService to retrieve a list of EmployeeDTO objects. 
o    For each employee: 
§    It checks whether the employee has an associated vehicleId.
§    If a vehicleId is present, a WebClient Builder call is made to the VehicleMS microservice to fetch complete vehicle details. (Note : Fetch the port number by performing Service Discovery for VehicleMS. Retrieve the vehicleId from each EmployeeDTO object)
o    The retrieved VehicleDTO is then set into the corresponding EmployeeDTO.
o    After setting the employee object with vehicle details, the method filters the employees based on the following conditions: 
§    Vehicle type must be TwoWheeler
§    Vehicle vacancies must be greater than or equal to 20
o    The filtered list is returned as a ResponseEntity with HTTP status OK (200).

·    public ResponseEntity addEmployee(EmployeeDTO employeeDTO) 
o    Add the appropriate annotation to 
§    Map the method to manage HTTP POST requests for the URI /employee 
§    Add the appropriate annotation to cascade the bean validation.
§    Add the appropriate annotation to convert the JSON Object to Java Object
o    The logic of the method is already implemented.

12.    Utility Classes
·    com.infy.employee.utility.LoggingAspect.java

Implement the following LoggingAspect class to log all the exceptions from service class using Spring AOP.
                                 
o    Annotate this class with proper annotation to declare it as Spring Component and Aspect class.
Method Description: 
·    public void logExceptionFromService(EmployeeException exception)

Note: The body of the method has been implemented for you. You need to add only annotations.

o    Annotate this method with proper annotation to declare it as an after throwing advice with pointcut expression.
o    Log all the exception message along with the exception thrown from methods of com.infy.employee.service.EmployeeServiceImpl class at error level.

·    com.infy.employee.utility.ExceptionControllerAdvice.java

Note: The body of the methods have been implemented for you. You need to add only annotations.

o    Annotate this class with proper annotation to declare it as an exception controller advice class.
o    Inject Environment object using appropriate annotation.
                         
Method Description:
·    public ResponseEntity<ErrorInfo> employeeExceptionHandler(EmployeeException exception)
o    This method is for handling EmployeeException exception.
o    Add appropriate annotation to make this method an exception handler for the EmployeeException.

·    public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception)
o    This method is for handling general exceptions.
o    Add appropriate annotation to make this method an exception handler for any type of exceptions.

·    public ResponseEntity<ErrorInfo> validatorExceptionHandler (Exception exception)
o    This method is for handling MethodArgumentNotValidException and ConstraintViolationException exceptions.
o    Add appropriate annotation to make this method an exception handler method for MethodArgumentNotValidException and ConstraintViolationException exceptions.
Spring Microservices implementation:
1.    For Consul:
§    consul is available in the following path: c -> java artifacts -> consul
§    From the above given path, open a command prompt and paste the link given below: 
consul agent -server -bootstrap-expect=1 -data-dir=consulFolder -ui -bind=127.0.0.1
§    Once the consul agent runs, verify the same by sending the below request from your browser
                                  <http://localhost:8500>
§    Upon sending the above request a new browser tab will be opened.

2.    For api-gateway - Spring Boot Project:
·    Configure api-gateway to run on port no 8000.
·    Kindly provide all Spring properties as mentioned below:

§    This project must be registered with consul server using the application name as "GatewayMS". 
§    Provide cloud consul as localhost.
§    Enable the Gateway Service Discovery
§    Add the route predicate as "/employees/employee/** " and route it to the id as EmployeeMS. 
§    Add route predicate as “/vehicles/vehicle/** ” and route it to the id as VehicleMS.
§    Add loadbalancing to EmployeeMS through gateway.
§    Add loadbalancing to VehicleMS through gateway.

·    Verify the requests to EmployeeMS is routed properly by sending the sample request as: <http://localhost:8000/employees/employee/jack@abc.com>
NOTE: Do above implementation in application.yml file inside Gateway project. 
3.    For EmployeeMS - Spring Boot Project:
·    Configure EmployeeMS project to run on port no 4001.
·    Kindly provide all Spring properties as mentioned below:
§    This project must be registered with consul server using the name as "EmployeeMS".
§    Provide cloud consul and Service discovery as localhost.
§    Create resilience circuit breaker pattern instance with a name “employeeService”
§    The threshold for failure rate should be set as 50, size and type of sliding window as 10 and  count-based respectively, minimum calls should be set to 5, while the allowed count of calls in the half open state to be set to 3. When the circuit is open the wait duration should be initialized to 30s and automatic transition from open to half open should be enabled. 
Assuming EmployeeMS registered in consul, verify the EmployeeMS Microservice is working by sending the request as: http://localhost:4001/employees/employee/jack@abc.com <mailto:jack@abc.com>
NOTE: Do above implementation in application.yml file inside EmployeeMS project. 
4.    For VehicleMS - Spring Boot Project:
·    Configure VehicleMS project to run on port no 4002.
·    Kindly provide all Spring properties as mentioned below:
§    This project must be registered with consul server using the name as "VehicleMS".
§    Provide cloud consul and Service discovery as localhost.
·    Verify the VehicleMS Microservice is working by sending the request as: <http://localhost:4002/vehicles/vehicle/101>
    NOTE: Do above implementation in application.yml file inside VehicleMS project.

Note: Verify the Output in Postman or Swagger.
<http://localhost:8000/employees/with-vehicles>
  
