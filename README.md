# User Service - MealMate

## Overview

The **User** service is a key component of the **MealMate** project, handling user registration, authentication, and profile management. This service is built using the Spring Boot framework and follows a microservices architecture.

## Features

- **User Registration**: Allows users to register to the MealMate platform.
- **Authentication**: Provides secure user authentication.
- **Profile Management**: Manage user profile details.
- **Spring Security**: Implements security for authentication and authorization.
- **Eureka Integration**: Registers with Eureka for service discovery.
- **MySQL Database**: Stores user data in a MySQL database.

## Prerequisites

- **JDK 17** or higher
- **Maven**
- **MySQL Database**
- **Eureka Server** (for service discovery)

## Getting Started

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Emon-Khan/User-MealMate.git
   ```


2. **Navigate to the Project Directory**

   ```bash
   cd User-MealMate

   ```

3. **Configure the Database**

   Update the application.properties file located in src/main/resources with your MySQL database details:

   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/user_db
   spring.datasource.username=root
   spring.datasource.password=your_password

   ```

4. **Build the Project**

   ```bash
   mvn clean install
   ```

5. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Register a New User
- URL: /api/user/users
- Method: POST
- Description: Registers a new user to the platform.
- Request Body: JSON object with user details.
- Response:  Success message or error.

```bash
   {
      "userName": "Raju Dada",
      "userPassword": "AmaderDada",
      "address": "Rainkhola",
      "city": "Dhaka"
   }
```

### Get User Profile
- URL: /api/user/users/{id}
- Method: GET
- Description: Retrieves the profile of a user by their ID.
- Response: JSON object of user details.


### Screenshots
![image](https://github.com/user-attachments/assets/81ea3a82-57cc-4a86-968d-f5b5ca314d73)
![image](https://github.com/user-attachments/assets/5791b738-e61c-4f73-9099-26759da1157b)


## Docker Instructions

If you prefer using Docker for this service, you can pull and run the User Service image directly from Docker Hub.

### Pulling the Image from Docker Hub

1. To pull the image, use the following command:
    ```bash
    docker pull rkemon94/user-service:latest
    ```

### Running the Order Service with Docker

2. Run the User Service service in a Docker container:
    ```bash
    docker run --name user-container -p 9093:9093 rkemon94/user-service:latest
    ```

3. Access the service:

   After running the container, you can access the API on http://localhost:9093.

### Stopping and Removing the Container

- To stop the running container:
    ```bash
    docker stop user-container
    ```

- To remove the container after stopping it:
    ```bash
    docker rm user-container
    ```

## Conclusion

The User-MealMate service is a key component of the MealMate microservices ecosystem, providing user management capabilities that integrate seamlessly with other services like the FoodCatalogue, Order, and RestaurantListing services. By utilizing modern technologies such as Spring Boot and MySQL, this service ensures reliable and efficient handling of user data, authentication, and authorization. With its integration into the overall MealMate architecture through Eureka service discovery, it enables smooth inter-service communication and contributes to a scalable, flexible food-ordering system.

