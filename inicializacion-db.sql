--- ESTRUCTURAS DE DATOS PARA MODELO SIMPLIFICADO DE "Alumno inscriptos en varios cursos de una carrera" ----

drop table inscripciones_curso;
drop table inscripciones_carrera;
drop table curso;
drop table carrera;
drop table alumno;
drop table persona;


CREATE TABLE persona (
    identificador  integer PRIMARY KEY NOT NULL,
    tipodoc        char(5) NOT NULL,
    documento 	    bigint NOT NULL,    
    nombre       varchar(40) NOT NULL,
    apellido       varchar(40) NOT NULL,
    fechanac		date NOT NULL
);


CREATE TABLE alumno (
    identificador  integer PRIMARY KEY NOT NULL,
    idpersona	    integer REFERENCES persona (identificador) UNIQUE,
    legajo 	    integer NOT NULL
);


   
CREATE TABLE carrera (
    identificador  integer PRIMARY KEY NOT NULL,
    nombre       varchar(40) NOT NULL,
    descripcion      varchar(250),
    fechadesde		date NOT NULL,
    fechahasta 	date
);

    

CREATE TABLE curso (
    identificador  integer PRIMARY KEY NOT NULL,
    idcarrera 		integer REFERENCES carrera (identificador),
    nombre       varchar(40) NOT NULL,
    descripcion      varchar(250),
    cupomaximo 	smallint NOT NULL,
    anio			smallint NOT NULL    
);


CREATE TABLE inscripciones_carrera(
    idalumno 		integer REFERENCES alumno (identificador) NOT NULL,
    idcarrera		integer REFERENCES carrera (identificador) NOT NULL,
    fechainscripcion	date NOT NULL
);

CREATE TABLE inscripciones_curso(
    idalumno 		integer REFERENCES alumno (identificador) NOT NULL,
    idcurso 		integer REFERENCES curso (identificador) NOT NULL,
    fechainscripcion	date NOT NULL
);


----- Insert de datos iniciales persona
   INSERT INTO persona VALUES
    (1,'DNI', 31565839, 'Florencia', 'Maneiro', '1985-06-28');
   INSERT INTO persona VALUES
    (2,'DNI', 31000123, 'Patricia', 'Brumatti', '1985-01-13');
    INSERT INTO persona VALUES
    (3,'DNI', 20945422, 'Diego', 'Menendez', '1982-04-10');   
    INSERT INTO persona VALUES
    (4,'DNI', 30999281, 'Franzo', 'Perez', '1986-02-05');
    INSERT INTO persona VALUES
    (5,'DNI', 24112872, 'Leandro', 'Garcia', '1988-01-03');
    
----- Insert de datos iniciales alumno
   INSERT INTO alumno VALUES
    (1,3, 98734);
   INSERT INTO alumno VALUES
    (2,4, 09213);
   INSERT INTO alumno VALUES
    (3,1, 35839);
   INSERT INTO alumno VALUES
    (4,5, 36299);
   INSERT INTO alumno VALUES
    (5,2, 11009);
    
----- Insert de datos iniciales carrera

   INSERT INTO carrera VALUES
    (1,'Ingenieria en sistema de información', 'Carrera a fines a programación y desarrollo de software en general','1960-01-01');

   INSERT INTO carrera VALUES
    (2,'Ingenieria civil', 'Carrera a fines a construcción, planificación y desarrollo de obras de desarrollo urbano','1980-01-01');


----- Insert de datos iniciales curso


   INSERT INTO curso VALUES
    (1,1,'Análisis matemático', 'Curso sobre el desarrollo avanzado de matemáticas', 5,2018);
    
  INSERT INTO curso VALUES
    (2,1,'Diseño de sistemas', 'Curso sobre diseño de componentes de sistemas de software', 3,2018);

  INSERT INTO curso VALUES
    (3,1,'Java', 'Curso sobre el lenguaje de programación JAVA', 4,2018);

  INSERT INTO curso VALUES
    (4,1,'Base de datos-SQL', 'Curso sobre tipos de base de datos y consultas sql', 10,2018);

  INSERT INTO curso VALUES
    (5,2,'Fisica básica', 'Curso sobre fundamentos base de física', 5,2018);

  INSERT INTO curso VALUES
    (6,2,'Dibujo', 'Curso sobre dibujo de planos', 10,2018);
    

----- Insert de datos iniciales inscripciones

INSERT INTO inscripciones_carrera VALUES
(1,1,'2000-01-01');
INSERT INTO inscripciones_carrera VALUES
(2,1,'2003-01-01');
INSERT INTO inscripciones_carrera VALUES
(3,1,'2004-01-01');
INSERT INTO inscripciones_carrera VALUES
(4,1,'2001-01-01');

INSERT INTO inscripciones_carrera VALUES
(5,2,'2000-01-01');
INSERT INTO inscripciones_carrera VALUES
(4,2,'2000-01-01');


INSERT INTO inscripciones_curso VALUES
(1,1,'2002-01-01');
INSERT INTO inscripciones_curso VALUES
(1,2,'2006-01-01');
INSERT INTO inscripciones_curso VALUES
(1,3,'2002-01-01');
INSERT INTO inscripciones_curso VALUES
(2,1,'2004-01-01');
INSERT INTO inscripciones_curso VALUES
(2,3,'2002-01-01');
INSERT INTO inscripciones_curso VALUES
(2,4,'2004-01-01');
INSERT INTO inscripciones_curso VALUES
(3,1,'2010-01-01');
INSERT INTO inscripciones_curso VALUES
(3,3,'2010-01-01');
INSERT INTO inscripciones_curso VALUES
(4,1,'2010-01-01');
INSERT INTO inscripciones_curso VALUES
(4,3,'2010-01-01');
INSERT INTO inscripciones_curso VALUES
(5,3,'2010-01-01');

INSERT INTO inscripciones_curso VALUES
(4,3,'2010-01-01');
INSERT INTO inscripciones_curso VALUES
(5,4,'2011-01-01');
INSERT INTO inscripciones_curso VALUES
(4,4,'2011-01-01');
INSERT INTO inscripciones_curso VALUES
(2,5,'2011-01-01');
INSERT INTO inscripciones_curso VALUES
(2,6,'2011-01-01');

alter table inscripciones_curso add column nota DECIMAL default 0;
alter table curso add column iddocente integer REFERENCES persona (identificador);

INSERT INTO persona VALUES
    (7,'DNI', 14112872, 'Jorge', 'Martinez', '1971-12-13');


INSERT INTO persona VALUES
    (8,'DNI', 14112872, 'Leandro', 'Ramirez', '1972-10-03');


INSERT INTO persona VALUES
    (9,'DNI', 14112872, 'Luis', 'Artusi', '1928-11-04');


INSERT INTO persona VALUES
    (10,'CIVIC', 4112888, 'Jazmin', 'Lopez', '1948-01-03');

UPDATE curso SET iddocente = 7 WHERE identificador = 1;
UPDATE curso SET iddocente = 8 WHERE identificador = 2;
UPDATE curso SET iddocente = 9 WHERE identificador = 3;
UPDATE curso SET iddocente = 10 WHERE identificador = 4;
UPDATE curso SET iddocente = 7 WHERE identificador = 5;
UPDATE curso SET iddocente = 10 WHERE identificador = 6;

CREATE SEQUENCE persona_id_seq MINVALUE 10;
CREATE SEQUENCE alumno_id_seq MINVALUE 6;

ALTER TABLE persona ALTER identificador SET DEFAULT nextval('persona_id_seq');
ALTER SEQUENCE persona_id_seq OWNED BY persona.identificador;

ALTER TABLE alumno ALTER identificador SET DEFAULT nextval('alumno_id_seq');
ALTER SEQUENCE alumno_id_seq OWNED BY alumno.identificador;