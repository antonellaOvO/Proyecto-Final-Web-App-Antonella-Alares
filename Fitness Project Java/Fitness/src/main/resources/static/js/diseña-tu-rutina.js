/*AUTORA:ANTONELLA ALARES*/
document.addEventListener("DOMContentLoaded", function () {
/*Este código es para el formulario para diseñar tu rutina*/

let formOne = document.getElementById("formOne");

function redireccionar(event) {
  event.preventDefault();
  
  

//Validar los distintos campos del formulario
  function validateForm() {
    let edad = document.getElementById("edad").value;
    let telefono = document.getElementById("telefono").value;
    if (isNaN(edad)) {
      let errorMessage = document.getElementById("error-edad");
      errorMessage.textContent = "El valor de edad debe contener sólo números";
      return false;
    } else if (edad < 13 || edad > 90) {
      let errorMessage = document.getElementById("error-edad");
      errorMessage.textContent =
        "El valor de edad debe contener sólo números de 13 a 90 años";
        return false;
    }else if (!/^\d{9}$/.test(telefono)) {
        let errorMessage = document.getElementById("error-telefono");
        errorMessage.textContent =
          "El número de teléfono debe contener exactamente 9 dígitos";
        return false;
      }else {
        let errorMessage = document.getElementById("error-telefono");
        errorMessage.textContent = ""; // Limpiar el mensaje de error
        return true; // Retorna verdadero para continuar con la redirección
      }
  }
  
  if (validateForm()) {
      let inputObjetivos = document.getElementById("objetivos").value;
      let inputFrecuencia = document.getElementById("frecuencia").value;
      let inputNombre = document.getElementById("nombre").value;
      let inputEdad = document.getElementById("edad").value;
      let inputTelefono = document.getElementById("telefono").value;
      // Realizar la comprobación si el número de teléfono está asociado a un usuario
      fetch(`/usuarios/telefono?telefono=${inputTelefono}`)
        .then(response => {
          if (!response.ok) {
            console.error('Error al obtener el ID del usuario:', response);
            throw new Error('Error al obtener el ID del usuario');
          }
          return response.json();
        })
        .then(usuario => {
          if (!usuario || !usuario.idUsuario) {
            let errorMessage = document.getElementById("error-telefono");
            errorMessage.textContent = "El número de teléfono introducido no está asociado a ningún usuario";
          } else {
            
            // Construir URL parametros
            var urlParams = new URLSearchParams();
            urlParams.append("objetivos", inputObjetivos);
            urlParams.append("frecuencia", inputFrecuencia);
            urlParams.append("nombre", inputNombre);
            urlParams.append("edad", inputEdad);
            urlParams.append("telefono", inputTelefono);

            // Redirecciona a la página ejercicios.html  con los URL parámetros
            window.location.href = "ejercicios.html?" + urlParams.toString();
          }
        })
        .catch(error => {
          console.error('Error:', error); // Mostrar cualquier error en la consola
        });
    }
  /*validateForm();*/
  
}
formOne.addEventListener("submit", redireccionar);

});




