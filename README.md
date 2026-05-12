# Suite de Pruebas con JUnit 5, Mockito y JaCoCo

Programación Web — Unidad 10: Pruebas de Software en Aplicaciones Web
Universidad de Santander (UDES) — Ingeniería de Sistemas 2026

## Descripción

Aplicación web desarrollada con Spring Boot para la gestión de tareas. El proyecto implementa pruebas automatizadas utilizando JUnit 5, Mockito, @WebMvcTest y @DataJpaTest. Además, se configuró JaCoCo para medir y verificar la cobertura de código de la aplicación.

La aplicación permite crear tareas, consultarlas por ID y marcarlas como completadas. Las pruebas cubren la capa de servicio, controlador y repositorio utilizando una base de datos H2 en memoria.

```

## Estructura del proyecto

tareas/
├── src/main/java/com/tareas/tareas/
│   ├── controller/
│   │   └── TareaController.java
│   ├── entity/
│   │   └── Tarea.java
│   ├── repository/
│   │   └── TareaRepository.java
│   ├── service/
│   │   └── TareaService.java
│   └── TareasApplication.java
│
├── src/test/java/com/tareas/tareas/
│   ├── controller/
│   │   └── TareaControllerTest.java
│   ├── repository/
│   │   └── TareaRepositoryTest.java
│   └── service/
│       └── TareaServiceTest.java
│
├── target/site/jacoco/
│   └── index.html
│
└── pom.xml

```
## Tecnologías utilizadas

* Java 17
* Spring Boot 3.2.x
* Spring Web
* Spring Data JPA
* H2 Database
* JUnit 5
* Mockito
* JaCoCo
* Maven

---

## Prerrequisitos

* Java JDK 17 o superior
* Apache Maven 3.8+
* IntelliJ IDEA o Visual Studio Code
* Navegador web

---

## Configuración de la aplicación

La aplicación utiliza H2 Database en memoria para las pruebas, por lo que no es necesario instalar MySQL u otro gestor de bases de datos.

Configuración principal utilizada automáticamente por Spring Boot:

spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create-drop

---

## Ejecución del proyecto

Ejecutar en la terminal:

mvn spring-boot:run

Abrir en navegador:

http://localhost:8080

---

## Endpoints implementados

Obtener tarea por ID:

GET /api/tareas/{id}

Crear tarea:

POST /api/tareas

Completar tarea:

PUT /api/tareas/{id}/completar

---

## Pruebas implementadas

### TareaServiceTest

* crear_conTituloValido_guardaYRetorna
* crear_conTituloVacio_lanzaIllegalArgumentException
* buscarPorId_noExiste_lanzaEntityNotFoundException
* completar_tareaExistente_marcaComoCompletada

### TareaControllerTest

* get_tareaExiste_retorna200
* get_noExiste_retorna404

### TareaRepositoryTest

* findByCompletada_false_retornaUnaTarea

---

## Ejecución de pruebas

Ejecutar todas las pruebas:

mvn test

Generar reporte JaCoCo:

mvn clean test

---

## Cobertura de código con JaCoCo

El reporte de cobertura se genera en:

target/site/jacoco/index.html

El proyecto verifica una cobertura mínima del 70 % utilizando jacoco-maven-plugin.

---

## Funcionalidades implementadas

* Gestión de tareas
* Validación de título obligatorio
* Manejo de excepciones
* Persistencia con JPA
* Pruebas unitarias con Mockito
* Pruebas web con MockMvc
* Pruebas JPA con H2 en memoria
* Medición de cobertura con JaCoCo

---

## Capturas de pantalla requeridas

* Reporte JaCoCo mostrando la cobertura de código, Cobertura mínima superior al 70 %
  <img width="1912" height="914" alt="msedge_2AnW06FPYl" src="https://github.com/user-attachments/assets/a3b2eabc-418f-4554-a4bd-17d1c59d155e" />

