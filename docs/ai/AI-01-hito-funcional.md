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