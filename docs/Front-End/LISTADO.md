# Listado de alojamientos

La página `List.html` muestra los alojamientos que recibe con el atributo `properties`. Mantiene la línea estética de Nano Inmobiliaria: tonos cálidos, tipografías DM Sans y Playfair Display, fondos suaves y tarjetas adaptables a distintos tamaños de pantalla.

Las tarjetas se definen en el fragmento `templates/fragments/property-card.html` y se repiten para cada alojamiento. Muestran los datos disponibles en `Property`, como dirección, tipo, precio por noche, superficie, descripción, habitaciones, capacidad y foto. Si un alojamiento no tiene foto se muestra un marcador visual, y si no hay alojamientos se presenta un mensaje de lista vacía.

Desde el botón **«Explorar alojamientos»** del home se puede navegar a `/List`. El controlador pasa a la vista la lista obtenida mediante el servicio.

## Cambios realizados en el código

- En `templates/List.html`, sustituí las tarjetas estáticas de ejemplo por la cuadrícula Thymeleaf que recorre `properties`. También añadí el contador de alojamientos y el mensaje para cuando la lista está vacía.
- Creé `templates/fragments/property-card.html` para definir cada tarjeta. El fragmento muestra los campos disponibles del inmueble, su primera foto cuando existe y un marcador visual cuando no tiene fotos.
- En `templates/home.html`, añadí el botón **«Explorar alojamientos»**, que enlaza con `/List`.

El mapeo `/List` y la carga de la lista mediante el servicio en el controlador son cambios configurados por el usuario; no fueron modificados aquí.

## Prompt inicial de la vista

> Se ha actualizado el nombre de Listado.html a List.html, además solo quiero actualmente la creacion de la parte visual, es decir solo crear una primera vision de como sería ese listado de los inmubles y que se pueda navegar a ese apartado desde el home, por ello solo rellena List.html siguiendo la linea estética de la página

## Prompt para conectar las tarjetas a los alojamientos

> puedes realizar tus esas modificaciones del html, ya he configurado service yc ontroller para permitirlo
