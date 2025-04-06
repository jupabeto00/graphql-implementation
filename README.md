# Implementación de GraphQL en Arquitectura Hexagonal

Este proyecto muestra una implementación de GraphQL en una arquitectura hexagonal, utilizando la paginación estándar de GraphQL basada en el cursor. El objetivo es proporcionar un ejemplo práctico de cómo implementar esta tecnología en una arquitectura hexagonal utilizando la librería de GraphQL de Spring Boot.

## Requisitos previos

* Java 21 instalado en el equipo
* Un IDE para ejecutar el proyecto

## Características

* Implementación de GraphQL en arquitectura hexagonal
* Paginación estándar de GraphQL basada en el cursor
* Utiliza la librería de GraphQL de Spring Boot

## Diagrama relacional de la base de datos
```mermaid
erDiagram

    USERS ||--o{ PRODUCTS : has
    PRODUCTS ||--|| ACCOUNTS : "has"
    PRODUCTS ||--|| CREDIT_CARDS : "has"
    PRODUCTS ||--|| CREDITS : "has"
    PRODUCTS ||--o{ MOVEMENTS : "has"

    USERS {
        bigint id PK
        varchar name
        timestamp created_date
    }

    PRODUCTS {
        bigint id PK
        varchar number
        varchar type
        bigint user_id FK
        timestamp created_date
    }

    ACCOUNTS {
        bigint id PK
        float balance
        bigint product_id FK
    }

    CREDIT_CARDS {
        bigint id PK
        float balance
        bigint product_id FK
    }

    CREDITS {
        bigint id PK
        float balance
        bigint product_id FK
    }

    MOVEMENTS {
        bigint id PK
        float amount
        varchar description
        timestamp transaction_date
        timestamp created_at
        bigint product_id FK
    }
```

### Cómo ejecutar el proyecto

1. Clona el repositorio en tu máquina local
2. Abre el proyecto en tu IDE
3. Ejecuta el comando `mvn spring-boot:run` para iniciar el servidor
4. Accede a la URL `http://localhost:8080/graphql` para interactuar con la API de GraphQL

### Documentación adicional

* [Documentación de GraphQL de Spring](https://docs.spring.io/spring-graphql/reference/)

### Contribuciones

Si deseas contribuir a este proyecto, por favor, crea un fork del repositorio y envía un pull request con tus cambios.