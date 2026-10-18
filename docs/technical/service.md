# Carpeta Service

- Clases encargadas de implementar la lógica de negocio y coordinar las operaciones entre los repositorios.

## PropertyService

- Gestiona la creación de propiedades y utiliza `PropertyRepository` para guardarlas y `UserRepository` para buscar al propietario.
- Comprueba que el usuario exista antes de crear la propiedad cuando se identifica mediante su ID o correo electrónico.

| Método | Acción |
|---|---|
| `crear(ownerID, address, type, nightPrice, surface)` | Busca al usuario por su ID, crea la propiedad y la guarda. Si no existe, lanza una excepción. |
| `crear(property)` | Guarda directamente la propiedad recibida. |
| `crear(email, address, type, nightPrice, surface)` | Busca al usuario por su correo y delega la creación en el método que recibe su ID. Si no existe, lanza una excepción. |

## Flujo de creación

1. Se reciben los datos de la propiedad y la identificación del propietario.
2. `PropertyService` busca al usuario mediante `UserRepository`, si corresponde.
3. Se construye la propiedad con los datos recibidos y el propietario.
4. `PropertyRepository` guarda la propiedad en la base de datos.
5. Se devuelve la propiedad guardada.
