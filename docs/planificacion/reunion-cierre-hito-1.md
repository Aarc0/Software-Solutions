# Reunión de cierre del Hito 1

> **Proyecto:** Plataforma de alquiler de viviendas  
> **Objetivo:** revisar el cierre del Hito 1, comprobar la publicación de inmuebles y acordar el próximo paso.

---

## Agenda

| # | Tema | Resultado esperado |
|---:|---|---|
| 1 | Cierre del desarrollo del Hito 1 | Confirmar qué se ha completado y registrar asuntos pendientes. |
| 2 | Pruebas de la funcionalidad de publicar inmueble | Revisar los casos de prueba, resultados e incidencias. |
| 3 | Siguiente paso del proyecto | Acordar y dejar anotada la prioridad para el próximo ciclo. |

## 1. Cierre del desarrollo del Hito 1

### Revisión

- [X] Repasar el alcance previsto para el hito.
- [X] Confirmar las funcionalidades terminadas.
- [X] Anotar tareas incompletas o incidencias conocidas.
- [X] Revisar documentación y cambios pendientes de integrar.

**Estado del hito:** _Pendiente de revisar en la reunión._

- Funcionalidad **Publicar un inmueble** terminada
- Implementado además **Home.html, Loging.html** y mapea de las rutas

**Pendientes / observaciones:**
- Documentacion Hito 1
- Reorganización de las ramas
- Confrontación con 1 integrante del equipo respecto a su desempeño en el 1º Hito. **Realizado**


## 2. Testing de la funcionalidad de publicar inmueble

Revisar el flujo de publicación de principio a fin: acceso del usuario, cumplimentación del formulario, envío y resultado visible para el usuario.

| Caso | Comprobación | Resultado |
|---|---|---|
| Publicación válida | Un usuario autenticado envía el formulario con datos válidos. | _Validado_ |
| Campos obligatorios | Se intenta publicar dejando sin completar campos requeridos. | _Redirige a Error.html_ |
| Datos no válidos | Se introducen valores con formato o límites incorrectos. | _No se permite_ |
| Usuario no autenticado | Se intenta acceder al flujo de publicación sin iniciar sesión. | _Por implementar_ |
| Persistencia | Se comprueba que la vivienda publicada queda guardada y asociada al usuario correspondiente. | _Validado_ |

### Registro de resultados

- **Responsable:** _Mario Sierra Iniesta_
- **Fecha de ejecución:** _20/10/2026_
- **Resultado global:** _Cerrado_