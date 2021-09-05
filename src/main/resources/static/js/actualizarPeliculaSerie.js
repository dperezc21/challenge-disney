
botonBuscar = document.getElementById("buscar");
botonActualizar =document.getElementById("actualizar");

botonBuscar.addEventListener("click", buscar);
botonActualizar.addEventListener("click", actualizarPeliculaSerie);



async function buscar(){
	let id = document.getElementById("id").value;
	console.log(id);
	const request = await fetch('movies/bucarPorId/'+id, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({"id":id})
  });
  const personaje = await request.json();
	console.log(personaje);
	mostrarPersonaje(personaje[0]);
}


function mostrarPersonaje(personaje){
	for(let i in personaje){
		console.log(i);
		document.getElementById("input"+i).value = personaje[i];	
	}
}


async function actualizarPeliculaSerie(){
	let datos = {}
	datos.id =document.getElementById('inputid').value;
	datos.titulo = document.getElementById('inputtitulo').value;
	datos.calificacion = document.getElementById('inputcalificacion').value;
	//datos.fecha_creacion = document.getElementById('inpufecha').value;
	
	console.log(datos.calificacion);
	const request = await fetch('movies/actualizar', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("Pelicula o serie actualizada");
  	//const personaje = await request.json();
	//console.log(datos);

}







