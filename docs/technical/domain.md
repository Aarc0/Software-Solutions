# Capa Domain

Esta capa tiene como proposito proporcionar persistencia a la aplicación mediante el uso de la base de datos. Se centra principalmente en la creación de tablas y creación de entidades y relaciones necesarias para proporcionar dicha persistencia. Funciona en conjunto a la capa repository (Encargada de operaciones sobre los datos) para servir con datos a la aplicación.

## Entidades

| Clase | Responsabilidad |
|---|---|
| `User` | Representa los datos comunes de una persona usuaria y permite asignarle los roles de propietario o inquilino. |
| `Owner` | Representa el rol de propietario y mantiene la relación con sus inmuebles. |
| `Renter` | Representa el rol de inquilino y mantiene la relación con sus reservas. |
| `Property` | Representa un inmueble, sus características y sus relaciones con el propietario, las fotos, la disponibilidad y las reservas. |
| `Booking` | Representa la reserva de un inmueble por un inquilino, con sus fechas, precio, estado y política de cancelación. |
| `Availability` | Representa un periodo de disponibilidad asociado a un inmueble. |
| `Photos` | Representa una foto asociada a un inmueble y almacena su URL. |


## Relaciones principales y Comportamiento del modelo

`User`: Es la clase padre de tanto `Owner` como de `Renter`, con fines de eficiencia, `User` cuenta con dos métodos que permiten que el usuario en cuestión adapte los roles necesarios (`Owner` o `User` o ambos) para ello, se usa `becomeUser()` y `becomeRenter()`, ambos roles heredarán el ID del usuario. El usuario es obligatorio y único.

`Owner`: Es la clase que representa que un usuario tiene el rol de propietario. Puede tener varias propiedades.

`Renter`: Es la clase que representa que un usuario tiene el rol de inquilino. Puede tener varias reservas.

`Property`: Es la clase que representa la propiedad en sí. Puede tener varias fotos, disponibilidades y reservas. Cuenta con una tabla de `Photos` separada que está asociada a esta. `Property` recoge todas las características posibles que especifique el `Owner`. La dirección es obligatoria y única.

`Booking`: Es la clase que representas las reservas. Cada una esta asociada a una `Property` y a un `Renter`.

## Enumeraciones y datos iniciales

`CancelPolicy`: Es el conjunto de politicas de cancelación disponible.

`DataInitializer`: Tiene como función la introducción de datos de prueba y utiliza los métodos de Repository para introducir datos.