# API REST de Películas 🎬

## Descripción
API REST desarrollada con Spring Boot para la gestión de películas. Esta aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre un catálogo de películas, incluyendo información detallada como título, director, género, año de lanzamiento y calificación IMDB.

## Tecnologías Utilizadas
- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven
- Spring Validation

## Requisitos Previos
- JDK 21 o superior
- Maven 3.6.x o superior
- PostgreSQL 12 o superior

## Configuración del Proyecto

### 1. Configurar Base de Datos
1. Crear una base de datos PostgreSQL
2. Configurar las credenciales en `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_base_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 2. Compilar y Ejecutar
```bash
mvn clean install
mvn spring-boot:run
```

## Estructura del Proyecto
```
src/main/java/com/jechavarria/api_restfull_movies/
├── controllers/     # Controladores REST
├── services/        # Lógica de negocio
├── repository/      # Acceso a datos
├── models/          # Entidades y DTOs
│   ├── entity/     # Entidades JPA
│   └── dtos/       # Objetos de transferencia de datos
├── mapper/         # Mapeo entre entidades y DTOs
├── exceptions/     # Manejo de excepciones
└── config/         # Configuraciones de la aplicación
```

## Modelo de Datos

### Película (Movie)
- `id`: Long (Identificador único)
- `title`: String (Título de la película)
- `director`: String (Director)
- `genre`: String (Género)
- `releaseYear`: Integer (Año de lanzamiento)
- `imdbRating`: Double (Calificación IMDB)

## Endpoints de la API

### Películas
- `GET /api/movies` - Obtener todas las películas
- `GET /api/movies/{id}` - Obtener una película por ID
- `GET /api/movies?director={nombre}` - Buscar películas por director
- `GET /api/movies?genre={genero}` - Buscar películas por género
- `POST /api/movies/create` - Crear una nueva película
- `PUT /api/movies/update/{id}` - Actualizar una película existente
- `DELETE /api/movies/delete/{id}` - Eliminar una película

## Pruebas de la API

### 1. Crear una Película
```http
POST http://localhost:8081/api/movies/create
Content-Type: application/json

{
    "title": "El Paseo",
    "director": "Dago García",
    "genre": "Comedy",
    "year_released": 2010,
    "imdb_score": 7.2
}
```

### 2. Obtener una Película por ID
```http
GET http://localhost:8081/api/movies/1
```

### 3. Obtener Todas las Películas
```http
GET http://localhost:8081/api/movies
```

### 4. Buscar Películas por Director
```http
GET http://localhost:8081/api/movies?director=james
```

### 5. Buscar Películas por Género
```http
GET http://localhost:8081/api/movies?genre=Action
```

### 6. Actualizar una Película
```http
PUT http://localhost:8081/api/movies/update/1
Content-Type: application/json

{
    "title": "Aquaman",
    "director": "James Wan",
    "genre": "Action",
    "year_released": 2018,
    "imdb_score": 6.8
}
```

### 7. Eliminar una Película
```http
DELETE http://localhost:8081/api/movies/delete/2
```

> **Nota**: Todas las pruebas están configuradas para ejecutarse en `localhost:8081`. Asegúrate de que tu aplicación esté corriendo en este puerto o ajusta las URLs según corresponda.

## Ejemplo de Uso

### Crear una Película
```bash
curl -X POST http://localhost:8080/api/movies \
-H "Content-Type: application/json" \
-d '{
    "title": "Inception",
    "director": "Christopher Nolan",
    "genre": "Ciencia Ficción",
    "releaseYear": 2010,
    "imdbRating": 8.8
}'
```

## Características
- Validación de datos
- Manejo de excepciones personalizado
- Documentación de API
- Soporte para operaciones CRUD
- Persistencia de datos con JPA/Hibernate

## Contribución
1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia
Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## Contacto
Jorge Andrés Echavarría Pardo - [@jorge0827](https://github.com/Jorge0827)

Link del Proyecto: [https://github.com/Jorge0827/api-restfull-movies](https://github.com/Jorge0827/api-restfull-movies) 