## GET
Propósito: Obtener (recuperar) un recurso.

### Características:

- Solo lee datos, no debe modificar nada en el servidor (es seguro e idempotente).
- Los parámetros se envían en la URL (query string).
- Tiene límite de longitud y no es adecuado para datos sensibles.
Ejemplo: GET /productos/123 → Devuelve los datos del producto con ID 123.
## POST
Propósito: Enviar datos al servidor para crear un nuevo recurso o procesar una operación que no es idempotente.

### Características:

- No es idempotente (dos peticiones idénticas pueden crear dos recursos diferentes).
- Los datos se envían en el cuerpo de la petición (body), sin límite teórico de tamaño.
- Se usa típicamente en formularios, subida de archivos, o APIs REST para crear entidades.

Ejemplo: POST /usuarios con body {"nombre": "Ana", "email": "ana@example.com"} → Crea un nuevo usuario.
## PUT

Propósito: Reemplazar completamente un recurso existente o crearlo si no existe (en algunas implementaciones).

### Características:

- Idempotente: Si envías la misma petición varias veces, el resultado final en el servidor es el mismo.
- El cliente envía la representación completa del recurso.
- Se diferencia de POST en que PUT apunta a un recurso específico (ej. /usuarios/5), mientras que POST generalmente a una colección (/usuarios).

Ejemplo: PUT /usuarios/5 con body {"nombre": "Ana", "email": "nuevo@example.com"} → Reemplaza todos los datos del usuario 5.

## PATCH

Propósito: Aplicar modificaciones parciales a un recurso (no reemplazarlo completamente).

### Características:

- No necesariamente idempotente (depende de la implementación, pero debería serlo si se usa bien).
- Más eficiente que PUT cuando solo cambiamos unos pocos campos.

Ejemplo: PATCH /usuarios/5 con body {"email": "nuevo@example.com"} → Solo actualiza el email del usuario 5.

## DELETE
Propósito: Eliminar un recurso.
Características:

- Idempotente: si eliminas el mismo recurso varias veces, el resultado final es el mismo (el recurso ya no existe).

Ejemplo: DELETE /usuarios/5 → Borra el usuario con ID 5.
