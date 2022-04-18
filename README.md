# vehicle-contract-service-v1

# Vehicle Contract Service 

This application provides endpoints for vehicle contractual process. The data default stored in in-memory database(H2) of Spring boot framework.

As the application built in spring boot framework. please run the following command to run the application locally.
- mvn spring-boot:run 

# Sample Working EndPoinds as stated below.

# Customers
GET:/customers
POST:/customers
GET:/customers/{customerId}
PUT:/customers/{customerId}

# Vehicles
GET:/vehicles
POST:/vehicles
GET:/vehicles/{vehicleId}
PUT:/vehicles/{vehicleId}

# LeaseContracts
GET:/leaseContracts
POST:/leaseContracts
GET:/leaseContracts/{leaseContractId}
PUT:/leaseContracts/{leaseContractId}
  
# Below are the used framework and tools.

- Spring Boot
- Open API Swagger
- H2 Database 
- Flyway
- 
  
 
