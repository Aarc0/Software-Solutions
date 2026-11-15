# Registro de uso de IA

Este documento recoge los usos relevantes de inteligencia artificial realizados durante el proyecto.

## Principio

- La IA puede proponer, pero el equipo decide.
- Todo cambio debe ser comprendido y revisado.
- Las propuestas deben verificarse mediante las herramientas correspondientes.
- No se integrará código generado por IA sin revisión humana.

## Hito 1 - Desarrollo funcional

### Cambio en los nombres del campo del formulario
 - Le he pedido al agente de IA que cambia el campo de **"name"** y **"id"** del acrhivo Formulary.html para que coincidan con el nombre de los atributos de la clase Property.java del directorio **domain/**

### Ayuda en la creacion y configuracion de la clae SecurityConfig
 - Se ha añadido la dependencia de SpringSecurity para ayudar a auntenticar e identificar el usuario una vez loggeado y de esta manera poder asociar la creacion de la vivenda con el ID del usuario en concreto.
 - Ayuda además añadiendo una seguridad obligando a que el usuaio tenga ciertos permisos/roles para poder acceder a ciertas rutas

### Ayuda en la creacion y configuracion de la clase CustomUserDetailsService
 - Se ha creado una nueva clase Service que ayudará a SecurityConfig a identificar al usuario, buscando en este caso el id del user usando el email pedido durante el inicio de sesion y verificar los permisos/roles del usuario 

### Creado un override del metodo Crear en la clase PropertyService
 - Se le ha pedido que hiciera un override al metodo crear() en PropertyService para que aceptara un email en vez de ID

### Creada una plantilla acerca de la reunion del cierre del Hito-1
 - Se ha usado al agente para la creacion de una plantilla en un **.md** que deje reflejado de alguna manera el estado en el que se cerro la última reunion del equipo previa a la Entrega Intermedia

### Se ha pedido ayuda para que implemente un método para recoger las fotos del frontend
- Se ha usado el agente para terminar de recoger las fotos del form y solucionar problemas, creados la sobrecarga del constructor `crear()` y los métodos `imageExtension()` y `deleteUploadedFiles()`.

### Se ha pedido a la ia que cree todo el front end del home,
- Se le pasó un esquema de código de como se quería la página con un carrusel en medio y se le pasos la issue #33. 
  Se decidió implementar ia en este proceso debido a que no es una funcionalidad muy importante y si está bien definida la issue no hay problemas a la hora de que la ia la haga. La documentación de lo que
  hace el código de ia está en la carpeta de Front-end en el apartado Home.


## Hito 2 - Pruebas y verificación

### Uso de Mockito además de JUnit en las pruebas de PropertyService
- Para probar la publicación de un inmueble (FP-01, casos CP-01 a CP-03 de `TEST_PLAN.md`) sin base de datos, el agente propuso crear dobles de `PropertyRepository` y `UserRepository` con Mockito, además de JUnit. Mockito ya viene incluido en `spring-boot-starter-test`, por lo que no se modificó el `pom.xml`.
- **Prompt:** Se le pidió ayuda al agente para la realización de las pruebas ya que se hablaba sobre creación de dobles y no sabíamos lo que era, además de que
las pruebas debían de ser aisladas.
- **Respuesta del agente (resumen):** Propuso un test unitario de `PropertyService` con repositorios simulados con Mockito y una carpeta temporal (`@TempDir`) para las fotos