/*AUTORA:ANTONELLA ALARES*/
document.addEventListener("DOMContentLoaded", function () {
  // Obtener referencias a los elementos del formulario
  let formFour = document.getElementById("form-four");
  let newParam = "perfil";

  function redireccionar(event) {
    event.preventDefault();

    // Obtener el valor del campo de entrada del formulario
    let telefono = document.getElementById("telefono-control-form").value;

    // Obtener referencias a los elementos de mensaje de error
    let errorMessageTelefono = document.getElementById("error-telefono");
   
    /* Validar input de telefono en el formulario */
    function validateForm() {
      if (!/^\d{9}$/.test(telefono)) {
        errorMessageTelefono.textContent =
          "El número de teléfono debe contener exactamente 9 dígitos";
        return false; // Retorna falso para evitar redireccionar
      } else {
        errorMessageTelefono.textContent = ""; // Limpiar el mensaje de error
        return true; // Retorna verdadero para continuar con la redirección
      }
    }

    if (validateForm()) {
      // Realizar la comprobación si el número de teléfono está asociado a un usuario
      fetch(`/usuarios/telefono?telefono=${telefono}`)
        .then(response => {
          if (!response.ok) {
            console.error('Error al obtener el ID del usuario:', response);
            throw new Error('Error al obtener el ID del usuario');
          }
          return response.json();
        })
        .then(usuario => {
          if (!usuario || !usuario.idUsuario) {
            errorMessageTelefono.textContent = "El número de teléfono introducido no está asociado a ningún usuario";
          } else {
            // Construir URL parametros
            var urlParams = new URLSearchParams();
            urlParams.append("perfil", newParam);
            urlParams.append("telefono", telefono);
            // Redirigir a la página de resultados con los parámetros en la URL
            console.log(
              "Redireccionando a perfil-datos.html con los parámetros:",
              urlParams.toString()
            );
            window.location.href = "perfil-datos.html?" + urlParams.toString();
          }
        })
        .catch(error => {
          console.error('Error:', error); // Mostrar cualquier error en la consola
        });
    }
  }

  formFour.addEventListener("submit", redireccionar);
});
