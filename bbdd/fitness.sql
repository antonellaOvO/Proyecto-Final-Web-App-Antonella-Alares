CREATE DATABASE fitness;
USE fitness;

CREATE TABLE Usuarios (
id_usuario INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(45) NOT NULL,
apellido VARCHAR(45) NOT NULL,
edad INT NOT NULL,
telefono INT NOT NULL UNIQUE,
email VARCHAR(100) NOT NULL UNIQUE,
fechaCreacion_usuario DATETIME DEFAULT NOW(),
fechaBaja_usuario DATETIME DEFAULT NOW(),
PRIMARY KEY (id_usuario)
);


drop table Usuarios;
SELECT * FROM Usuarios;
-- set foreign_key_checks = 1;





CREATE TABLE Rutinas (
id_rutina INT AUTO_INCREMENT,
id_usuario INT,
objetivo_rutina VARCHAR(100),
ejercicio1  INT,
ejercicio2  INT,
fechaCreacion_rutina DATETIME DEFAULT NOW(),
PRIMARY KEY (id_rutina),
FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);


drop table Rutinas;
truncate table Rutinas;
SELECT * FROM Rutinas;

CREATE TABLE Ejercicios (
id_ejercicio INT AUTO_INCREMENT,
objetivo VARCHAR(200),
nombre VARCHAR(100),
imagen  VARCHAR(800),
video  VARCHAR(800),
PRIMARY KEY (id_ejercicio)
);


drop table Ejercicios;
truncate table Ejercicios;
SELECT * FROM Ejercicios;

CREATE TABLE EjerciciosPracticados (
id_ejercicioPracticado INT AUTO_INCREMENT,
nombre VARCHAR(200),
repeticiones INT,
duracion DOUBLE,
PRIMARY KEY (id_ejercicioPracticado)
);


drop table EjerciciosPracticados;
truncate table EjerciciosPracticados;
SELECT * FROM EjerciciosPracticados;

CREATE TABLE SesionesEntrenamiento (
id_sesion INT AUTO_INCREMENT,
id_usuario INT,
id_EjercicioPracticado1 INT,
id_EjercicioPracticado2  INT,
id_EjercicioPracticado3  INT,
fechaCreacion_sesion DATETIME DEFAULT NOW(),
PRIMARY KEY (id_sesion)
);


drop table SesionesEntrenamiento;
truncate table SesionesEntrenamiento;
SELECT * FROM SesionesEntrenamiento;




CREATE TABLE AlimentosAgregados (
nombre_planning VARCHAR(900),
id_usuario int,
id_alimento INT AUTO_INCREMENT,
nombre_alimento VARCHAR(400),
cantidad  INT,
calorias  DOUBLE,
proteinas DOUBLE, 
datos_adicionales VARCHAR(900),
PRIMARY KEY (id_alimento),
FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)

);

drop table AlimentosAgregados;
truncate table AlimentosAgregados;
SELECT * FROM AlimentosAgregados;








-- FIXED INSERTED VALUES from BBDD:

-- EJERCICIOS (estos son valores fijos- no modificar nunca!!)
-- PERDER PESO: (ya insertados)
INSERT INTO Ejercicios (nombre, objetivo, imagen, video) VALUES 
('Abdominales con Roller', 'Perder Peso', 'abdominales-con-roller.png', 'https://www.youtube.com/embed/qCPB3h2U1eY?si=W_-VelCMjZz3w7QR'),
('Mountain Climber', 'Perder Peso', 'mountain-climber.png', 'https://www.youtube.com/embed/L3i_8RTKmtc?si=JYX0kgewX-RqlhYK'); 

-- MEJORAR SALUD DIGESTIVA: (ya insertados)
INSERT INTO Ejercicios (nombre, objetivo, imagen, video) VALUES 
('Sombra de boxeo', 'Mejorar Salud digestiva', 'sombra-de-boxeo.png', 'https://www.youtube.com/embed/CcO4FqvT_dM?si=breerSKPyCr8OoB7'),
('Skipping', 'Mejorar Salud digestiva', 'carrera-en-el-sitio-o-skipinng.png', 'https://www.youtube.com/embed/iBpgkuFuENY?si=rUNqeaaRLQoyuKEA'); 

-- MEJORAR RESISTENCIA CARDIOVASCULAR (ya insertados):
INSERT INTO Ejercicios (nombre, objetivo, imagen, video) VALUES 
('Flexión de caderas', 'Mejorar Resistencia Cardiovascular', 'flexion-cadera.png', 'https://www.youtube.com/embed/r4tewUf5CRs?si=yPWATvP9MaOV4pK-'),
('Jumping Jack', 'Mejorar Resistencia Cardiovascular', 'jumping-jack.png', 'https://www.youtube.com/embed/Zu0wqnT6Zow?si=z_lOQPU65BRWVjn_');

-- AUMENTAR FUERZA MUSCULAR (ya insertados):
INSERT INTO Ejercicios (nombre, objetivo, imagen, video) VALUES 
('Kettlebell : El molino', 'Aumentar Fuerza Muscular', 'kettlebell-el-molino.png', 'https://www.youtube.com/embed/FzzMq9XYO3s?si=w7ak1FNRSFs89U5u'),
('Peso muerto + curl biceps', 'Aumentar Fuerza Muscular', 'peso-muerto.jpeg', 'https://www.youtube.com/embed/HeIhpN9N0GQ?si=QkUmCZnkHun_-oig');

-- AUMENTAR FUERZA MUSCULAR (ya insertados):
INSERT INTO Ejercicios (nombre, objetivo, imagen, video) VALUES 
('Media sentadilla', 'Mejorar Glúteos', 'media-sentadilla.png', 'https://www.youtube.com/embed/3-C_8dqE7-0?si=Zrn3RR1ms1Nlb_Je'),
('Plancha y flexión', 'Mejorar Glúteos', 'plancha-con-salto.png', 'https://www.youtube.com/embed/R-zQU5zpTp8?si=wkmsiyz8LFB8wgCE');
 
 -- MARCAR Y DEFINICAR (ya insertados):
 INSERT INTO Ejercicios (nombre, objetivo, imagen, video) VALUES 
('Encogimientos a rodilla', 'Marcar y Definir', 'encogimientos.png', 'https://www.youtube.com/embed/-EQ5PM-ReKE?si=kytJfRzEFbiEfUmW'),
('Burpee', 'Marcar y Definir', 'burpee.png', 'https://www.youtube.com/embed/cWEs3-ZEXVc?si=Iy88JJB6N_Qe69r2');
 



-- Query para poder obtener los datos de rutinas y sus respectivos ejercicios de un usuario por su teléfono

SELECT 
    u.*,
    r.id_rutina,
    r.objetivo_rutina,
    e1.nombre AS ejercicio1_nombre,
    e1.objetivo AS ejercicio1_objetivo,
    e1.imagen AS ejercicio1_imagen,
    e1.video AS ejercicio1_video,
    e2.nombre AS ejercicio2_nombre,
    e2.objetivo AS ejercicio2_objetivo,
    e2.imagen AS ejercicio2_imagen,
    e2.video AS ejercicio2_video
FROM Usuarios u
JOIN Rutinas r ON u.id_usuario = r.id_usuario
LEFT JOIN Ejercicios e1 ON r.ejercicio1 = e1.id_ejercicio
LEFT JOIN Ejercicios e2 ON r.ejercicio2 = e2.id_ejercicio
WHERE u.telefono = 876123456;

-- Query para encontrar el número de rutinas y el número de Sesiones de Entrenamiento por un usuario:
SELECT COUNT(*) FROM Rutinas r WHERE r.id_usuario = 1;
SELECT COUNT(*) FROM SesionesEntrenamiento s WHERE s.id_usuario=1;

-- Query para encontrar el número de Food Plannings que tiene un usuario determinado:
SELECT COUNT(DISTINCT nombre_planning)
FROM AlimentosAgregados
WHERE id_usuario = 1;


-- Query para ver todas las sesiones de entrenamiento de un usuario (incluyendo los datos de cada uno de los ejercicios por sesión) con un determinado número de teléfono:

SELECT se.*, ep1.nombre AS nombre_ejercicio1, ep1.repeticiones AS repeticiones_ejercicio1, ep1.duracion AS duracion_ejercicio1,
              ep2.nombre AS nombre_ejercicio2, ep2.repeticiones AS repeticiones_ejercicio2, ep2.duracion AS duracion_ejercicio2,
              ep3.nombre AS nombre_ejercicio3, ep3.repeticiones AS repeticiones_ejercicio3, ep3.duracion AS duracion_ejercicio3
FROM SesionesEntrenamiento se
JOIN EjerciciosPracticados ep1 ON se.id_EjercicioPracticado1 = ep1.id_ejercicioPracticado
JOIN EjerciciosPracticados ep2 ON se.id_EjercicioPracticado2 = ep2.id_ejercicioPracticado
JOIN EjerciciosPracticados ep3 ON se.id_EjercicioPracticado3 = ep3.id_ejercicioPracticado
JOIN Usuarios u ON se.id_usuario = u.id_usuario
WHERE u.telefono = 876123456;

-- Query para seleccionar los FoodPlannings de un usuario determinado
SELECT ua.*, u.*
FROM AlimentosAgregados AS ua
JOIN Usuarios AS u ON ua.id_usuario = u.id_usuario
WHERE u.telefono = 876123456; 

-- Query para seleccionar los FoodPlannings de un usuario determinado con NombrePlanning determinado:
SELECT ua.*, u.*
FROM AlimentosAgregados AS ua
JOIN Usuarios AS u ON ua.id_usuario = u.id_usuario
WHERE u.telefono = 876123456
AND ua.nombre_planning = 'Mi Planning';

-- Query para seleccionar los FoodPlannings de un usuario determinado:
SELECT ua.*, u.*
FROM AlimentosAgregados AS ua
JOIN Usuarios AS u ON ua.id_usuario = u.id_usuario
WHERE u.telefono = 876123456;


commit;
