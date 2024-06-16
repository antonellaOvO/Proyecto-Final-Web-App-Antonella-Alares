/*AUTORA:ANTONELLA ALARES*/
document.addEventListener("DOMContentLoaded", function () {
    // Coger valores seleccionados
    var urlParams = new URLSearchParams(window.location.search);
    var objetivos = urlParams.get("objetivos");
    var frecuencia = urlParams.get("frecuencia");
    var nombre = urlParams.get("nombre");
    var edad = urlParams.get("edad");
    var telefono = urlParams.get("telefono");

    // Para la binvenida, que dé el nombre y la edad (estos datos proceden del formulario a través de los parámetros de la url)
    if (nombre && edad) {
        let nombreUsuario = nombre.charAt(0).toUpperCase() + nombre.slice(1).toLowerCase();
        document.getElementById("intro-section-one").textContent = `Bienvenid@ ${nombreUsuario} 🎉 a tu Rutina personalizada!!`;
        document.getElementById("intro-section-two").textContent = `${edad} años es una buena edad para empezar 😉`;
    }

    // Crear el titulo de la rutina en función del objetivo seleccionado en el formulario
    let rutinaTitle = document.getElementById("rutina-title");
    rutinaTitle.textContent = `Rutina ${objetivos}`;
    rutinaTitle.classList.add("text-center");

    // Introducir el párrafo  explicativo en funcion de la frecuencia seleccionada en el formulario 
    if (frecuencia) {
        document.getElementById("intro-section-three").textContent = `Mira los ejercicios que hemos seleccionado para ti, teniendo en cuenta tu dedicación de ${frecuencia}. Ayúdate con videos para saber en detalle como realizar estos ejercicios.`;
    }

    // Variable para almacenar los datos de los ejercicios
    let ejerciciosData = [];

    // Obtener ejercicios desde la API (tabla Ejercicios de SQL dónde ya están introducidos ejercicios)
    fetch(`/api/ejercicios?objetivo=${objetivos}`)
        .then(response => response.json())
        .then(data => {
            ejerciciosData = data; // Guardar los datos de los ejercicios (de la tabla "Ejercicios" de sql)

            let rutinaList = document.getElementById("rutina-listado");
            data.forEach(function (ejercicio) {
                // Crear elementos HTML para cada ejercicio 
                let rutinaItem = document.createElement("div");
                let subtitle = document.createElement("h3");
                let image = document.createElement("img");
                let video = document.createElement("iframe");

                subtitle.setAttribute("class", "my-5");
                subtitle.textContent = ejercicio.nombre;

                // Asignar la fuente de la imagen, ya que la imagen está en una carpeta llamada "images"
                image.src = `../images/${ejercicio.imagen}`;
                image.setAttribute("class", "img-fluid");

                // Asignando el video, teniendo en cuanta que es un enlace de YouTube
                video.src = ejercicio.video;
                video.setAttribute("class", "my-5");
                video.setAttribute("width", "560");
                video.setAttribute("height", "315");
                video.setAttribute("title", "YouTube video player");
                video.setAttribute("frameborder", "0");
                video.setAttribute("allow", "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share");
                video.setAttribute("allowfullscreen", "");

                // Agregar elementos al contenedor del ejercicio (al div creado anteriormente)
                rutinaItem.appendChild(subtitle);
                rutinaItem.appendChild(image);
                rutinaItem.appendChild(video);
                rutinaItem.classList.add("p-3", "mx-3", "bg-warning-subtle", "text-warning-emphasis", "fw-bold", "text-center");
                
                // Agregar el contenedor del ejercicio al listado de rutina (dentro de otro div superior al anterior)
                rutinaList.appendChild(rutinaItem);
            });
        })
        .catch(error => console.error('Error:', error));

    // Para el botón de guardar Rutina:
    function crearRutina() {
        // Solo se seleccionarán dos ejercicios, ya que sólo hay 2 ejercicios en la tabla Ejercicios SQL por objetivo (ej.:"Perder Peso")
        console.log(ejerciciosData);
        let [ejercicio1, ejercicio2] = ejerciciosData.map(ej => ej.id);  
        console.log(ejerciciosData);
        const rutinaData = {
            "objetivo": objetivos,
            "ejercicio1": ejercicio1,
            "ejercicio2": ejercicio2
        };

        console.log("Datos enviados:", rutinaData); // Log para depuración
        fetch(`/rutinas/${telefono}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "objetivo": objetivos,
                "ejercicio1": ejercicio1,
                "ejercicio2": ejercicio2
            })
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            document.getElementById('feedback-guardar').textContent = 'Genial! 😙 Ya has guardado tu rutina';
        })
        .catch((error) => {
            console.error('Error:', error);
            document.getElementById('feedback-guardar').textContent = 'Lo sentimos, parece ser que hay algún problema en este momento para guardar tu rutina 🙄. Vuelve a intentarlo más tarde, por favor 🙏';
        });
    }

    const btnGuardarRutina = document.getElementById('guardar-rutina');
    btnGuardarRutina.addEventListener('click', (event) => {
        event.preventDefault();
        crearRutina();
    });
});
