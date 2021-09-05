
botonBuscar = document.getElementById("buscar");
botonActualizar =document.getElementById("actualizar");

botonBuscar.addEventListener("click", buscar);
botonActualizar.addEventListener("click", actualizarGenero);



async function buscar(){
	let id = document.getElementById("id").value;
	const request = await fetch('generos/buscarPorId/'+id, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({"id":id})
  });
  const genero = await request.json();
	//console.log(personaje);
	mostrarGenero(genero[0]);
}


function mostrarGenero(genero){
	for(let i in genero){
		document.getElementById("input"+i).value = genero[i];
	}
}


async function actualizarGenero(){
	let datos = {}
	datos.id =document.getElementById('inputid').value;
	datos.nombre = document.getElementById('inputnombre').value;
	
	const request = await fetch('generos/actualizar', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("Genero Actualizado");
  	//const personaje = await request.json();
	//console.log(datos);

}







