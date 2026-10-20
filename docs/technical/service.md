# Carpeta Service

- Clases encargadas de implementar la lógica de negocio y coordinar las operaciones entre los repositorios.

## PropertyService

- Gestiona la creación de propiedades y utiliza `PropertyRepository` para guardarlas y `UserRepository` para buscar al propietario.
- Comprueba que el usuario exista antes de crear la propiedad cuando se identifica mediante su ID o correo electrónico.

| Método | Acción |
|---|---|
| `crear(ownerID, address, type, nightPrice, surface)` | Busca al usuario por su ID, crea la propiedad y la guarda. Si no existe, lanza una excepción. |
| `crear(property)` | Guarda directamente la propiedad recibida. |
| `crear(property, photos)` | Guarda las imágenes recibidas en el directorio configurado, asocia sus rutas a la propiedad y guarda la propiedad con sus fotos. Si no se reciben imágenes, guarda solo la propiedad. |
| `crear(email, address, type, nightPrice, surface)` | Busca al usuario por su correo y delega la creación en el método que recibe su ID. Si no existe, lanza una excepción. |

### Métodos auxiliares para las fotos

| Método | Acción |
|---|---|
| `imageExtension(photo)` | Comprueba el tipo de contenido de la imagen y devuelve su extensión. Acepta JPEG, PNG, GIF y WebP; si no se puede determinar o no está permitido, lanza una excepción. |
| `deleteUploadedFiles(files, failure)` | Intenta borrar los archivos guardados durante la operación si ocurre un error. Si falla la limpieza, añade el error a la excepción original. |

Las imágenes se guardan en la ruta definida por `app.upload.dir`. En la base de datos se almacena la ruta web `/uploads/<nombre>` asociada a la propiedad, no el contenido de la imagen.

## Flujo de creación

1. Se reciben los datos de la propiedad y la identificación del propietario.
2. `PropertyService` busca al usuario mediante `UserRepository`, si corresponde.
3. Se construye la propiedad con los datos recibidos y el propietario.
4. `PropertyRepository` guarda la propiedad en la base de datos.
5. Se devuelve la propiedad guardada.

## Flujo de publicación con fotos

1. `PropertyService` descarta los archivos vacíos y comprueba el tipo de contenido de cada imagen.
2. Guarda cada imagen con un nombre único en el directorio configurado por `app.upload.dir`.
3. Crea un objeto `Photos` por cada archivo y lo asocia a la propiedad usando la ruta web `/uploads/<nombre>`.
4. `PropertyRepository` guarda la propiedad y sus fotos asociadas.
5. Si ocurre un error durante el guardado, se intenta eliminar los archivos que ya se habían guardado y se propaga la excepción.
