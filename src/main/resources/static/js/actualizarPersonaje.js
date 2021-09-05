
botonBuscar = document.getElementById("buscar");
botonActualizar =document.getElementById("actualizar");

botonBuscar.addEventListener("click", buscar);
botonActualizar.addEventListener("click", actualizarPersonaje);



async function buscar(){
	let id = document.getElementById("id").value;
	const request = await fetch('characters/buscarPorId/'+id, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({"id":id})
  });
  const personaje = await request.json();
	//console.log(personaje);
	mostrarPersonaje(personaje[0]);
}


function mostrarPersonaje(personaje){
	for(let i in personaje){
		document.getElementById("input"+i).value = personaje[i];
	}
}


async function actualizarPersonaje(){
	let datos = {}
	datos.id =document.getElementById('inputid').value;
	datos.nombre = document.getElementById('inputnombre').value;
	datos.edad = document.getElementById('inputedad').value;
	datos.peso = document.getElementById('inputpeso').value;
	datos.historia = document.getElementById('inputhistoria').value;
	
	const request = await fetch('characters/actualizar', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("Personaje Actualizado");
  	//const personaje = await request.json();
	//console.log(datos);

}







