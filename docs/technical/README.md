# DOCUMENTACIÓN TÉCNICA

En este archivo se explicará lo que se hace tanto con Maven como con Spring Boot.

# Base técnica

**Evidencias mínimas:**

- ./mvnw verify -> BUILD SUCCESS
- ./mvnw spring-boot:run
  - http://localhost:8080 responde

# Dependencias

- spring-boot-starter-webmvc → Permite crear apps web.
- spring-boot-starter-thymeleaf → vistas HTML mediante plantillas Thymeleaf.
- spring-boot-starter-webmvc-test → soporte para pruebas de Spring MVC.
- spring-boot-starter-thymeleaf-test → soporte para pruebas de Thymeleaf
- spring-boot-starter-data-jpa → Permite acceder y gestionar bases de datos usando JPA
- spring-boot-starter-security → Añade mecanismos de autenticación y seguridad para proteger la aplicación
- spring-boot-devtools → Permite agilizar el proceso de desarrollo volviendo a lanzar el servidor cuando se produce una modificación de los archivos
- spring-boot-h2console → Permite el acceso a la consola web H2 que permite la consulta y administración de la base de datos
- h2 → Es la base datos relacionadl usada en el proyecto


# Ejecución

## Linux

- **./mvnw clean**: Elimina directorio target para empezar con compilación limpia
- **./mvnw test**: Ejecuta pruebas ubicadas en src/test utilizando un framework como JUnit
- **./mvnw package**: Empaqueta el proyecto en un archivo .jar incluyendo código compilado y recursos
- **./mvnw verify**: Ejecuta pruebas de integración y comprueba que el paquete cumpla con criterios de calidad
- **./mvnw spring-boot:run**: Se utiliza para compilar y arrancar una app spring boot

## Windows

- **./mvnw.cmd clean**: Elimina directorio target para empezar con compilación limpia
- **./mvnw.cmd test**: Ejecuta pruebas ubicadas en src/test utilizando un framework como JUnit
- **./mvnw.cmd package**: Empaqueta el proyecto en un archivo .jar incluyendo código compilado y recursos
- **./mvnw.cmd verify**: Ejecuta pruebas de integración y comprueba que el paquete cumpla con criterios de calidad
- **./mvnw.cmd spring-boot:run**: Se utiliza para compilar y arrancar una app spring boot
