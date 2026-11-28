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

## Actualización del esquema H2 local

El 28/11/2026, al consultar la base de datos H2 persistente configurada en `./data/DB_Persistance`, se detectó que la tabla `PROPERTY` no contenía las columnas `CITY` y `STREET`, aunque ambas están definidas como obligatorias en la entidad `Property`. La consulta de alojamientos fallaba con `Column "P1_0.CITY" not found`.

Se actualizaron manualmente las columnas en la base H2 local con sentencias aditivas e idempotentes:

```sql
ALTER TABLE PROPERTY ADD COLUMN IF NOT EXISTS CITY VARCHAR(255) DEFAULT '' NOT NULL;
ALTER TABLE PROPERTY ADD COLUMN IF NOT EXISTS STREET VARCHAR(255) DEFAULT '' NOT NULL;
```

Las filas existentes reciben una cadena vacía en esos campos; no se modificaron ni eliminaron los registros de alojamientos. Tras el cambio, se verificó que ambas columnas existen y que la tabla conserva sus 8 alojamientos.

Esta corrección se aplicó al archivo local `data/DB_Persistance.mv.db`; no es una migración versionada incluida en el código. Otras copias antiguas de la base de datos necesitarán la misma actualización si presentan el mismo error.
