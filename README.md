# Proyecto-Final-Web-App-Antonella-Alares

## Configuraciones necesarias:
  Al abrir el repositorio del proyecto, habrán 2 carpetas: la “BBDD” -base de datos-  y  “Fitness Project Java” - la carpeta contenedora del proyecto creado en NetBeans- :
  #### Configuración de la Base de Datos MySQL:
    1.	Iniciar el Servidor MySQL: 
    o	Abrir MySQL Workbench
    o	Conectarse al servidor en MySQL : Asegurarse de que el servidor MySQL esté en ejecución.
    2.	Crear la Base de Datos y Tablas en MySQL: 
    o	Abrir el SQL Script “fitness” ubicado en la carpeta de “bbdd”.
    o	Ejecutar este script SQL para crear la base de datos y las tablas necesarias.
  
  
  
  #### Configuración del Proyecto en NetBeans con Spring Boot:
    1. Abrir NetBeans.
    2. Abrir el proyecto Java en NetBeans ubicado en la carpeta: “Fitness Project Java”.
    3. Una vez abierto el proyecto en NetBeans: 
    o	Configurar el Archivo application.properties, modificando sólo las líneas siguientes, de esta forma configuramos las credenciales de la base de datos:
    spring.datasource.url=jdbc:mysql://localhost:3306/fitness (Indicar la ruta del servidor de tu base de datos y el nombre de tu base de datos)
    spring.datasource.username=tu_usuario  (Indicar nombre de usuario del servidor de tu base de datos)
    spring.datasource.password=tu_contraseña (Indicar contraseña del servidor de tu base de datos)
    o	Configurar el Archivo pom.xml: asegurarse que contiene las dependencias necesarias para Spring Boot y MySQL (en sí no hay que modificar nada).



## Instrucciones para el despliegue de la aplicación en un entorno local:
  A continuación del apartado anterior:
  Ejecución de la Aplicación:
  o	Compilar el Proyecto en Netbeans: Seleccionar Clean and Build.
  o	Ejecutar la Aplicación: Seleccionar Run.
  o	Verificar la Aplicación: Abrir un navegador web y navegar a http://localhost:8080 o la ruta que se tenga por defecto en NetBeans. Verificar que la aplicación se esté ejecutando correctamente.
