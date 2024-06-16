/*AUTORA:ANTONELLA ALARES*/
document.addEventListener("DOMContentLoaded", function () {
  // Coger valores seleccionados
  var urlParams = new URLSearchParams(window.location.search);

  var nombre = urlParams.get("nombre");
  var apellido = urlParams.get("apellido");
  var telefono = urlParams.get("telefono");
  var edad = urlParams.get("edad");
  var email = urlParams.get("email");
  
  /*Para que la primera letra del nombre que introduzca el usuario en el formulario sea siempre en mayúscula*/
    nombre =
      nombre.charAt(0).toUpperCase() + nombre.slice(1).toLowerCase();
      
  let bienvenida = document.getElementById("bienvenida-nombre");
  let nombrePrincipal = document.getElementById("p-nombre-principal");
  let emailPrincipal = document.getElementById("p-email-principal");
  let nombreTexto = document.getElementById("p-nombre");
  let apellidoTexto = document.getElementById("p-apellido");
  let telefonoTexto = document.getElementById("p-telefono");
  let edadTexto = document.getElementById("p-edad");
  
  /*Inyectar los datos del formulario rellenado a esta página*/
  
  bienvenida.textContent = `BIEVENID@ ${nombre}`;
  nombrePrincipal.textContent = `${nombre}`;
  emailPrincipal.textContent = `${email}`;
  nombreTexto.textContent = `Nombre: ${nombre}`;
  apellidoTexto.textContent = `Apellido: ${apellido}`;
  telefonoTexto.textContent = `Telefono: ${telefono}`;
  edadTexto.textContent = `Edad: ${edad} años`;
  
});
