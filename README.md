# Lowgistic Backend

## Overview
Lowgistic Backend is the backend service for a logistics management platform. This application provides robust APIs for managing logistics operations, including communication services such as email notifications. The architecture incorporates microservices, a centralized gateway, and Kafka for efficient messaging.

## Features
- **Microservice Architecture**: Modularized services for better scalability and maintainability.
- **Central Gateway**: All services are accessed through a centralized API gateway, ensuring a single point of entry.
- **Email Notification System**: Leveraging Apache Kafka for asynchronous email notification functionality.

## Architecture

### Gateway
- The **API Gateway** acts as the single entry point into the platform.
- It handles routing, rate limiting, authentication, and more.
- **Gateway Security**: The gateway is the **only component exposed** to external clients, providing secure access to internal services.

### Kafka Integration
- **Apache Kafka** is used as a message broker.
- It handles **email notifications**, which are produced by one service and consumed by an email service for sending out messages.
- This approach ensures reliability and decouples the email service from other core services, enhancing fault tolerance.

### Services
- **User Management**: CRUD operations for managing user profiles and roles.
- **Logistics Management**: Manages orders, shipments, tracking, and other logistics-related activities.
- **Email Notification Service**: Listens to Kafka topics to process and send emails asynchronously.

## Installation

### Prerequisites
- **Java 11** or later
- **Apache Kafka** running locally or hosted.
- **Spring Boot CLI** for local development.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yassineramzi/lowgisticbackend.git

## Run application

## Using Docker to simplify development (optional)

To use docker run :

    mvnw clean verify jib:dockerBuild

Then run :

    docker-compose -f src/main/docker/app.yml up -d

## Branch management 

For each ticket, create a branch and in the end of the ticket, 
Make a pull request to develop by specifying the other developers for a code review.

## Access database

    psql -h <ip_address> -d <db> -U <user_name>

Then type password :

    <password>
