DROP TABLE IF EXISTS TBL_EMPLOYEES,TBL_COURSES, TBL_CONSTANCY, TBL_TAKECOURSES;
 
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  phone VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);


CREATE TABLE TBL_COURSES (
  idC INT AUTO_INCREMENT  PRIMARY KEY,
  nombre_curso VARCHAR(250) NOT NULL,
  descripcion_curso VARCHAR(250) NOT NULL,
  duracion_curso VARCHAR (250) NOT NULL,
  url_curso VARCHAR (250) NOT NULL
);


CREATE TABLE TBL_CONSTANCY (
  idCons INT AUTO_INCREMENT  PRIMARY KEY,
  name_Employee VARCHAR(250) NOT NULL,
  name_Course VARCHAR(250) NOT NULL,
  date_Cons VARCHAR (250) NOT NULL,
  img BINARY,
  str VARCHAR(250) NOT NULL,
  estado_Curso BOOLEAN

);

CREATE TABLE TBL_TAKECOURSES (
  idTC INT AUTO_INCREMENT  PRIMARY KEY,
  id_employee INT,
  id_courses INT,
  Date VARCHAR (250) NOT NULL

);