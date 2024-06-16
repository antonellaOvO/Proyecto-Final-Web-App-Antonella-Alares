/*AUTORA:ANTONELLA ALARES*/
/*Este código es para el formulario de registro de usuario - sección "Únete"*/
document.addEventListener("DOMContentLoaded", function () {
  //Obtener referencias a los elementos del formulario
  let formRegister = document.getElementById("formReg");

  function redireccionar(event) {
    event.preventDefault();

    // Obtener los valores de los campos de entrada del formulario
    let nombre = document.getElementById("nombre-usuario").value;
    let apellido = document.getElementById("apellido-usuario").value;
    let edad = document.getElementById("edad-usuario").value;
    let telefono = document.getElementById("telefono-usuario").value;
    let email = document.getElementById("email-usuario").value;
    /*Validar input de email en el formulario para que contenga el formato @*/
    function validateForm() {
      let email = document.getElementById("email-usuario").value;
      let edad = document.getElementById("edad-usuario").value;
      var validEmail = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/;
      if (isNaN(edad)) {
        let errorMessage = document.getElementById("errorEdad");
        errorMessage.textContent =
          "El valor de edad debe contener sólo números";
      } else if (edad < 13 || edad > 90) {
        let errorMessage = document.getElementById("errorEdad");
        errorMessage.textContent =
          "La edad debe estar comprendida entre 13 a 90 años";
      } else if (!/^\d{9}$/.test(telefono)) {
        let errorMessage = document.getElementById("errorTelefono");
        errorMessage.textContent =
          "El número de teléfono debe contener exactamente 9 dígitos";
      } else if (!validEmail.test(email)) {
        let errorMessage = document.getElementById("errorEmail");
        errorMessage.textContent =
          "El email que ha introducido no tiene formato de correo electrónico pedro@cuenta.com";
      }else {
        // Enviar una solicitud POST al servidor con los datos del pedido
        fetch("/usuarios", {
          method: "POST", // Método HTTP a utilizar
          headers: {
            "Content-Type": "application/json" // Especificar que los datos se envían en formato JSON
          },
          body: JSON.stringify({
            nombre: nombre,
            apellido: apellido,
            edad: parseInt(edad),
            telefono: parseInt(telefono),
            email: email
          }) // Convertir los datos a JSON
        })
          .then((response) => response.json()) // Convertir la respuesta a JSON
          .then((data) => {
            console.log("Success:", data); // Mostrar los datos de la respuesta en la consola
            formRegister.reset(); // Resetear el formulario para limpiar los campos de entrada
            // Construir URL parametros
            var urlParams = new URLSearchParams();
            urlParams.append("nombre", nombre);
            urlParams.append("apellido", apellido);
            urlParams.append("telefono", telefono);
            urlParams.append("edad", edad);
            urlParams.append("email", email);
            // Redirigir a la página de resultados con los parámetros en la URL
            console.log(
              "Redireccionando a feedback-register.html con los parámetros:",
              urlParams.toString()
            );
            window.location.href =
              "feedback-register.html?" + urlParams.toString();
          })
          .catch((error) => {
            console.error("Error:", error); // Mostrar cualquier error en la consola
          });
      }
    }
    validateForm();
  }
  formRegister.addEventListener("submit", redireccionar);
});
