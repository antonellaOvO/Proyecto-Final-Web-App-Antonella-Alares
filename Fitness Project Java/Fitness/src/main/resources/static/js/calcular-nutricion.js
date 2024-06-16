/*AUTORA:ANTONELLA ALARES*/
class Alimento {
  constructor(nombre, cantidad, calorias, proteinas) {
    this.nombre = nombre;
    this.cantidad = cantidad;
    this.calorias = calorias;
    this.proteinas = proteinas;
  }
}

class Fruta extends Alimento {
  constructor(nombre, cantidad, calorias, proteinas, conservacion) {
    super(nombre, cantidad, calorias, proteinas);
    this.conservacion = conservacion;
  }
}

class Verdura extends Alimento {
  constructor(nombre, cantidad, calorias, proteinas, frescas) {
    super(nombre, cantidad, calorias, proteinas);
    this.frescas = frescas;
  }
}

// Instancias de las clases

// Tres instancias adicionales de la clase Alimento
const Alimento1 = new Alimento("Lácteos", 1, 30, 5);
const Alimento2 = new Alimento("Cereales", 1, 10, 45);
const Alimento3 = new Alimento("Legumbres", 1, 40, 8);

// Tres instancias adicionales de la clase Fruta
const Fruta1 = new Fruta(
  "Pera",
  1,
  34,
  30,
  "Conservar en nevera siempre"
);
const Fruta2 = new Fruta(
  "Manzana",
  1,
  86,
  46,
  "Conservar en nevera siempre"
);
const Fruta3 = new Fruta(
  "Naranja",
  1,
  67,
  15,
  "Conservar en nevera siempre"
);
const Fruta4 = new Fruta(
  "Platano",
  1,
  45,
  32,
  "Conservar en nevera siempre"
);
const Fruta5 = new Fruta(
  "Melocotón",
  1,
  30,
  56,
  "Conservar en nevera siempre"
);

// Tres instancias adicionales de la clase Verdura
const Verdura1 = new Verdura(
  "Coliflor",
  1,
  45,
  36,
  "Consume mejor verduras frescas"
);
const Verdura2 = new Verdura(
  "Zanahoria",
  1,
  65,
  16,
  "Consume mejor verduras frescas"
);
const Verdura3 = new Verdura(
  "Berenjena",
  1,
  32,
  56,
  "Consume mejor verduras frescas"
);

const alimentos = [
  Alimento1,
  Alimento2,
  Alimento3,
  Fruta1,
  Fruta2,
  Fruta3,
  Fruta4,
  Fruta5,
  Verdura1,
  Verdura2,
  Verdura3
];

document.addEventListener("DOMContentLoaded", function () {
  const alimentosSection = document.getElementById("alimentos");
  const resultadosSection = document.getElementById("resultados");
  const resultadosComparacion = document.getElementById("resultadosCalculo");

  let cantidadTotalMax = 0;
  let cantidadTotalMaxCalorias = 0;

  // Función para agregar campo de destino
  function agregarCampoDestino() {
    const nuevoCampo = document.createElement("div");
    nuevoCampo.innerHTML = `
            <label class="form-label" for="alimento">Alimento:</label>
            <select class="form-select" name="alimento" id="opciones-select" onchange="mostrarOpciones(this)">
                <option value="seleccionar" disabled selected>Seleccionar</option>
                ${crearOpcionesDestinos()}
            </select>
            <div id="opciones"></div>
            <label class="form-label mt-3" for="cantidad">Cantidad:</label>
            <input class="form-control mb-5" type="text" id="ingreso-cantidad" name="cantidad" placeholder="Ingrese la cantidad de alimentos">
        `;
    alimentosSection.appendChild(nuevoCampo);
  }

  // Función para crear las opciones del desplegable
  function crearOpcionesDestinos() {
    let opciones = "";
    alimentos.forEach((alimento) => {
      opciones += `<option value="${alimento.nombre}">${alimento.nombre}</option>`;
    });
    return opciones;
  }

  // Función para mostrar opciones específicas según el destino seleccionado:
  function mostrarOpciones(select) {
    const opcionSeleccionada = select.value;
    const opcionesDiv = select.nextElementSibling;

    // Limpiar opciones anteriores
    opcionesDiv.innerHTML = "";

    // Encontrar el destino seleccionado
    const alimentoSeleccionado = alimentos.find(
      (alimento) => alimento.nombre === opcionSeleccionada
    );
  }

  // Función para calcular el itinerario
  function calcularNutricion() {
    let cantidadTotal = 0;
    let cantidadTotalCalorias = 0;

    let resultadosHTML = `
            <h2 class="mt-5 mb-4">Resultados:</h2>
            <table id="table-nutricion">
                <tr id="columna-nutricion">
                    <th class="fila-nutricion">Alimento</th>
                    <th class="fila-nutricion">Cantidad</th>
                    <th class="fila-nutricion">Calorías</th>
                    <th class="fila-nutricion">Proteínas</th>
                    <th class="fila-nutricion">Datos adicionales</th>
                </tr>
        `;

    const alimentosInputs = document.getElementsByName("alimento");
    const cantidadInputs = document.getElementsByName("cantidad");

    for (let i = 0; i < alimentosInputs.length; i++) {
      const tipoAlimento = alimentosInputs[i].value;
      const cantidad = parseInt(cantidadInputs[i].value);

      // Validar duración ingresada
      if (isNaN(cantidad) || cantidad <= 0) {
        alert(
          "Por favor, ingrese una cantidad válida para el alimento " +
            alimentosInputs[i].value
        );
        return;
      }
      let calorias = "";
      let proteinas = "";
      let datosAdicionales = "";

      // Buscar el alimento seleccionado en la lista de alimentos
      const alimentoSeleccionado = alimentos.find(
        (alimento) => alimento.nombre === tipoAlimento
      );

      if (alimentoSeleccionado) {
        // Asignar cantidad según tipo de alimento
        if (
          alimentoSeleccionado instanceof Fruta ||
          alimentoSeleccionado instanceof Verdura ||
          alimentoSeleccionado instanceof Alimento
        ) {
          // Calcular calorias y proteinas por cada alimento seleccionado
          calorias = parseInt(alimentoSeleccionado.calorias) * cantidad;
          proteinas = parseInt(alimentoSeleccionado.proteinas) * cantidad;
        }

        // Determinar "Datos adicionales"
        if (alimentoSeleccionado instanceof Fruta) {
          datosAdicionales = alimentoSeleccionado.conservacion;
        } else if (alimentoSeleccionado instanceof Verdura) {
          datosAdicionales = alimentoSeleccionado.frescas;
        } else if (alimentoSeleccionado instanceof Alimento) {
          datosAdicionales = "Amplia tu dieta con este tipo de alimentos";
        }

        // Agregar fila a la tabla de resultados
        resultadosHTML += `
                    <tr>
                        <td class="dato-columna">${alimentoSeleccionado.nombre}</td>
                        <td  class="dato-columna">${cantidad}</td>
                        <td  class="dato-columna">${calorias}</td>
                        <td  class="dato-columna">${proteinas}</td>
                        <td  class="dato-columna">${datosAdicionales}</td>
                    </tr>
                `;

        cantidadTotal += cantidad;
        cantidadTotalCalorias += calorias;
      }
    }

    resultadosHTML += `</table>`;
    resultadosSection.innerHTML = resultadosHTML;

    // Mostrar cantidad total nutrición
    alert("La cantidad de alimento es de " + cantidadTotal);
    cantidadTotalMax = cantidadTotal;
    cantidadTotalMaxCalorias = cantidadTotalCalorias;
  }

  function calcularComparacion() {
    let objetivo = document.getElementById("objetivo-nutricion");
    let valorMaximo = parseFloat(objetivo.value);

    if (isNaN(valorMaximo) || valorMaximo <= 0) {
      alert("Por favor, ingrese un valor válido para el objetivo de calorías.");
      return;
    }

    if (valorMaximo < cantidadTotalMaxCalorias) {
      let caloriasRestantes = cantidadTotalMaxCalorias - valorMaximo;
      resultadosComparacion.innerHTML = `<p> ¡Te has pasado de calorías! Tienes ${caloriasRestantes} Cal sobrantes en tu dieta.</p>`;
    } else if (valorMaximo === cantidadTotalMaxCalorias) {
      resultadosComparacion.innerHTML = `<p> ¡Has planificado tu dieta al límite! No te sobran ni te faltan calorías. </p>`;
    } else {
      let caloriasRestantes = valorMaximo - cantidadTotalMaxCalorias;
      resultadosComparacion.innerHTML = `<p> Aún puedes añadir más Cal a tu dieta (Tienes(${caloriasRestantes} Cal restantes). </p>`;
    }
  }

  // Evento para agregar campo de alimento al hacer clic en un botón
  document
    .getElementById("agregar-alimento")
    .addEventListener("click", agregarCampoDestino);

  // Evento para calcular el contenido nutricional al hacer clic en un botón
  document
    .getElementById("calcular-nutricion")
    .addEventListener("click", calcularNutricion);

  // Evento para calcular la comparación de cantidades al hacer clic en un botón
  document
    .getElementById("calcular-comparacion")
    .addEventListener("click", calcularComparacion);

  // Evento para guardar el plan de alimentos al hacer clic en un botón
  document
    .getElementById("guardar-food-planning")
    .addEventListener("click", function () {
      const alimentosGuardados = [];

      // Obtener las filas de la tabla de resultados
      const filasTablaResultados = document.querySelectorAll("#table-nutricion tr:not(#columna-nutricion)");

      // Recorrer cada fila para obtener los datos
      filasTablaResultados.forEach((fila) => {
        const columnas = fila.querySelectorAll("td"); // Obtener las columnas de la fila
        const nombreAlimento = columnas[0].textContent; // Obtener el nombre del alimento
        const cantidad = parseInt(columnas[1].textContent); // Obtener la cantidad
        const calorias = parseInt(columnas[2].textContent); // Obtener las calorías
        const proteinas = parseInt(columnas[3].textContent); // Obtener las proteínas
        const datosAdicionales = columnas[4].textContent; // Obtener los datos adicionales

        // Agregar los datos al arreglo alimentosGuardados
        alimentosGuardados.push({
          nombreAlimento: nombreAlimento,
          cantidad: cantidad,
          calorias: calorias,
          proteinas: proteinas,
          datosAdicionales: datosAdicionales
        });
      });

      const telefono = document.getElementById("telefono-control-form").value;
      const nombrePlanning = document.getElementById("nombre-planning-form")
        .value;

      // Depuración: Mostrar los datos antes de enviar
      console.log("Datos a enviar:", JSON.stringify(alimentosGuardados));
      
      
      fetch(
        `/alimentos/guardar?telefono=${telefono}&nombrePlanning=${nombrePlanning}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(alimentosGuardados)
        }
      )
        .then((response) => {
          if (response.ok) {
            return response.json();
          }
          throw new Error("Error al guardar el plan de alimentos.");
        })
        .then((data) => {
          console.log("Plan de alimentos guardado:", data);
          alert("Plan de alimentos guardado exitosamente.");
        })
        .catch((error) => {
          console.error("Error:", error);
          alert("Plan de alimentos guardado exitosamente.");
        });
    });
});
