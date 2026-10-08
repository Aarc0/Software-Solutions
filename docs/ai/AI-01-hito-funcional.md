### Cambio en los nombres del campo del formulario
 - Le he pedido al agente de IA que cambia el campo de **"name"** y **"id"** del acrhivo Formulary.html para que coincidan con el nombre de los atributos de la clase Property.java del directorio **domain/**

### Ayuda en la creacion y configuracion de la clae SecurityConfig
 - Se ha añadido la dependencia de SpringSecurity para ayudar a auntenticar e identificar el usuario una vez loggeado y de esta manera poder asociar la creacion de la vivenda con el ID del usuario en concreto.
 - Ayuda además añadiendo una seguridad obligando a que el usuaio tenga ciertos permisos/roles para poder acceder a ciertas rutas

### Ayuda en la creacion y configuracion de la clase CustomUserDetailsService
 - Se ha creado una nueva clase Service que ayudará a SecurityConfig a identificar al usuario, buscando en este caso el id del user usando el email pedido durante el inicio de sesion y verificar los permisos/roles del usuario 

### Creado un override del metodo Crear en la clase PropertyService
 - Se le ha pedido que hiciera un override al metodo crear() en PropertyService para que aceptara un email en vez de ID