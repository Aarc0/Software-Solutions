# Carpeta Controller

- Clases encargadas de recibir las peticiones del usuario y asegurar el manejo adecuada de las mismas

## HomeController
-Gestiona las rutas que aparecen desde el main siendo:

 | Método | Ruta | Vista |
 |---|---|---|
 | GET | `/` | `home` |
 | GET | `/login` | `login` |
 | GET | `/Register` | `Register` |
 | GET | `/Formulary` | `Formulary` |

## PropertyController

- Gestiona la publicación de inmuebles y se comunica con PropertyService para la creación del inmueble
- Se incluye un handleError para poder controlar las excepciones que puedan ocurrir durante el proceso

 | Método | Ruta | Acción |
 |---|---|---|
 | GET | `/publish` | Muestra el formulario `Formulary` |
 | POST | `/publish` | Envía el inmueble a `PropertyService` y redirige a `/` |
 | GET | `/error` | Redirige a `Error` en caso de que surga algún problema |

## Flujo de publicación

 1. El usuario envía el formulario de publicación a `POST /publish`
 2. `PropertyController` recibe los datos como un objeto `Property`
 3. El controlador llama a `PropertyService.crear(property)`
 4. Si la operación termina correctamente, redirige al Home
