![image](https://github.com/user-attachments/assets/fbcab021-6a6e-4ba0-9975-fa8885669782)


Desarrollar una aplicación web que ofrezca a los usuarios una plataforma integral para gestionar y realizar seguimiento de productos pertenecientes a una empresa.  
Esta aplicación web está diseñada para proporcionar a los usuarios una solución completa que facilite la gestión de su propio inventario. 
Este sistema permite gestionar información clave de productos, como precios, IVA, disponibilidad, fechas de adquisición y caducidad, y automatizar ciertos procesos de introducción de datos. 
Al cumplir con estos objetivos, se espera garantizar una interacción y administración más fluida sobre los datos de los productos que pueda llegar a disponer una empresa.


# Funcionalidades principales:
Este sistema de inventario tiene las siguientes funcionalidades, las cuales se pueden agrupar en las siguientes secciones:
## ✓	Registro Productos:
        o	Facilitar el registro de productos en el sistema de inventario a través de un formulario intuitivo y seguro donde los usuarios pueden introducir los datos sobre un producto en concreto que deseen incorporar en el inventario.
## ✓	Modificación Productos:
        o	 Desarrollar un formulario que permita a los usuarios obtener los datos de un producto determinado y poder modificar esos datos. 

## ✓	Consultas de datos de Productos:
      o	Los usuarios pueden disponer de una vista de inventario en tiempo real y consultar los datos de un producto determinado como por ejemplo:
      o Mantener un control preciso del stock disponible en tiempo real.
## ✓	Cálculos sobre datos de Productos:
      o	Los usuarios pueden obtener cálculos sobre un producto determinado y gestionar precios e IVA para cada producto.
## ✓	Dar de baja a Productos:
      o	Facilitar el seguimiento de productos y poder dar de baja a éstos. También el proceso inverso, fácil acceso a revertir esta acción.
## ✓	Historial de Cambios:
      o	Registro de actualizaciones de productos, cambios en el estado de disponibilidad y fecha de baja cuando un producto es desactivado.



# Público objetivo:
El sistema está diseñado para empresas que necesitan gestionar un inventario, como tiendas en línea, almacenes, y minoristas, facilitando su administración y mejorando la eficiencia del control de existencias. A continuación, se detallan distintos perfiles de usuarios más probables que podrían beneficiarse de esta aplicación:
## ↬	Administradores de inventario
      •	Necesidades a cubrir: Mantener un control eficiente sobre el stock, evitar faltantes o excesos de productos y optimizar los costos de almacenamiento.
## ↬	Supervisores de Almacén
      •	Necesidades a cubrir: Asegurar que los productos estén disponibles, identificar rápidamente el stock disponible y facilitar el flujo eficiente de mercancías.

## ↬	Gerentes de Compras
      •	Necesidades a cubrir: Optimizar las compras, evitar el agotamiento de inventario y asegurar la calidad de los productos adquiridos
## ↬	Contabilidad y personal de Finanzas:
      •	Necesidades a cubrir: Calcular el valor exacto del inventario para fines financieros, calcular impuestos y realizar ajustes contables.



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
