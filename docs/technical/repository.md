# Carpeta Repository

- Interfaces encargadas de gestionar el acceso a la base de datos mediante Spring Data JPA, proporcionando operaciones CRUD sin necesidad de implementarlas manualmente.

## PropertyRepository

- Gestiona las operaciones sobre las propiedades (`Property`).

| Método | Acción |
|---|---|
| `save(entity)` | Guarda o actualiza una propiedad |
| `findById(id)` | Busca una propiedad por su ID |
| `findAll()` | Obtiene todas las propiedades |
| `delete(entity)` | Elimina una propiedad |
| `deleteById(id)` | Elimina una propiedad por su ID |
| `existsById(id)` | Comprueba si existe una propiedad con ese ID |

## UserRepository

- Gestiona las operaciones sobre los usuarios (`User`).
- Incluye métodos para buscar usuarios y comprobar su existencia mediante el correo electrónico.

| Método | Acción |
|---|---|
| `existsByEmail(email)` | Comprueba si existe un usuario con ese correo |
| `save(entity)` | Guarda o actualiza un usuario |
| `findByEmail(email)` | Busca un usuario por su correo electrónico |
| `findById(id)` | Busca un usuario por su ID |
| `findAll()` | Obtiene todos los usuarios |
| `delete(entity)` | Elimina un usuario |
| `deleteById(id)` | Elimina un usuario por su ID |
| `existsById(id)` | Comprueba si existe un usuario con ese ID |