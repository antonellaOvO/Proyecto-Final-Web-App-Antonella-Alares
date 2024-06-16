/*AUTORA:ANTONELLA ALARES*/
let formTwo = document.getElementById("formTwo");
let timers = {};

function startTimer(fieldId) {
    if (!timers[fieldId]) {
        timers[fieldId] = {
            startTime: Date.now(),
            accumulatedTime: 0
        };
    } else {
        timers[fieldId].startTime = Date.now();
    }
}

function stopTimer(fieldId) {
    if (timers[fieldId]) {
        let now = Date.now();
        let elapsedTime = now - timers[fieldId].startTime;
        timers[fieldId].accumulatedTime += elapsedTime;
        let totalTimeInSeconds = timers[fieldId].accumulatedTime / 1000;
        document.getElementById(fieldId).value = totalTimeInSeconds.toFixed(2);
    }
}

function redireccionar(event) {
  event.preventDefault();

  // Obtener el número de teléfono del usuario
  let telefonoUsuario = document.getElementById("telefono-control-form").value;

  // Solicitar el ID del usuario basado en su teléfono
  fetch(`/usuarios/telefono?telefono=${telefonoUsuario}`)
    .then(response => {
      if (!response.ok) {
        console.error('Error al obtener el ID del usuario:', response);
        throw new Error('Error al obtener el ID del usuario');
      }
      return response.json();
    })
    .then(usuario => {
        if (!usuario || !usuario.idUsuario) {
                // Mostrar mensaje de error si no se encuentra el usuario
                let errorMessage = document.getElementById("error-telefono");
                errorMessage.textContent = "El número de teléfono introducido no pertenece a ningún usuario";
                throw new Error('Usuario no encontrado');
            }
      let idUsuario = usuario.idUsuario; //asociamos una variable que creamos al ID encontrado según el número de teléfono

      // Nombres ejercicios
      let inputEjercicioOne = document.getElementById("ejercicioOne").value;
      let inputEjercicioTwo = document.getElementById("ejercicioTwo").value;
      let inputEjercicioThree = document.getElementById("ejercicioThree").value;
  
      // Repeticiones ejercicios
      let inputRepeticionOne = document.getElementById("repeticionOne").value;
      let inputRepeticionTwo = document.getElementById("repeticionTwo").value;
      let inputRepeticionThree = document.getElementById("repeticionThree").value;
  
      // Duraciones ejercicios
      let duracionOne = document.getElementById("duracionOne").value;
      let duracionTwo = document.getElementById("duracionTwo").value;
      let duracionThree = document.getElementById("duracionThree").value;
  
      // Log de los datos recogidos
      console.log("Datos recogidos:");
      console.log({ inputEjercicioOne, inputEjercicioTwo, inputEjercicioThree });
      console.log({ inputRepeticionOne, inputRepeticionTwo, inputRepeticionThree });
      console.log({ duracionOne, duracionTwo, duracionThree });
  
      // Construir objetos para cada ejercicio, es decir, un objeto por ejercicio
      let ejercicio1 = {
        nombre: inputEjercicioOne,
        repeticiones: inputRepeticionOne,
        duracion: duracionOne
      };

      let ejercicio2 = {
        nombre: inputEjercicioTwo,
        repeticiones: inputRepeticionTwo,
        duracion: duracionTwo
      };

      let ejercicio3 = {
        nombre: inputEjercicioThree,
        repeticiones: inputRepeticionThree,
        duracion: duracionThree
      };
  
      // Log de los objetos ejercicio
      console.log("Objetos ejercicio construidos:");
      console.log(ejercicio1);
      console.log(ejercicio2);
      console.log(ejercicio3);
  
      // Guardar ejercicios primero y luego la sesión
      return Promise.all([
        fetch('/api/ejerciciosPracticados', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(ejercicio1)
        }).then(response => {
          if (!response.ok) {
            console.error('Error en la solicitud de ejercicio 1:', response);
            throw new Error('Error en la solicitud de ejercicio 1');
          }
          return response.json();
        }),

        fetch('/api/ejerciciosPracticados', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(ejercicio2)
        }).then(response => {
          if (!response.ok) {
            console.error('Error en la solicitud de ejercicio 2:', response);
            throw new Error('Error en la solicitud de ejercicio 2');
          }
          return response.json();
        }),

        fetch('/api/ejerciciosPracticados', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(ejercicio3)
        }).then(response => {
          if (!response.ok) {
            console.error('Error en la solicitud de ejercicio 3:', response);
            throw new Error('Error en la solicitud de ejercicio 3');
          }
          return response.json();
        })
      ]).then(values => {
        let ejercicio1 = values[0];
        let ejercicio2 = values[1];
        let ejercicio3 = values[2];

        // Log de los objetos ejercicio con IDs
        console.log("Ejercicios registrados:");
        console.log(ejercicio1);
        console.log(ejercicio2);
        console.log(ejercicio3);

        let sesion = {
          idUsuario: idUsuario, // Usar el ID de usuario obtenido
          ejercicio1: ejercicio1,
          ejercicio2: ejercicio2,
          ejercicio3: ejercicio3,
          fechaCreacion: new Date().toISOString()
        };

        // Log de los datos de la sesión a enviar
        console.log('Datos de la sesión a enviar:', sesion);

        return fetch('/api/sesiones', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(sesion)
        });
      });
    })
    .then(response => {
      if (!response.ok) {
        console.error('Error en la solicitud de sesión:', response);
        throw new Error('Error en la solicitud de sesión');
      }
      return response.json();
    })
    .then(data => {
      console.log('Sesión registrada:', data);
      // Construir URL parametros
      var urlParams = new URLSearchParams();
      urlParams.append("ejercicioOne", document.getElementById("ejercicioOne").value);
      urlParams.append("ejercicioTwo", document.getElementById("ejercicioTwo").value);
      urlParams.append("ejercicioThree", document.getElementById("ejercicioThree").value);
      urlParams.append("repeticionOne", document.getElementById("repeticionOne").value);
      urlParams.append("repeticionTwo", document.getElementById("repeticionTwo").value);
      urlParams.append("repeticionThree", document.getElementById("repeticionThree").value);

      // Redirigir a la página resultante con los Parámetros
      window.location.href = "feedback-control.html?" + urlParams.toString();
    })
    .catch(error => {
      console.error('Error:', error);
      
    });
}

formTwo.addEventListener("submit", redireccionar);

// Para reproducir o pausar video
let video = document.getElementById("myVideo");
function playVid() {
  video.play();
}

function pauseVid() {
  video.pause();
}
