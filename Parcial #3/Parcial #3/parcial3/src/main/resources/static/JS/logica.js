function enviarFormulario() {
    // Crear un objeto con los valores de los tres campos
    var campos = {
        nombreUsuario: document.getElementById("nombre_Usuario").value,
        idCuenta: document.getElementById("id_Cuenta").value,
        comentarios: document.getElementById("coment").value,
    };

    // Enviar la solicitud al servidor
    fetch('/guardarComentario', {
        method: 'POST',
        body: JSON.stringify(campos),
        headers: {
            "Content-type": 'application/json; charset=UTF-8'
          }
    })
    
    .then(response => response.json())
    .then(data => {
        console.log('Respuesta del servidor:', data);
        // Puedes manejar la respuesta del servidor según tus necesidades
    })
    .catch(error => {
        console.error('Error al enviar la solicitud:', error);
    });
}

