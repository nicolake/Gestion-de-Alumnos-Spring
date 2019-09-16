# Sistema de gestion de alumnos
## IT CHALLENGE JAVA de Tecso.

Utilizando Spring Framework.

Consigna:
Desarrollar una aplicación, puede ser en cualquier lenguaje y tanto una aplicación web o de escritorio o simplemente una aplicación que requiera ingreso de datos por consola, que:

1. Registre y edite alumnos en el modelo de base de datos anterior.
2. Provea los siguientes reportes:
    - Estado académico de un alumno dado (inscripciones actuales a carreras y cursos,  estado de cursos anteriores, promedio general por carrera tomando los cursos ya aprobados)
    - Para una asignatura(curso) dado, los alumnos inscriptos y el docente correspondiente.
3. Permita a un alumno inscribirse a una materia.
(para esto se deberán realizar los cambios que crean convenientes en el modelo de datos provisto en el paso 1)

### Descripcion
Spring boot + postgresql + thymeleaf + intelliJ IDEA

### Instrucciones
1. Correr el script SQL.
2. Editar el archivo application.properties con los datos de la base de datos.
3. Ejecturar y entrar al navegador a localhost:8080

### Docker
1. generar la imagen de docker: ./mvnw install dockerfile:build
2. Para correr la imagen: docker run -p 8080:8080 -t nicolake/sistema-alumnos:latest