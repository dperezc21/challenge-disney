window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
	get();
    const datatablesSimple = document.getElementById('tablaPersonajes');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
    
});


async function get(){
	const request = await fetch('movies', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    
  });
  const peliculasSeries = await request.json();
  let lista = listarPeliculasSeries(peliculasSeries);
	document.querySelector("#tablaPersonajes tbody").innerHTML = lista;
  console.log(peliculasSeries);
  
}


async function eliminarPeliculaSerie(id){
	if(confirm("¿Esta seguro que quiere eliminar la pelicula o serie seleccionada?")){
		const request = await fetch('movies/eliminar/'+id, {
    	method: 'DELETE',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json',
	      //'Authentication':localStorage.token
	    },
	    
	  });
	  location.reload();
	}  
}


function listarPeliculasSeries(peliculaSerie){
	let lista = "";
	
	for (let i of peliculaSerie){
		
		let botonEliminar = '<a href="#" onclick="eliminarPeliculaSerie('+i.id+')">Eliminar</a>';
		let peliculaserie = '<tr><td>'+i.id
						+'</td><td>'+i.titulo
						+'</td><td>'+i.calificacion
						+'</td><td></td><td>'+botonEliminar+'</td></tr>';
						
		lista += peliculaserie;
	}
	return lista;
}


select = document.getElementById("select");

botonBuscar = document.getElementById("buscarPeliculaSerie");


botonBuscar.addEventListener("click", buscarPersonajePor);

async function buscarPersonajePor(){
	
	let dato = document.getElementById("dato").value;
	for (let i = 0; i < select.length; i++){
		if(select.options[i].selected){
			let opcion = select.options[i].value;
			if( opcion == "Titulo"){
				buscarPorNombre(dato);
			}else if(opcion == "Id, Orden Desc"){
				buscarPorOrdenDescOAsc("desc");
			}else if (opcion == "Id, Orden Asc"){
				buscarPorOrdenDescOAsc("asc");
			}
			
		}
	}
	

	
}


async function buscarPorNombre(nombre){
	const requestPeliculasSeries = await fetch('/movies/buscarPorNombre?name='+nombre, {
    	method: 'GET',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	    
	  });

	const peliculasSeries = await requestPeliculasSeries.json();
	//console.log(peliculasSeries,"hola");
	
	document.querySelector("#tablaPersonajes tbody").innerHTML = listarPeliculasSeries(peliculasSeries);
	
}


async function buscarPorOrdenDescOAsc(orden){
	const requestPeliculasSeries = await fetch('movies/'+orden, {
    	method: 'GET',
	    headers: {
	      'Accept': 'application/json',
	      'Content-Type': 'application/json'
	    },
	    
	  });

	const peliculasSeries = await requestPeliculasSeries.json();
	console.log(peliculasSeries,"hola");
	
	document.querySelector("#tablaPersonajes tbody").innerHTML = listarPeliculasSeries(peliculasSeries);
	
}

