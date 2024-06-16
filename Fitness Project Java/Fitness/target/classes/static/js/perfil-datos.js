/*AUTORA:ANTONELLA ALARES*/
document.addEventListener("DOMContentLoaded", function () {
    // Coger valores seleccionados
    var urlParams = new URLSearchParams(window.location.search);
    var telefono = urlParams.get("telefono");

    fetch(`/usuarios/usuario/conteo?telefono=${telefono}`)
        .then(response => {
            if (response.ok) {
                return response.text(); // Leer como texto en lugar de JSON
            } else {
                throw new Error("Usuario no encontrado");
            }
        })
        .then(userJson => {
            // Parsear el JSON manualmente
            var user = JSON.parse(userJson);
            console.log(user);
           
            // Encabezado Conteo
            document.getElementById("conteo-rutinas").textContent = user.rutinas;
            document.getElementById("conteo-entrenamientos").textContent = user.entrenamientos;
            document.getElementById("conteo-food").textContent = user.foodPlannings;
            
        })
        .catch(error => {
            console.error(error);
            // Manejar error: mostrar un mensaje al usuario, etc.
        });
        
    fetch(`/usuarios/telefono?telefono=${telefono}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Usuario no encontrado");
            }
        })
        .then(user => {
            //ENCABEZADO
            document.getElementById("bienvenida-nombre").textContent = user.nombre;
            document.getElementById("nombre-encabezado").textContent = user.nombre;
            document.getElementById("apellido-encabezado").textContent = user.apellido;
            document.getElementById("email-encabezado").textContent = user.email;
            //APARTADO DATOS
            document.getElementById("nombre").textContent = user.nombre;
            document.getElementById("apellido").textContent = user.apellido;
            document.getElementById("telefono").textContent = user.telefono;
            document.getElementById("edad").textContent = user.edad;
            
            // Obtener sesiones de entrenamiento del usuario
            getSesionesEntrenamiento(telefono);
            // Obtener Rutinas del usuario
            getRutinas(telefono);
            
            //Obtener Food Plannings del usuario
            getFoodPlannings(telefono);
        })
        .catch(error => {
            console.error(error);
            // Manejar error: mostrar un mensaje al usuario, etc.
        });

    // Función para obtener las sesiones de entrenamiento del usuario
    function getSesionesEntrenamiento(telefono) {
        fetch(`/api/sesiones/por-telefono?telefono=${telefono}`)
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Error al obtener las sesiones de entrenamiento del usuario");
                }
            })
            .then(sesiones => {
                // Mostrar las sesiones de entrenamiento en el HTML
                mostrarSesionesEntrenamiento(sesiones);
            })
            .catch(error => {
                console.error(error);
                // Manejar error: mostrar un mensaje al usuario, etc.
            });
    }

    // Función para mostrar las sesiones de entrenamiento en el HTML
    function mostrarSesionesEntrenamiento(sesiones) {
        console.log(sesiones); //para ver la estructura
        const container = document.getElementById('sesiones-entrenamiento-container');

        // Limpiar el contenido anterior
        container.innerHTML = '';

        // Iterar sobre cada sesión de entrenamiento y mostrarla en el HTML
        sesiones.forEach((sesion, index) => { /*index representa el índice de ese elemento en el array, es decir, de cada sesión*/
            let nombreEjercicio1 = `${sesion.ejercicio1.nombre}`;
            let nombreEjercicio2 = `${sesion.ejercicio2.nombre}`;
            let nombreEjercicio3 = `${sesion.ejercicio3.nombre}`;
            //Para transformar el nombre del Ejercicio con el formato: primeraletraMayúscula+ el resto en minúscula
            let nombreEjercicio1FormatoNuevo = nombreEjercicio1.charAt(0).toUpperCase() + nombreEjercicio1.slice(1).toLowerCase();
            let nombreEjercicio2FormatoNuevo = nombreEjercicio2.charAt(0).toUpperCase() + nombreEjercicio2.slice(1).toLowerCase();
            let nombreEjercicio3FormatoNuevo = nombreEjercicio3.charAt(0).toUpperCase() + nombreEjercicio3.slice(1).toLowerCase();
            
            const sesionHTML = `
        <table class="table table-bordered">
           <thead>
               <tr>
                   <th colspan="6" class="text-center">Sesión ${index + 1}</th>
               </tr>
           </thead>
           <tbody>
               <tr>
                   <th rowspan="3" scope="row">Ejercicio 1 - ${nombreEjercicio1FormatoNuevo}</th>
                   <td>Repeticiones Series</td>
                   <td>${sesion.ejercicio1.repeticiones}</td>
               </tr>
               <tr>
                   <td>Duración</td>
                   <td>${sesion.ejercicio1.duracion} ms</td>
               </tr>
               <tr></tr>
               <tr>
                   <th rowspan="3" scope="row">Ejercicio 2 - ${nombreEjercicio2FormatoNuevo}</th>
                   <td>Repeticiones Series</td>
                   <td>${sesion.ejercicio2.repeticiones}</td>
               </tr>
               <tr>
                   <td>Duración</td>
                   <td>${sesion.ejercicio2.duracion} ms</td>
               </tr>
               <tr></tr>
               <tr>
                   <th rowspan="3" scope="row">Ejercicio 3 - ${nombreEjercicio3FormatoNuevo}</th>
                   <td>Repeticiones Series</td>
                   <td>${sesion.ejercicio3.repeticiones}</td>
               </tr>
               <tr>
                   <td>Duración</td>
                   <td>${sesion.ejercicio3.duracion} ms</td>
               </tr>
           </tbody>
       </table>
       `;
            container.insertAdjacentHTML('beforeend', sesionHTML);
            /*insertAdjancentHTML toma 2 argumentos: 1- posición de inserción (especifica dónde se insertará el nuevo
             contenido con respecto al elemento de destino) en este caso "beforeend" indica que el nuevo contenido
             se agregará al final de lo que ya esté existente dentro del "container"// 2- el contenido HTML que se 
             va agregar*/
        });
    }
    
    // Función para obtener las sesiones de entrenamiento del usuario
    function getRutinas(telefono) {
       fetch(`/rutinas/por-telefono?telefono=${telefono}`)
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Error al obtener las rutinas del usuario");
                }
            })
            .then(rutinas => {
                 console.log(rutinas); //para ver la estructura
                // Mostrar las sesiones de entrenamiento en el HTML
                mostrarRutinas(rutinas);
            })
            .catch(error => {
                console.error(error);
                // Manejar error: mostrar un mensaje al usuario, etc.
            });
    
    }
    
     // Función para mostrar las sesiones de entrenamiento en el HTML
    function mostrarRutinas(rutinas) {
       
        //DATOS APARTADO RUTINAS
        const containerRutinas = document.getElementById('container-rutinas');
        
        

        // Iterar sobre cada rutina y mostrarla en el HTML
        rutinas.forEach((elemento, index) => { /*index representa el índice de ese elemento en el array, es decir, de cada elemento*/
            // Crear un nuevo elemento para la rutina
            console.log(elemento);
            const rutinaHTML = `
            <a href="#" class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover mb-5" data-objetivo="${elemento.rutina.objetivo}">Rutina ${elemento.rutina.objetivo}</a> <br />
            `;
            
        
        // Agregar la rutina al contenedor
        containerRutinas.insertAdjacentHTML('beforeend', rutinaHTML);
        });

        // Agregar event listeners a los enlaces
        const enlaces = containerRutinas.querySelectorAll('a');
        enlaces.forEach(enlace => {
            enlace.addEventListener('click', function(event) {
                event.preventDefault();
                const objetivo = this.getAttribute('data-objetivo');
                const url = `acceso-tu-rutina.html?objetivo=${encodeURIComponent(objetivo)}`;
                window.location.href = url;
            });
        });
    }
    
    
    // Función para obtener todos los Food Plannings del usuario
    function getFoodPlannings(telefono) {
        fetch(`/alimentos/por-telefono?telefono=${telefono}`)
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Error al obtener las sesiones de entrenamiento del usuario");
                }
            })
            .then(foodPlannings => {
                // Mostrar las sesiones de entrenamiento en el HTML
                mostrarFoodPlannings(foodPlannings);
            })
            .catch(error => {
                console.error(error);
                // Manejar error: mostrar un mensaje al usuario, etc.
            });
    }


// Función para mostrar los Food Plannings en el HTML
    function mostrarFoodPlannings(foodPlannings) {
        let currentPlanning = ""; // Inicialmente vacío
        let tableHTML = "";
        console.log(foodPlannings); //para ver la estructura
        const container = document.getElementById('food-plannings-container');

        // Iterar sobre cada foodPlanning
        foodPlannings.forEach((foodPlanning, index) => {
            if (foodPlanning.nombrePlanning !== currentPlanning) {
                // Si hay una tabla abierta, ciérrala
                if (tableHTML) {
                    tableHTML += `
                        </tbody>
                    </table>
                    `;
                    container.insertAdjacentHTML('beforeend', tableHTML);
                }
                // Iniciar una nueva tabla
                currentPlanning = foodPlanning.nombrePlanning; // Actualiza currentPlanning
                tableHTML = `
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th colspan="6" class="text-center">Food Planning ${currentPlanning}</th>
                            </tr>
                        </thead>
                        <tbody>
                `;
            }
            // Agregar filas a la tabla actual
            tableHTML += `
                <tr>
                    <th rowspan="4" scope="row">Alimento - ${foodPlanning.nombreAlimento}</th>
                    <td>Cantidad</td>
                    <td>${foodPlanning.cantidad}</td>
                </tr>
                <tr>
                    <td>Calorías</td>
                    <td>${foodPlanning.calorias} Kcal</td>
                </tr>
                <tr>
                    <td>Proteinas</td>
                    <td>${foodPlanning.proteinas} g</td>
                </tr>
                <tr>
                    <td>Datos Adicionales</td>
                    <td>${foodPlanning.datosAdicionales}</td>
                </tr>
            `;
        });

        // Cerrar la última tabla si hay alguna abierta
        if (tableHTML) {
            tableHTML += `
                </tbody>
            </table>
            `;
            container.insertAdjacentHTML('beforeend', tableHTML);
        }
    }
    
        
    
    
});


  



    