# Listado y detalle de alojamientos

## Listado de alojamientos

`List.html` presenta los alojamientos que recibe bajo el atributo `properties`. Conserva la estética de Nano Inmobiliaria, con tonos cálidos, tipografías DM Sans y Playfair Display, fondos suaves y tarjetas adaptables.

Las tarjetas se definen en `templates/fragments/property-card.html` y muestran los datos disponibles de cada inmueble, como dirección, tipo, precio por noche, superficie, descripción, habitaciones, capacidad y fotografía. Si no hay foto, se muestra un marcador visual; si la lista está vacía, se informa al usuario.

Desde el botón **«Explorar alojamientos»** del home se accede a `/List`.

## Vista de detalle

La sub-issue #53, hija de la #48, solicita que el usuario pueda seleccionar un alojamiento del listado y consultar su información completa antes de reservar. La vista muestra los datos disponibles de `Property`, incluidas descripción, fotos, características, comodidades y normas.

Al seleccionar una tarjeta, el navegador abre una ruta que contiene el identificador del alojamiento, por ejemplo `/property/17`. El controlador obtiene ese inmueble mediante el servicio y entrega el objeto a `PropertyDetail.html`.

La vista de detalle tiene una navegación superior con una flecha y el texto **«Volver al listado»**, que lleva a `/List`, y un icono de casa que lleva al home (`/`). El botón **«Reservar»** aparece como elemento visual y actualmente no realiza ninguna acción.

Si el ID solicitado no corresponde a un inmueble, se redirige al listado.

## Plan inicial y revisión

El plan inicial para la #53 contemplaba enlazar las tarjetas usando el ID del inmueble, añadir una ruta de detalle que consultara el servicio, crear una plantilla con la estética existente, mostrar los datos y dejar el botón de reserva sin funcionalidad. También se planteó tratar el caso de un identificador inexistente.

Durante la revisión, el usuario concretó que la tarjeta debía abrir una ruta distinta con el detalle completo y que el botón **Reservar** sería solo visual. Después indicó que la vista necesitaba navegación superior: una flecha o símbolo para volver a `List.html` y el icono de casa del home para volver a `/`. Se acordó incluir esa navegación como parte de la #53, sin crear una sub-issue adicional.

## Cambios realizados en el código

### Cambios realizados por Codex

- `templates/home.html`: añadí el botón **«Explorar alojamientos»** con enlace a `/List`.
- `templates/List.html`: reemplacé las tarjetas estáticas por una cuadrícula Thymeleaf que recorre `properties`; añadí el contador de alojamientos y el estado vacío.
- `templates/fragments/property-card.html`: creé el fragmento reutilizable de tarjeta y después lo convertí en un enlace a `/property/{id}`. La tarjeta muestra los campos del inmueble y contempla alojamientos sin fotos.
- `controller/PropertyController.java`: añadí la ruta `GET /property/{id}`, que obtiene el inmueble del servicio, lo entrega a la vista o redirige a `/List` si no existe.
- `service/PropertyService.java`: añadí `findById(Long id)`, que delega la búsqueda en el repositorio y devuelve un `Optional<Property>`.
- `templates/PropertyDetail.html`: creé la vista de detalle con fotografías, descripción, características, comodidades, normas, el botón visual **«Reservar»** y el menú superior de vuelta al listado y al home.

### Cambios de integración realizados por el usuario

El usuario configuró previamente el mapeo `/List` y la carga de inmuebles en el modelo mediante el servicio. También añadió `PropertyService.list()`, utilizado por esa ruta para recuperar el listado. Esos cambios no fueron realizados por Codex.

## Prompts registrados

### Prompt inicial para la vista visual del listado

> Se ha actualizado el nombre de Listado.html a List.html, además solo quiero actualmente la creacion de la parte visual, es decir solo crear una primera vision de como sería ese listado de los inmubles y que se pueda navegar a ese apartado desde el home, por ello solo rellena List.html siguiendo la linea estética de la página

### Prompt para conectar el listado con los datos

> puedes realizar tus esas modificaciones del html, ya he configurado service yc ontroller para permitirlo

### Prompt para implementar la navegación al detalle

> vale, pues añade la creacion del menu con la navegación de una flecha o símbolo que indique que se puede volver hacia atrás que sería list.html y una casa como la que aparece en la animación cuando se entra al home para poder navegar a home

## Verificación

Se ejecutó `mvn -q -DskipTests package` y la compilación terminó sin mensajes de error. No se ejecutaron tests.
