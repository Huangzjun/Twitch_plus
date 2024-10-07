# Twitch+ | Full-Stack Personalized Twitch Resource Recommendation Engine

Url：https://3zkx3mvm3q.us-west-2.awsapprunner.com/

### Project Overview

**Twitch+** is a personalized Twitch resource recommendation engine designed to improve user engagement by providing a tailored experience for discovering Twitch content, including streams, videos, and clips. Built as a full-stack application, **Twitch+** combines powerful backend technologies with a sleek and responsive frontend, optimizing both functionality and user experience.

### Key Features

- **User Registration and Login**: Users can create accounts, log in, and manage their profiles, ensuring a personalized experience each time they access the platform.
- **Recommendation System**: The application provides customized recommendations based on user preferences and past interactions, helping users quickly find content that aligns with their interests.
- **Search Functionality**: Allows users to search for Twitch content such as streams, videos, and clips, with relevant results displayed in a responsive and intuitive interface.
- **Favorites and Collections**: Users can save their favorite Twitch resources, creating a personal collection for easy access and better content management.

### Technical Details

- **Frontend**: Built with React and Ant Design, offering a modern, user-friendly interface with seamless navigation and a visually appealing design.
- **Backend**: Developed using Spring Boot, leveraging Java servlets and RESTful APIs to handle HTTP requests and ensure efficient data processing.
- **Database**: MySQL is used for data storage, hosted on Amazon RDS to provide scalability and simplify database management for high availability.
- **Deployment**: Hosted on Amazon EC2, optimizing performance and reliability for a seamless user experience across regions.

## Frontend Architecture

https://github.com/Huangzjun/Twitch_plus_fe/blob/main/README.md

## Backend Architecture

### Overview

The backend of this project is built using **Spring Boot**, a powerful framework for building Java-based web applications. The project leverages various Spring Boot modules and other libraries to provide a robust and scalable backend solution.

### Key Components

1. **Spring Boot**: The core framework used to build the application.
2. **Spring Security**: Provides authentication and authorization capabilities.
3. **Spring Data JDBC**: Simplifies database interactions.
4. **Spring Web**: Facilitates the creation of RESTful web services.
5. **Spring WebFlux**: Supports reactive programming.
6. **Spring Cloud OpenFeign**: Simplifies HTTP client creation.
7. **MySQL**: The relational database used for data storage.
8. **Caffeine Cache**: Provides caching capabilities to improve performance.
9. **Java Faker**: Generates fake data for testing purposes.
10. **Docker**: Containerizes the application for consistent deployment.
11. **AWS**: Hosts the Docker images and provides cloud infrastructure.

### Project Structure

- `src/main/java`: Contains the Java source code.
- `src/main/resources`: Contains configuration files.
- `build.gradle`: Gradle build configuration file.
- `docker-compose.yml`: Docker Compose configuration file.

### Functionality

#### User Authentication and Authorization

- **Spring Security** is used to secure the application.
- OAuth2 client support is provided for secure communication with external services.

#### Data Management

- **Spring Data JDBC** is used for database interactions.
- **MySQL** is the primary database, configured via `docker-compose.yml`.

#### RESTful APIs

- **Spring Web** is used to create RESTful endpoints.
- **Spring WebFlux** supports reactive programming for non-blocking I/O operations.

#### Caching

- **Caffeine Cache** is integrated to cache frequently accessed data, reducing database load and improving performance.

#### Containerization with Docker

- **Docker** is used to containerize the application, ensuring consistent environments across different stages of development and deployment.
- The `docker-compose.yml` file configures the MySQL database service and other necessary services.

#### Cloud Deployment with AWS

- **AWS ECR** is used to store and manage Docker images for easy deployment of containerized applications.
- **AWS RDS** provides a managed relational database, handling data storage and retrieval with automated backups and scaling.

- **AWS App Runner** deploys and runs the containerized application directly from ECR, providing a seamless way to launch and scale web services without managing infrastructure.

## Project Setup and Deployment Guide

### Prerequisites
- Java 17
- Docker
- AWS CLI
- Gradle

### Building the Project
1. **Build the Project**:
    ```sh
    ./gradlew build
    ```

2. **Run the Application**:
    ```sh
    ./gradlew bootRun
    ```

### Docker Integration
1. **Build Docker Image**:
    ```sh
    ./gradlew bootBuildImage --imageName=<account-id>.dkr.ecr.us-west-2.amazonaws.com/<repository-name>
    ```

2. **Run with Docker Compose**:
    ```sh
    docker-compose up
    ```

### Cloud Deployment with AWS

#### AWS ECR (Elastic Container Registry)
AWS ECR is used to store Docker images. It integrates with AWS IAM to control access to your repositories and images.

1. **Push Docker Image to AWS ECR**:
    ```sh
    aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin <account-id>.dkr.ecr.us-west-2.amazonaws.com
    docker tag <image-name>:latest <account-id>.dkr.ecr.us-west-2.amazonaws.com/<repository-name>:latest
    docker push <account-id>.dkr.ecr.us-west-2.amazonaws.com/<repository-name>:latest
    ```

#### AWS IAM (Identity and Access Management)
AWS IAM is used to manage access to AWS services and resources securely. You can create IAM roles and policies to control who can access your ECR repositories and ECS/EKS clusters.

1. **Create IAM Roles and Policies**: Define permissions for accessing ECR, ECS, and EKS.
2. **Attach Roles to Services**: Attach the IAM roles to your ECS tasks or EKS nodes to grant them the necessary permissions.

#### AWS CLI (Command Line Interface)
AWS CLI is a unified tool to manage your AWS services. It allows you to interact with AWS services using commands in your command-line shell.

1. **Install AWS CLI**: Follow the [installation guide](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html).
2. **Configure AWS CLI**: Set up your AWS credentials and default region.
    ```sh
    aws configure
    ```

#### Security Groups
Security groups act as virtual firewalls to control inbound and outbound traffic to your AWS resources.

1. **Create Security Groups**: Define rules to allow or deny traffic to your ECS tasks or EKS nodes.
2. **Attach Security Groups**: Attach the security groups to your ECS services or EKS nodes.

#### AWS RDS (Relational Database Service)
AWS RDS makes it easy to set up, operate, and scale a relational database in the cloud. You can use RDS to host your MySQL database.

1. **Create an RDS Instance**: Set up a MySQL database instance.
2. **Configure Security Groups**: Ensure the RDS instance is accessible from your ECS tasks or EKS nodes.

#### AWS App Runner
AWS App Runner is a fully managed service that makes it easy to build, deploy, and run containerized web applications and APIs at scale.

1. **Create an App Runner Service**: Deploy your Docker container directly from ECR.
2. **Configure Auto Scaling**: Set up auto-scaling policies to handle varying loads.

By following these steps, you can build, run, and deploy your application using Docker and AWS services.
