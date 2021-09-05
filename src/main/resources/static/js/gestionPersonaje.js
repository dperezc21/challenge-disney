


window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
	personajes();
    const datatablesSimple = document.getElementById('tablaPersonajes');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
    
});


async function personajes(){
	
	const ResponsePersonajes = await fetch('characters', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    
  });
  const personajes = await ResponsePersonajes.json();
  
  let lista = listarPersonajes(personajes);
	document.querySelector("#tablaPersonajes tbody").innerHTML = lista;
	//console.log(personajes);
  	
}


async function eliminarPersonaje(id){
	if(confirm("¿Esta seguro que quiere eliminar el personaje seleccionado?")){
		const response = await fetch('characters/eliminar/'+id, {
    	method: 'DELETE',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json',
	      'Authentication':localStorage.token
	    },
	    
	  });
	  location.reload();
	}  
}


function listarPersonajes(personajes){
	let lista = "";
	for (let i of personajes){
		
		let botonEliminar = '<a href="#" onclick="eliminarPersonaje('+i.id+')">Eliminar</a>';
		let personaje = '<tr><td>'+i.id
						+'</td><td>'+i.nombre
						+'</td><td>'+i.edad
						+'</td><td>'+i.peso
						+'</td><td>'+i.historia
						+'</td><td></td><td>'+botonEliminar+'</td></tr>';
						
		lista += personaje;
	}
	return lista;
}



select = document.getElementById("select");

botonBuscar = document.getElementById("buscarPersonaje");


botonBuscar.addEventListener("click", buscarPersonajePor);

async function buscarPersonajePor(){
	
	let dato = document.getElementById("dato").value;
	for (let i = 0; i < select.length; i++){
		if(select.options[i].selected){
			let opcion = select.options[i].value;
			if( opcion == "Nombre"){
				buscarPorNombre(dato);
			}else if(opcion == "Edad"){
				console.log("aqui");
				buscarPorEdad(dato);
			}
			
		}
	}
	

	
}


async function buscarPorNombre(nombre){
	const responsePersonajes = await fetch('/characters/searchByName?name='+nombre, {
    	method: 'GET',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	    
	  });

	const personajes = await responsePersonajes.json();
	console.log(personajes);
	
	document.querySelector("#tablaPersonajes tbody").innerHTML = listarPersonajes(personajes);
	
}

async function buscarPorEdad(edad){
	const responsePersonajes = await fetch('/characters/searchByAge?age='+edad, {
    	method: 'GET',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	  });

	const personajes = await responsePersonajes.json();
	console.log(personajes);
	
	document.querySelector("#tablaPersonajes tbody").innerHTML = listarPersonajes(personajes);
	
}







