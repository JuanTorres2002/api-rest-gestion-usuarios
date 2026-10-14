# API REST de gestión de usuarios

Proyecto de portfolio con **Java 17, Spring Boot, Spring Data JPA, Spring Security, validación y H2**.

## Funcionalidades
- CRUD de usuarios mediante endpoints REST.
- Validación de nombre, correo y edad.
- Correo electrónico único.
- Autenticación HTTP Basic.
- Persistencia relacional con H2 en memoria.
- Prueba de carga del contexto de Spring.

## Requisitos
- JDK 17+
- Maven 3.8+

Comprueba las instalaciones con `java -version` y `mvn -version`.

## Ejecutar
Desde la carpeta del proyecto:

```bash
mvn spring-boot:run
```

API: `http://localhost:8080/api/usuarios`

La base de datos es temporal: los datos se borran al detener la aplicación.

## Credenciales locales de demostración
- Usuario: `admin`
- Contraseña: `Admin123!`

Todos los endpoints requieren HTTP Basic. Son credenciales de desarrollo; no reutilizarlas ni desplegar la aplicación con estas credenciales en un servidor público.

## Endpoints

| Método | Ruta | Función |
|---|---|---|
| GET | `/api/usuarios` | Listar usuarios |
| GET | `/api/usuarios/{id}` | Buscar por ID |
| POST | `/api/usuarios` | Crear usuario |
| PUT | `/api/usuarios/{id}` | Actualizar usuario |
| DELETE | `/api/usuarios/{id}` | Eliminar usuario |

### Crear usuario

```bash
curl -u admin:Admin123! -X POST http://localhost:8080/api/usuarios -H "Content-Type: application/json" -d '{"nombre":"Juan Pérez","email":"juan@example.com","edad":24}'
```

### Listar usuarios

```bash
curl -u admin:Admin123! http://localhost:8080/api/usuarios
```

### Buscar por ID

```bash
curl -u admin:Admin123! http://localhost:8080/api/usuarios/1
```

### Actualizar

```bash
curl -u admin:Admin123! -X PUT http://localhost:8080/api/usuarios/1 -H "Content-Type: application/json" -d '{"nombre":"Juan Torres","email":"juan@example.com","edad":25}'
```

### Eliminar

```bash
curl -u admin:Admin123! -X DELETE http://localhost:8080/api/usuarios/1
```

En PowerShell puedes usar `curl.exe` o Postman si `curl` se comporta como alias.

## Validaciones
- Nombre obligatorio, entre 2 y 80 caracteres.
- Email obligatorio y con formato válido.
- Edad obligatoria, entre 18 y 120 años.
- No se permite repetir el correo electrónico.

## Consola H2
Con la aplicación en marcha: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:usuariosdb`
- Usuario: `sa`
- Contraseña: vacía

La consola es solo para desarrollo local; no la expongas en producción.

## Pruebas

```bash
mvn test
```

## Estructura
```text
src/main/java/com/portfolio/usuarios/
├── config/SecurityConfig.java
├── controller/UsuarioController.java
├── dto/UsuarioRequest.java
├── exception/GlobalExceptionHandler.java
├── model/Usuario.java
├── repository/UsuarioRepository.java
├── service/UsuarioService.java
└── ApiRestGestionUsuariosApplication.java
```

## Tecnologías que demuestra
Java, programación orientada a objetos, diseño REST, Spring Boot, JPA, validación, autenticación, base de datos relacional y pruebas.

## Mejoras futuras
- Sustituir H2 por PostgreSQL o MariaDB.
- Añadir paginación, búsqueda y documentación Swagger/OpenAPI.
- Implementar roles y autenticación por tokens.
- Añadir migraciones de esquema y pruebas de integración.

## Seguridad
Es una demo educativa, no una solución de producción. Antes de desplegarla, configura secretos externos, HTTPS, una gestión de identidades adecuada, autorización por roles, limitación de intentos y una estrategia de persistencia segura.
