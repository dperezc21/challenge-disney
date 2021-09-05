
async function agregar(){
	
	let datos = {}
	datos.id =document.getElementById('inputId').value;
	datos.titulo = document.getElementById('inputTitulo').value;
	datos.calificacion = document.getElementById('inputCalificacion').value;
	//datos.imagen = document.getElementById('inputImagen').value;
	
	const request = await fetch('movies/guardar', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  //const peliculasSeries = await request.json();
  alert("pelicula o serie registrada");
  //console.log(peliculasSeries);
  
}